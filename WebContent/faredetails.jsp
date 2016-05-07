<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel='stylesheet' type='text/css' href='design1.css'>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <title>Fare Details | KIIT Shuttle Service</title>
</head>
<style>
#faredelhi
{
margin-left: 200px;
border : 3px solid #009;
opacity: 0.8;
}
#faredelhi:hover
{
opacity: 1;
transition : 0.5s;
-webkit-transition: 0.5s; 
}
#bottom
{
font-size: 18px;
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

<div class="container">
  <h3> KIIT Shuttle Service | Tariffs </h3> <br>
  <ul class="nav nav-pills">
    <li class="active"><a href="faredetails.jsp"> Bhubaneswar </a></li>
    <!-- <li><a href="faremumbai.jsp"> Mumbai </a></li> -->
  </ul>
  <br><br>
</div>
<img id="faredelhi" src="images/faredelhi.png">

<br><br><br><br><br><br>
<div id="footer">
<p> <a href="contactus.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer>
<br>
&reg;All rights reserved!
</footer>

</body>
</html>