<%@page import="com.jsp.servlet.IPLDB.IPLTeam"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateTeamTable" method="post">
		<table>
		<% IPLTeam res=(IPLTeam)request.getAttribute("teamData"); %>
			<tr>
				<td>ID:</td>
				<td><input type="number" name="playerId" value="<%=res.getPlayerId()%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="playerName" value="<%=res.getPlayerName()%>" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="number" name="playerAge" value="<%=res.getPlayerAge()%>" /></td>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="playerCountry" value="<%=res.getPlayerCountry()%>" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="iplTeam" value="<%=res.getIplTeam()%>" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="number" name="salary" value="<%=res.getSalary()%>" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Update Data" required="required" />

	</form>
	<br />
	<a href="index.jsp">Return to Home Page</a>
</body>
</html>