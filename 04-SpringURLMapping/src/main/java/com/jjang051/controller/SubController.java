package com.jjang051.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@RequestMapping("/Sub01.do") // 둘 다 받는다 post/get
	public String sub01() {
		logger.info("/Sub01.do로 ㅇ이동");
		return "sub/sub01"; // jsp로 포워딩
				
	}
	@RequestMapping("/Sub02.do")
	public String sub02() {
		logger.info("/Sub02.do로 ㅇ이동");
		return "sub/sub02"; // jsp로 포워딩
	}
}
