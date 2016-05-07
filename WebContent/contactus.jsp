<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='design1.css'>
<meta charset="ISO-8859-1">
<title>Contact us | KIIT Shuttle</title>
</head>
<style>
h3
{
border:double;
padding : 10px;
}
#contactform
{
border:double;
padding : 30px;
}
</style>
<body>
<!-- <script>
	{
		var svar = '<%=session.getAttribute("name")%>';
		if(svar.localeCompare("null")==0)
			{
		alert('Please log in to access the dashboard.');
		location.href='first.jsp';
			}
	}
	</script> -->
<div id="div1"></div>
<header>
<p class="stuts">Welcome <span><%=session.getAttribute("name") %></span></p>

            <h5> <a href="Logout.jsp">Logout</a></h5>

<a id="feedback" href="feedback.jsp"><img id="feed" src="images/feedback.png"/></a>
<a id="heading" href="index.jsp" onmouseout="myFunction2('heading')"> <h1 onmouseout="myFunction2('heading')">KIIT Shuttle Service</h1> </a>
<h3 id="contacts"> Contact us : </h3>
<h4> For any queries or complaints : </h4> <br>
<form id="form1" method="get" action="contactaction">
 <p>Name :
  <input name="tb1" type="text" autofocus id="tb1" autocomplete="on" placeholder="Enter Name" size="40" maxlength="60" required="required"><br><br>
    Mobile Number : 
    <input name="tb2" type="text" id="tb2" autocomplete="on" placeholder="Enter Mobile Number" size="40" required="required"><br><br>
   
  </p>
  <p>E-mail ID : 
    <input name="email" type="email" id="email" autocomplete="on" placeholder="Enter e-mail ID" size="40" required="required">
    <br>
&nbsp;</p><hr id="hr1">
<br>
<!-- input name="ta1" type="textarea" placeholder="enter your feedback" id="ta1" cols="100" rows="15"> -->
<label for="textarea">Query<br> <br>
  </label>
  <textarea name="textarea" id="textarea" cols="100" rows="15" id="textarea"></textarea>
  <br><br>
  <div id="btn">
<input id="button" type="submit" value="Submit query"> </div>

</form>
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