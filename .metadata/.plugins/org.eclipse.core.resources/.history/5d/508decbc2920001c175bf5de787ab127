package com.jjang051.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

//web.xml 대체....
public class SpringConfigClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("start");
		//web.xml에서 servletAppContext 설정을 자바로 대치....
		
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class);
		
		//DispatcherServlet 설정
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		
		//부가 설정
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		//bean정의 클래스 지정  root-context.xml
		 AnnotationConfigWebApplicationContext rootAppContext =  new AnnotationConfigWebApplicationContext();
		 rootAppContext.register(RootAppContext.class);
		
		 System.out.println("rootAppContext");
		
		//리스너 설정
		ContextLoaderListener listener =  new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);
		
		System.out.println("listener");
		
		//인코딩 설정
		FilterRegistration.Dynamic filter =  servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcher");
	}
}







