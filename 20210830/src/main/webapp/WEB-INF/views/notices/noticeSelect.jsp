<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function NoticeEdit(str) {
		if (str == 'U') {
			frm.action = "noticeUpdateForm.do";
		} else {
			frm.action = "noticeDelete.do"
		}
		frm.submit();
	}
</script>
<title>게시글 상세</title>
</head>
<jsp:include page="../home/header.jsp" />
<body>
	<div align="center">
		<div>
			<h1>상세 내용</h1>
		</div>
		<div >
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
					<td colspan="5"><textarea rows="5" cols="33">${notice.contents }</textarea></td>
				</tr>
			</table>
		</div>
		<br />
		<div>
			<c:if test="${id eq notice.writer }">
				<button type="button" onclick="NoticeEdit('U')">글 수정</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="NoticeEdit('D')">글 삭제</button>
					&nbsp;&nbsp;&nbsp;
			</c:if>
			<button type="button" onclick="location.href='noticeList.do'">목록보기</button>
		</div>
		<div>
			<form id="frm" name="frm" method="post">
				<input type="hidden" id="id" name="id" value="${notice.id }">
			</form>
		</div>
	</div>
</body>
</html>