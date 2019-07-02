<%@page import="domain.CurrentBorrow"%>
<%@page import="domain.Customer"%>
<%@page import="business.BusinessImpl"%>
<%@page import="business.Business"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp"%>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>网上书城</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/./css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/./js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/./js/bootstrap.min.js"></script>

</head>

<h3>Query Overdue Books of readers</h3>
<c:if test="${empty page.items}">
	<h2>
		No reader，<a
			href="${pageContext.request.contextPath}/servlet/ManageServlet?op=addUser">Add</a>
	</h2>
</c:if>
<c:if test="${!empty page.items}">
	<table class="table table-striped" style="width: 70%;">
		<tr>
			<th>ISBN</th>
			<th>ID</th>
			<th>borrowTime</th>
			<th>bookName</th>
			<th>stuNumber</th>
		</tr>
		<c:forEach items="${page.items}" var="b" varStatus="vs">
			<tr class="${vs.index%2==0?'even':'odd'}">
			<%-- <c:if test="${b.stunumber==customer.getId()}"> --%>
				<td id="ISBN" >${b.ISBN}</td>
				<td id="ID">${b.ID}</td>
				<td id="borrowtime">${b.borrowtime}</td>
				<td id="bookname">${b.bookname}</td>
				<td id="stunumber">${b.stunumber}</td>
			<%-- </c:if> --%>
			</tr>
		</c:forEach>
	</table>
	<%-- <%@ include file="/page.jsp"%> --%>
</c:if>
</body>
</html>


