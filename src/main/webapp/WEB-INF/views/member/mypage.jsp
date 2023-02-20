<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<form action="/member/modify.kh" method="post">
			ID : <input type="text" value="${member.memberId }" readonly><br>
			PW : <input type="password"><br>
			NAME : <input type="text" value="${member.memberName }" readonly><br>
			EMAIL : <input type="text" value="${member.memberEmail }"><br>
			PHONE : <input type="text" value="${member.memberPhone }"><br>
			ADDRESS : <input type="text" value="${member.memberAddr }"><br>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</form>
	</body>
</html>