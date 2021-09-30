<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INCLUDE 연습</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="summernote/summernote.min.css" rel="stylesheet">

<link rel="stylesheet" href="css/layout.css">

<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="summernote/summernote.min.js"></script>
<script	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body>
	<header id="header">
		<div class="container">
			<h1 id="logo">
				<a href="">JJANG051'S MEDIA</a>
				
			</h1>
			<nav id="gnb">
				<c:choose>
					<c:when test="${empty loggedMember }">
						<ul>
							<li><a href="MemberLoginForm02.do">로그인</a></li>
							<li><a href="MemberJoinForm02.do">회원가입</a></li>
							<li><a href="BoardList02.do">게시판</a></li>
							<li><a href="MemberList02.do">회원리스트</a></li>
							<!-- <li><a href="../board/faq.jsp">자주하는 질문</a></li> -->
						</ul>
					</c:when>
					<c:otherwise>
						<ul>
							<li><a href="MemberInfo02.do?no=${loggedMember.getNo()}">${loggedMember.getName() }</a></li>
							<li><a href="MemberLogOut02.do">로그아웃</a></li>
							<li><a href="BoardList02.do">게시판</a></li>
							<!-- <li><a href="../board/faq.jsp">자주하는 질문</a></li> -->
						</ul>
					</c:otherwise>
				</c:choose>
			</nav>
		</div>
	</header>
	<!-- 내용은 여기에 들어감... -->