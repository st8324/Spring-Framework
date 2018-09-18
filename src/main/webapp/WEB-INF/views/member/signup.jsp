<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="/spring/resources/css/base_signup.css">
	<title>Document</title>
</head>
<body>
	<div class="container">
		<form action="" method="get">
			<div class="display-flex">
				<div class="input-form"> 아이디 </div>
				<input type="text" name="id">
			</div>
			<div class="display-flex">
				<div class="input-form"> 비밀번호 </div>
				<input type="password" name="pw">
			</div>
			<div class="display-flex">
				<div class="input-form"> 비밀번호 확인 </div>
				<input type="password" name="pwConfirm">
			</div>
			<div class="display-flex">
				<div class="input-form">성별</div>
				<label for="male">남성</label>
				<input type="radio" name="gender" id="male"
				checked value="male">
				<label for="female">여성</label>
				<input type="radio" name="gender" id="female"
				value="female">
			</div>
			<div class="display-flex">
				<div class="input-form">이메일</div>
				<input type="email" name="email">
			</div>
			<div>
				<button type="submit" id="submit">제출</button>
			</div>
		</form>
	</div>
</body>
</html>