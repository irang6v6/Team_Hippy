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
    article input[type=text] { width: 100%; margin: 10px 0; padding: 7px; }
    article div#summernote { margin-bottom: 30px; }
    article .btn2 { margin-right: 5px; margin-top: 10px; }
  </style>
   <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
   <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<div class="container2">

  <div class="nav">
    &gt; 게시판 &gt; ${ board.title }
  </div>

  <article>
    <form:form method="post" modelAttribute="articleEdit">

      <form:input path="title" />
      <form:errors path="title" class="error" />

      <div id="summernote">${ articleEdit.body }</div>
      <input type="hidden" name="body" />
      <form:errors path="body" class="error" />
      <form:errors path="*" class="error" />

      <a class="btn2 small right" href="detail?id=${articleEdit.id}&${pagination.queryString}">
        <i class="fa fa-times"></i> 취소</a>
      <button class="btn2 small right blue" type="submit">
        <i class="fa fa-check"></i> 저장</button>

    </form:form>

    <script>
      $("#summernote").summernote({ height: 700 });

      $("form").submit(function() {
          let body = $('#summernote').summernote('code');
          $('input[name=body]').val(body);
      })
    </script>
  </article>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>

</body>
</html>
