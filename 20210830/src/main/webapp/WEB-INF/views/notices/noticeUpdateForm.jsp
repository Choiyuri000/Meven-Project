<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
	<div align="center">
		<div><h1>글 작업</h1></div>
		<form id="frm" name="frm" action="noticeUpdate.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th>ID</th>
						<td>${notice.id }</td>
						<th>writer</th>
						<td>${notice.name }</td>
						<th>writeDate</th>
						<td>${notice.writeDate }</td>
					</tr>
					<tr>
						<th>title</th>
						<td colspan="3">${notice.title }</td>
						<th>hit</th>
						<td>${notice.hit }</td>
					</tr>
					<tr>
						<th>contents</th>
						<td colspan="5"><textarea rows="5" cols="33" id="contents" name="contents">${notice.contents }</textarea></td>
					</tr>
				</table>
			</div>
			<br />
			<div>

				<input type="hidden" id="id" name="id" value="${notice.id }">
				<input type="submit" value="수정"> <input type="reset"
					value="취소">
				<button type="button" onclick="location.href='noticeList.do'">목록</button>
			</div>
		</form>
	</div>
</body>
</html>