package com.jjang051.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jjang051.model.GalleryDao;
import com.jjang051.model.GalleryDto;
import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
import com.jjang051.utils.ScriptWriterUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GalleryController {
	
	@Autowired
	GalleryDao galleryDao;
	
	@Autowired
	GalleryDto galleryDto;
	
	@Autowired
	ReplyDto replyDto;
	
	@Autowired
	ReplyDao replyDao;
	
	@RequestMapping("/GalleryWriteForm.do")
	public String galleryWriteForm() {
		return "gallery_write";
	}
	
	@RequestMapping("/GalleryWrite.do")
	public String galleryWrite(
								GalleryDto galleryDto,
								MultipartFile multipartFile,
								HttpServletRequest request,
								HttpServletResponse response
							  ) throws IOException {
		
		String context = request.getContextPath();//지금 실행중인 context
		String fileRoot =  "C:\\galleryImage\\";
		String originalFileName=  multipartFile.getOriginalFilename(); // 중복 파일때문에...
		String extention =  FilenameUtils.getExtension(originalFileName);// 확장자 구하기...
		String savedFileName = UUID.randomUUID()+"."+extention; //16짜리 random코드 작성
		File targetFile = new File(fileRoot+savedFileName); 
		String dbFileName = context+"/galleryImage/"+savedFileName;
		
		log.info("dbFileName==={}",dbFileName);
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		galleryDto.setRealImg(originalFileName);//진짜 이름
		galleryDto.setImg(dbFileName); // 중복처리 네임
		
		log.info("galleryDto=={}",galleryDto.toString());
		
		int result = galleryDao.insertGalley(galleryDto);
		if(result>0) {
			ScriptWriterUtil.alertAndNext(response, "등록되었습니다.", "GalleryList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "등록실패");
		}
		return null;
	}
	
	@RequestMapping("/GalleryList.do")
	public String galleryList() {
		return "gallery_list";
	}
	
	@RequestMapping("/GalleryJsonList.do")
	@ResponseBody
	public Map<String,List<GalleryDto>> galleryJsonList() {
		Map<String,List<GalleryDto>> hashMap = null;
		
		List<GalleryDto> galleryList = galleryDao.getAllGallery();
		hashMap = new HashMap<String,List<GalleryDto>>();
		hashMap.put("galleryList", galleryList);
		
		return hashMap;
	}
	
	//reply
	@RequestMapping("/Gallery_write.do")
	@ResponseBody
	public Map<String,Object> replyWrite(ReplyDto replyDto){
		int result = 0;
		result = replyDao.insertReply(replyDto);
		int boardId = replyDto.getBoardId();
		replyDao.getAllReply(boardId);
		List<replyDto> replyList = replyDao.getAllReply();
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("result", result);
		hashMap.put("replyList", replyList);
		return hashMap;
	}
}








