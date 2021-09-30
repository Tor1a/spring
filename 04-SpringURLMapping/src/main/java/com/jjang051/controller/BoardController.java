package com.jjang051.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Board")
public class BoardController {
	
	@RequestMapping("/List.do")
	public String list() {
		return "board/lsit";
	}
	@RequestMapping("/Write.do")
	public String write() {
		return "board/write";
	}
	@RequestMapping("/Update.do")
	public String update() {
		return "board/update";
	}
}
