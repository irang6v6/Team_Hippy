<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<script src="https://kit.fontawesome.com/92bb2bf275.js" crossorigin="anonymous"></script>
<header class="header">
	<div id="menu-btn" class="fas fa-bars"></div>

	<a href="${R}" class="logo">HIPPI<i class="fa-brands fa-hackerrank"></i></a>

	<nav class="navbar">
		<a href="${R}article/list?bd=1">게시판</a>
		<span>|</span>
		<a href="${R}store/list">힙플</a>
		<span>|</span>
		<a href="${R}article/list?bd=2">후기</a>
	</nav>
	<sec:authorize access="not authenticated">  
	<div>
      <a class="left" href="${R}login">로그인</a>
      <a class="left" href="${R}signUp">회원가입</a>      
      </div>            
    </sec:authorize>
        <sec:authorize access="authenticated">
        <span>
      <a class="left" href="${R}logout_processing" style="font-size: 12px;">로그아웃</a></span>
    </sec:authorize>
    

</header>

