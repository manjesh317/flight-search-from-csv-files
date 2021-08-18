<%@page import="com.nagarro.FlightSearchManagement.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" 
       uri="http://java.sun.com/jsp/jstl/functions" %>
        <%
    User s=(User)request.getAttribute("sessionData");
        
    if(s!=null)
    {
    	response.sendRedirect("Login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align: center;
}
#form{
background-color: rgb(16, 216, 252);
    padding: 100px;
    text-align: left;
    margin: auto;
    display: table;
}

body{
background-image: url("/image/flights-background2.jpg");
}
th{
background-color: green;
}
input[type=submit ] {
  float:right;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

</style>
</head>


<body>

<div>

	<form action="/SignUp.html">
	<input type="submit" name="submit" value="Logout">
	</form>
</div>
<c:choose>
	<c:when test="${mode=='All_Flights' }">
	<div class='container text-center' id='tasksDiv' style="background-color: skyblue;">
	<h2 align="center">Available Flights</h2>
	<div class='table-responsive' >
		<table style="width: 100%; font-size: 18px;">
			<thead>
			<tr>
				<!-- getFlightNo() -->
				<th>FlightNo</th>
				<th>departureLocation</th>
				<th>arrivalLocation</th>
				<th>flightDate</th>
				<th>flightTime</th>
				<th>flightDuration</th>
				<th>fare</th>
				<th>seatAvailability</th>
				<th>flightClass</th>
				</tr>
				</thead>
			<tbody>
				<c:forEach var="flights" items="${flights}">
					<tr>
						<td>${flights.flightNo}</td>
						<td>${flights.departureLocation}</td>
						<td>${flights.arrivalLocation}</td>
						<td>${flights.flightDate}</td>
						<td>${flights.flightTime}</td>
						<td>${flights.flightDuration}</td>
						<td>${flights.fare}</td>
						<td>${flights.seatAvailability}</td>
						<td>${flights.flightClass}</td>
						</tr>
										
				</c:forEach>
			</tbody>
			
			
		</table>
	
	</div>
		
	</div>
	</c:when>
	</c:choose>
</body>
</html>