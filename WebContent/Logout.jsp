<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logging out..</title>
</head>
<body>
<%

request.getSession().invalidate();
%>
<script type="text/javascript">
{
alert("You have been successfully logged out");
location.href="first.jsp" ;
}

</script>
response.sendRedirect(request.getContextPath() + "first.jsp");

</body>
</html>