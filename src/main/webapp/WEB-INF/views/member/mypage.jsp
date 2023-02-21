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
			ID : <input type="text" name="memberId" value="${member.memberId }" readonly><br>
			PW : <input type="password" name="memberPw"><br>
			NAME : <input type="text" name="memberName" value="${member.memberName }" readonly><br>
			EMAIL : <input type="text" name="memberEmail" value="${member.memberEmail }"><br>
			PHONE : <input type="text" name="memberPhone" value="${member.memberPhone }"><br>
			ADDRESS : <input type="text" name="memberAddr" value="${member.memberAddr }"><br>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</form>
		<a href="/member/out.kh?memberId=${member.memberId }">탈퇴하기</a>
	</body>
</html>