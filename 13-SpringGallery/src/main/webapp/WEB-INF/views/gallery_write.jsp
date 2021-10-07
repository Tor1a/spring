<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
	<div id="contents">
		<h2 class="contentsTitle">이미지 업로드</h2>
		<form method="POST" action="GalleryWrite.do" id="join" class="form" name="signUp" enctype="multipart/form-data" >
			<table border="1" class="tdLeft">
				<cols>
				<col style="width: 200px">
				<col style="width: 600px">
				</cols>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" placeholder="제목을 입력하시오." id="title">
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="contents" id="txtContents"></textarea>
						</td>
					</tr>
					<tr>
						<th>파일</th>
						<td><input type="file" name="multipartFile" id="img"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="확인">
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
	<%@ include file="include/footer.jsp" %>