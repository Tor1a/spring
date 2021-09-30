package com.jjang051.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Board")
public class BoardController {
	
	@RequestMapping(value="/List.do", method=RequestMethod.GET)
	public String list() {
		return "board/list";
	}
	
	@RequestMapping(value="/Write.do", method=RequestMethod.POST)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value="/Update.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String update() {
		return "board/update";
	}
	
	
}
