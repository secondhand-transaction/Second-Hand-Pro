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

<h3>Query Reader</h3>

	<table class="table table-striped" style="width: 70%;">
		<tr>
			<th>Stunumber</th>
			<th>Name</th>
			<th>Password</th>
			<th>Telephone</th>
			<th>Address</th>
			<th>Email</th>
			<th>Operate</th>
		</tr>
				<td id="id">${customer.id}</td>
				<td id="username">${customer.username}</td>
				<td id="password">${customer.password}</td>
				<td id="phone">${customer.phone}</td>
				<td id="address">${customer.address}</td>
				<td id="email" name="emailshit">${customer.email}</td>
				<td>
					<button type="submit" class="btn btn-info"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/manager/editUser.jsp?customerId=${customer.id}'">Edit</button>
					<%-- <button type="submit" class="btn btn-info"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/servlet/ManageServlet?op=currentBorrow&customerId=${b.id}'">More</button> --%>
					<button type="submit" class="btn btn-danger"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/servlet/ManageServlet?op=delUser&customerId=${customer.id}'">Delete</button>
				</td>
			</tr>
	</table>
</body>
</html>
