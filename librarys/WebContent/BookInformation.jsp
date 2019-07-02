<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/huakai.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="js/jquery.min.js" >
<title>book information</title>
<style>
	.td_style_1{
		width: 60px;
		height: 50px;
	}	
	.td_style_2{
		width:150px;
		height: 50px;
	}	
</style>
</head>
<body  style="background:#3F506A">

<div style="height: 500px;width: 100%;background-color:#3F506A;margin-top: 10px" >
	<div style="background-color:aliceblue ;float: left;height: 98%;width: 50%;padding-left: 20px;padding-top: 20px;margin: 10px">
		<div>
			<div style="float: left">BookName：${books.get(0).getBookname()}</div>
			<div  style="float:right;">
				<textarea  id="bookname" name="bookname_submit" form="formsub" type="submit" style="width:200px;height: 25px;display:none">${books.get(0).getBookname()}</textarea>
			</div>
		</div><br><br>
		
		<div>
			<div style="float: left">ISBN：<span>${books.get(0).getISBN()}</span></div>
			<div  style="float:right;">
				<textarea  id="ISBN" name="ISBN_submit" form="formsub" type="submit"  style="width:200px;height: 25px;display:none">${books.get(0).getISBN()}</textarea>
			</div>
		</div><br><br>

		<div>
			<div style="float: left">Category：<span>${books.get(0).getCategory()}</span></div>
			<div  style="float:right;">
				<textarea  id="category" name="category_submit" form="formsub" type="submit"  style="width:200px;height: 25px;display:none">${books.get(0).getCategory()}</textarea>
			</div>
		</div><br><br>
		
		<div>
			<div style="float: left">Press：<span>${books.get(0).getPress() }</span></div>
			<div  style="float:right;">
				<textarea  id="press" name="press_submit" form="formsub" type="submit"  style="width:200px;height: 25px;display:none">${books.get(0).getPress() }</textarea>
			</div>
		</div><br><br>
		
		<div>
			<div style="float: left">Author：<span>${books.get(0).getAuthor()}</span></div>
			<div  style="float:right;">
				<textarea  id="author" name="author_submit" form="formsub" type="submit"   style="width:200px;height: 25px;display:none">${books.get(0).getAuthor()}</textarea>
			</div>
		</div><br><br>
		
		<div>
			<div style="float: left">PrintDate：<span>${books.get(0).getPrintdate().toString()}</span></div>
			<div  style="float:right;">
				<textarea  id="printdate" name="printdate_submit" form="formsub" type="submit"  style="width:200px;height: 25px;display:none">${books.get(0).getPrintdate().toString()}</textarea>
			</div>
		</div><br><br> 
		
		<div>
			<div style="float: left">Version：<span>${books.get(0).getVersion()}</span></div>
			<div  style="float:right;">
				<textarea  id="version" name="version_submit" form="formsub" type="submit"  style="width:200px;height: 25px;display:none">${books.get(0).getVersion()}</textarea>
			</div>
		</div><br><br>
		
		<div>
			<div style="float: left">Price：<span>${books.get(0).getPrice()}</span></div>
			<div  style="float:right;">
				<textarea  id="price" name="price_submit" form="formsub" type="submit"  style="width:200px;height: 25px;display:none">${books.get(0).getPrice()}</textarea>
			</div>
		</div><br><br>
		
		<div>
			<div>
				<div style="float: left">Introduction：<script></script></div>
				<div  style="float:right;">
					<textarea  id="introduction" name="introduction_submit" form="formsub" type="submit" style="width:200px;height: 25px;display:none">${books.get(0).getIntroduction() }</textarea>
				</div>
			</div><br>
			<textarea cols="70px" rows="3px">${books.get(0).getIntroduction() }</textarea><br><br>
			<div>
					<a href="BookListServlet?"><button style="float:left" type="button" onclick="myFunction()"><span style="color: black">Home</span></button></a>
						  		   <button style="float:left;margin-left:10px" onClick="baocun.style.display='block',bookname.style.display='block',category.style.display='block',	press.style.display='block',author.style.display='block',printdate.style.display='block',version.style.display='block',price.style.display='block',introduction.style.display='block', booknamesub.style.display='block',categorysub.style.display='block',	presssub.style.display='block',authorsub.style.display='block',printdatesub.style.display='block',versionsub.style.display='block',pricesub.style.display='block',introductionsub.style.display='block' " >Modify</button>
					<form action="BookInformationServlet?isUpdate=1" method="post" id="formsub">
						 		   <input  type="submit" value="Save" style="display:none;float:left;margin-left:10px" id="baocun" onClick="baocun.style.display='none',bookname.style.display='none',category.style.display='none',	press.style.display='none',author.style.display='none',printdate.style.display='none',version.style.display='none',price.style.display='none',introduction.style.display='none',booknamesub.style.display='none',categorysub.style.display='none',presssub.style.display='none',authorsub.style.display='none',printdatesub.style.display='none',versionsub.style.display='none',pricesub.style.display='none',introductionsub.style.display='none' " ><br>
					</form>
			</div>
			</div>	
	</div>
	
	
	<div style="float: right;margin-right:10px;height: 100%;width:45%;background-color:#3F506A;align: center">
		<div align="center" style="margin-top: 10px"><img src="images/library.jpg" style="width: 100%;height: 230px;"></div>
		<div style="height: 50%;margin-top: 10px;background-color: aliceblue">
			<table style="margin-left: 5px;margin-left: 10px">
				<tr>
					<td class="td_style_1"><span style="font-size: 15px;text-align: center"><b>ID</b></span></td>
					<td class="td_style_2"><span style="font-size: 15px;text-align: center"><b>Location</b></span></td>
					<td></td>
					<td class="td_style_1"><span style="font-size: 15px;text-align: center"><b>Can Borrow</b></span></td>
					<td class="td_style_1"><span style="font-size: 15px;text-align: center"><b>Can Order</b></span></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach items="${books}" var="book" varStatus="st">
				
				<tr>
					<td class="td_style_2"><span style="font-size: 15px;text-align: center"><b>${book.ID}</b></span></td>
					<td class="td_style_2">
						<span id="location_1_${st.count }" style="font-size: 15px;text-align: center"><b>${book.location}</b></span>
						<textarea form="location_submit_${st.count }" id="location_2_${st.count }" name="location_submit" style="width:200px;height: 25px;display:none">${book.location}</textarea>
					</td>
					<td>
						<button id="location_submit_1_${st.count }" onClick="location_1_${st.count }.style.display='none',location_2_${st.count }.style.display='block',location_submit_1_${st.count }.style.display='none',location_submit_2_${st.count }.style.display='block'">Edit</button>
						<form action="BookInformationServlet?isLocationUpdate=1&ISBN=${book.ISBN }&ID=${book.ID}" method="post" id="location_submit_${st.count }">
							<button type="submit" id="location_submit_2_${st.count }" style="display:none">Save</button>
						</form>
					</td>
					<td class="td_style_1">
						<span style="font-size: 15px;text-align: center">
							<c:if test="${book.isborrow == 0 }">No</c:if>
							<c:if test="${book.isborrow == 1 }">Yes</c:if>
						</span></td>
					<td class="td_style_1"><span style="font-size: 15px;text-align: center">
							<c:if test="${book.isorder == 0 }">No</c:if>
							<c:if test="${book.isorder == 1}">Yes</c:if>
						</span></td>	
					<td>
						<form action="BookInformationServlet?isDelete=1&ID=${book.ID}&ISBN=${book.ISBN}&bookname=${book.bookname}" method="post" id="delete_submit_${st.count }">
							<button type="button" id="delete_1_submit${st.count }" onClick="delete_1_submit${st.count }.style.display='none',delete_submit${st.count }.style.display='block',select_${st.count }.style.display='block'">Delete</button>
							<button type="submit" id="delete_submit${st.count }" style="display:none">Sure?</button>
						</form>					
					</td>
					<td>
						<select id="select_${st.count }" name="deleteReason" form="delete_submit_${st.count }" style="display:none">
							<option>damage
							<option>lost
						</select>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>	
										
</body>
</html>