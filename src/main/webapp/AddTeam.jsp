<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition of Team</title>
</head>
<body>
<h2>Fill in the details</h2>

	<form action="AddTeam" method="post">
		<table>
			<tr>
				<td>PlayerID:</td>
				<td><input type="number" name="playerId" required="required" /></td>
			</tr>
			<tr>
				<td>PlayerName:</td>
				<td><input type="text" name="playerName" required="required" /></td>
			</tr>
			<tr>
				<td>PlayerAge:</td>
				<td><input type="number" name="playerAge" required="required" /></td>
			</tr>
			<tr>
				<td>PlayerCountry:</td>
				<td><input type="text" name="playerCountry" required="required" /></td>
			</tr>
			<tr>
				<td>PlayerIPLTeam:</td>
				<td><input type="text" name="iplTeam" required="required" /></td>
			</tr>
			<tr>
				<td>PlayerSalary:</td>
				<td><input type="number" name="salary" required="required" /></td>
			</tr>
			
		</table>
		<br /> <input type="submit" value="Insert Data" required="required" />

	</form>
	<br />
	<a href ="index.jsp">Return to Home Page</a>
</body>
</html>