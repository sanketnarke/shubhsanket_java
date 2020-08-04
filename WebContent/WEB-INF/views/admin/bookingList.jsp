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
  background-color: #ddd ;
  font-color: white;

}
</style>
<title>Insert title here</title>
</head>
<body style="background-color: white">
<div class="container-fluid" >
  <b><center><font size="6" color="black" face="ink free"> Event Management </center></font>
  </b>
</div>
<div class="navbar">

	<a href="http://localhost:7070/EventMgmt/index.jsp"><i class="fa fa-home" style="font-size:20px">Home</i></a>
	
<a href="providerList"><i class="fa fa-book"></i>Provider List</a>
<a href="providerServices"><i class="fa fa-book"></i>Provider Services</a>
<a href="customerList"><i class="fa fa-book"></i>Customer List</a>
<a href="bookingList"><i class="fa fa-book"></i>Booking List</a>
<a href="logout"><i class="fa fa-sign-out"></i>Logout</a>
</div>
<font color="black">

<hr/>
<table style="background-color: white; margin: auto;"align="center" border="1">
		<caption> History</caption>
		<tr>
				<td>bid</td>
				<td>sid</td>
				<td>pid</td>
				<td>cid</td>
				<td>Provider Name</td>
				<td>Customer Name</td>
				<td>Total cost</td>
				<td>Status</td>
				<td>Date</td>
				<td>Service</td>
				<td>Delete</td>
			</tr>
		
		<c:forEach var="v" items="${requestScope.bookingList}">
				<tr>
				<td>${v.bid}</td>
				<td>${v.sid}</td>
				<td>${v.pid}</td>
				<td>${v.cid}</td>
				<td>${v.pname}</td>
				<td>${v.cname}</td>
				<td>${v.total_cost}</td>
				<td>${v.status}</td>
				<td>${v.date}</td>
				<td>${v.service}</td>
				<td><a style="text-decoration:none" href="<spring:url value='/admin/bookingdelete?bid=${v.bid}'/>">Delete</a></td>
				
				
			</tr>
		</c:forEach>
	</table>
<a href="welcome">Back</a><br/>
</font>
</body>
</html>