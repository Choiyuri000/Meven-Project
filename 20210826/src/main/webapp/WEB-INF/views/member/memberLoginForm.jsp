<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>로그인 폼</title>
</head>
<body>
	<div align="center" class="container">
		<div >
			<h1>로 그 인</h1>
		</div>
		
		<div>
			<form id="frm" name="frm" action="memberLogin.do" method="post">
				<div class="jumbotron">
					<table border="1">
						<tr>
							<th>ID</th>
							<td><input type="text" id="id" name="id"></td>
						</tr>
						<tr>
							<th>PW</th>
							<td><input type="password" id="password" name="password"></td>
						</tr>
					</table>
				</div>
				<input type="submit" value="Login">&nbsp;&nbsp;&nbsp; 
				<input type="reset" value="Cancel">&nbsp;&nbsp;&nbsp;
				<input type="button" value="Home" onclick="location.href='main.do'">
			</form>
		</div>
	</div>
</body>
</html>