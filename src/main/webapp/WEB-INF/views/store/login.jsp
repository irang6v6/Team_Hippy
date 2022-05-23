<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="R" value="/" />
<!DOCTYPE html PUBLIC>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>힙플 게시판</title>
  <link rel="stylesheet" href="${R}res/css/common2.css" />
  <link rel="stylesheet" 
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
  <style>
  body {background-color: white;}
    div.container2 { padding-top: 100px; }
    div.login-form {
      width: 800px; height: 500px;
      margin: 0px auto 200px auto; text-align: center;
      border: 1px solid #ddd; border-radius: 5px;
      box-shadow: 3px 3px 3px #ccc;
    }
    div.login-form h1 {
      margin: 0; font-size: 14pt; font-weight: bold; 
	 padding: 10px 15px 7px 15px;
    }
    div.login-form img {
      display: block; margin: 40px auto; 
    }
    div.login-form input { padding: 0.7em 3em; margin-bottom: 7px; width: 250px; 
        border: 2px solid #dee; border-radius: 8px; }
    div.login-form input:focus { border: 2px solid #aaf; outline: none; }
    div.login-form .btn2 { margin-top: 10px; padding: 0.7em 1.5em; }
    div.input { position: relative; display: inline-block;margin:10px; }
    div.input i { position: absolute; left: 15px; top: 0.7em; color: gray; }
    div.login-body {margin: 100px auto 0px auto;}
  </style>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<div class="container2">

  <div class="login-form">
    <h1 class="login-header">힙플 게시판 로그인</h1>
    <div class="login-body">
      <form method="post" action="${R}login_processing" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="input">
          <i class="fa fa-user fa-lg"></i>
          <input type="text" name="loginName" placeholder="아이디" />
        </div> <br />
        <div class="input">
            <i class="fa fa-key fa-lg"></i>
            <input type="password" name="passwd" placeholder="비밀번호" />
        </div> <br />
        <button type="submit" class="btn2 blue"><i class="fa fa-sign-in"></i> 로그인</button>
        <a href="${R}signUp" class="btn2"><i class="fa fa-user-plus"></i> 회원가입</a>
      </form>
    </div>
  </div>  
  

</div>

</body>
</html>

