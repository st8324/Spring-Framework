<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
	<div>
		<form method="POST">
			<div>
				<label for="">아이디</label>
				<input type="text" name="id">
			</div>
			<div>
				<label for="">비밀번호</label>
				<input type="password" name="pw">
			</div>
			<button type="submit">로그인</button>
		</form>
	</div>
	<a href="<%= request.getContextPath() %>/signup">회원가입</a>
</body>
</html>






