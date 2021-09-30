package com.jjang051.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyStringController {
	
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/RequestBodyString01.do")
	public void requestBodyString01(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody =  StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		log.info("messageBody = {}",messageBody);
		response.getWriter().write("ok");
	}
	
	@PostMapping("/RequestBodyString02.do")
	public void requestBodyString02(InputStream inputStream, Writer responseWriter) throws IOException {
		String messageBody =  StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		log.info("messageBody = {}",messageBody);
		responseWriter.write("ok");
	}
	
	@PostMapping("/RequestBodyString03.do")
	public HttpEntity<String> requestBodyString03(HttpEntity<String> httpEntity) throws IOException {
		String messageBody =  httpEntity.getBody();
		log.info("messageBody = {}",messageBody);
		return new HttpEntity<String>("ok");
	}
	
	@ResponseBody
	@PostMapping("/RequestBodyString04.do")
	public String requestBodyString04(@RequestBody String messageBody) throws IOException {
		log.info("messageBody = {}",messageBody);
		return "ok";
	}
}













