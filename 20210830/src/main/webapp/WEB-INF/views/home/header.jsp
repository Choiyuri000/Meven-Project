<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="main.do">Home</a></li>
				<c:if test="${empty id}">
					<li><a href="loginForm.do">Login</a></li>
				</c:if>
				<c:if test="${id ne null }">
					<li><a href="logOut.do">LogOut</a></li>
					<li><a href="myInfoEdit.do">MyPage</a></li>
				</c:if>
				
				<li><a href="noticeList.do">Notice</a></li>
				<li><a href="#">Product</a></li>
				<li><a href="#">Service</a></li>
				<c:if test="${auth eq 'ADMIN' }">
					<li><a href="#">Members</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>