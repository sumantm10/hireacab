<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='design1.css'>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link href="http://www.cssscript.com/wp-includes/css/sticky.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Feedback | KIIT Shuttle Serrvice</title>
</head>
<style>
*
{
margin: 0px;
padding: 0px;
}
body
{
font-family: verdana;
background-image: url("back4.jpg");
padding:50px;
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
#feedback
{
position:fixed;
z-index: 500;
margin-left: 1265px;
}
h3
{
text-align: left;
border-bottom: 00px solid #330533;
margin-bottom: 30px
}
div.background
{
border: 1px solid black;
text-align: center;
opacity: 0.6;
font-family: verdana;
}
h4
{
color: #1E0F26;
}
#form1
{
background-color: #ECECEC;
display: block;
position: relative;
border: 2px solid black;
padding: 20px;
}


.cont {
  width: 93%;
  max-width: 350px;
  text-align: center;
  margin: 4% auto;
  padding: 30px 0;
  background: #111;
  color: #EEE;
  border-radius: 5px;
  border: thin solid #444;
  overflow: hidden;
}

hr {
  margin: 20px;
  border: none;
  border-bottom: thin solid rgba(255,255,255,.1);
}

div.title { font-size: 2em; }

h1 span {
  font-weight: 300;
  color: #Fd4;
}

div.stars {
  width: 270px;
  display: inline-block;
}

input.star { display: none; }

label.star {
  float: right;
  padding: 5px;
  font-size: 36px;
  color: #444;
  transition: all .2s;
}

input.star:checked ~ label.star:before {
  content: '\f005';
  color: #FD4;
  transition: all .25s;
}

input.star-5:checked ~ label.star:before {
  color: #FE7;
  text-shadow: 0 0 20px #952;
}

input.star-1:checked ~ label.star:before { color: #F62; }

label.star:hover { transform: rotate(-15deg) scale(1.3); }

label.star:before {
  content: '\f006';
  font-family: FontAwesome;
}
#rate
{
margin-right: 800px;
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
<div class="background">
<h4 id="feed">
Please provide us your feedback to help you serve better in the future.
</h4></div>
<br>
<form id="form1" method="get" action="feedback">
  <p>Name :
  <input name="tb1" type="text" autofocus id="tb1" autocomplete="on" placeholder="Enter Name" size="40" maxlength="60" required="required"><br><br>
    Mobile Number : 
    <input name="tb2" type="text" id="tb2" autocomplete="on" placeholder="Enter Mobile Number" size="40" required="required"><br><br>
  
  E-mail ID  :
    <input name="email" type="email" id="email" autocomplete="on" placeholder="Enter e-mail ID" size="40" required="required">
    </p><hr id="hr1">
Booking ID : <input name="tb3" type="text" autofocus id="tb3" autocomplete="on" placeholder="Enter ID" size="40" maxlength="60" required="required">
    <br><br>
<!-- input name="ta1" type="textarea" placeholder="enter your feedback" id="ta1" cols="100" rows="15"> -->
Driver Rating : 

<div id="rate">
<input class="star star-5" id="star-5-2" type="radio" name="star" value="5"/>
      <label class="star star-5" for="star-5-2"></label>
      <input class="star star-4" id="star-4-2" type="radio" name="star" value="4"/>
      <label class="star star-4" for="star-4-2"></label>
      <input class="star star-3" id="star-3-2" type="radio" name="star" value="3"/>
      <label class="star star-3" for="star-3-2"></label>
      <input class="star star-2" id="star-2-2" type="radio" name="star" value="2"/>
      <label class="star star-2" for="star-2-2"></label>
      <input class="star star-1" id="star-1-2" type="radio" name="star" value="1"/>
      <label class="star star-1" for="star-1-2"></label>
 </div>     
      <br><br><br><br>

<label for="textarea">Feedback<br> <br>
  </label>
  <textarea name="textarea" cols="100" rows="15" id="textarea"></textarea>
  <br><br>
  <div id="btn">
<input id="button" type="submit" value="Submit">
</div>
<br>
</form><br><br>
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