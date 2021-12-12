<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세</title>
<script type="text/javascript">
	function CallMember(str) {
		if (str == "U") {
			frm.action = "memberEditForm.do";
		} else {
			frm.action = "memberDelete.do";
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>상 세 정 보</h1>
		</div>
		<div>
			<form id="id" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td>${member.id }</td>
							<th>비밀번호</th>
							<td>${member.password }</td>
							<th>이름</th>
							<td>${member.name }</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${member.address }</td>
						</tr> 
					</table>
				</div><br/>
				<div>
					<button type="button" onclick="CallMember('U')">수정</button>
					<button type="button" onclick="CallMember('D')">삭제</button>
					<button type="button" onclick="location.href='memberList.do'"></button>
					<input type="hidden" id="id" name="id" value="${member.id }">
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>