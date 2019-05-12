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
.loginHead {
	text-align: center;
	height: 34px;
	width: 175px;
	font-family: arial;
	font-size: 20px;
	font-style: normal;
	font-weight: bold;
	/* border: 1px solid; */
	margin: 6px auto;
	/* padding: 4px 0px 0px 0px; */
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
.g_i_f_d{
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
<div class="home"><a href="/agedcare/doctorhome/${doctor.doctorId}" class="home_a">Home</a></div>
<div  class="nurse_visiting"><a href="/agedcare/dnursevisiting/${doctor.doctorId}" class="nurse_visiting_a">NURSE VISITING</a></div>
 <div  class="g_i_f_d"><a href="/agedcare/doctorcontacts/${doctor.doctorId}" class="g_i_f_d_a">CONTACT PATIENT</a></div>
<div  class="logout"><a href="/agedcare/logout" class="logout_a">LOGOUT</a></div>
</div> --%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <ul class="navbar-nav">
	 	<li class="nav-item" > <a href="/agedcare/doctorhome/${doctor.doctorId}"  class="nav-link">Home</a> </li>
	    <li class="nav-item "> <a href="/agedcare/dnursevisiting/${doctor.doctorId}" class="nav-link">NURSE VISITING</a></li>   
	   	<li class="nav-item active"> <a href="/agedcare/doctorcontacts/${doctor.doctorId}" class="nav-link">CONTACT PATIENT</a></li>   
	    <li class="nav-item"><a href="/agedcare/logout" class="nav-link">LOGOUT</a></li>  
	  </ul> 
  </nav>
<div class="navbar_border"></div>
<div class="loginHead">Contact Patient </div>
<form action="/agedcare/contactdoctor/${doctor.doctorId}/${doctorContact.doctorContactId}" method="post">
<div  class="formbody">
	<div class="data-label">Patient Name</div>
	<div class="data-text"><input type="text"  name="patientName"  value="${doctorContact.patientName}" readonly="readonly"></div>
	<div class="data-label">Patient Mail Id</div>
	<div class="data-text"><input type="text"  name="patientMailId"  value="${doctorContact.patientMailId}" readonly="readonly"></div>
	<div class="data-label">Patient Query</div>
	<div class="data-text"><input type="text"  name="query"  value="${doctorContact.query}" readonly="readonly"></div>
	<div class="data-label">Answer</div>
	<div class="data-text"><input type="text"  name="answer" placeholder="ANSWER" value="${doctorContact.answer}"></div>
	<div class="data-button">
			<input type="submit" class="signin"  name="submit" value="SUBMIT">  
	</div>
</div>
</form>


</body>
</html>