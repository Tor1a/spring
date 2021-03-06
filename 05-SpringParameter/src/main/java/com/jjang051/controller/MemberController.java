package com.jjang051.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.model.MemberDto;

@Controller
@RequestMapping("/Member")
public class MemberController {
	//board/write.jsp, list.jsp
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@RequestMapping("/Join.do")
	public String join(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age =  Integer.parseInt( request.getParameter("age") );
		logger.info("name = {},age={}",name,age);
		return "member/join";
	}
	
	@RequestMapping("/Join02.do")
	public String join02(@RequestParam("name")String userName,
						@RequestParam("age") int userAge
			) {
		logger.info("name = {},age={}",userName,userAge);
		return "member/join";
	}
	
	@RequestMapping("/Join03.do")
	public String join03(@RequestParam	String name,
						@RequestParam int age
			) {
		logger.info("name = {},age={}",name,age);
		return "member/join";
	}
	
	@RequestMapping("/Join04.do")
	public String join04(String name,
						 int age
			) {
		logger.info("name = {},age={}",name,age);
		return "member/join";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join05.do")
	public String join05(String name,
						 int age
			) {
		logger.info("name = {},age={}",name,age);
		return "Ok";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join06.do")
	public String join05Required(@RequestParam(required = true)	String name,
								@RequestParam(required = false) int age
			) {
		logger.info("name = {},age={}",name,age);
		return "Ok";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join07.do")
	public String join05RequiredDefault(@RequestParam(required = true, defaultValue = "noname")	String name,
								@RequestParam(required = false, defaultValue = "1") int age
			) {
		logger.info("name = {},age={}",name,age);
		return "Ok";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join08.do")
	public String join08ParamMap(@RequestParam Map<String,Object> parameterMap) {
		logger.info("name = {},age={}",parameterMap.get("name"),parameterMap.get("age"));
		return "Ok";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join09.do")
	public String join09ModelAttribute(@RequestParam String name, @RequestParam int age) {
		MemberDto memberDto = new MemberDto();
		memberDto.setName(name);
		memberDto.setAge(age);
		logger.info("name = {},age={}",memberDto.getName(),memberDto.getAge());
		return "Ok";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join10.do")
	public String join10ModelAttribute(@ModelAttribute MemberDto memberDto) {
		
		logger.info("name = {},age={}",memberDto.getName(),memberDto.getAge());
		return "Ok";
	}
	
	@ResponseBody	// view를 찾지 않는다.
	@RequestMapping("/Join11.do")
	public String join11ModelAttribute(MemberDto memberDto) {
		
		logger.info("name = {},age={}",memberDto.getName(),memberDto.getAge());
		return "Ok";
	}
	
	
	
	@RequestMapping("/List.do")
	public String list() {
		return "member/list";
	}
}
