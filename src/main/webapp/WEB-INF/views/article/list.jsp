<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <style>
      a.btn { float: right; margin: -20px 0 5px 0; }
  </style>
</head>
<body>
<div class="container">
  <h1>게시글 목록</h1>
  <a href="create?${pagination.queryString}" class="btn">등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>NO</th>
        <th>제목</th>
        <th>내용</th>
        <th>시간</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="article" items="${ articles }">
        <tr data-url="edit?id=${article.id}&${pagination.queryString}">
          <td>${ article.no }</td>
          <td>${ article.title }</td>
          <td>${ article.body }</td>
          <td ><fmt:formatDate value="${ article.modifiedTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
</div>
</body>
</html>
