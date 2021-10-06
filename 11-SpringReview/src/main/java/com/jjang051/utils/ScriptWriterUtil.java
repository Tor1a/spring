package com.jjang051.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ScriptWriterUtil {
	//메서드 3개  경고창, 경고창 띄우고 이전 페이지로 돌아가기,경고창 띄우고 다음 페이지로 가기, 
	//static
	public static void init(HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}
	public static void alert(HttpServletResponse response, String alertMessage) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMessage+"');");
		out.println("</script>");
		out.flush();//무조건 밀어넣기...
	}
	public static void alertAndBack(HttpServletResponse response, String alertMessage) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMessage+"');");
		out.println("history.back();");
		out.println("</script>");
		out.flush();//무조건 밀어넣기...
	}
	//메타버스
	public static void alertAndNext(HttpServletResponse response, String alertMessage,String next) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMessage+"');");
		out.println("location.href='"+next+"'");
		out.println("</script>");
		out.flush();//무조건 밀어넣기...
	}
}









