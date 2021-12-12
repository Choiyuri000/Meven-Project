<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
<div align="center">
<div><h1>${message }</h1></div>
<div>
<button type="button" onclick="location.href='noticeList.do'">Go list</button>
</div>
</div>
</body>
</html>