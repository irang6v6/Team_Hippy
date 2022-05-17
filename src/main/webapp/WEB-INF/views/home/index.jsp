<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="R" value="/" />
<!DOCTYPE html PUBLIC>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ include file="/WEB-INF/views/include/head.jsp" %>
  <style>
    div.panel { width: 1100px; }
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
<%@ include file="/WEB-INF/views/include/mainMenu.jsp" %>

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
        <li class='active'>1</li><li>2</li><li>3</li><li>4</li><li>5</li>
        <li>6</li><li>7</li><li>8</li><li>9</li><li>10</li><li>Next</li>
      </ul>    
    </div>
  </div>  
  
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>

</body>
</html>
