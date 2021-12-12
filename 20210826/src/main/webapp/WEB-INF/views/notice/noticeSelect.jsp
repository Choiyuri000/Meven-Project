<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지세부내용</title>
</head>
<body>
	<div>
		<div>
			<h1>상 세 정 보</h1>
		</div>
		<div>
			<form action="noticeList.do">
				<div onmousemove="noticeList.do">
					<table border="1">
						<tr>
							<th>Title</th>
							<td>${notice.title }</td>
							<th>HIT</th>
							<td>${notice.hit }</td>
						</tr>
						<tr>
							<th>Writer</th>
							<td>${notice.writer }</td>
							<th>WriteDate</th>
							<td>${notice.writeDate }</td>
						</tr>
						<tr>
							<th>Contents</th>
							<td>${notice.contents }</td>
						</tr>
					</table>
				</div><br />
				<div>
					<input type="button" value="list" onclick="location.href='main.do'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>