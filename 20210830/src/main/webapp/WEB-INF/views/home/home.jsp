<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function NoticeSelect(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>
<title>홈</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div align="center">
		<div>
			<h1>Welcome My HomePage!</h1>
		</div>
		<div>
			<h2>공지사항</h2>
		</div>
		<div>
			<table border="1">
				<tr>
					<td>ID</td>
					<td>writer</td>
					<td>writeDate</td>
					<td>title</td>
					<td>contents</td>
					<td>hit</td>
				</tr>
				<c:forEach var="notice" items="${notices }">
					<tr onmouseover="this.style.background='yellow'"
						onmouseout="this.style.background='white'"
						onclick="NoticeSelect('${notice.id}')">
						<td width="50">${notice.id }</td>
						<td width="100">${notice.name }</td>
						<td width="100">${notice.writeDate }</td>
						<td width="150">${notice.title }</td>
						<td width="200">${notice.contents }</td>
						<td width="30">${notice.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<form id="frm" name="frm" action="noticeSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
		</div>
	</div>
</body>
</html>