<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>회원 전체 목록</title>
<script type="text/javascript">
	function CallMember(str) {
		frm.id.value = str;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center" class="container">
		<div>
			<h1>회 원 목 록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberSelect.do" method="post">
				<div>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>ADDRESS</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="member" items="${members }">
								<tr onclick="CallMember('${member.id }')">
									<td>${member.id }</td>
									<td>${member.name }</td>
									<td>${member.address }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<br />
				<button type="button" onclick="location.href='main.do'">홈으로</button>
				<input type="hidden" id="id" name="id">
			</form>
		</div>
	</div>
</body>
</html>