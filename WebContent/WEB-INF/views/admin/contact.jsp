<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial;
  padding: 10px;
  background: #f1f1f1;
}

/* Header/Blog Title */
.header {
  padding: 30px;
  text-align: center;
  background: white;
}

.header h1 {
  font-size: 50px;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}



/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
  margin-top: 20px;
}




/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .topnav a {
    float: none;
    width: 100%;
  }
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 15px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
  .column {
    width: 100%;
  }
}
</style>
<style>


.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}

.fa-linkedin {
  background: #007bb5;
  color: white;
  
}

.fa-youtube {
  background: #bb0000;
  color: white;
}

.fa-instagram {
  background: #125688;
  color: white;
}

.fa-skype {
  background: #00aff0;
  color: white;
}

.fa-android {
  background: #a4c639;
  color: white;
}


</style>

</head>
<body>

<div class="header">
  <b><center><font size="12" color="black" face="ink free"><b>SHUBHSANKET</b> </center></font>
  </b>
  <p>SHADE YOUR DREAMS</p>
</div>

<div class="topnav">
<a  href="http://localhost:7070/EventMgmt/index.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
  <a href="http://localhost:7070/EventMgmt/customer/login" style="float:right"><i class="fa fa-sign-in"  ></i>&nbsp Customer Login</a>
  <a href="http://localhost:7070/EventMgmt/provider/login" style="float:right"><i class="fa fa-sign-in"  ></i>&nbsp Provider Login</a>
</div>
<br/><br/>
<div class="row">
  <div class="column">
    <h2>Address</h2>
    <p><address>
    ShubhSanket Event Management<br />
    IACSD CDAC, Akurdi<br/>
    Pune, Maharashtra 411057<br />
    <abbr title="Phone">Phone:</abbr>
    8888888888
</address>
</p></div>
  
  <div class="column">
    <h2>Mail</h2>
    <p>
<address>
    <strong>Support:</strong>   <a href="mailto:shubhsanketevents9194@gmail.com">Support@shubhsanketevents.com</a><br />
    <strong>Marketing:</strong> <a href="mailto:shubhsanketevents9194@gmail.com">Marketing@shubhsanketevents.com</a>
</address></p>
  </div>
  
  
</div>

<br/><br/><br/><br/>
<div class="footer">
<b>Join us on</b><br/><br/>
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
<br/><div align="center">&copy<font color="Black" size="2"><b><u>All Copyrights of this site are reserved</u></b></font></div>

</div>

</body>
</html>
