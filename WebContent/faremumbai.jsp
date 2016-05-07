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
  <title>Fare Details | hireacab</title>
</head>
<style>
#faredelhi
{
margin-left: 200px;
border : 3px solid #009;
opacity:0.8;
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
<div id="div1"></div>
<!-- <div id="div3" align="right"></div> -->

<a id="feedback" href="feedback.html"><img id="feed" src="images/feedback.png"/></a>
<a id="heading" href="index.html" onmouseout="myFunction2('heading')"> <h1 onmouseout="myFunction2('heading')"> Hire-a-cab</h1> </a>

<div class="container">
  <h3 id="tariff"> Hire-a-cab | Tariffs </h3> <br>
  <ul class="nav nav-pills">
    <li><a href="faredetails.jsp"> New Delhi </a></li>
    <li class="active"><a href="faremumbai.jsp"> Mumbai </a></li>
  </ul>
  <br><br>
</div>
<img id="faredelhi" src="images/faremumbai.png">

<br><br><br><br><br><br>
<div id="footer">
<p id="bottom"> <a href="#">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer>
&reg;All rights reserved!
</footer>

</body>
</html>