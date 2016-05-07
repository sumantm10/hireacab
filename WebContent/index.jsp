<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
	<%@page import="java.sql.ResultSet"%>
    <%@page import="hirecab.Beans" %>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="scripts/jquery-1.6.min.js" type="text/javascript"></script>
<script src="scripts/jquery.cycle.all.js" type="text/javascript"></script>
<title>KIIT Shuttle Service</title>
<style type="text/css">
#slideshow {  
    			padding: 10px;
				margin:0;
				left:100px;  
			} 
			#slideshow-caption{
				padding:0;
				margin:0;
			}
 
			#slideshow img, #slideshow div {  
    			padding: 10px;
    			background-color: #EEE;
				-webkit-border-radius: 10px;
				-moz-border-radius: 10px;
				border-radius: 10px; 
    			margin: 0; 
			}
		
/* EndOAWidget_Instance_2559022 */
</style>
</head>
<style>
*
{
margin: 0px;
padding: 0px;
}
#footer
{
border: 1px solid;
}
body
{
font-family: verdana;
padding:20px;
background-image: url("back4.jpg");
}
h1,#heading
{

text-decoration:none;
color: black;
text-align: center;
border-bottom: 2px solid #009;
margin-bottom: 50px;
}
#heading,h1:hover
{
text-decoration:none;
color: #4E0384;
text-align: center;
-webkit-transition: 0.5s; 
transition:0.5s;
}

#ul
{
margin-left: 350px;
}
ul#ulname,ul.sub1
{
list-style-type: none;
}
ul#ulname li
{
width: 125px;
text-align: center;
position: relative;
float: left;
margin-right: 4px;
}
ul#ulname a
{
text-decoration: none;
display: block;
width: 125px;
height: 25px;
line-height: 25px;
background-color: #BCB3C1;
border: 1px solid #9D259D; 
}
ul#ulname .sub1 a
{
margin-top: 3px;
}
ul#ulname li:hover > a {
background-color: #BF8ADB;
}
ul#ulname li:hover a:hover {
background-color: #C48CCB;
}
ul#ulname ul.sub1 {
display: none;
position: absolute;
top :26px;
left: 0px;
}
ul#ulname li:hover .sub1
{
display:block;
transition:background 0.3s linear 0s, color 0.3s linear 0s;
}

.darrow
{
font-size: 11pt;
position: absolute;
top: 5px;
right: 2px;
}
#div1
{
width: 20px;
    height: 20px;
    background: red;
    position: relative;
    text-align: left;
    -webkit-animation: myfirst 5s; /* Chrome, Safari, Opera */
    animation: myfirst 8s;
     animation-timing-function: linear;
    animation-delay: 2s;
    animation-iteration-count: infinite;
    animation-direction: alternate;
    animation-play-state: running;
}
@keyframes myfirst {
    0%   {background:red; left:0px; top:0px;}
    25%  {background:yellow; left:440px; top:0px;}
    50%  {background:blue; left:440px; top:60px;}
    75%  {background:green; left:0px; top:60px;}
    100% {background:red; left:0px; top:0px;}
}


#footer p
{
margin-left: 400px;
}
#footer p a
{
text-decoration: none;
}
#feedback
{
position:fixed;
z-index: 500;
margin-left: 1285px;
}
h5 a
{
text-decoration: none;
margin-left: 30px;
}
.stuts{
    margin-left:30px;
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
		alert('Please log in to access the kiit shuttle service.');
		location.href='first.jsp';
			}
	}
	</script>
<div id="div1"></div>
<!-- <div id="div3" align="right"></div> -->
<header><p class="stuts">Welcome <span><%= session.getAttribute("name")%></span></p>   
            <h5> <a href="Logout.jsp">Logout</a></h5>
<a id="feedback" href="feedback.jsp"><img id="feed" src="images/feedback.png"/></a>
<a id="heading" href="index.jsp" onmouseout="myFunction2('heading')"> <h1 onmouseout="myFunction2('heading')">KIIT Shuttle Service</h1> </a>
</header>
<div id="ul">
<ul id="ulname">

<li><a>Book a cab</a><span class="darrow">&#9660;</span>
	<ul class="sub1">
	<li><a href="bookdelhi.jsp">Bhubaneswar</a>
	<!-- <li><a href="bookmumbai.jsp">Mumbai</a> -->
	</ul>
<li><a href="status.jsp">Track</a>
<li><a href="faredetails.jsp">Fare Details</a>
<li><a href="more.jsp">History </a>	
</ul>
</div>
<!-- <div id="div2"> -->
<br><br><br><br><br>

<script type="text/javascript">
// BeginOAWidget_Instance_2559022: #slideshow

   		    slideshowAddCaption=true;
$(document).ready(function() {
	$('#slideshow').cycle({
		after:			slideshowOnCycleAfter, //the function that is triggered after each transition
		autostop:			false,     // true to end slideshow after X transitions (where X == slide count) 
		fx:				'blindX',// name of transition effect 
		pause:			false,     // true to enable pause on hover 
		randomizeEffects:	true,  // valid when multiple effects are used; true to make the effect sequence random 
		speed:			1000,  // speed of the transition (any valid fx speed value) 
		sync:			true,     // true if in/out transitions should occur simultaneously 
		timeout:		3000,  // milliseconds between slide transitions (0 to disable auto advance) 
		fit:			true,
		height:		   '300px',
		width:         '1000px'   // container width (if the 'fit' option is true, the slides will be set to this width as well) 
	});
}); 
function slideshowOnCycleAfter() { 
	if (slideshowAddCaption==true){
			$('#slideshow-caption').html(this.title); 
	}
} 
		
// EndOAWidget_Instance_2559022
</script>
<div id="slideshow">
  <!--All elements inside this will become slides-->
  <img src="images/taxi1.jpg" width="1000" height="300" /> <img src="images/taxi2.png" width="1000" height="300"  /> <img src="images/taxi3.jpg" width="1000" height="300"  />
  
  <img src="images/taxi4.jpg" width="1000" height="300"  /> <img src="images/taxi5.jpg" width="1000" height="300"  /> <img src="images/taxi6.jpg" width="1000" height="300"  /></div>
<!--It is safe to delete this if captions are disabled-->
<div id="slideshow-caption"></div>
<br><br>
<hr>
<br><br>
<div id="footer">
<p> <a href="contactus.jsp">contact us</a> | <a href="#">report error</a> | <a href="#">Advertise with us</a></p>
</div>
<footer><br>
&reg;All rights reserved!
</footer>
</body>
</html>