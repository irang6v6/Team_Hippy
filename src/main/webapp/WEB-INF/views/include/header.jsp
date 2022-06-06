<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<header class="header">
	<div id="menu-btn" class="fas fa-bars"></div>

	<a href="${R}" class="logo">HIPPI <i class="fas fa-mug-hot"></i></a>

	<nav class="navbar">
		<a href="${R}article/list?bd=1">게시판</a>
		<span>|</span>
		<a href="${R}store/list">힙플</a>
		<span>|</span>
		<a href="${R}article/list?bd=2">후기</a>
	</nav>
	<sec:authorize access="not authenticated">  
	<div>
      <a class="right" href="${R}login">로그인</a>
      <a class="right" href="${R}signUp">회원가입</a>      
      </div>            
    </sec:authorize>
        <sec:authorize access="authenticated">
        <span>
      <a class="right" href="${R}logout_processing" style="font-size: 12px;">로그아웃</a></span>
    </sec:authorize>
    

</header>

