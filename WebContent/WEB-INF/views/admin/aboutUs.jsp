<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
* {
  box-sizing: border-box;
}

body {
  background-color: #f1f1f1;
  padding: 20px;
  font-family: Arial;
}

/* Center website */
.main {
  max-width: 1000px;
  margin: auto;
}

h1 {
  font-size: 50px;
  word-break: break-all;
}

.row {
  margin: 8px -16px;
}

/* Add padding BETWEEN each column */
.row,
.row > .column {
  padding: 8px;
}

/* Create four equal columns that floats next to each other */
.column {
  float: left;
  width: 25%;
}

/* Clear floats after rows */ 
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Content */
.content {
  background-color: white;
  padding: 10px;
}

/* Responsive layout - makes a two column-layout instead of four columns */
@media screen and (max-width: 900px) {
  .column {
    width: 50%;
  }
}

/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
  }
}

body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}

.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
  margin-top: 30px;
}
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


</style>
</head>
<body>

<!-- MAIN (Center website) -->
<div class="main">

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
<a href="logout"><i class="fa fa-fw fa-home"></i>Logout</a>-->
<a class="active" href="http://localhost:7070/EventMgmt/index.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
  <a href="http://localhost:7070/EventMgmt/customer/login" style="float:right"><i class="fa fa-sign-in"  ></i>&nbsp Customer Login</a>
  <a href="http://localhost:7070/EventMgmt/provider/login" style="float:right"><i class="fa fa-sign-in"  ></i>&nbsp Provider Login</a>

</div>

<hr>

<div class="about-section">
  <h2>About Us</h2>
  <p>Some text about who we are and what we do.</p>
  <p>Resize the browser window to see that this page is responsive by the way.</p>
</div>

<h2 style="text-align:center">Our Team</h2>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMQp1DKmuXF1MMdKVI7NW2f0tq1IJVU9ucQWN5PplHhMY2Jhjy" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Sanket Narke</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.dghagfdhfgdhgfdsds</p>
        <p>Sanket@shubhsanketevents.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTb03rDEkMLsIwbc51dmW5XdxYmIlomuHGa9_9ML21XLtWdDocD" alt="Mike" style="width:100%">
      <div class="container">
        <h2>Shubham Khindre</h2>
        <p class="title">CFO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.sdsadghgsadghdgfhjd</p>
        <p>shubham@shubhsanketevents.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUsEmcIIkDKqNUXedyi_oZ5ai0zxmWbBwFlPL8ZOAGn3UFWLL9" alt="John" style="width:100%">
      <div class="container">
        <h2>Nadan Parindye</h2>
        <p class="title">Designer & Supporters</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>nadanparindye@shubhsanketevents.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
</div>
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

</div>
</body>
</html>
