<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ include file="/WEB-INF/views/include/head.jsp" %>
  <style>
    div.panel { margin: 40px auto 200px auto; }
    div.panel-body { text-align: center; }
    i { color: #d00; }
    p { font-size: 14pt; color: #800; }
  </style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/mainMenu.jsp" %>

<div class="container2">

  <div class="panel">
    <h1 class="panel-header">에러 발생</h1>
    <div class="panel-body">
    
    <p><i class="fa fa-exclamation-triangle fa-lg"></i> ${ message }</p>
    
    <a href="${R}" class="btn2"> 시작 화면으로</a>
    </div>
  </div>  
  
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>
</body>
</html>
