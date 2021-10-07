<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<div id="filterList">
	<ul>
		<li class="on">여행</li>
		<li>일상</li>
		<li>공부</li>
		<li>영화</li>
	</ul>
</div>
<div id="galleryList">
	
</div>
<div id="big">
	<div class="imgWrap">
		<div class="img">
			<img src="">
		</div>
		<div class="replyBox">
			<textarea name="reply" id="reply" placeholder="댓글을 입력해주세요."></textarea>
			<button class="btnReply">댓글 등록</button>
		</div>
	</div>
	<div class="replyList">
		<!-- 여기에 댓글 등록 -->
		<ul class="list">
			<li data-no="1" data-boardid="1">
			<div class="txt">댓글이 들어옵니다</div>
			<button><span class="matal-"></span></button>
			</li>
		</ul>
	</div>
</div>


<%@ include file="include/footer.jsp"%>