<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recover Your Password</title>
</head>
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
h1
{
text-align: center;
border-bottom:0px solid #009;
margin-bottom: 50px;
}
#form1
{
padding: 50px;
font-size: 14px;
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
#name,#number,#email,#pass,#pass1,#email1,#passw
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
#recover
{
	padding:6px;
	font-size: 14px;
	font-family: Aller;
	color:#4B3F3F;
	font-style: bold;
	position: block;
	background-color: #CDC9C9;
	border-width: 00;
	width: 30%;
	margin-left:250px;
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
}
#footer p a
{
text-decoration: none;
}
#forgot
{
font-size: 12px;
font-family: monospace;
color: #BDBDBD;
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
</style>
<body>
<h1> KIIT Shuttle Service </h1>
<div class="bordering" align="center">
<h4> Having Trouble Signing in? </h4>
<form id="form1" action="Recover" method="post">
Enter Your Registered Email ID &nbsp;&nbsp; : &nbsp;&nbsp; <input type="email" name="email" id="email" placeholder="Valid Email ID" required="required" size="40" maxlength="60"><br><br><br>
<input type="submit" name="recover" id="recover" value="continue">
<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
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