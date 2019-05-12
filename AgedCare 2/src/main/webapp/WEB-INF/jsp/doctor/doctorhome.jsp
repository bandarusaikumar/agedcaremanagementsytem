<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include.jsp"%>
<html>
<head>
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
.home{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
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
</style>

<meta charset="ISO-8859-1">
<title>AgedCare</title>
</head>
<body>
<div class="head">Aged Care Management System </div>
<%-- <div class="menu">
<div class="home"><a href="/agedcare/doctorhome/${doctor.doctorId}" class="home_a">Home</a></div>
<div  class="nurse_visiting"><a href="/agedcare/dnursevisiting/${doctor.doctorId}" class="nurse_visiting_a">NURSE VISITING</a></div>
 <div  class="g_i_f_d"><a href="/agedcare/doctorcontacts/${doctor.doctorId}" class="g_i_f_d_a">CONTACT PATIENT</a></div>
<div  class="logout"><a href="/agedcare/logout" class="logout_a">LOGOUT</a></div>
</div>
 --%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <ul class="navbar-nav">
	 	<li class="nav-item active" > <a href="/agedcare/doctorhome/${doctor.doctorId}"  class="nav-link">Home</a> </li>
	    <li class="nav-item "> <a href="/agedcare/dnursevisiting/${doctor.doctorId}" class="nav-link">NURSE VISITING</a></li>   
	   	<li class="nav-item "> <a href="/agedcare/doctorcontacts/${doctor.doctorId}" class="nav-link">CONTACT PATIENT</a></li>   
	    <li class="nav-item"><a href="/agedcare/logout" class="nav-link">LOGOUT</a></li>  
	  </ul> 
  </nav>
<div class="navbar_border"></div>

<div class="container">
<c:if test="${!empty patients}">
	<table class="table table-bordered">
		<tr>
			<th align="center">Patient Name</th>
			<th align="center">Address</th>
			<th align="center">Email Id</th>
			<th align="center">contactNumber</th>
			
		</tr>
		<c:forEach items="${patients}" var="patient">
			<tr>				
				<td><c:out value="${patient.patientName}"/></td>
				<td><c:out value="${patient.patientaddress}"/></td>
				<td> <c:out value="${patient.patientemail}"/></td>				 
				<td><c:out value="${patient.patientContactnumber}"/></td>
				
			</tr>
		</c:forEach>
	</table>
	<br/>
</c:if>


</div>
</body>
</html>