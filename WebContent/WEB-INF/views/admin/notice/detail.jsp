<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/adminheader.jsp" />
<!------------------------------------------------------>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnDelete").click(function(){
		
		var answer = confirm("공지사항을 삭제하시겠습니까?")
		
		if(answer == true) {
			submitContents($("#btnSubmit"))
		
			$("form").submit();
		} else {
			return false;
		}
	});
	$("#btnCancel").click(function(){
		history.go(-1);
	});
});
</script>
<style>

#content {
	vertical-align:middle;
}

</style>

<div class="container">


<h2>공지사항 세부 조회</h2>
<hr>

<table class ="table table-bordered table-condensed" style="">
<thead>
<tr>
	<td colspan="6" style="height: 40px; font-size: 30px;">${notice.noticeTitle }</td>
</tr>
<tr>
	<td class="item">번호</td>
	<td>${notice.noticeNo }</td>
	<td class="item">작성자</td>
	<td>${notice.adminId }</td>
	<td class="item">작성일</td>
	<td>${notice.noticeDate }</td>
</tr>
<c:if test="${notice.fileNo ne 0 }">
	<tr>
		<td class="item">첨부파일</td>
		<td colspan="5"><a href="/upload/${file.fileStoredName }" download="${file.fileOriginName }">${file.fileOriginName }</a></td>
	</tr>
</c:if>
<tr>
	<td id="content" colspan="6" style="height: 300px;">${notice.noticeContent }</td>
</tr>
</thead>
</table>

<br>
<a href="<%=request.getContextPath() %>/admin/notice/list"><button class="btnBack">목록</button></a>
<a href="<%=request.getContextPath() %>/admin/notice/update?noticeno=${notice.noticeNo }"><button class="btnUpdate" id="btnUpdate">수정</button></a>
<a href="<%=request.getContextPath() %>/admin/notice/delete?noticeno=${notice.noticeNo }"><button class="btnDelete" id="btnDelete">삭제</button></a>

<!------------------------------------------------------>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />