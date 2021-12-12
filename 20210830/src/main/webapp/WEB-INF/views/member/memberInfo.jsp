<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
	<div align="center">
		<div>
			<h1>회원정보 수정</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="myInfoUpdate.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="id" name="id" value="${member.id }"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="password" name="password" value="${member.password }"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" id="name" name="name" value="${member.name }"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" id="address" name="address" value="${member.address }"></td>
						</tr>
						<tr>
							<th>권한</th>
							<td><input type="text" id="auth" name="auth" value="${member.auth }"></td>
						</tr>
					</table>
				</div><br />
				<div>
				<input type="hidden" id="id" name="id" value="${member.id }">
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
				<input type="button" onclick="location.href='main.do'" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>