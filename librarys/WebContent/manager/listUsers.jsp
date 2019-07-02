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
<script type="text/javascript">
	 function changeLanguage(){
	 	document.getElementById("p1").innerHTML="姓名：";
	 	document.getElementById("p2").innerHTML="密码：";
 		document.getElementById("p3").innerHTML="电话：";
		document.getElementById("p4").innerHTML="地址：";
		document.getElementById("p5").innerHTML="邮箱：";
		document.getElementById("p6").innerHTML="添加";
		document.getElementById("p7").innerHTML="添加管理员";	
		document.getElementById("p8").innerHTML="添加管理员";
		document.getElementById("p9").innerHTML="查询管理员";
		document.getElementById("p10").innerHTML="超期图书";
		document.getElementById("p11").innerHTML="读者管理";
		document.getElementById("p12").innerHTML="添加读者";
		document.getElementById("p13").innerHTML="查询读者";	
		document.getElementById("p14").innerHTML="管理员账号管理";
	 }
	</script>
</head>

<h3>Query Reader</h3>
<c:if test="${empty page.items}">
	<h2>
		No reader，<a
			href="${pageContext.request.contextPath}/servlet/ManageServlet?op=addUser">Add</a>
	</h2>
</c:if>
<c:if test="${!empty page.items}">

 <div style="padding: 70px 550px 10px">
    	<form   method="post" action="${pageContext.request.contextPath }/servlet/ManageServlet?op=searchUser" class="form-inline"  id="searchform">
        	<div class="input-group">
           <input type="text" placeholder="input your stuNumber" class="form-control" id="search" name="customerId" class="form-control">
            <span class="input-group-btn">
                  <input type="submit" value="search" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        function mySubmit(flag){
            return flag;
        }
        $("#searchform").submit(function () {
            var val=$("#search").val();
            if(val==''){
                alert("please input right");
                return mySubmit(false);
            }
        })
    </script>
</div>

	<table class="table table-striped" style="width: 70%;">
		<tr>
		    <th>StuNumber</th>
			<th>Name</th>
			<th>Password</th>
			<th>Telephone</th>
			<th>Address</th>
			<th>Email</th>
			<th>Operate</th>
		</tr>
		<c:forEach items="${page.items}" var="b" varStatus="vs">
			<tr class="${vs.index%2==0?'even':'odd'}">
			    <td id="id">${b.id}</td>
				<td id="username">${b.username}</td>
				<td id="password">${b.password}</td>
				<td id="phone">${b.phone}</td>
				<td id="address">${b.address}</td>
				<td id="email" name="emailshit">${b.email}</td>
				<td>
					<button type="submit" class="btn btn-info"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/manager/editUser.jsp?customerId=${b.id}'">Edit</button>
					<%-- <button type="submit" class="btn btn-info"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/servlet/ManageServlet?op=currentBorrow&customerId=${b.id}'">More</button> --%>
					<button type="submit" class="btn btn-danger"
						onclick="javascript:window.location.href='${pageContext.request.contextPath}/servlet/ManageServlet?op=delUser&customerId=${b.id}'">Delete</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/page.jsp"%>
</c:if>
</body>
</html>
