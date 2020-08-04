<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<a class="active" href="http://localhost:7070/EventMgmt/index.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
<a href="searchservice"><i class="fa fa-search"></i>Search Services</a>
<a href="<spring:url value='/customer/history?cid=${customer_dtls.cid }'/>"><i class="fa fa-book"></i>History</a>
<a href="logout"><i class="fa fa-sign-out"></i>Logout</a>
</div>
<font color="black">
<form method="post">

<div align="center"><h2>Services</h2></div>
<br/>
<h4 style="color: red;">${requestScope.mesg}</h4>
<hr/>
		<table >
			<tr>
				<td>Enter Location</td>
				<td>
				<select name="location" size="1">
				<c:forEach var="v" items="${sessionScope.placeselectionlist}">
				<option value="${v}">${v }</option>
				</c:forEach>
				</select>
				</td>
				
			</tr>
			<tr>
				<td>Enter Service Type</td>
				<td>
				<c:forEach var="s" items="${sessionScope.serviceselectionlist}">
				<input type=radio name="serviceType" value="${s}" required/>${s}
					</c:forEach></tr>
			<!-- <tr>
				<td><input type="submit" value="Search " /></td>
				<td><input type="reset" value="Reset Page" /></td>
			</tr> -->
		</table>
		<br/><br/>
				<center><button  type="submit" style="background-color:green">Search </button>
				<button type="reset" style="background-color:dodgerblue" >Reset Page</button></center>
</form>
<br/>
		<br/>
			<div class="backbutton" align="center">
			<a href="welcome">Back</a>
			</div>
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