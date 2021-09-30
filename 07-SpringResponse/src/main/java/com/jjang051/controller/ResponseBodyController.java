package com.jjang051.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jjang051.model.MemberDto;

//@Controller
//@ResponseBody
@RestController  // @Controller 랑 @ResponseBody 를 동시에 사용
public class ResponseBodyController {
	
	//JSON 출력해주면 front에 받아서 처리....
	@GetMapping("/ResponseBody01.do")
	public void responseBody01(HttpServletResponse response) throws IOException {
		response.getWriter().write("ok");
	}
	
	@GetMapping("/ResponseBody02.do")
	public ResponseEntity<String> responseBody02() {
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
	
	//@ResponseBody  // view를 매핑하지 않는다.
	@GetMapping("/ResponseBody03.do")
	public String responseBody03() {
		return "ok"; //view를 찾는다. /WEB-INF/views/ok.jsp
	}
	
	@GetMapping("/ResponseBody04.do")
	public ResponseEntity<MemberDto> responseBody04() {
		MemberDto memberDto = new MemberDto();
		memberDto.setName("jjang051");
		memberDto.setAge(20);
		// 객체를 JSON으로 변환해주는 library  Gson // jackson
		return new ResponseEntity<MemberDto>(memberDto,HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.OK)
	//@ResponseBody
	@GetMapping("/ResponseBody05.do")
	public MemberDto responseBody05() {
		MemberDto memberDto = new MemberDto();
		memberDto.setName("jjang051");
		memberDto.setAge(20);
		// 객체를 JSON으로 변환해주는 library  Gson // jackson
		return memberDto;
	}
	
	@ResponseStatus(HttpStatus.OK)
	//@ResponseBody
	@GetMapping("/ResponseBody06.do")
	public Map<String, Object> responseBody06() {
		Map<String,Object> map = new HashMap<String,Object>();
		MemberDto memberDto = new MemberDto();
		memberDto.setName("jjang051");
		memberDto.setAge(20);
		map.put("member", memberDto);
		return map;
	}
}






