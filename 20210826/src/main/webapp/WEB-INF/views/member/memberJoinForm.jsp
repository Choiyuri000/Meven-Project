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
<title>회원가입 폼</title>
<script type="text/javascript">
	function login() {
		if (frm.password.value != frm.passwordCheck.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}

		if (frm.idCheck.value == 'N') {
			alert("아이디 중북체크를 해주세요");
			return false;
		}

		frm.submit();
	}

	function IdCheck() {
		window.open("idCheck.do?id=", "childForm",
				"width=570, height=400, resizable=no, scrollbars=no");
	}
</script>
</head>
<body>
	<div align="center" class="container">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" method="post">
				<div class="jumbotron">
					<table border="1">
						<tr>
							<th>아이디 입력</th>
							<td><input type="text" id="id" name="id" required="required">
								<button type="button" onclick="IdCheck()" value="idCheck">중복체크</button></td>
						</tr>
						<tr>
							<th>비밀번호 입력</th>
							<td><input type="password" id="password" name="password" required="required"></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" id="passwordCheck"
								name="passwordCheck"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" id="name" name="name" required="required"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" id="address" name="address" required="required"></td>
						</tr>
					</table>
				</div>
				<br /> <input type="button" onclick="login()" value="Join In">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="Cancel">&nbsp;&nbsp;&nbsp; <input
					type="button" value="Home" onclick="location.href='main.do'">
			</form>
		</div>
	</div>
</body>
</html>