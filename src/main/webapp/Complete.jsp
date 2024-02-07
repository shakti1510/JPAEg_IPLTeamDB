<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
	<div id="Mid">
		<h1><%=request.getParameter("msg") %></h1>
		<br>
		<a href ="index.jsp">Return to Home Page</a>
	</div>
</body>
</html>