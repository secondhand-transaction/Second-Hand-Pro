<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/huakai.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/PersonInformation.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="js/jquery.min.js" >
<link rel="stylesheet" herf="js/bootstrap.min.js">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>person information</title>


<script>
		function btn1(){
			document.getElementById('HistoryBorrow').style.display='none';
			document.getElementById('CurrentBorrow').style.display='block'; 
			document.getElementById('CB').style.backgroundColor="#98bf21";
			document.getElementById('HB').style.backgroundColor="aliceblue";
		}
		function btn2(){
			document.getElementById('CurrentBorrow').style.display='none'; 
    		document.getElementById('HistoryBorrow').style.display='block'; 
			document.getElementById('HB').style.backgroundColor="#98bf21";
			document.getElementById('CB').style.backgroundColor="aliceblue";
		}
		function Function1(){
			document.getElementById('CB').style.backgroundColor="black"
		}

</script>

</head>
<body  style="background:#3F506A">
<div style="width:96%;height:500px;margin-left: 2%">
	<div style="width: 25%;height: 100%;background-color: aliceblue;float: left">
		<div style="width: 100%;height: 60%">
			<div align="center" style="height: 100px;width: 100%;margin-top: 15px;padding-top: 10px">
				<img src="images/librarian.jpg" style="height: 100px;width: 100px">
			</div>	
			<div style="width: 90%;height: 300px;padding-left: 20px;padding-top: 20px;margin-top: 20px;margin-left: 5%;font-size: 16px;border: 5px solid #4B90C8">
				
				<div style="float:left">
					<p>username : ${readers.get(0).getName()}</p>
				</div>
				<div style="float:right;">
					<textarea  id="username" name="name_submit" form="formsub_1" type="submit"  style="width:100px;margin-right:5px;height: 25px;display:none">${readers.get(0).getName()}</textarea>
				</div><br/><br/>
				
				<div style="float:left">
					<p>phnumber: ${readers.get(0).getStunumber()}</p>
				</div><br/><br/>
				
				<div style="float:left">
					<p>EmailNum: ${readers.get(0).getEmail()}</p>
				</div>
				<div style="float:right;">
					<textarea  id="Emailnumber" name="Enumber_submit" form="formsub_1" type="submit"  style="width:100px;margin-right:5px;height: 25px;display:none">${readers.get(0).getEmail()}</textarea>
				</div><br/><br/>
				
				<div style="float:left">
					<p>address  : ${readers.get(0).getAddress()}</p>
				</div>
				<div style="float:right;">
					<textarea  id="address" name="address_submit" form="formsub_1" type="submit"  style="width:100px;margin-right:5px;height: 25px;display:none">${readers.get(0).getAddress()}</textarea>
				</div><br/><br/>
				
				<div style="float:left">
					<p>deposit : ${readers.get(0).getDeposit()}</p>
				</div>
				<div style="float:right;">
					<textarea  id="deposit" name="deposit_submit" form="formsub_1" type="submit"  style="width:100px;margin-right:5px;height: 25px;display:none">${readers.get(0).getDeposit()}</textarea>
				</div><br/><br/>
				
				<div style="float:left">
					<p>f i n e : ${readers.get(0).getFine()}</p>
				</div>
				<div style="float:right;">
					<textarea  id="fine" name="fine_submit" form="formsub_1" type="submit"  style="width:100px;margin-right:5px;height: 25px;display:none">${readers.get(0).getFine()}</textarea>
				</div><br/><br/><br/>
				
				<div align="center">
					<form action="PersonInformationServlet?isEdit=1&ponumber=${readers.get(0).getStunumber()}" method="post" id="formsub_1">
						<button id="button_1" type="button" style="width:100px;float:left;display:block" onClick="button_1.style.display='none',button_2.style.display='block',username.style.display='block',Emailnumber.style.display='block',address.style.display='block',deposit.style.display='block',fine.style.display='block'">Edit</button>
				    	<button id="button_2" type="submit" style="width:100px;float:left;display:none" onClick="button_1.style.display='block',button_2.style.display='none'">Save</button>
				    </form>
					<a href="PersonInformationServlet?isPayFine=1&ponumber=${readers.get(0).getStunumber()}&pofine=${readers.get(0).getFine()}"><button type="button" style="width: 100px;">Pay fine</button></a>
				</div>
			</div>	
		</div>
	</div>
	<div style="width: 72%;height: 100%;float: right;background-color:">
		<div style="height:50px">
			<ul>
  				<li><input id="CB" type="submit" value="CurrentBorrow" onclick="btn1()" style="height: 100%;border: none;background-color: aliceblue;height: 100%;padding-top: 6px;padding-bottom: 6px;font-size: 20px"></li>
  				<li><input id="HB" type="submit" value="HistoryBorrow" onclick="btn2()" style="height: 100%;border: none;background-color: #98bf21;height: 100%;padding-top: 6px;padding-bottom: 6px;font-size: 20px;margin-left: 40px"></li>
			</ul>
	  </div>
	  <div id="CurrentBorrow" style="height: 90%;width: 100%;background-color: aliceblue;display: none">
	  	<table id="customers1">
			<tr>
				 <th>ISBN</th>
				 <th>ID</th>
				 <th>borrowtime</th>
				 <th>bookname</th>
				 <th>stunumber</th>
			</tr>

		<c:forEach items="${currentBorrows}" var="currentBorrow" varStatus="st">
			<tr>
				<td>${currentBorrow.ISBN}</td>
				<td>${currentBorrow.ID}</td>
				<td><fmt:formatDate value="${currentBorrow.borrowtime}" pattern="dd/MM/yyyy HH:mm aa"/></td>
				<td>${currentBorrow.bookname}</td>
				<td>${currentBorrow.stunumber}</td>
			</tr>
		</c:forEach>
		</table>
	  </div>
	  	
	  <div id="HistoryBorrow" style="height: 90%;width: 100%;background-color: aliceblue;display:block">
	    <div style="height: 87%;width: 100%;">
	  	  <table id="customers2">
			  <tr>
				  <th>ISBN</th>
				  <th>ID</th>
				  <th>borrowtime</th>
				  <th>returntime</th>
				  <th>bookname</th>
				  <th>stunumber</th>
				  <th>historyfine</th>
			  </tr>
		  <c:forEach items="${historyBorrows}" var="historyBorrow" varStatus="st">
			  <tr>
				 <td>${historyBorrow.ISBN}</td>
				 <td>${historyBorrow.ID}</td>
				 <td><fmt:formatDate value="${historyBorrow.borrowtime}" pattern="dd/MM/yyyy HH:mm aa"/></td>
				 <td><fmt:formatDate value="${historyBorrow.returntime}" pattern="dd/MM/yyyy HH:mm aa"/></td>
				 <td>${historyBorrow.bookname}</td>
				 <td>${historyBorrow.stunumber}</td>
				 <td>${historyBorrow.historyfine}</td>
			  </tr>
		  </c:forEach>
		  </table>
		</div>
		<div>
		  <nav>
		     <ul class="pager">
			 	 <li style="padding-left:30%" ><a href="?start=0" >首 页</a></li>
				 <li style="padding-left:10px"><a href="?start=${pre}">上一页</a></li>
				 <li style="padding-left:10px"><a href="?start=${next}">下一页</a></li>
				 <li style="padding-left:10px"><a href="?start=${last}">末 页</a></li>
			 </ul>
		  </nav>
		</div>
	  </div>
	  
	</div>
</div>
	
										
</body>
</html>