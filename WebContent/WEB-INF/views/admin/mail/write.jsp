<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/adminheader.jsp" />

<style type ="text/css">

table {
	text-align: center;
}

</style>

<div class="container">
	<form action="<%=request.getContextPath() %>/admin/mail/write" method="post">
		<table>
			<tr>
				<th colspan="2">메일 주소 입력해서 메일 작성</th>
			</tr>
			<tr>
				<td>보내는 이</td>
				<td>${adminMail }</td>
			</tr>
			<tr>
				<td>받는 이</td>
				<td><input type="text" name="memmail" /></td>
			</tr>
			<tr>
				<td>메일 제목</td>
				<td><input type="text" name="mailtitle" /></td>
			</tr>
			<tr>
				<td>content</td>
				<td><textarea name="mailcontent"
						style="width: 170px; height: 200px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;"><input type="submit" value="Transmission" /></td>
			</tr>
		</table>
	</form>
</div>


<c:import url="/WEB-INF/views/layout/footer.jsp" />