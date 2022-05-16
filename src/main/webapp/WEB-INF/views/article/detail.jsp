<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html PUBLIC>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ include file="/WEB-INF/views/include/head.jsp" %>
  <style>
    article { margin-bottom: 100px; }
    article div.header { border-bottom: 1px solid lightgray; padding-bottom: 5px; margin-bottom: 20px; }
    article div.header span { margin-right: 50px; }
    article div.body { line-height: 2; margin-bottom: 30px; }
    article .btn2 { margin-right: 5px; }
  </style>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<div class="container2">

  <div class="nav">
    &gt; 게시판 &gt; ${ board.title }
  </div>

  <article>
    <div class="error">${ error }</div>
    <a class="btn2 small right" href="list?${pagination.queryString}">
      <i class="fa fa-list-ul"></i> 목록으로</a>
    <a class="btn2 small right red"
       href="delete?id=${article.id}&${pagination.queryString}" data-confirm-delete>
      <i class="fa fa-trash-o"></i> 삭제</a>
    <a class="btn2 small right blue" href="edit?id=${article.id}&${pagination.queryString}">
      <i class="fa fa-pencil-square-o"></i> 수정</a>
    <h2>${ article.title }</h2>
    <div class="header">
       <span>${ article.userName }</span>
       <span><fmt:formatDate value="${ article.modifiedTime }" pattern="yyyy-MM-dd HH:mm:ss" /></span>
    </div>
    <div class="body">${ article.body }</div>
  </article>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>

</body>
</html>

