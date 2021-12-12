<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>${member.name }${message }</h1>
		</div>
		<div>
			<a href="memberList.do">멤버목록</a> <a href="noticeList.do">공지사항</a>
		</div>
	</div>
</body>
</html>