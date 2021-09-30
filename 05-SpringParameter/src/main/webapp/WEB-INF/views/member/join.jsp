<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">회원가입</h2>
		<form method="POST" action="MemberJoin02.do" id="join" class="form"
			name="signUp">
			<table border="1" class="tdLeft">
				<cols>
					<col style="width: 200px">
					<col style="width: 600px">
				</cols>
				<tbody>
					<tr>
						<th>아이디 <span>*</span></th>
						<td><input type="text" name="userId" placeholder="아이디"></td>
					</tr>
					<tr>
						<th>비밀번호 <span>*</span></th>
						<td><input type="password" name="userPw" placeholder="패스워드"  id="userPw"></td>
					</tr>
					<tr>
						<th>비밀번호확인 <span>*</span></th>
						<td>
							<input type="password" name="userPw02" placeholder="패스워드" id="userPw02">
							<span class="txtPass red"></span>
						</td>
					</tr>
					<tr>
						<th>이름*</th>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<div>
								<!-- 정규표현식.... -->
								<input type="number" name="zipcode" class="short" id="zipcode"> 
								<input type="button" name="addressBtn" value="우편번호" id="btnZip">
							</div>
							<div>
								<input type="text" name="address01" id="address01"><span>기본주소</span>
							</div>
							<div>
								<input type="text" name="address02" id="address02"><span>나머지주소</span>
							</div>
						</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td><select name="phoneNumber" class="short">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="017">017</option>
						</select> - <input type="number" name="phoneMiddleNumber" class="short">
							- <input type="number" name="phoneLastNumber" class="short"></td>
					</tr>
					<tr>
						<th>이메일<span>*</span></th>
						<td><input type="text" name="userEmail"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원가입" onClick="return signCheck();">
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
			} else if (document.signUp.userPw02.value == "") {
				alert("패스워드확인를 입력하시오.");
				document.signUp.userPw02.focus();
				return false;
			} else {
				return true;
			}
		}
	</script>
	
	<script>
		$("#btnZip").on("click",function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            //console.log(data.zonecode);
		            //console.log(data.address);
		        	$("#zipcode").val(data.zonecode);
		        	$("#address01").val(data.address);
		            
		        }
		    }).open();
			return false;
		});
		$("#userPw02").on("keyup",function(e){
			if($("#userPw").val() !== $("#userPw02").val()){
				//console.log("틀리다");
				$(".txtPass").text("비밀번호가 맞지 않습니다.");
				$(".txtPass").addClass("red");
			} else {
				//console.log("같다");
				$(".txtPass").text("비밀번호가 맞습니다.");
				$(".txtPass").removeClass("red");
			}
		});
	</script>
</main>
<%@ include file="../include/footer.jsp"%>





