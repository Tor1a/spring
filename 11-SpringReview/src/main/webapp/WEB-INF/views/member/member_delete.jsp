<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">회원탈퇴</h2>
		<form method="POST" action="MemberDelete.do" class="form">
			<table border="1" class="tdLeft">
				<cols>
				<col style="width: 150px">
				<col style="width: 550px">
				</cols>
				<tbody>
					<tr>
						<th>password</th>
						<td><input type="password" placeholder="패스워드를 입력하시오." name="password"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원탈퇴">
				<a href="MemberInfo.do">취소</a>
			</div>
			<input type="hidden" name="no" value="${param.no }" >
		</form>
	</div>
	<!-- contents end -->
</main>
<%@ include file="../include/footer.jsp"%>





