<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세</title>
	</head>
	<body>
		<h1>공지사항 상세</h1>
		번호 : ${notice.noticeNo } / 제목 : ${notice.noticeTitle } / 작성자 : ${notice.noticeWriter } / 작성날짜 : ${notice.nCreateDate }<br>
		내용 ${notice.noticeContent }<br>
		첨부파일 ${notice.noticeFilename }<br>
		<a href="#">수정하기</a>
		<a href="javascript:void(0);" onclick="removeCheck(${notice.noticeNo });">삭제하기</a>
		<script>
			function removeCheck(noticeNo) {
				if(confirm("정말 삭제하시겠습니까?")) {
					location.href="/notice/remove.kh?noticeNo="+noticeNo;
				}
			}
		</script>
	</body>
</html>