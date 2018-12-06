<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/global.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>관리자 페이지</title>
<style type="text/css">
.sub-menu{
  width : 200px;
  /*  브라우저 높이에서 네비게이션의 높이를 뺌  */
  height: calc(100vh - 56px);
  background-color: gray;
}
.sub-menu>ul{
  /*  리스트의 마커를 제거 */
  list-style: none;
  margin: 0;
  /*  리스트의 들여쓰기를 제거 */
  padding: 0;
  text-align: center;
}
.sub-menu>ul>li{
  display: block;
  height: 40px;
  /*  문자열의 높이를 박스의 중간으로 하기 위해 */
  line-height: 40px;
  font-size: 23px;
  border-bottom: solid 1px white;
}
a{
  text-decoration: none;
  color: black;
}
.sub-menu a{
  color: white;
}
.sub-menu .select a{
  color: black;
}
.sub-menu .select{
  font-weight: bold;
  background-color: whitesmoke;
}
.contents{
  width:calc(100%);
}
.container-table{
  width: 400px;
  margin: 40px auto 0;
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

<div class="container-fluid">
  <div class="row">
    <div class="contents">
      <div class="container-table">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th width="150px">아이디</th>
              <th width="100px">권한</th>
              <th width="150px">수정</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="acc" items="${list}">
              <tr>
                <td>${acc.id}</td>
                <td>${acc.author}</td>
                <td>
                  <c:choose>
                    <c:when test="${acc.author.compareTo('user')==0}">
                      <a href="<%=request.getContextPath() %>/admin/cms/user/modify?author=admin&id=${acc.id}">
                        <button class="btn btn-outline-primary">admin</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <a href="<%=request.getContextPath() %>/admin/cms/user/modify?author=user&id=${acc.id}">
                        <button class="btn btn-outline-primary">user</button>
                      </a>
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <div id="pagination">
          <ul class="pagination">
            <li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>"> 
              <a class="page-link" href="<%=request.getContextPath()%>/admin/cms/user?page=${pageMaker.startPage -1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"><i class="fas fa-angle-left"></i></a>
            </li>
            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
              <li class="page-item <c:if test="${pageMaker.criteria.page == i}">active</c:if>">
                <a class="page-link" href="<%=request.getContextPath()%>/admin/cms/user?page=${i}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">${i}</a>
              </li>
            </c:forEach>
            <li class="page-item <c:if test="${!(pageMaker.next)}">disabled</c:if>">
              <a class="page-link" href="<%=request.getContextPath()%>/admin/cms/user?page=${pageMaker.endPage +1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"><i class="fas fa-angle-right"></i></a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>  
</div>
</body>
</html>