<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.navbar a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background-color: #000;
}

.active {
  background-color: #4CAF50;
}

@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
  }
}
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #ddd ;
  font-color: white;

}

.dwn-content{
display:none;
position:absolute;
background-color:#f9f9f9;
min-width:150px;
box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
z-index:1;


}


</style>
<title>Insert title here</title>
</head>
<body style="background-color: white">
<font color=black>
<center><h2>Booking Form</h2>
<hr/>
<table>
<tr>
<td><h3  align="left">Customer Name:${customer_dtls.cname}</h3></td>
<td ><h3 align="right">Provider Name:${sessionScope.temp_pname}</h3></td>
<hr/>
</tr></table>
<form method="post" modelAttribute="booking">

		<table >
			<tr class="dwn-content">
				<td>Customer ID</td>
				<td><input type="text" name="cid" value="${customer_dtls.cid}" readonly/></td>
			</tr>
			<tr class="dwn-content">
				<td>Provider ID</td>
				<td><input type="text" name="pid" value="${sessionScope.temp_pid}" readonly/></td>
			</tr>
			
			<tr class="dwn-content">
				<td>Service ID</td>
				<td><input type="text" name="sid" value="${sessionScope.temp_sid}" readonly/></td>
			</tr>
			
			<tr>
				<td>Provider Name</td>
				<td><input type="text" name="pid" value="${sessionScope.temp_pname}" readonly/></td>
			</tr>
			
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="cname" value="${customer_dtls.cname}" readonly/></td>
			</tr>
			<tr>
				<td>Service</td>
				<td><input type="text" name="service" value="${sessionScope.temp_service}" readonly/></td>
			</tr>
			
			<tr>
				<td>Total Cost</td>
				<td><input type="text" name="total_cost" id="total_cost" name="total_cost" value="${sessionScope.temp_rate}" readonly/></td>
			</tr>
			<tr class="dwn-content">
				<td>Status</td>
				<td><input type="text" name="status" id="status" name="status" value="in-progress" readonly/></td>
			</tr>
			<tr>
				<td>Booking Date</td>
				<td><input type="date" name="date" id="date" name="date" required/></td>
			</tr>
			
			<tr>
			<td></td>
				<td><input type="submit" value="Confirm Booking " /></td>


			</tr>
		</table>
	</form>
	<br/>
		<br/>
			<div class="backbutton" align="center">
			<a href="/EventMgmt/customer/searchservice">Back</a>
			</div>
</body>
</html>