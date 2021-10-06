package com.jjang051.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriterUtil;

import lombok.extern.slf4j.Slf4j;


@Controller  // spring  관리 대상
@Slf4j
public class MemberController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberDto memberDto; 
	
	@Autowired
	MemberDto loggedMember;
	
	
	@RequestMapping("/IDCheck.do")
	@ResponseBody
	public Map<String,String> idCheck(String id) {
		log.info("id==={}",id);
		Map<String, String> hashMap = new HashMap<String, String>();
		int result = memberDao.idCheck(id);
		if(result > 0) {
			hashMap.put("result", "fail"); //갯수 id랑 같은게 있으면 그 갯수세는거니까  중복이 있다.
		} else {
			hashMap.put("result", "ok");
		}
		return hashMap;
	}
	
	@RequestMapping("/MemberList.do")
	public String list(Model model) {
		List<MemberDto> memberList =  memberDao.showAllMember();
		model.addAttribute("memberList",memberList);
		return "member/list";
	}
	
	@RequestMapping("/MemberInfo.do")
	public String memberInfo(int no, Model model) {
		memberDto = memberDao.getSelectOne(no);
		model.addAttribute("infoMember",memberDto);
		return "member/member_info";
	}
	
	@RequestMapping("/MemberJoinForm.do")
	public String memberJoinForm() {
		return "member/join";
	}
	
	@RequestMapping("/MemberJoin.do")
	public String memberJoin(@ModelAttribute MemberDto memberDto, HttpServletResponse response) throws IOException {
		log.info("memberDto==={}",memberDto.toString());
		memberDto.setAddress(memberDto.getAddress01()+" "+memberDto.getAddress01());
		memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneNumber());
		int result = memberDao.insertMember(memberDto);
//		if(result>0) {
//			ScriptWriterUtil.alertAndNext(response, "회원가입이 되었습니다.", "MemberList.do");
//		} else {
//			ScriptWriterUtil.alertAndBack(response, "회원가입에 실패하였습니다.");
//		}
//		return null;
		//response.sendRedirect();
		return "redirect:/MemberList.do";
	}
	
	@RequestMapping("/MemberLoginForm.do")
	public String memberLoginForm() {
		return "member/login";
	}
	
	@RequestMapping("/MemberLogin.do")
	public String memberLogin(MemberDto memberDto, HttpSession session,HttpServletResponse response) throws IOException {
		
		loggedMember = memberDao.getLoggedMember(memberDto);
		
		if(loggedMember!=null) {
			session.setAttribute("loggedMember", loggedMember);
			ScriptWriterUtil.alertAndNext(response, "로그인되었습니다.", "MemberList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "아이디 비밀번호를 확인해 주세요.");
		}
		
		return null;
	}
	
	@RequestMapping("/MemberLogOut.do")
	public String memberLogOut(HttpSession session,HttpServletResponse response ) throws IOException {
		loggedMember = (MemberDto)session.getAttribute("loggedMember");
		if(loggedMember!=null) {
			session.invalidate();
			ScriptWriterUtil.alertAndNext(response, "로그아웃되었습니다.", "MemberList.do");
		} else {
			ScriptWriterUtil.alertAndNext(response, "로그아웃되었습니다.", "MemberLoginForm.do");
		}
		return null;
	}
	
	@RequestMapping("/MemberDeletForm.do")
	public String memberDeleteForm() {
		return "member/member_delete";
	}
	
	@RequestMapping("/MemberDelete.do")
	public String memberDelete(int no,String password, HttpServletResponse response) throws IOException {
		log.info("no==={}",no);
		String dbPassword = memberDao.getPassword(no); //no에해당하는 패스워드 받기...
		if(dbPassword.equals(password)) {
			int result = memberDao.deleteMember(no);
			if(result>0) {
				ScriptWriterUtil.alertAndNext(response, "회원탈퇴되었습니다.", "MemberList.do");
			} else {
				ScriptWriterUtil.alertAndBack(response, "회원탈퇴에 실패하였습니다.");
			}
		} else {
			ScriptWriterUtil.alertAndBack(response, "비밀번호를 확인해 주세요.");
		}
		return null;
	}
	
	@RequestMapping("/MemberModifyForm.do")
	public String memberModifyForm(int no) {
		return "member/member_modify";
	}
	
	
	@RequestMapping("/MemberModify.do")
	public String memberModify(int no,MemberDto memberDto, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		memberDto.setAddress(memberDto.getAddress01()+" "+memberDto.getAddress01());
		memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneNumber());
		memberDto.setNo(no);
		
		String dbPassword = memberDao.getPassword(no); //no에해당하는 패스워드 받기...
		if(dbPassword.equals(memberDto.getPassword())) {
			int result = memberDao.modifyMember(memberDto);
			if(result>0) {
				ScriptWriterUtil.alertAndNext(response, "회원정보 수정 되었습니다.", "MemberList.do");
			} else {
				ScriptWriterUtil.alertAndBack(response, "회원정보 수정에 실패하였습니다.");
			}
		} else {
			ScriptWriterUtil.alertAndBack(response, "비밀번호를 확인해 주세요.");
		}
		return null;
	}
	
	
	@RequestMapping("/MemberJsonList.do")
	@ResponseBody
	public Map<String,Object> jsonList() {
		Map<String, Object> hashMap = new HashMap<String,Object>();
		List<MemberDto> memberList =  memberDao.showAllMember();
		//model.addAttribute("memberList",memberList);
		hashMap.put("memberList", memberList);
		return hashMap;
	}
	
	@RequestMapping("/MemberJsonList02.do")
	@ResponseBody
	public List<MemberDto> jsonList02() {
		List<MemberDto> memberList =  memberDao.showAllMember();
		return memberList;
	}
	
}













