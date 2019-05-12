<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
.loginHead{
text-align: center;
height: 30px;
width: 175px;
font-family: arial;
font-size: 20px;
font-style: normal;
font-weight: bold;
border: 1px solid;
margin: 10px auto;
padding: 4px 0px 0px 0px;
}
.formbody{
margin: 5px 0px 0px 0px;
text-align: center;
height: 200px;
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
	text-align: center;	padding: 5px 10px;	margin: 0 auto;
	display: inline-block;
}
.data-text {
	padding: 5px 10px;
	display: inline-block;
	width: 37%;
}
input {
	height: 20px;
}
.signin {
	padding: 4px 18px 21px 18px;
	border-radius: 4px;
	/* text-align: center; */
}
.reg {
	display: inline-block;
	padding: 6px 10px;
	border: 1px solid;
	border-radius: 5px;
	/* text-decoration: none; */
	margin: 30px 10px;
}
.reg_a, .admin_a {
	text-decoration: none;
	color: #000;
}
.admin {
	display: inline-block;
	padding: 5px 10px;
	border: 1px solid;
	margin: 30px 10px;
	border-radius: 5px;
}
.menu-title {
	text-align: center;
	font-weight: bold;
	font-size: 12px;
	padding: 5px 0px;
	color: Red;
}
.textbold{
text-align: right;
}
.back {
	display: inline-block;
	padding: 5px 10px;
	border: 1px solid;
	border-radius: 5px;
	margin: 10px 0px;
}
.back_a{
	text-decoration: none;
	color: #000;
}
.data-label {
	display: inline-block;
	text-align: right;
	width: 36%;
}
</style>

<meta charset="ISO-8859-1">
<title>AgedCare</title>
</head>
<body>
<div class="head">Aged Care Management System </div>
<div class="loginHead">ADMINLOGIN </div>
<form action="/agedcare/adminlogin" method="post">
<div  class="formbody">
<div class="menu-title">${msg}</div>
	<div class="data-label">User Name</div>
	<div class="data-text"><input type="text" name="username" placeholder="USERNAME" ></div>
	<div class="data-label">Password</div>
	<div class="data-text"><input type="password"  name="password" placeholder="PASSWORD"></div>
	<div class="data-button">
			<input type="submit" class="signin"  name="submit" value="SIGNIN"> 
	</div>
	<div class="back"><a href="/agedcare/logout" class="back_a">BACK</a></div>
</div>



</form>


</body>
</html>