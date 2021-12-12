<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>목 록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="noticeSelect.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>제목</th>
							<th>조회수</th>
						</tr>
						<c:forEach var="notice" items="${notices }">
							<tr>
								<td><c:out value="${notice.id }" /></td>
								<td><c:out value="${notice.writer }" /></td>
								<td><c:out value="${notice.writeDate }" /></td>
								<td><c:out value="${notice.title }" /></td>
								<td><c:out value="${notice.hit }" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div><br/>
				<input type="button" value="home" onclick="location.href='main.do'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>