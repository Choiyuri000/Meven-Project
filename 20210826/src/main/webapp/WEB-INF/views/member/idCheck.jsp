<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복체크확인</title>
<script type="text/javascript">
	function CloseWindow() {
		window.close();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>${message }</h1>
		</div>
		<div>
			<button type="button" onclick="CloseWindow()">확인</button>
		</div>
	</div>
</body>
</html>