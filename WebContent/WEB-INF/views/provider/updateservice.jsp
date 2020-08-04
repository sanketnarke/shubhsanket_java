<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
  background-color: #555 ;
  font-color: white;

}
</style>
<title>Insert title here</title>
</head>
<body style="background-color: black">

<div class="navbar">
<a class="active" href="welcome"><i class="fa fa-fw fa-home"></i>Provider Home</a><br/>
<a href="addservice"><i class="fa fa-fw fa-home"></i>Add Services</a><br/>
<a href="<spring:url value='/provider/booking?pid=${provider_dtls.pid}'/>"><i class="fa fa-fw fa-home"></i>Bookings</a><br/><br/>
<a href="<spring:url value='/provider/providerservices?pid=${provider_dtls.pid}'/>"><i class="fa fa-fw fa-home"></i>Services</a><br/><br/>
<a href="logout"><i class="fa fa-fw fa-home"></i>Logout</a><br/>

</div>
<font color="white">

<h4 style="color: red;">${requestScope.mesg}</h4><hr/>
Update service
<hr/>
<form method="post" modelAttribute="services">
<table style="background-color: white; margin: auto;"align="center" border="1">

		<caption> Services</caption>
		
		<tr>	
			<td>Service Id</td>
			<td><input type="text" name="sid" id="sid" value="${ProviderServices.sid}" readonly/></td>
		</tr>
		<tr>	
			<td>Provider Id</td>
			<td><input type="text" name="pid" id="pid" value="${ProviderServices.pid}" readonly/></td>
		</tr>	
		<tr>	
			<td>Provider Name</td>
			<td><input type="text" name="pname" id="pname" value="${ProviderServices.pname}" readonly/></td>
		</tr>	
		<tr>
				<td>Rate</td>
				<td><input type="text" name="rate" value="${ProviderServices.rate}" required/></td>
				
		</tr>
				<tr>
				<td>Service Type</td>
				<td><input type="radio" name="serviceType" value="Hall" required/>Hall
					<input type="radio" name="serviceType" value="Lawns" required/>Lawns
					<input type="radio" name="serviceType" value="DJ" required/>DJ
					<input type="radio" name="serviceType" value="Decoration" required/>Decoration</td>
				<td>Old Selection of service: "${ProviderServices.serviceType}"</td>
			</tr>
		<tr>
				<td>Location</td>
				<td><input type="text" name="location" value="${ProviderServices.location}" required/></td>
		</tr>
		<tr>
				<td><input type="submit" value="Update " /></td>
		</tr>
	</table>	
	</form>	
</body>
</html>