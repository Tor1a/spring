package com.jjang051.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//servlet-context.xml 대체


@Configuration

//Controller annotation이 붙어있는 class를  Controller 로 등록해준다.
@EnableWebMvc

//scan할 패키지 지정  annotation은 마지막에 ;을 쓰지 않는다.
@ComponentScan("com.jjang051.controller")
public class ServletAppContext implements WebMvcConfigurer {
	
	//ViewResolver
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	//정적 파일 세팅
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
}













