<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
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
</head>
<body style="background-color: white">

<div class="container-fluid" style="background-color:white" >
  <b><center><font size="10" color="black" face="ink free"><b>SHUBHSANKET</b> </font></center>
  </b>
  <h5><center><font  color="black" face="ink free">Shade your dreams</font></center></h5>
</div><hr/>
<div class="navbar">
<a  class="active" href="http://localhost:7070/EventMgmt/index.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
<a href="/EventMgmt/customer/searchservice"><i class="fa fa-search"></i>Search Services</a>
<a href="<spring:url value='/customer/history?cid=${customer_dtls.cid }'/>"><i class="fa fa-book"></i>History</a>
<a href="/EventMgmt/customer/logout"><i class="fa fa-sign-out"></i>Logout</a>
</div>

<form >
<h2>Services</h2>
		<table >
			<!-- <tr>
				<td>Provider Id is</td>
				<td><input type="text" name="pid" id="pid" value="${showdtls.pid}" readonly/></td>
			</tr>
			<tr>
				<td>Service Id is</td>
				<td><input type="text" name="sid" id="sid" value="${showdtls.pid}" readonly/></td>
			</tr>
			<tr>
				<td>Provider Name</td>
				<td><input type="text" name="pname" id="pname" value="${showdtls.pname}" readonly/></td>
			</tr>
			<tr>
				<td>Service Name</td>
				<td><input type="text" name="sname" id="sname" value="${showdtls.sname}" readonly/></td>
			</tr> -->
			<tr>
				<td>City</td>
				<td><input type="text" name="location" value="${showdtls.city}" readonly/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="${showdtls.address}" readonly/></td>
			</tr>
			<tr>
				<td>Rate</td>
				<td><input type="text" name="rate" value="${showdtls.rate}" readonly/></td>
			</tr>
	</table>
	
	<!-- <address>
	<h3><b>Provider Name:</b></h3>&nbsp${showdtls.pname}<br/>
	<h3><b>Service Name:</b></h3>&nbsp${showdtls.sname}<br/>
	</address>
	
	<div>
	<img src="${showdtls.imageurl2}" alt="Trulli" width="1200" height="400">
	</div>
	<div>
	<img src="${showdtls.imageurl3}" alt="Trulli" width="1200" height="400">
	</div>
	 -->
	<div>
	<img src="${showdtls.imageurl1}" alt="Trulli" width="1200" height="400">
	</div>
	
	<br/>
	
				<h2>Details</h2>
				<hr/>${showdtls.readdtls}<hr/>
				
			
			

		
</form>
<br/>
		<br/>
			<div class="backbutton" align="center">
			<a href="welcome">Back</a>
			</div><br/><br/>
						
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
</div></div>
<div align="center">&copy<font color="Black" size="2"><b><u>All Copyrights of this site are reserved</u></b></font></div>
			
</body>
</html>