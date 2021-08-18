<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input[type=submit ] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=button ] {
  
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: auto;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  display: block;
}
input[type=text],
{
	font-size: 18px;
}
intput[type=password]{
font-size: 18px;
}
body{
background-image: url("/image/flights-background2.jpg");
}
</style>
</head>
<body>
	<div id="form-wrapper" style="max-width:500px;margin:auto;background-color: skyblue; width: 75%">
	<form action="LoginValidator" >
		<table>
			<tr>
				<td><h1 style="color: green;">Login Page</h1></td>
			</tr>
			<tr>
				
				<td>UserID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				
				<td>UserName :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			</table>
			<input type="submit" name="submit" value="Login">
	</form>
	</div>
	<div  >
	<form action="SignUp.html" class="fomr2"  >
		<input style="width: 10%;margin-left: 45%;"  type="submit" name="submit" value="SignUp">
	</form>
	</div>
</body>
</html>