package com.jjang051.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.model.BoardDao;
import com.jjang051.model.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	BoardDto boardDto; 
	
	//@PostMapping("/BoardList.do")
	//@GetMapping("/BoardList.do")
	@RequestMapping("/BoardList.do")
	//@ResponseBody
	public String list(Model model) {
		model.addAttribute("boardList", "boardList");
		return "board/list"; //WEB-INF/views/board/list.jsp
	}
}




