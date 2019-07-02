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

<h3>Query Manager</h3>

	<table class="table table-striped" style="width: 70%;">
		<tr>
			<th>Account</th>
			<th>Name</th>
			<th>Password</th>
			<th>Telephone</th>
			<th>Address</th>
			<th>Email</th>
			<th>Operate</th>
		</tr>
				<td id="id">${manager.id}</td>
				<td id="username">${manager.username}</td>
				<td id="password">${manager.password}</td>
				<td id="phone">${manager.phone}</td>
				<td id="address">${manager.address}</td>
				<td id="email" name="emailshit">${manager.email}</td>
				<td>
					<%-- 	    				<a href="${pageContext.request.contextPath}/manager/editManager.jsp?managerId=${b.id}">Edit</a> --%>
					<button type="submit" class="btn btn-info"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/manager/editManager.jsp?managerId=${manager.id}'">Edit</button>
					<%-- 	    				<a href="${pageContext.request.contextPath}/servlet/ManageServlet?op=delManager&managerId=${b.id}">Delete</a> --%>
					<button type="submit" class="btn btn-danger"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/servlet/ManageServlet?op=delManager&managerId=${manager.id}'">Delete</button>
				</td>
			</tr>
	</table>
</body>
</html>
