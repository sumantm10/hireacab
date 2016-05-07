<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="hirecab.Beans" %>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel='stylesheet' type='text/css' href='design1.css'>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 
  <title>More Services | KIIT Shuttle Service</title>
</head>
<style>
#soon
{
height: 400px;
width : 100%;
}
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
text-align: left;
}
</style>
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
<!-- <div id="div3" align="right"></div> -->

<a id="feedback" href="feedback.jsp"><img id="feed" src="images/feedback.png"/></a>
<a id="heading" href="index.jsp" onmouseout="myFunction2('heading')"> <h1 onmouseout="myFunction2('heading')">KIIT Shuttle Service</h1> </a>


<h4 id="title"> Your Previous Rides :</h4><br>
<%! String id; %>
<div id="data">
<%
try {
	Beans.connect();
	id=(String)session.getAttribute("custid");
	String query = "select * from cust_bookings,driver_bookings where cust_bookings.booking_id = driver_bookings.booking_id AND cust_id='"+id+"'ORDER BY date";
	Beans.dataRet(query);
	System.out.println("12345");
	ResultSet rs = Beans.getRs();
	while(rs.next())
		{
		%>
		<br>
		   <p>Name : <%= rs.getString(3) %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   Mobile Number : <%= rs.getString(4) %> </p>
	<br><p>Date of Journey : <%= rs.getString(6) %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Time of Journey : <%= rs.getString(7) %> </p>
	<br><p>Pick up Location : <%= rs.getString(8)%> </p>
	<br><p>Drop location : <%= rs.getString(9) %> </p>
	<br><p>Driver Name : <%= rs.getString(12) %> </p>
	 <br><hr>
		  
	<%	  
}}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</div>

<br>
<br><hr><br>
<div id="footer">
<p> <a href="contactus.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer><br>
&reg;All rights reserved!
</footer>
</body>
</html>