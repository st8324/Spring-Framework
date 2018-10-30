<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <title>Document</title>
</head>
<body>
	<div class="container">
		<h1> 로그인 </h1>
		<form method="POST">
			<div class="form-group">
				<label for="">아이디</label>
				<input type="text" name="id" 
					class="form-control">
			</div>
			<div class="form-group">
				<label for="">비밀번호</label>
				<input type="password" name="pw"
					class="form-control">
			</div>
			<button type="submit" class="btn btn-default">
				로그인
			</button>
		</form>
		<a href="<%= request.getContextPath() %>/signup">회원가입</a>
		<input type="hidden" value="${loginOk}" id="loginOk"/>
	</div>
	<script type="text/javascript">
		var loginOk = document.getElementById('loginOk');
		if(loginOk.value == 0){
			alert('아이디 또는 패스워드를 잘못입력했습니다');
		}
		if(${signup} == 1){
			alert('회원가입에 성공했습니다.');
		}
	</script>
</body>
</html>






