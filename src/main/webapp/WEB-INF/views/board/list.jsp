<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/global.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
#pagination{
	display : table;
	margin : 0 auto;
}
.dropdown:hover>.dropdown-menu{
  display: block;
}
</style>
</head>
<body>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
        </li>
        <c:if test="${!user.author.equals('user') }">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  관리자 페이지
            </a>
            <div class="dropdown-menu">
              <c:if test="${user.author.equals('super admin')}">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/cms/user">회원</a>
              </c:if>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/cms/board">게시판</a>
            </div>
          </li>
        </c:if>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath()%>/signout">로그아웃</a>
        </li>
      </ul>
    </div>
  </nav>
    
	<div class="container">
		<h1>게시판 리스트</h2>
		<a href="<%= request.getContextPath()%>/signout">로그아웃</a>
		<form method="get">
			<div class="input-group mb-3">
			  <select class="form-control" name="type">
			    <option value="0" <c:if test="${pageMaker.criteria.type ==0}">selected</c:if> >제목</option>
			    <option value="1" <c:if test="${pageMaker.criteria.type ==1}">selected</c:if> >작성자</option>
			    <option value="2" <c:if test="${pageMaker.criteria.type ==2}">selected</c:if> >내용</option>
			  </select>
			  <input type="text" class="form-control" placeholder="Search" name="search" value="${pageMaker.criteria.search}">
			  <div class="input-group-append">
			    <button class="btn btn-success" type="submit">검색</button> 
			  </div>
			</div>
		</form>
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
			      <td><a href="<%= request.getContextPath() %>/board/detail?num=${board.num}&page=${pageMaker.criteria.page}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">${board.title}</a></td>
			      <td>${board.author}</td>
			      <td>${board.register_date}</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<div id="pagination">
			<ul class="pagination">
				<li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>"> 
					<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pageMaker.startPage -1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"><i class="fas fa-angle-left"></i></a>
				</li>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
					<li class="page-item <c:if test="${pageMaker.criteria.page == i}">active</c:if>">
						<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">${i}</a>
					</li>
				</c:forEach>
				<li class="page-item <c:if test="${!(pageMaker.next)}">disabled</c:if>">
					<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pageMaker.endPage +1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"><i class="fas fa-angle-right"></i></a>
				</li>
			</ul>
		</div>
		<a href="<%= request.getContextPath() %>/board/register">
			<button class="btn btn-primary"> 등록 </button>
		</a>
	</div>
</body>
</html>