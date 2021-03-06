<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연의 모든 것, 공공연히</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
.main_list {
    width: 1100px;
    margin: 0 auto;
}

.list_start {
    text-align: center;
}

.list_detail {
    display: inline-block;
    width: 300px;
    height: 350px;
    margin-bottom: 40px;
    margin-right: 20px;
    margin-left: 20px;
    text-align: center;
}

.paging_start{
	text-align: center;
}

.poster {
    width: 240px;
    height: 360px;
    background-size: contain;
    background-repeat: no-repeat;
    background-position: center;
}

.search {
	width: 240px;
	margin: 0 auto;
}

</style>

</head>
<body>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">

<h3><strong>${keyword }</strong> 에 대한 검색 결과</h3>
<hr>
<c:if test="${not empty showList }">
<div class="main_list">
		<div class="list_start">
			<c:forEach items="${showList }" var="showList">
			<div class="list_detail">
			
			<a href="<%=request.getContextPath() %>/show/detail?showNo=${showList.showNo }"> 
			<c:set var="ranAll"><%= java.lang.Math.round(java.lang.Math.random() * 31+1) %></c:set>
			<img class="poster" id="poster" src="/resources/file/show_poster/${ranAll }.jpg"/><br>
			${showList.showTitle} <br> ${showList.showStart }~${showList.showEnd }
			</a>
			
			</div>
			</c:forEach>
		</div>
</div>
</c:if>

<c:if test="${empty showList }">

<h4>검색 결과가 없습니다.</h4>
</c:if>


<br>
<button onclick="location.href='<%=request.getContextPath()%>/main'">공연목록</button>
</div>


<c:import url="/WEB-INF/views/layout/parameterPaging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />

</body>
</html>