<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="hirecab.Beans" %>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='design1.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>check status | kiit shuttle service</title>
</head>
<script>
function myFunction2(id)
{
	document.getElementById(id).style.transition = "0.5s";
	document.getElementById(id).style.WebkitTransition = "0.5s";
}
</script>
<body>
<script>
	{
		var svar = '<%=session.getAttribute("name")%>';
		if(svar.localeCompare("null")==0)
			{
		alert('Please log in to access the KIIT Shuttle Service.');
		location.href='first.jsp';
			}
	}
	</script>
<div id="div1"></div>
<header>
<p class="stuts">Welcome <span><%=session.getAttribute("name") %></span></p>

            <h5> <a href="Logout.jsp">Logout</a></h5>

<a id="feedback" href="feedback.jsp"><img id="feed" src="images/feedback.png"/></a>
<a id="heading" href="index.jsp" onmouseout="myFunction2('heading')"> <h1 onmouseout="myFunction2('heading')">KIIT Shuttle Service</h1> </a>
<br><br><br>
<form id="form1" action="showstatus.jsp">
Booking ID : <input name="tb1" type="text" autofocus id="tb1" autocomplete="on" placeholder="Enter ID" size="40" maxlength="60" required="required">	&nbsp;
  &nbsp;
  <br><br>
  <div id="btn">
<input id="button" type="submit" value="check status">
</div><br>
</form>
<br><br><br><br><br><br><br>
<div id="footer">
<p> <a href="contactus.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer><br>
&reg;All rights reserved!
</footer>
</body>
</html>