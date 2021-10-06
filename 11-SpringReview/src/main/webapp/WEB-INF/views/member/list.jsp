<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">MEMBER LIST</h2>
		<div class="form wide">
			<table border="1">
				<cols>
					<col style="width: 50px">
					<col style="width: 100px">
					<col style="width: 100px">
					<col style="width: 100px">
					<col>
					<col style="width: 150px">
					<col style="width: 200px">
				</cols>
				<thead>
					<tr>
						<th>NO</th>
						<th>ID</th>
						<th>이름</th>
						<th>우편번호</th>
						<th>주소</th>
						<th>H.P</th>
						<th>E-MAIL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var ="memberDto" items="${memberList }">
						<tr>
							<td>${memberDto.no }</td>
							<!-- <td><a href="member_info.jsp">${memberDto.id }</a></td> -->
							<td><a href="MemberInfo.do?no=${memberDto.no }">${memberDto.id }</a></td>
							<td>${memberDto.name }</td>
							<td>${memberDto.zipcode }</td>
							<td>${memberDto.address }</td>
							<td>${memberDto.hp }</td>
							<td>${memberDto.email }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>





