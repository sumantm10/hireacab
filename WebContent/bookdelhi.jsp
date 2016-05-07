<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
	<%@page import="java.sql.ResultSet"%>
    <%@page import="hirecab.Beans" %>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='design1.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Bhubaneswar | KIIT Shuttle</title>
</head>
<style>
h3
{
border : double;
padding: 10px;
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
<!-- <div id="div3" align="right"></div> -->

<a id="feedback" href="feedback.jsp"><img id="feed" src="images/feedback.png"/></a>
<a id="heading" href="index.jsp" onmouseout="myFunction2('heading')"> <h1 onmouseout="myFunction2('heading')">KIIT Shuttle Service</h1> </a>
</header>
<h3>Book A Cab For</h3>
<form id="form1" method="get" action="bookeddelhi">
  <p>Name :
  <input name="tb1" type="text" autofocus id="tb1" autocomplete="on" placeholder="Enter Name" size="40" maxlength="60" required="required">	&nbsp;
  &nbsp;
    Mobile Number : 
    <input name="tb2" type="text" id="tb2" autocomplete="on" placeholder="Enter Mobile Number" size="40" required="required">
  <br><br><br>
  <p>E-mail ID 
    <input name="email" type="email" id="email" autocomplete="on" placeholder="Enter e-mail ID" size="40" required="required">
    <br><br>
&nbsp;</p><hr id="hr1">
<br>
  <p>Pick up Date and Time
 <!--   <input list="date" name="date" placeholder="Select a day"> -->
      <select id="date" name="date">
      <option value="Today">Today</option>
      <option value="Tomorrow">Tomorrow</option>
    </select>
  <!-- <input list="hour" name="time1" placeholder="Select Hour"> -->
  <select id="hour" name="hr">
    <option value="00">00</option>
      <option value="01">01</option>
      <option value="02">02</option>
      <option value="03">03</option>
      <option value="04">04</option>
      <option value="05">05</option>
      <option value="06">06</option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">      17</option>
    <option value="18">18</option>
      <option value="19">      19</option>
    <option value="20">20</option>
      <option value="21">      21</option>
    <option value="22">22</option>
      <option value="23">23</option>
    </select>
  <!-- <input list="time" name="timemin" placeholder="Select minutes"> -->
  <select id="minute" name="min">
    <option value="00">00</option>
  <option value="10">10</option>
  <option value="20">20</option>
  <option value="30">30</option>
  <option value="40">40</option>
  <option value="50">  50</option>
</select>
<br><br>
<hr id="hr2">
<br>
Location &nbsp;&nbsp;
<%! int i; %>
<%
try
{Beans.connect();
String c="Bhubaneswar";
i=1;
Beans.dataRet("select place from city where city='Bhubaneswar'");
ResultSet rs=Beans.getRs();
%>
<select id="pick" name="pick">
<option value="00">-Select-</option>
<%while(rs.next())
{
%>
<option><%= rs.getString(i) %></option>
<%} %>
</select>
<br>
<%}
catch(Exception e)
{
	e.getStackTrace();
}
%>
<br><br>
<label for="textarea">Pick up Address
  </label>
  <br><br>
  <textarea name="textarea" cols="100" rows="15" id="textarea"></textarea>
  <br><br>
 Drop Location &nbsp;&nbsp;
<%
try
{Beans.connect();
String c="Delhi";
i=1;
Beans.dataRet("select place from city where city='Bhubaneswar'");
ResultSet rs=Beans.getRs();
%>
<select id="drop" name="drop">
<option value="00">-Select-</option>
<%while(rs.next())
{
%>
<option><%= rs.getString(i) %></option>
<%} %>
</select>
<br>
<%}
catch(Exception e)
{
	e.getStackTrace();
}
%>
<br><br>
  <div id="btn">
<input id="button" type="submit" value="book now">
</div>
<br>
</form><br><br>
<div id="footer">
<p> <a href="contactus.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer><br>
&reg;All rights reserved!
</footer>
</body>
</html>