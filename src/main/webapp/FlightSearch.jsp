<%@page import="com.nagarro.FlightSearchManagement.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#form{
background-color: rgb(16, 216, 252);
    padding: 100px;
    text-align: left;
    margin: auto;
    display: table;
}
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
  float:right;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input[type=submit]:hover {
  background-color: #45a049;
}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: 18px;
}
input[type=date], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: 18px;
}
body{
background-image: url("/image/flights-background2.jpg");
}
label{
font-size: 18px;
}
</style>
</head>
<body>

<div>
<h1 style="text-align: center; color: green;">Search Flights</h1>
	<form action="/SignUp.html" class="form1">
	<input style="width: 10%;margin-left: 90%;" type="submit" name="submit" value="Logout" id="button1">
	</form>
</div>
<div>
	<form action="searchFlight" class="form2">
		
				<label>Enter Departure Location :</label>
				<input type="text" name="departureLocation"><br>
			<label>Enter Arrival Location :</label>
				<input type="text" name="arrivalLocation"><br>
			<label>Enter Flight Date :</label>
				<input type="date" name="flightDate"><br><br>
			<label>Select Flight Class :</label>
				<input type="radio" name="flightClass" value="E" checked><label>Economic</label>
					 <input type="radio" name="flightClass" value="EB" checked><label>Economic and Business</label><br><br>
					
				<input type="radio" name="outputPreference" value="fare"><label>Fare</label>
					<input type="radio" name="outputPreference"
					value="fare_and_flight_duration"><label>Fare and Flight duration</label><br><br>
			
				<input type="submit" name="submit" value="search" id="button2">
				
		
	</form>
	</div>
</body>
</html>