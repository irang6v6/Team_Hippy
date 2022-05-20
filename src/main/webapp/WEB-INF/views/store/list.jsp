<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${R}common.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script>
<script src="https://kit.fontawesome.com/92bb2bf275.js"
	crossorigin="anonymous"></script>
<style>
form {
	margin-bottom: 5px;
}

a.btn {
	float: right;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container">

		<form:form method="get" modelAttribute="pagination">
			<form:hidden path="pg" value="1" />
			<form:hidden path="sz" />
			<span>구:</span>
			<form:select path="di" class="form-control">
				<form:option value="0">전체</form:option>
				<form:options itemValue="id" itemLabel="location"
					items="${ locations }" />
			</form:select>
			<br>
			<span>태그:</span>
			<br>
			<form:radiobutton path="ti" value="0" label="전체" />
			<form:radiobuttons path="ti" itemValue="id" class="form-control"
				itemLabel="tagName" items="${ tags }" />
			<br>
			<form:radiobutton path="mi" value="0" label="전체" />
			<form:radiobuttons path="mi" itemValue="id" class="form-control"
				itemLabel="mood" items="${ moods }" />
			<br>
			<form:radiobutton path="pi" value="0" label="전체" />
			<form:radiobuttons path="pi" itemValue="id" class="form-control"
				itemLabel="party" items="${ partys }" />
			<br>

			<button type="submit" class="btn">검색</button>
			<a href="create?${pagination.queryString}" class="btn">가게등록</a>
		</form:form>
		<table class="list">
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>주소</th>
					<th style="width: 70px">구</th>
					<th>시간</th>
					<th style="width: 50px">태그</th>
					<th style="width: 80px">분위기</th>
					<th style="width: 80px">인원수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="store" items="${ stores }">
					<tr data-url="edit?id=${store.id}&${pagination.queryString}">
						<td>${ store.id }</td>
						<td>${ store.name }</td>
						<td>${ store.locate }</td>
						<td>${ store.location.location }</td>
						<td>${ store.time }</td>
						<td style="text-align: center;">${ store.tag.tagName}</td>
						<td style="text-align: center;">${ store.mood.mood }</td>
						<td style="text-align: center;">${ store.party.party }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<my:pagination pageSize="${ pagination.sz }"
			recordCount="${ pagination.recordCount }" queryStringName="pg" />
	</div>
</body>
</html>

