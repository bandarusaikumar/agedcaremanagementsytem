<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty adid}">
<%@include file="../include.jsp"%>
</c:if>
<c:if test="${!empty adid}">
<%@include file="../include1.jsp"%>
</c:if>
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
.g_i_f_d{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
}
.menu-title {
	text-align: center;
	font-weight: bold;
	font-size: 14px;
	padding: 5px 0px;
}
.textbold{
text-align: right;
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
</div> --%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <ul class="navbar-nav">
	 	<li class="nav-item " > <a href="/agedcare/doctorhome/${doctor.doctorId}"  class="nav-link">Home</a> </li>
	    <li class="nav-item "> <a href="/agedcare/dnursevisiting/${doctor.doctorId}" class="nav-link">NURSE VISITING</a></li>   
	   	<li class="nav-item active"> <a href="/agedcare/doctorcontacts/${doctor.doctorId}" class="nav-link">CONTACT PATIENT</a></li>   
	    <li class="nav-item"><a href="/agedcare/logout" class="nav-link">LOGOUT</a></li>  
	  </ul> 
  </nav>
<div class="navbar_border"></div>
<div class="container">
<div class="menu-title">Contact Patient</div>
<c:if test="${!empty doctorContacts}">
	<table class="table table-bordered">
		<tr>
			<!-- <th align="center">Admin Contact Id</th> -->
			<th align="center">Patient Name</th>
			<th align="center">Patient Mail Id</th>
			<th align="center">Query</th>
			<th align="center">Answer</th>
			<th align="center">Edit</th>		
		</tr>
		<c:forEach items="${doctorContacts}" var="doctorContact">
			<tr>
				<%-- <td><c:out value="${adminContact.adminContactId}"/></td> --%>
				<td><c:out value="${doctorContact.patientName}"/></td>
				<td><c:out value="${doctorContact.patientMailId}"/></td>
				<td> <c:out value="${doctorContact.query}"/></td>
				<td> <c:out value="${doctorContact.answer}"/></td>
				<td><a href="/agedcare/contactdoctoredit/${doctor.doctorId}?caid=${doctorContact.doctorContactId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
</c:if>


</div>
</body>
</html>