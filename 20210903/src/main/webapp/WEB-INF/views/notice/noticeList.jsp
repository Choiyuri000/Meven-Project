<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="notice" items="${notices }">
	${notice.id } : ${notice.title } <br>
</c:forEach>

<a href="noticeSelect.do">세부 글보기</a>


</body>
</html>