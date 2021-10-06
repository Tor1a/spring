<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">로그인</h2>
		<form method="POST" action="MemberLogin.do" id="join" class="form"
			name="signUp">
			<table border="1" class="tdLeft">
				<cols>
					<col style="width: 200px">
					<col style="width: 600px">
				</cols>
				<tbody>
					<tr>
						<th>아이디 <span>*</span></th>
						<td><input type="text" name="id" placeholder="아이디"></td>
					</tr>
					<tr>
						<th>비밀번호 <span>*</span></th>
						<td><input type="password" name="password" placeholder="패스워드"  id="userPw"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="로그인" onClick="return signCheck();">
				<a href="javascript:history.back();">취소</a>
			</div>
		</form>
	</div>
	<!-- contents end -->
	<script>
		function signCheck() {
			if (document.signUp.userId.value == "") {
				alert("아이디를 입력하시오.");
				document.signUp.userId.focus();
				return false;
			} else if (document.signUp.userPw.value == "") {
				alert("패스워드를 입력하시오.");
				document.signUp.userPw.focus();
				return false;
			} else {
				return true;
			}
		}
	</script>
	
</main>
<%@ include file="../include/footer.jsp"%>





