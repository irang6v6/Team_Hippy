<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="main-menu">
  <ul>
    <li class="title" data-url="${R}">소프 게시판</li>
    <sec:authorize access="not authenticated">
      <li data-url="${R}login" class="right" >로그인</li>
      <li data-url="${R}signUp" class="right" >회원가입</li>                  
    </sec:authorize>
    <sec:authorize access="authenticated">
      <li data-url="${R}article/list?bd=1">공지사항</li>
      <li> 시스템 관리      
        <ul>
          <li data-url="${R}user/list">사용자 목록</li>
          <li>로그 기록</li>
        </ul>  
      </li>
      <li data-url="${R}logout_processing" class="right">로그아웃</li>
    </sec:authorize>
  </ul>
</div>

