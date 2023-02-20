<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원등록</title>
	</head>
	<body>
		<form action="/member/register.kh" method="post">
			ID : <input type="text" name="memberId"><br>
			PW : <input type="password" name="memberPw"><br>
			NAME : <input type="text" name="memberName"><br>
			EMAIL : <input type="text" name="memberEmail"><br>
			PHONE : <input type="text" name="memberPhone"><br>
			ADDRESS : <input type="text" name="memberAddr"><br>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</body>
</html>