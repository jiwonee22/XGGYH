<%@page import="dto.XAsk"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
	List<XAsk> list = (List) request.getAttribute("list");
%>

<c:import url="/WEB-INF/views/layout/adminheader.jsp"></c:import>

<style type="text/css">

table {
	text-align: center;
}

</style>

<div class="container">

<h2>문의 목록</h2>

<hr>

<table class="table table-hover table-condensed">
<thead>
<tr>
	<th style="text-align: center; width: 8%">문의 번호</th>
	<th style="text-align: center; width: 20%">작성자</th>
	<th style="text-align: center; width: 39%">제목</th>
	<th style="text-align: center; width: 13%">문의 종류</th>
	<th style="text-align: center; width: 12%">작성일</th>
	<th style="text-align: center; width: 8%">답변 여부</th>
</tr>
</thead>

<tbody>
<% for(int i=0 ; i<list.size(); i++) { %>
<tr>
	<td><%= list.get(i).getAskNo() %></td>
	<td><%= list.get(i).getMemId() %></td>
	<td><a href="<%=request.getContextPath() %>/admin/ask/detail?askNo=<%=list.get(i).getAskNo() %>">
			<%= list.get(i).getAskTitle() %>
		</a>
	</td>
	<td><%= list.get(i).getAskKind() %></td>
	<td><%= list.get(i).getAskDate() %></td>
	<td><%= list.get(i).getAskState() %></td>
</tr>
<%} %>
</tbody>
</table>


</div>

<c:import url="/WEB-INF/views/layout/paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />

