<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style >
body
{
 background-image: url("https://img.freepik.com/free-photo/dark-style-sky-nighttime_23-2151103593.jpg?t=st=1738178485~exp=1738182085~hmac=4a9ee7076f02f696fafcb6607f30adcde732fcf876e7cd4d9de90aacbdb8b435&w=1380");
 /* url("https://img.freepik.com/free-photo/black-white-view-off-road-vehicle-driven-rough-terrain_23-2151476150.jpg?t=st=1738177645~exp=1738181245~hmac=2f1ee5fec84e1591696091da8cc004dbba3eaa16a29898930ee9c0c192c68389&w=1380"); */
 text-align: center;
  background-repeat: no-repeat;
  background-size: cover;

}
.form-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; /* vh stands for viewport height */
}

form {
  width: 50%; 
}


</style>
</head>
<body>
	
	<div class="form-container">
	
	<form action="add-car " method="post">
		<input type="number" placeholder="Enter Id" name="carID"><br>
		<input type="text" placeholder="Enter Model" name="carModel"><br>
		<input type="text" placeholder="Enter Brand" name="carBrand"><br>
		<input type="text" placeholder="Enter Colour" name="carColour"><br>
		<input type="number" placeholder="Enter Price" name="carPrice"><br>
		<input type="submit" value="Adding"> 
	</form>
	
	</div>

</body>
</html>