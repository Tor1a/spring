<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 1. 값을 받아와야한다. -->
<%
	//
	
	request.setCharacterEncoding("utf-8");  // 요청으로 들어오는 한글 인코딩을 utf-8로 처리하겠다.
	response.setContentType("text/html; charset=utf-8");// 출력용 한글깨짐 방짐...
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw"); 
	String userName = request.getParameter("userName");
	int zipcode =  Integer.parseInt(request.getParameter("zipcode"));
	String address =  request.getParameter("address01")+" "+request.getParameter("address02");
	String phone = request.getParameter("phoneNumber")+request.getParameter("phoneMiddleNumber")+request.getParameter("phoneLastNumber");
	String userEmail = request.getParameter("userEmail");
	
	//out.println(userId+"<br>");
	//out.println(userPw+"<br>");
	//out.println(userName+"<br>");
	//out.println(zipcode+"<br>");
	//out.println(address+"<br>");
	//out.println(phone+"<br>");
	//out.println(userEmail+"<br>");
	// 제대로 넘어오면 소리 질러 주세요....
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection  conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO MEMBER VALUES	(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, userPw);
		pstmt.setString(3, userName);
		pstmt.setInt(4, zipcode);
		pstmt.setString(5, address);
		pstmt.setString(6, phone);
		pstmt.setString(7, userEmail);
		int result = pstmt.executeUpdate();// table에영향을 미칠때는 executeUpdate();
		if(result > 0) {
			//response.sendRedirect("list.jsp");
%>
			<script>
				alert("화원가입이 완료");
				location.href="list.jsp";
			</script>
<%
		} else {
%>
			<script>
				alert("화원가입 실패");
				history.back();
			</script>
<%
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
%>













