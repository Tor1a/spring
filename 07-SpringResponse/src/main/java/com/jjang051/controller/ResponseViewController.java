package com.jjang051.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j  // log찍는 Annotation
public class ResponseViewController {
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@RequestMapping(value="View01.do",method=RequestMethod.GET)
	public ModelAndView responseView01() {
		//ModelAndView mav = new ModelAndView("response/view01");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("response/view01");
		mav.addObject("sendData", "view01 데이터 보냅니다.");
		return mav;
	}
	
	@RequestMapping("View02.do")
	public String responseView02(Model model) {
		log.info("log를 기록합니다.");
		model.addAttribute("sendData", "view01 데이터 보냅니다.");
		return "response/view01";
	}
	
	//@RequestMapping(value="View01.do",method=RequestMethod.GET)
	@GetMapping("View03.do")
	public String responseView03(Model model) {
		log.info("log를 기록합니다.");
		model.addAttribute("sendData", "view01 get으로 받은 데이터 보냅니다.");
		return "response/view01";
	}
	@PostMapping("View04.do")
	public String responseView04(Model model) {
		log.info("log를 기록합니다.");
		model.addAttribute("sendData", "view01 post으로 받은 데이터 보냅니다.");
		return "response/view01";
	}
}





