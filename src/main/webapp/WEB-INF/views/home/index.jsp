<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html PUBLIC>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>힙피 게시판</title>
  <link rel="stylesheet"  href="${R}res/css/common2.css" />
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

<div class="main-menu">
  <div>
    <h1>힙피 게시판</h1>
    <sec:authorize access="not authenticated">  
      <a class="right" href="${R}login">로그인</a>
      <a class="right" href="${R}signUp">회원가입</a>                  
    </sec:authorize>
    <sec:authorize access="authenticated">
      <a class="right" href="${R}logout_processing">로그아웃</a>
    </sec:authorize>
  </div>
</div>

<div class="container2">

  <div class="nav">
    &gt; 시스템 관리 &gt; 로그기록  
  </div>

  <div class="panel">
    <h1 class="panel-header">로그기록 목록</h1>
    <div class="panel-body">
    
     <button type="button" class="btn2 red small right">선택항목 삭제</button>
    
      <div class="form">
        <select>
          <option value="0" selected="selected">정렬순서</option>
          <option value="1">IP</option>
          <option value="2">URL</option>
          <option value="3">카테고리</option>
        </select>
    
        <select>
          <option value="0" selected="selected">조회조건</option>
          <option value="1">IP</option>
          <option value="2">URL</option>
          <option value="3">카테고리</option>
          <option value="4">내용</option>
        </select>
        <input type="text" />
        <button type="submit" class="btn2 cyan small">조회</button>        
      </div>
    
      <table>
        <thead>
          <tr>
            <th><input type="checkbox" /></th>
            <th>ID</th>
            <th>사용자</th>
            <th>날짜</th>
            <th>IP</th>
            <th>category</th>
          </tr>
        </thead>
        <tbody> 
          <c:forEach begin="1" end="15" var="index">
            <tr>
              <td><input type="checkbox"/></td>
              <td>${ index }</td>
              <td>lsj</td>
              <td>2022-03-08 08:21:33</td>
              <td>121.134.133.242</td>
              <td>로그인</td>
            </tr>
          </c:forEach>         
        </tbody>
      </table>
    
      <select class="right">
        <option value="10">10</option>
        <option value="15" selected="selected">15</option>
        <option value="30">30</option>
        <option value="100">100</option>
      </select>
    
      <ul class="pagination">
        <li class='active'>1</li><li>2</li><li>3</li><li>4</li><li>5</li><li>
                           6</li><li>7</li><li>8</li><li>9</li><li>10</li><li>Next</li>
      </ul>    
    </div>
  </div>  
  
  <div class="footer">
    <div style="float: left; padding-right: 20px;">
      <img src="${R}res/images/skhu.png" style="width: 200px; "/>
    </div>
    <div>152-716 서울시 구로구 연동로 320 / 지하철 1, 7호선 온수(성공회대입구)역 T.02-2610-4114</div>
    <div style="margin-top: 5px;">Copyright (c) Sung-Kong-Hoe Univisity. All rights reserved.</div>
  </div>  
</div>

</body>
</html>

