<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="hirecab.Beans" %>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='design1.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status | KIIT Shuttle Service</title>
</head>
<style>
#title
{
text-align: center;
}
#data
{
border: 2px solid black;
padding: 20px;
background-color: #E2E2E2;
display: block;
position: relative;
text-align: center;
}
</style>
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

<br><br>
<h3 id="title">Your Booking Status is :</h3>
<%! String id1; %>
<div id="data">
<%
try
{Beans.connect();
id1=request.getParameter("tb1");
Beans.dataRet("select * from `cust_bookings` where `booking_id`='"+id1+"'");
//Beans.dataRet("select * from `customer` where `cust_id`='T539TAJPUC'");
System.out.println("12345");
ResultSet rs=Beans.getRs();
if(rs.first())
{
//while(rs.next())
{
	System.out.println(rs.getString(2));  
	System.out.println("1234");
 
	  %>
	   <p>Name : <%= rs.getString(3) %> </p>
<br><p>Date of Journey : <%= rs.getString(6) %> </p>
<br><p>Time of Journey : <%= rs.getString(7) %> </p>
<br><p>Pick up Location : <%= rs.getString(8)%> </p>
<br><p>Address : <%= rs.getString(10) %></p>
<br><p>Drop location : <%= rs.getString(9) %> </p>
	  
	  <%
}}
else
{
	%>
<script>
{
alert("No Booking found with this ID");
location.href="status.jsp";
}
</script>


<%}
}
catch(Exception e)
{e.printStackTrace();
}%>
</div>
<br><br>
<div id="footer">
<p> <a href="contactus.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer><br>
&reg;All rights reserved!
</footer>
</body>
</html>