package com.jjang051.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.model.MemberDto;

@Controller
@RequestMapping("/Member")
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@RequestMapping("/MemberJoinForm.do")
	public String memberJoinForm() {
		return "member/join";
	}
	
	@RequestMapping("/MemberJoin.do")
	@ResponseBody
	public String memberJoin(@ModelAttribute MemberDto memberDto) {
		//logger로 찍어 보기...
		logger.info("memberDto = {}",memberDto.toString());
		return "OK";
	}
}
