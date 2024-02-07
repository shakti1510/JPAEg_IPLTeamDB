<%@page import="com.jsp.servlet.IPLDB.IPLTeam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% List<IPLTeam> solution = (List<IPLTeam>)request.getAttribute("solution"); %>

	<table border="">
	<tr>
	<th>Player Id</th>
	<th>Player Name</th>
	<th>Player Age</th>
	<th>Player Country</th>
	<th>IPL Team</th>
	<th>Salary</th>
	<th>Update</th>
	<th>Delete</th>
	</tr>
	
<% for (int i = 0; i < solution.size(); i++) { %>
        <tr>
            <td><%= solution.get(i).getPlayerId() %></td>
            <td><%= solution.get(i).getPlayerName() %></td>
            <td><%= solution.get(i).getPlayerAge() %></td>
            <td><%= solution.get(i).getPlayerCountry() %></td>
            <td><%= solution.get(i).getIplTeam() %></td>
            <td><%= solution.get(i).getSalary() %></td>
            <!-- Add other columns as needed -->
            <td><a href="updatePlayer?playerId=<%=solution.get(i).getPlayerId()%>" >Update</a></td>
			<td><a href="deletePlayer?playerId=<%=solution.get(i).getPlayerId()%>">Delete</a></td>
        </tr>
    <% } %>
	</table>
	<a href="index.jsp">Return to Home Page</a>
</body>
</html>