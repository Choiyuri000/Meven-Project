<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>게시글 목록</title>
</head>
<body>
	<div align="center" class="container">
		<div>
			<h1>목 록</h1>
		</div>
		<div>
			<div>
				<form id="frm" name="frm" action="noticeSelect.do" method="post">
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>제목</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="notice" items="${notices }">
								<tr>
									<td><c:out value="${notice.id }" /></td>
									<td><c:out value="${notice.writer }" /></td>
									<td><c:out value="${notice.writeDate }" /></td>
									<td><c:out value="${notice.title }" /></td>
									<td><c:out value="${notice.hit }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
			<br /> <input type="button" value="home"
				onclick="location.href='main.do'">
		</div>
		<div>
			<form id="frm" name="frm" action="noticeSelect.do" method="post">
				<input type="hidden" id="id" name="id" value="${notice.id }">
			</form>
		</div>

	</div>

</body>
</html>