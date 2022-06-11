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

	<h2>최신 힙플</h2>
		<table class="list">
			<thead>
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
				<c:set var="s" value="${ fn:length(stores)>5? 5:fn:length(stores)}" />
				<c:forEach var="store" items="${ stores }" begin="${fn:length(stores) - s }" end="${fn:length(stores)}">
					<tr data-url="store/edit?id=${store.id}&${pagination.queryString}">
						<td>${ store.id }</td>
						<td>${ store.name }</td>
						<td>${ store.locate }</td>
						<td>${ store.location.location }</td>
						<td>${ store.time }</td>
						<td style="width: 70px;">${ store.tag.tagName}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>최신 글</h2>
			<table>
					<thead>
						<tr>
							<th style="width: 5%;">no</th>
							<th style="width: 23%;">제목</th>
							<th style="width: 15%;">작성자</th>
							<th style="width: 10%;">구</th>
							<th style="width: 10%;">태그</th>
							<th style="width: 10%;">분위기</th>
							<th style="width: 10%;">인원수</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="i" value="${ fn:length(articles)>5? 5:fn:length(articles)}" />
						<c:forEach var="article" items="${ articles }"  begin="${fn:length(articles) - i}" end="${fn:length(articles)}">
													<c:set var="l" value="${ article.locationId }" />						
							<c:set var="t" value="${ article.tagId }" />
							<c:set var="m" value="${ article.moodId }" />
							<c:set var="p" value="${ article.partyId }" />
							<tr data-url="article/detail?id=${article.id }&pg=1&sz=15&di=0&ti=0&mi=0&pi=0&si=0&od=0&bd=1&st=">
								<td>${ article.no }</td>
								<td>${ article.title }</td>
								<td>${ article.userName }</td>
								<td>${ locations[l-1].location }</td>
								<td>${ tags[t-1].tagName }</td>
								<td>${ moods[m-1].mood }</td>
								<td>${ partys[p-1].party }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	
		
		
		<h2>최신 후기</h2>
			<table>
					<thead>
						<tr>
							<th style="width: 5%;">no</th>
							<th style="width: 23%;">제목</th>
							<th style="width: 15%;">작성자</th>
							<th style="width: 10%;">구</th>
							<th style="width: 10%;">태그</th>
							<th style="width: 10%;">분위기</th>
							<th style="width: 10%;">인원수</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="j" value="${ fn:length(afters)>5? 5:fn:length(afters)}" />
						<c:forEach var="after" items="${ afters }" begin="${fn:length(afters) - j}" end="${fn:length(afters)}">
							<c:set var="l" value="${ after.locationId }" />						
							<c:set var="t" value="${ after.tagId }" />
							<c:set var="m" value="${ after.moodId }" />
							<c:set var="p" value="${ after.partyId }" />
							<tr data-url="article/detail?id=${after.id }&pg=1&sz=15&di=0&ti=0&mi=0&pi=0&si=0&od=0&bd=1&st=">
								<td>${ after.no }</td>
								<td>${ after.title }</td>
								<td>${ after.userName }</td>
								<td>${ locations[l-1].location }</td>
								<td>${ tags[t-1].tagName }</td>
								<td>${ moods[m-1].mood }</td>
								<td>${ partys[p-1].party }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

	</div>

</body>
</html>

