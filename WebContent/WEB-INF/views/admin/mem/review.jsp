<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/adminheader.jsp" />

<script type="text/javascript">

$(document).ready(function(){
	
	$("#btnBack").click(function(){
		
		history.go(-1);
		
	})
	
})


</script>

<style type="text/css">

table {
	text-align: center;
}

</style>

<div class="container">

<input type="hidden" name="memid" value="{memReviewList.memId }" />
<h2>${memid} 님이 작성한 리뷰</h2>
<hr>

<table class="table table-hover table-condensed">

<c:if test="${empty memReviewList }">
	<h3>검색 결과가 없습니다</h3>
</c:if>

<c:if test="${not empty memReviewList }">
<thead>
<tr>
	<th style="text-align: center; width: 8%">리뷰 번호</th>
	<th style="text-align: center; width: 59%">제목</th>
	<th style="text-align: center; width: 13%">작성자</th>
	<th style="text-align: center; width: 12%">작성 날짜</th>
	<th style="text-align: center; width: 8%">조회수</th>
</tr>
</thead>

<c:forEach items="${memReviewList }" var="review">
</tbody>
<tr>

	<td>${review.reviewNo }</td>
	<td><a href="<%=request.getContextPath() %>/admin/review/detail?reviewno=${review.reviewNo }">${review.reviewTitle }</a></td>
	<td>${review.memId }</td>
	<td>${review.reviewDate }</td>
	<td>${review.reviewHit }</td>
</tr>
</tbody>
</c:forEach>
</c:if>

</table>

<button id="btnBack" class="btnBack">뒤로 가기</button>

</div><!-- .container end -->

<c:if test="${not empty reviewMemList }">
<c:import url="/WEB-INF/views/layout/paging.jsp" />
</c:if>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
