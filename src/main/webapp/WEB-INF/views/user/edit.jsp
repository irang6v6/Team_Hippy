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
    div.panel { width: 600px; }
    form > div { margin-bottom: 20px; }
    label:nth-child(1) { font-size: 11pt; font-weight: bold; display: block; padding: }   
    div.panel input[type=text] { 
      padding: 0.7em 1em; margin-bottom: 7px; width: 300px; 
      border: 2px solid #dee; border-radius: 8px; 
    }
    div.panel input[type=text]:focus { border: 2px solid #aaf; outline: none; }
    div.panel .btn2 { margin-top: 10px; padding: 0.7em 1.5em; }
    div.panel label:not(:nth-child(1)) { margin-right: 30px; }
    .error { margin-top: 10px;  }
  </style>
</head>

<body>
<%@ include file="/WEB-INF/views/include/mainMenu.jsp" %>

<div class="container2">
  <div class="nav">
    &gt; 시스템 관리 &gt; 사용자관리
  </div>

  <div class="panel">
    <h1 class="panel-header">사용자 정보</h1>
    <div class="panel-body">
    
    <form:form method="post" modelAttribute="userEdit">
        <div>
          <label>사용자 아이디:</label>
          <form:input path="loginName" placeholder="아이디를 입력하세요" />
          <form:errors path="loginName" class="error" />
        </div>
        <div>
          <label>이름:</label>
          <form:input path="name" placeholder="이름을 입력하세요" />
          <form:errors path="name" class="error" />
        </div>
        <div>
          <label>이메일:</label>
          <form:input path="email" placeholder="이메일 주소를 입력하세요" />
          <form:errors path="email" class="error" />
        </div>
        <div>
          <label>권한:</label>
          <label><form:checkbox path="roles" value="ADMIN"/> ADMIN</label>
          <label><form:checkbox path="roles" value="PROFESSOR"/> PROFESSOR</label>
          <label><form:checkbox path="roles" value="STUDENT"/> STUDENT</label>
          <label><form:checkbox path="roles" value="TA"/> TA</label>
        </div>
        <div>
          <label>활성화:</label>
          <form:checkbox path="enabled" />
        </div>
        <div class="error"><form:errors /></div>
        <button type="submit" class="btn2 blue" name="cmd" value="save">
                <i class="fa fa-check"></i> 저장</button>
        <button type="submit" class="btn2 red" name="cmd" value="delete" data-confirm-delete>
                <i class="fa fa-trash"></i> 삭제</button>
        <a href="list?${pagination.queryString}" class="btn2"><i class="fa fa-times"></i> 취소</a>        
      </form:form>
   
    </div>
  </div>  
  
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>
</body>
</html>
