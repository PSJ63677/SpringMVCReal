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
			ADDRESS : <input type="text" id="sample4_postcode" name="memberAddr">
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
			function sample4_execDaumPostcode() {
				new daum.Postcode({
				      oncomplete: function(data) {
				           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				           // 예제를 참고하여 다양한 활용법을 확인해 보세요.
				           console.log(data);
				           document.getElementsById("sample4_postcode").value = data.zonecode + ", " + data.address + ", " + data.autoJibunAddress + ", " + data.autobuildingName;
				       }
				}).open();
			}
		</script>
	</body>
</html>