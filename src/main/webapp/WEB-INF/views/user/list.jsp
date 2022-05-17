<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
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
    &gt; 시스템 관리 &gt; 사용자관리  
  </div>

  <div class="panel">
    <h1 class="panel-header">사용자 목록</h1>
    <div class="panel-body">
    
      <form:form method="get" modelAttribute="pagination">
        <form:select path="od" class="autosubmit">
          <form:option value="0" label="정렬순서" />
          <form:option value="1" label="가입순서" />
          <form:option value="2" label="사용자 아이디" />
          <form:option value="3" label="이름" />
        </form:select>
    
        <form:select path="si">
          <form:option value="0" label="조회조건" />
          <form:option value="1" label="사용자 아이디" />
          <form:option value="2" label="이름" />
        </form:select>
        <form:input path="st" />
        <button type="submit" class="btn2 cyan small">조회</button>
        <a class="btn2 small" href="list">초기화</a>

        <form:select path="sz" class="right autosubmit">
          <form:option value="2" />
          <form:option value="3" />
          <form:option value="4" />
          <form:option value="5" />
          <form:option value="10" />
          <form:option value="15" />
          <form:option value="30" />
          <form:option value="100" />
        </form:select>
      </form:form>
    
      <table>
        <thead>
          <tr>
            <th style="width: 7%;">ID</th>
            <th style="width: 15%;">사용자 아이디</th>
            <th style="width: 15%;">이름</th>
            <th style="width: 26%;">이메일</th>
            <th style="width: 7%;">활성</th>
            <th style="width: 30%;">권한</th>
          </tr>
        </thead>
        <tbody> 
          <c:forEach var="user" items="${ users }">
            <tr data-url="edit?id=${user.id }&${pagination.queryString}">
              <td>${ user.id }</td>
              <td>${ user.loginName }</td>
              <td>${ user.name }</td>
              <td>${ user.email }</td>
              <td>${ user.enabled ? "활성" : "" }</td>
              <td>
                <c:forEach var="role" items="${ user.roles }">
                  <span>${ role }</span>
                </c:forEach>
              </td>
            </tr>
          </c:forEach>         
        </tbody>
      </table>
    
      <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                     queryStringName="pg" />
    </div>
  </div>  
  
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>

</body>
</html>
