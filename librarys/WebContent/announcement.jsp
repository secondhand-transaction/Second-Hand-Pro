<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/huakai.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/homepage.css">
<link rel="stylesheet" type="text/css" href="css/Showbig.css">
<script src="js/jquery.min.js"></script>
</head>

<div class="bodylibrary">
	<div class="allpage">
		<div class="headpage">
		<div class="booklibrarian">
			<img src="images/librarian.jpg" width="40%" height="80%" style="float:left;margin-top:10%">
			<p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:10%;float:left">Nickname:</p>
			 <p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:0%;float:left"><%
out.println(session.getAttribute("Librarianname"));
%>!</p>
	  	    <form action="login.jsp?" method="post">  	   
 <p><input type="submit"  value="logout" style="color:white;background-color:red;width:60px;height:30px;margin-left:10%;float:left;"><p>
	</form>													
																
		</div>
		<div class="picturepage">
			<img src="images/library.jpg" width="100%" height="100%">	
		</div>
		<div class="sumpage">
     <p class="part" style="color:#F00F13">Total number of library Announcement: <strong style="color:#000000">${all}</strong>piece</p>
	 
	</div>
	</div>

 <div class="div1" >
    <div style="align-content: center" align="center"><span style="font-size: 30px"><b>Announcement</b></span></div><form method="POST" action="AnnouncementListServlet?">
	<div class="fill_ipt" >
	<span style="margin-right:450px;font-size:20px"></span>
	<input type="text" class="showbig" name="announcement" placeholder="Please input announcement" style="width: 500px;height:50px;margin:auto;" />
	<input type="submit"  value="submit" style="color:white;background-color:#2B7ACD;width:60px;height:30px;margin:auto;align:center">
	</div>
   </form>
  <script type="text/javascript">
//金额输入放大显示
$(".showbig").focus(function(){
	var _fill_ipt = $(this).parent(".fill_ipt");
	if (_fill_ipt.find('.bigtx').size() === 0) {
		var tar = "<div class='bigtx'><span></span><i></i></div>";
		_fill_ipt.append(tar)
	}
}).bind('input propertychange', function(){
	//console.log(1)
	var tx =$(this).val();
	
	var _format_value = tx;
	if (_format_value !== '' && !isNaN(_format_value)) {
		var _value_array = _format_value.split('.');
		var _int = _value_array[0];
		var _decimal = '';
		if (_value_array.length > 1) {
			_decimal = _value_array[1];
		}

		var _int_str = '';
		var _count = 0;

		for (var i = _int.length - 1; i >= 0; i--) {
			_count++;
			_int_str = _int.charAt(i) + _int_str;
			if (!(_count % 3) && i !== 0) {
				_int_str = ',' + _int_str;
			}
		}

		_format_value = _int_str;

		if (_decimal !== '') {
			_format_value += '.' + _decimal;
		}
	}
	
	$(this).siblings(".bigtx").css({
		"top":"-37px",
		"opacity":"1"
	});
	$(this).siblings(".bigtx").find("span").html(_format_value);
	if(_format_value ===""){
		$(this).siblings(".bigtx").css({
		"top":"0",
		"opacity":"0"
		})
		}
}).blur(function(){

		$(this).siblings(".bigtx").css({
			"top":"0",
			"opacity":"0"
		});
		var _fill_ipt = $(this).parent(".fill_ipt");
		if (_fill_ipt.find('.bigtx').size() > 0) {
			setTimeout(function () {
				_fill_ipt.find('.bigtx').remove();
			}, 200);
		}
});
</script>  
    
    
 <c:forEach items="${announcements}" var="announcement" varStatus="pt">
   <div>
   <form method="POST" action="AnnouncementListServlet?ID=${announcement.ID}&tag=0">
	<table  class="table1" cellpadding="0" cellspacing="0"  onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='white';">
	   <tr >
	    <td class="td3" >ID：${announcement.ID}<a href="###"></a></td>
			<td style="text-align: right"><span style="color: #807576;text-align: center"></span></td>
	    </tr>
		<tr height="5px"></tr>
     	<tr>
	   	<td align="center" colspan="2"><textarea id="content" name="content" style="border: none" cols="80%" rows="6px" >${announcement.content}</textarea></td>
	   </tr>
	    <tr height="5px"></tr>
		<input type="submit"  value="edit" style="color:white;background-color:#2B7ACD;width:60px;height:30px; position:relative;left:78%;top:70px;">
	  </form>
	   <form method="POST" action="AnnouncementListServlet?ID=${announcement.ID}&tag=1">
	   <input type="submit"  value="delete" style="color:white;background-color:#2B7ACD;width:60px;height:30px; position:relative;left:72.5%;top:130px;">
	  </form>
	  </table>
	  </div>
		</c:forEach>
		<br>

	 

 <br>  
	<nav>
	<ul class="pager">
		<li><a href="?start=0">home page</a></li>
		<li><a href="?start=${pre}">previous page</a></li>
		<li><a href="?start=${next}">next page</a></li>
		<li><a href="?start=${last}">last page</a></li>
	</ul>
</nav>
	<br>
<div style="width=100%" >
	
       
</div>
</div>

	</div>
</div>	

		
</body>
</html>
 <%@ include file="/hualuo.jsp"%>