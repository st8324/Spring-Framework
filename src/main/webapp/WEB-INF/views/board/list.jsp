<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Bordered Table</h2>
		<p>The .table-bordered class adds borders on all sides of the table and the cells:</p>            
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th width="10%">번호</th>
		      <th width="50%">제목</th>
		      <th width="20%">작성자</th>
		      <th width="20%">작성일</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="board" items="${list}">
			    <tr>
			      <td>${board.num}</td>
			      <td>${board.title}</td>
			      <td>${board.author}</td>
			      <td>${board.register_date}</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>