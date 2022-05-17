<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html PUBLIC>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ include file="/WEB-INF/views/include/head.jsp" %>
  <style>
    div.panel {width: 600px;
    div.panel .btn2 { margin-top: 10px; padding: 0.7em 1.5em; }
    p { font-size: 14pt; }      
  </style>
</head>

<body>
<%@ include file="/WEB-INF/views/include/mainMenu.jsp" %>

<div class="container2">
  <div class="nav">
    &gt; 회원가입
  </div>

  <div class="panel">
    <h1 class="panel-header">회원가입 성공</h1>
    <div class="panel-body">
    
    <p><i class="fa fa-user-plus fa-lg"></i> 회원가입이 성공했습니다</p>
    
    <a href="${R}login" class="btn2"> 로그인 하기</a>
    </div>
  </div>  
  
  <%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>
</body>
</html>
