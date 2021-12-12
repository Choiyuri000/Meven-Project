<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function CallMember(str) {
	frm.id.value = str;
	frm.submit();
}
</script>
<title>게시글 목록</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
	<div align="center">
		<div>
			<h1>목 록</h1>
		</div>
		<div>
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
						 onclick="CallMember('${notice.id}')">
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
			<br />
			<div>
				<c:if test="${id ne null}">
					<button type="button" onclick="location.href='noticeWriteForm.do'">글쓰기</button>
				</c:if>
			</div>
			<div>
				<form id="frm" action="noticeSelect.do" method="post">
					<input type="hidden" id="id" name="id"  >
				</form>
			</div>
		</div>
	</div>
</body>
</html>