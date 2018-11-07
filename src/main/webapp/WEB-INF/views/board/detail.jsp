<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/global.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>게시판 상세</h1>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" name="title" id="title" 
                class="form-control" readonly value="${board.title}">
        </div>
        <div class="form-group">
            <label for="author">작성자</label>
            <input type="text" name="author" id="author" class="form-control" 
                readonly value="${board.author}">
        </div>
        <div class="form-group">
            <label for="contents">내용</label>
            <textarea name="contents" id="contents" rows="10" 
                class="form-control" readonly>${board.contents}</textarea>
        </div>
        <a href="<%= request.getContextPath() %>/board/list?page=${page}&search=${search}"><button type="button" class="btn btn-primary">목록</button></a>
        <a href="<%= request.getContextPath() %>/board/modify?num=${board.num}&page=${page}&search=${search}">
            <button type="button" class="btn btn-primary float-right">수정</button>
        </a>
        <a href="<%= request.getContextPath() %>/board/delete?num=${board.num}">
            <button type="button" class="btn btn-primary float-right">삭제</button>
        </a>
	</div>
</body>
</html>