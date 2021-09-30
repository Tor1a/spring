package com.jjang051.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Member")
public class MemberController {
	//board/write.jsp, list.jsp
	
	@RequestMapping("/Join.do")
	public String join() {
		return "member/join";
	}
	
	@RequestMapping("/List.do")
	public String list() {
		return "member/list";
	}
}
