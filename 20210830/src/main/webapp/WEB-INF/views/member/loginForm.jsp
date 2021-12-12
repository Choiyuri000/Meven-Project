<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
	<div align="center">
		<div><h1>로 그 인</h1></div>
		<div>
			<form id="frm" name="frm" action="login.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">ID</th>
							<td width="150"><input type="text" id="id" name="id" ></td>
						</tr>
						<tr>
							<th width="100">Password</th>
							<td width="150"><input type="password" id="password" name="password" ></td>
						</tr>
					</table>
				</div><br/>
		<div>
		
			<input type="submit" value="login in">&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="location.href='main.do'" value="cancel">
		</div>
			</form>
		</div>
	</div>
</body>
</html>