<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="main.do" /> <!-- 모든 요청을 한 곳으로 보내기 위해 -->
	<% response.sendRedirect("main.do"); %>
</body>
</html>