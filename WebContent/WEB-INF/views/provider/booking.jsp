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


.dwn-content{
display:none;
position:absolute;
background-color:#f9f9f9;
min-width:150px;
box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
z-index:1;
}


.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
  margin-top: 30px;
}

</style>
<title>Insert title here</title>
</head>
<body style="background-color: white">

<div class="container-fluid" style="background-color:white" >
  <b><center><font size="10" color="black" face="ink free"><b>SHUBHSANKET</b> </font></center>
  </b>
  <h5><center><font  color="black" face="ink free">Shade your dreams</font></center></h5>
</div>
<div class="navbar">
<!-- <a class="active" href="welcome"><i class="fa fa-fw fa-home"></i>Provider Home</a>
<a href="addservice"><i class="fa fa-fw fa-home"></i>Add Services</a>
<a href="<spring:url value='/provider/booking?pid=${provider_dtls.pid}'/>"><i class="fa fa-fw fa-home"></i>Bookings</a>
<a href="<spring:url value='/provider/providerservices?pid=${provider_dtls.pid}'/>"><i class="fa fa-fw fa-home"></i>Services</a>
<a href="logout"><i class="fa fa-fw fa-home"></i>Logout</a> -->

<a class="active" href="http://localhost:7070/EventMgmt/index.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
<a href="addservice"><i class="fa fa-plus-square"></i>Add Services</a>
<a href="<spring:url value='/provider/booking?pid=${provider_dtls.pid}'/>"><i class="fa fa-book"></i>Bookings</a>
<a href="<spring:url value='/provider/providerservices?pid=${provider_dtls.pid}'/>"><i class="fa fa-book"></i>Services</a>
<a href="logout"><i class="fa fa-sign-out"></i>Logout</a>

</div>

<hr/>
<center><h2>Booking History</h2></center>
<h4 style="color: red;">${requestScope.mesg}</h4><hr/>

<font color="black">
<table >

		<!--<caption> History</caption>-->
		<tr style="background-color:dodgerblue">
				<td class="dwn-content">bid</td>
				<td class="dwn-content">sid</td>
				<td class="dwn-content">pid</td>
				<td class="dwn-content">cid</td>
				<td>Provider Name</td>
				<td>Customer Name</td>
				<td>Total cost</td>
				<td>Status</td>
				<td>Date</td>
				<td>Service</td>
				<td>Positive Response</td>
				<td>Negative Response</td>
			</tr>
			
		<c:forEach var="v" items="${sessionScope.probooking}">
			<tr>
				<td class="dwn-content">${v.bid}</td>
				<td class="dwn-content">${v.sid}</td>
				<td class="dwn-content">${v.pid}</td>
				<td class="dwn-content">${v.cid}</td>
				<td>${v.pname}</td>
				<td>${v.cname}</td>
				<td>${v.total_cost}</td>
				<td>${v.status}</td>
				<td>${v.date}</td>
				<td>${v.service}</td>
				<td><a href="<spring:url value='/provider/acceptbooking?pid=${v.pid}&cid=${v.cid}&sid=${v.sid}&bid=${v.bid}'/>">Accept</a></td>
				<td><a href="<spring:url value='/provider/rejectbooking?pid=${v.pid}&cid=${v.cid}&sid=${v.sid}&bid=${v.bid}'/>">Reject</a></td>
			</tr>
		</c:forEach>
	</table>
<br/>
		<br/>
			<div class="backbutton" align="center">
			<a href="welcome">Back</a>
			</div>
			</font>
			<br/><br/>
			
<div class="footer">
<b>Join us on</b><br/>
 <div class="social">
 <a href="#" class="fa fa-facebook" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-twitter" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-google" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-linkedin" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-youtube" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-instagram" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-skype" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
<a href="#" class="fa fa-android" style="text-decoration: none; font-size: 30px;padding: 15px;border-radius: 50%;"></a>
</div>
<div align="center">&copy<font color="Black" size="2"><b><u>All Copyrights of this site are reserved</u></b></font></div>
			
</body>
</html>