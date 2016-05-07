<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='feedback.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KIIT Shuttle Service</title>
<script src="js/my_js.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<script>
var pass,pass1;
function checkFunction()
{
	pass = document.getElementById("pass").value;
	pass1 = document.getElementById("pass1").value;
	if(pass != pass1)
		{
		alert('Passwords Do not match');
		}
	}
	
function mirror(){
	  document.getElementById("numdis").innerHTML=document.getElementById("number").value
	}

	
</script>
<style>
body
{
background-image: url("back4.jpg");
background-position: center;
position : relative;
font-size: 18px;
font-style: normal;
font-family: Aller ;
font-weight: bold;
margin-top:35px;
margin-left:30px;
margin-right:40px;

    color: #000000;

}
h1,#head1
{
text-align: center;
border-bottom:0px solid #009;

}
#form1
{
padding: 50px;
font-size: 18px;
font-style: normal;
font-family: sans-serif;
font-weight: bold;
    color: #000000;
}
.bordering
{

border: 10px solid transparent;
    padding: 15px;
    
    
    
    position : relative;
    -webkit-border-image: url(images/border.png) 30 round; /* Safari 3.1-5 */
    -o-border-image: url(images/border.png) 30 round; /* Opera 11-12.1 */
    border-image: url(images/border.png) 30 round;
}
#regisf
{
float:left;
}
#loginf
{
float:right;
margin-right: 60px;
}
#name,#number,#email,#pass,#pass1,#email1,#passw,#roll,#otp
{
padding: 8px;
font-size:16px;
background-color: #EBE3E3;
background: transparent;
overflow:hidden;
border-width: 1px;
border-color:black;
height:20px;
}
#login,#Register
{
	padding:6px;
	font-size: 14px;
	font-family: Aller;
	color:#4B3F3F;
	font-style: bold;
	position: block;
	background-color: #CDC9C9;
	border-width: 00;
	width: 60%;
	height:30px;
}
#Register1
{

	padding:6px;
	font-size: 14px;
	font-family: Aller;
	color:#4B3F3F;
	font-style: bold;
	position: block;
	background-color: #CDC9C9;
	border-width: 00;
	width: 20%;
	height:30px;
}
#footer
{
position: relative;
  top: 50%;
  transform: translateY(-50%);
  color:#F15858;
}
#footer a
{
color:#2A1212;
text-decoration: none;
}
#forgot
{
font-size: 12px;
font-family: monospace;
color: #1C1C1C;
text-decoration: none;
}
h6
{
font-size: 12px;
font-family: monospace;
color:black;
text-decoration: none;
}
#fgot
{
 background-color: Transparent;
    background-repeat:no-repeat;
    border: none;
    cursor:pointer;
    overflow: hidden;
    
    outline:none;
    font-size: 12px;
font-family: monospace;
color: #BDBDBD;
text-decoration: none;
}
.clear { 
	clear:both; 
}
</style>

<body>



<h1 id="head1"> KIIT Shuttle Service </h1>

<div class="bordering" align="center">
<form action = "Input" method = "post" id = "form1">
Enter OTP : <input type = "text" name = "otp" id = "otp" placeholder = "Enter OTP"> <br><br><br>
<%
String t = (String)request.getAttribute("time");
String otpp = (String)request.getAttribute("otp");

/* request.getAttribute("pass1", pass1);
request.getAttribute("roll", roll);
request.getAttribute("date", date);
request.getAttribute("number", number);
request.getAttribute("email", email);
request.getAttribute("name", name);
request.getAttribute("uid", uid);
 */%>
<input type="hidden" name="name" value=<%=request.getAttribute("name") %>> 
<input type="hidden" name="roll" value=<%=request.getAttribute("roll") %>> 
<input type="hidden" name="number" value=<%=request.getAttribute("number")%>> 
<input type="hidden" name="email" value=<%=request.getAttribute("email") %>> 
<input type="hidden" name="date" value=<%=request.getAttribute("date") %>> 
<input type="hidden" name="pass" value=<%=request.getAttribute("pass") %>> 
<input type="hidden" name="time" value=<%=request.getAttribute("time") %>> 
<input type="hidden" name="otpt" value=<%=request.getAttribute("otp") %>> 

<br><br>
<input type = "submit" id="Register1" value = "check">
</form>

<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
</form>
<div id="footer">
<p> <a href="contactusfirst.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer>
&reg;All rights reserved! <br> <br>
</footer>
</div>
</body>
</html>