<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All CAR</title>
<style>
body
{
 background-image: url("https://img.freepik.com/free-photo/dark-style-sky-nighttime_23-2151103593.jpg?t=st=1738178485~exp=1738182085~hmac=4a9ee7076f02f696fafcb6607f30adcde732fcf876e7cd4d9de90aacbdb8b435&w=1380");
 /* url("https://img.freepik.com/free-photo/black-white-view-off-road-vehicle-driven-rough-terrain_23-2151476150.jpg?t=st=1738177645~exp=1738181245~hmac=2f1ee5fec84e1591696091da8cc004dbba3eaa16a29898930ee9c0c192c68389&w=1380"); */
 text-align: center;
  background-repeat: no-repeat;
  background-size: cover;
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
<!-- All Come as a Object -->
	<%ResultSet rs=(ResultSet) request.getAttribute("carList"); %>
	<table border="3" class="center">
	<tr>
	<th>CarId</th>
	<th>CarModel</th>
	<th>CarBrand</th>
	<th>CarColour</th>
	<th>CarPrice</th>
	<th>Update</th>
	<th>Delete</th>
	
	</tr>
	
	<% while(rs.next())
	{ 
	%>
	<tr>
	
	<td><%=rs.getInt(1)%></td>
	<td><%=rs.getString(2)%></td>
	<td><%=rs.getString(3)%></td>
	<td><%=rs.getString(4)%></td>
	<td><%=rs.getInt(5)%></td>
	<th><a href="find-car-by-id?carId=<%=rs.getInt(1)%>">Update</a></th>
	<th><a href="dlt-car-by-id?carId=<%=rs.getInt(1)%>">Delete</a></th>
	</tr>
	
	<% } %>
	</table>
	
	<h2><a href="index.jsp">Go Back To DashBoard</a></h2>
	
	
	
</body>
</html>