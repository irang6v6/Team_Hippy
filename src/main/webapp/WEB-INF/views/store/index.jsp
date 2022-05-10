<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<c:url var="R" value="/" />
<!DOCTYPE html PUBLIC>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>힙플 게시판</title>
  <link rel="stylesheet" type="text/css" href="${R}common.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script>
<script src="https://kit.fontawesome.com/92bb2bf275.js" crossorigin="anonymous"></script>
<style>
form {
	margin-bottom: 5px;
}
a {
	font-size: 12px;
}
a.btn {
	float: right;
}
  <style>
    div.container2 { padding: 20px; }
    div.nav { 
      padding: 5px; border-bottom: 1px solid #ddd; margin-bottom: 25px;
    }
    div.panel {
      width: 1100px; margin-bottom: 50px;
      border: 1px solid #ddd; border-radius: 5px;
      box-shadow: 3px 3px 3px #ccc;
    }
    div.panel h1 {
      margin: 0; font-size: 14pt; font-weight: bold; 
      background:linear-gradient(90deg, #def, #bcd); padding: 10px 15px 7px 15px;
    }
    div.panel-body {
      padding: 20px; font-size:
    }
    select:nth-child(1) { margin-right: 100px; }
    
    table {     
      width: 100%; margin: 10px 0px 20px 0px;
      border-collapse: collapse;
    }
    td, th { 
      border: 1px solid #ddd; padding: 7px; text-align: left; 
      font-size: 11pt; font-weight: normal;
    }
    th { background-color: #eee; }
  </style>
</head>

<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div style="text-align:center">
		 <h1>메인 화면</h1>
	</div>

</body>
</html>

