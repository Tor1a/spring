package com.jjang051.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	//주입을 해준다. SpringContainer에서 이쪽으로 자동으로 주입을 해준다.
	
	
	
	//view
	@RequestMapping("/")
	public String home(Model model) {
		//dao 에 있는 메서드 실행해서 데이터 받아서   
		model.addAttribute("userName","jjang051");
		return "index";  // view  /WEB-INF/views/index.jsp  
	}
}