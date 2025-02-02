<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Car</title>
<style>
body
{
 background-image: url("https://img.freepik.com/free-photo/dark-style-sky-nighttime_23-2151103593.jpg?t=st=1738178485~exp=1738182085~hmac=4a9ee7076f02f696fafcb6607f30adcde732fcf876e7cd4d9de90aacbdb8b435&w=1380");
 text-align: center;
  background-repeat: no-repeat;
  background-size: cover;
}

h1
{
color: white;
}

.center {
  margin-left: auto;
  margin-right: auto;
}

tr,th
{
color: white;
}
a
{
color: red;
}
</style>

</head>
<body>

	<% 
	ResultSet rs = (ResultSet) request.getAttribute("carObject"); 
	if(rs.next())
	{
	%>
	<div align="center">
	<h1>Update the Details for carId</h1>	
	
	<form action="update-car" method="post" >
		<input type="number" value="<%= rs.getInt(1) %>" name="carId" readonly="readonly"><br>
		<input type="text" value="<%= rs.getString(2) %>" name="carBrand"><br>
		<input type="text" value="<%= rs.getString(3) %>" name="carModel"><br>
		<input type="text" value="<%= rs.getString(4) %>" name="carColor"><br>
		<input type="number" value="<%= rs.getInt(5) %>" name="carPrice"><br><br>
		<input type="submit" value="Update" style="color: blue;">
	</form>
	
	</div>
	<%} else { %>
		<h2>Some Error Occurred Fetching the details</h2>
	
	<%} %>
	
</body>
</html>