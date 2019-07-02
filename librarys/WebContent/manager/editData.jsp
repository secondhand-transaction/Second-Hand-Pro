<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="business.BusinessImpl"%>
<%@page import="business.Business"%>
<%@page import="domain.Setdata"%>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>bibliosoft</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/./css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/./js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/./js/bootstrap.min.js"></script>



</head>
<%
	Business b = new BusinessImpl();
	int id = Integer.valueOf(request.getParameter("id"));
	Setdata setdata = b.findSetDataById(id);
    %>
<%@ include file="/manager/header.jsp"%>
<h3 id="p7">Edit Data</h3>
<form
	action="${pageContext.request.contextPath}/servlet/ManageServlet?op=editData&id=<%=setdata.getId() %>"
	method="post">
	<table class="table table-striped" style="width: 50%;">
		<%-- <tr>
			<td id="p1">Id：</td>
			<td><input name="id" id="id" class="form-control"
				value="<%=setdata.getId()%>" /></td>
		</tr> --%>
		<tr>
			<td id="p1">Fine：</td>
			<td><input name="fine" id="fine" class="form-control"
				value="<%=setdata.getFine()%>" /></td>
		</tr>
		<tr>
			<td id="p2">Day：</td>
			<td><input name="day" id="day" class="form-control"
				value="<%=setdata.getDay()%>" /></td>
		</tr>
		<tr>
			<td id="p3">Deposit：</td>
			<td><input name="deposit" id="deposit" class="form-control"
				value="<%= setdata.getDeposit()%>" /></td>
		</tr>
		
	</table>
	<button type="submit" class="btn btn-info" id="p4">Edit</button>
</form>
</body>
</html>
