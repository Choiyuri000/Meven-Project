<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
	<div align="center">
		<div>
			<h1>글 쓰기</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="noticeWrite.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th align="center">제목</th>
							<td><input type="text" id="title" name="title" size="36"></td>
							<th align="center">작성일자</th>
							<td><input type="date" id="writeDate" name="writeDate"></td>
						</tr>
						<tr>
							<th align="center">내용</th>
							<td colspan="3">
							<textarea rows="5" cols="70" id="contents" name="contents"></textarea></td>
						</tr>
					</table>
				</div><br />
				<div>
				<input type="submit" value="save">&nbsp;
				<input type="reset" value="cancel">&nbsp;
				<input type="button" onclick="location.href='noticeList.do'" value="lits">
				</div>
				<input type="hidden" id="writer" name="writer" value="${id }">
			</form>
		</div>
	</div>
</body>
</html>