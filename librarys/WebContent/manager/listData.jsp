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

<h3>Query Data</h3>

	<table class="table table-striped" style="width: 60%;">
		<tr>
			<!-- <th>Id</th> -->
		    <th>Fine</th>
			<th>Day</th>
			<th>Deposit</th>
			<th>Operate</th>
		</tr>
		<c:forEach items="${page.items}" var="b" varStatus="vs">
			<tr class="${vs.index%2==0?'even':'odd'}">
				<%-- <td id="id">${b.id}</td> --%>
			    <td id="fine">${b.fine}</td>
				<td id="day">${b.day}</td>
				<td id="deposit">${b.deposit}</td>
				<td>
					<button type="submit" class="btn btn-info"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/manager/editData.jsp?id=${b.id}'">Edit</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <%@ include file="/page.jsp"%> --%>

</body>
</html>
