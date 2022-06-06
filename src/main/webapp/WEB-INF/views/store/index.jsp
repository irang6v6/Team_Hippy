<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<script src="https://kit.fontawesome.com/92bb2bf275.js"
	crossorigin="anonymous"></script>
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

<
style>div.container2 {
	padding: 20px;
}

div.nav {
	padding: 5px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 25px;
}

div.panel {
	width: 1100px;
	margin-bottom: 50px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 3px 3px 3px #ccc;
}

div.panel h1 {
	margin: 0;
	font-size: 14pt;
	font-weight: bold;
	background: linear-gradient(90deg, #def, #bcd);
	padding: 10px 15px 7px 15px;
}

div.panel-body {
	padding: 20px;
	font-size:
}

select:nth-child(1) {
	margin-right: 100px;
}

table {
	width: 100%;
	margin: 10px 0px 20px 0px;
	border-collapse: collapse;
}

td, th {
	border: 1px solid #ddd;
	padding: 7px;
	text-align: left;
	font-size: 11pt;
	font-weight: normal;
}

th {
	background-color: #eee;
}
</style>
</head>

<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container">


		<table class="list">
			<thead>
				<tr>
					<th colspan="6">최신 힙플</th>
				</tr>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>주소</th>
					<th style="width: 70px">구</th>
					<th>시간</th>
					<th style="width: 50px">태그</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="store" items="${ stores }" begin="${fn:length(stores) - 5 }" end="${fn:length(stores)}">
					<tr data-url="store/edit?id=${store.id}&${pagination.queryString}">
						<td>${ store.id }</td>
						<td>${ store.name }</td>
						<td>${ store.locate }</td>
						<td>${ store.location.location }</td>
						<td>${ store.time }</td>
						<td style="text-align: center;">${ store.tag.tagName}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table>
			<thead>
				<tr>
					<th style="width: 100%;" colspan="2">최신글</th>
				</tr>
				<tr>
					<th style="width: 10%;">no</th>
					<th style="width: 90%;">제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${ articles }" begin="${fn:length(articles) - 5}" end="${fn:length(articles)}">
         <tr data-url=http://localhost:8088/article/detail?id=${ article.id }&pg=1&sz=15&di=0&ti=0&si=0&od=0&bd=1&st=>
						<td>${ article.no }</td>
						<td>${ article.title }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
			<table>
			<thead>
				<tr>
					<th style="width: 100%;" colspan="2">최신후기</th>
				</tr>
				<tr>
					<th style="width: 10%;">no</th>
					<th style="width: 90%;">제목</th>
				</tr>
			</thead>
			</tbody>
		</table>

	</div>

</body>
</html>

