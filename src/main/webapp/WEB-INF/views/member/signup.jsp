<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<!-- <link rel="stylesheet" href="/spring/resources/css/base_signup.css"> -->
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
		<h1> 회원가입 </h1>
		<form action="" method="post">
			<div class="form-group">
				<div class="input-form"> 아이디 </div>
				<input type="text" name="id" 
					class="form-control">
			</div>
			<div class="form-group">
				<div class="input-form"> 비밀번호 </div>
				<input type="password" name="pw"
					class="form-control">
			</div>
			<div class="form-group">
				<div class="input-form"> 비밀번호 확인 </div>
				<input type="password" name="pwConfirm"
					class="form-control">
			</div>
			<div class="form-group">
				<div class="input-form">성별</div>
				<label for="male">남성</label>
				<input type="radio" name="gender" id="male"
				checked value="male">
				<label for="female">여성</label>
				<input type="radio" name="gender" id="female"
				value="female">
			</div>
			<div class="form-group">
				<div class="input-form">이메일</div>
				<input type="email" name="email"
					class="form-control">
			</div>
			<div>
				<button type="submit" id="submit" class="btn btn-primary">제출</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	if(${signup} == 0){
		alert('회원가입에 실패했습니다.');
	}
	var form = document.getElementsByTagName('form');
	form[0].onsubmit = checkValid;
	function checkValid(){
		if(!checkValidId()){
			alert("아이디는 5~12자로 숫자와 영문자로 이루어져있습니다.");
			return false;
		}
		if(!checkValidPw()){
			alert("비밀번호는 8~20자이며, 숫자와 영문자가 꼭 들어가야합니다.");
			return false;
		}
		if(!checkValidPwConfirm()){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		}
		if(!checkValidEmail()){
			alert("이메일을 입력해주세요.");
			return false;
		}
		return true;
	}
	function checkValidEmail(){
		var email = document.getElementsByName('email')[0].value;
		if(email ==""){
			return false;
		}
		return true;
	}
	function checkValidPw(){
		var regexPw = /^(?=\w{8,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/;
		var pw = document.getElementsByName('pw')[0].value;
		if(!checkRegex(regexPw,pw)){
			return false;
		}
		return true;
	}
	function checkValidId(){
		var regexId = /^\w{5,12}$/;
		var id = document.getElementsByName('id')[0].value;
		if(!checkRegex(regexId,id)){
			return false;
		}
		return true;
	}
	function checkValidPwConfirm(){
		var pw = document.getElementsByName('pw')[0].value;
		var pwConfirm 
			= document.getElementsByName('pwConfirm')[0].value;
		if(pw != pwConfirm)
			return false;
		return true;
	}
	function checkRegex(regex, str){
		if(!regex.test(str)){
			return false;
		}
		return true;
	}
	</script>
</body>
</html>








