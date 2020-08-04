<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
</style>
<title>Insert title here</title>
</head>
<body style="background-color: white">
<div class="container-fluid" >
  <b><center><font size="6" color="black" face="ink free"> Event Management </font></center></font>
  </b>
</div>

<div class="navbar">
<a  href="providerList"><i class="fa fa-fw fa-home"></i>Provider List</a>
<a href="providerServices"><i class="fa fa-fw fa-home"></i>Provider Services</a>
<a href="customerList"><i class="fa fa-fw fa-home"></i>Customer List</a>
<a href="bookingList"><i class="fa fa-fw fa-home"></i>Booking List</a>
<a href="logout"><i class="fa fa-fw fa-home"></i>Logout</a>
</div>
<h2><center>Welcome Admin</center><br/></h2>
</body>
</html>