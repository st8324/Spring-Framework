<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기는 ${company}입니다.
	<form action="/spring/test" method="post">
		<input name="id">
		<button type="submit">제출</button>
	</form>
</body>
</html>