<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include.jsp"%>
<html>
<head>
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
.contact_admin{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
}
.formbody{
margin: 5px 0px 0px 0px;
text-align: center;
height: 250px;
width: 30%;
font-family: arial;
font-size: 14px;
font-style: normal;
font-weight: bold;
border: 1px solid;
margin: 0 auto;
padding: 15px 0px 0px 0px;
}

.data-button{
	text-align: center;	padding: 5px 10px;	width: 40%;	margin: 0 auto;
}
.data-text{
	padding: 5px 10px;
	display: inline-block;
}
input {
	height: 20px;
}
.signin {
	padding: 4px 18px 21px 18px;
	/* text-align: center; */
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
.loginHead {
	text-align: center;
	height: 34px;
	width: 200px;
	font-family: arial;
	font-size: 20px;
	font-style: normal;
	font-weight: bold;
	/* border: 1px solid; */
	margin: 6px auto;
	/* padding: 4px 0px 0px 0px; */
}
 .data-label {
	display: inline-block;
	width: 30%;
	text-align: right;
}
</style>

<meta charset="ISO-8859-1">
<title>AgedCare</title>
</head>
<body>
<div class="head">Aged Care Management System </div>
<%-- <div class="menu">
<div class="home"><a href="/agedcare/patienthome/${patient.patientId}" class="home_a">Home</a></div>
<div  class="nurse_visiting"><a href="/agedcare/nursevisiting/${patient.patientId}" class="nurse_visiting_a">NURSE VISITING</a></div>
<div  class="contact_admin"><a href="/agedcare/admincontact/${patient.patientId}" class="contact_admin_a">CONTACT ADMIN</a></div>
<div  class="g_i_f_d"><a href="/agedcare/doctorcontact/${patient.patientId}" class="g_i_f_d_a">CONTACT DOCTOR</a></div>
<div  class="logout"><a href="/agedcare/logout" class="logout_a">LOGOUT</a></div>
</div>
 --%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <ul class="navbar-nav">
	 	<li class="nav-item " > <a href="/agedcare/patienthome/${patient.patientId}"  class="nav-link">Home</a> </li>
	    <li class="nav-item "> <a href="/agedcare/nursevisiting/${patient.patientId}" class="nav-link">NURSE VISITING</a></li>   
	   	<li class="nav-item active"> <a href="/agedcare/admincontact/${patient.patientId}" class="nav-link">CONTACT ADMIN</a></li> 
	   	<li class="nav-item "> <a href="/agedcare/doctorcontact/${patient.patientId}" class="nav-link">CONTACT DOCTOR</a></li>     
	    <li class="nav-item"><a href="/agedcare/logout" class="nav-link">LOGOUT</a></li>  
	  </ul> 
  </nav>
  <div class="navbar_border"></div>
  <div class="loginHead">Contact Admin </div>
<form action="/agedcare/pcontactadmin/${patient.patientId}" method="post">
<div  class="formbody">
	<div class="data-label">Patient Name</div>
	<div class="data-text"><input type="text"  name="patientName"  value="${patient.patientName}" readonly="readonly"></div>	
	<div class="data-label">Query</div>
	<div class="data-text"><input type="text"  name="query" placeholder="QUERY"></div>
	<div class="data-label">Patient Mail Id</div>
	<div class="data-text"><input type="text"  name="patientMailId" placeholder="Patient Mail Id"></div>
	
	<div class="data-button">
			<input type="submit" class="signin"  name="submit" value="SUBMIT"> 
	</div>
</div>
</form>
</body>
</html>