<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버리스트</title>
</head>
<body>
<c:forEach var="member" items="${members }">
${member.id } : ${member.password } <br>
</c:forEach>
<a href="noticeList.do">게시글 목록</a>
<a href="memberInsert.do">멤버추가</a>

</body>
</html>