<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 	<script src="webjars/jquery/3.0.0/jquery.min.js" ></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<style type="text/css">
.head{
text-align: center;
height: 50px;
width: 100%;
font-family: arial;
font-size: 20px;
font-style: normal;
font-weight: bold;
border-bottom: 1px solid;
margin: 0px 0px 2px 0px;
color: darkgreen;
background: skyblue;
}
.menu{
text-align: center;
height: 50px;
width: 100%;
font-family: arial;
font-size: 20px;
font-style: normal;
border-bottom: 1px solid;
margin: 0px 0px 2px 0px;
}
.home, .nurse_visiting, .contact_admin , .g_i_f_d, .logout {
	display: inline-block;
	padding: 5px 10px;
	border: 1px solid;
	border-radius: 5px;
	margin: 10px 0px;
}
.home_a, .nurse_visiting_a, .contact_admin_a , .g_i_f_d_a, .logout_a{
	text-decoration: none;
	color: #000;
}
.nurse_visiting{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
}
a {
	text-decoration: none;
	color: #000;
}
.bg-dark {
	background-color: #a4aab0 !important;
}
.navbar {
	padding: 0px 0px;
	width: 50%;
	text-align: center;
	margin: 0 auto;
}
.nav-link {
	padding: 8px 0px;
}
.active.nav-item {
	background: aqua;
	border-radius: 10px;
}
.navbar_border {
	border-bottom: 1px black solid;
	padding-top: 2px;
}
.table.table-borderless {
	margin: 0px 0px 3px 0px;
}
.table.table-bordered {
	margin: 10px 0px 3px 0px;
}
.table-borderless td {
	border-top: 0px;
}
</style>

<meta charset="ISO-8859-1">
<title>AgedCare</title>
</head>
<body>
<div class="head">Aged Care Management System </div>
<!-- <div class="menu">
<div class="home"><a href="/agedcare/adminhome" class="home_a">Home</a></div>
<div  class="nurse_visiting"><a href="/agedcare/nursevisiting" class="nurse_visiting_a">NURSE VISITING</a></div>
<div  class="contact_admin"><a href="/agedcare/admincontact" class="contact_admin_a">CONTACT ADMIN</a></div>
<div  class="g_i_f_d"><a href="/agedcare/getinformationdoctor" class="g_i_f_d_a">GET INFORMATION FROM DOCTOR</a></div>
<div  class="logout"><a href="/agedcare/logout" class="logout_a">LOGOUT</a></div>
</div> -->

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <ul class="navbar-nav">
	 	<li class="nav-item" > <a href="/agedcare/adminhome"  class="nav-link">Home</a> </li>
	    <li class="nav-item active"> <a href="/agedcare/nursevisiting" class="nav-link">NURSE VISITING</a></li>   
	   	<li class="nav-item "> <a href="/agedcare/admincontact" class="nav-link">CONTACT ADMIN</a></li>   
	    <li class="nav-item"><a href="/agedcare/logout" class="nav-link">LOGOUT</a></li>  
	  </ul> 
  </nav>
<div class="navbar_border"></div>

<div class="container">
<table class="table table-borderless" >
	<tr><td align="right" class="textbold"><font color="blue"><a href="/agedcare/nursevisit/addnursevisit">Add New</a></font> </td></tr>
	</table>
<c:if test="${!empty patientRelationBeans}">
	<table class="table table-bordered" >
	<thead>
		<tr>
			<th align="center">Patient Name</th>
			<th align="center">Nurse Name</th>
			<th align="center">Doctor Name</th>
			<th align="center">Nurse Visiting Day</th>
			<th align="center">Nurse Reason</th>
			<th align="center">Delete</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${patientRelationBeans}" var="patientRelationBean">
			<tr>
				<td ><c:out value="${patientRelationBean.patientName}"/></td>
				<td><c:out value="${patientRelationBean.nuirseName}"/></td>
				<td><c:out value="${patientRelationBean.doctorName}"/></td>
				<td><c:out value="${patientRelationBean.nurseVisitingDate}"/></td>
				<td> <c:out value="${patientRelationBean.reason}"/></td>
				<td align="center"><a href="/agedcare/deletenursevisit/${patientRelationBean.pat_relationId}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br/>
</c:if>


</div>
</body>
</html>