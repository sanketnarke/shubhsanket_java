<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
.dropdwn {
float:left;
overflow: hidden;
}

.nav-link{
padding: 8px 15px;
border:none;
outline:none;
margin:0;
background-color:black;
color:white;
}

.navbar-nav button:hover,.nav-item:hover,.dropdwn:hover .dropbtn{
background-color:#555;
}

.dwn-content{
display:none;
position:absolute;
background-color:#f9f9f9;
min-width:150px;
box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
z-index:1;
}

.dwn-content a{
float:none;
color:white;
background-color:black;
padding: 12px 16px;
text-decoration:none;
display:block;
text-align:left;}

.dwn-content a:hover{
background-color:#ddd;
}
.dropdwn:hover .dwn-content{
	display:block;
} 
/* Footer */
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
</div>


<script type="text/javascript">
function home()
{
	location.replace("http://localhost:7070/EventMgmt/index.jsp")
}

</script>

<div style="background-color: black ">

<nav class="navbar navbar-expand-sm bg-blue" >
  <ul class="navbar-nav">
	<div><li class="nav-item">
	<button class="nav-link" style="background-color:green" onclick="home()"><i class="fa fa-home" style="font-size:20px">Home</i></button>
	</li></div>
	<div class="dropdwn" >
	<li class="nav-item">
      <button class="nav-link" id="dropbtn1" ><i class="fa fa-bars" style="font-size:20px"></i><font color="white">
      Menu</font></button>
    </li>
    <div class="dwn-content">
      <a href="admin/services"><font color="white">
      Services</font></a>
    </div></div>
    <div class="dropdwn" >
	<li class="nav-item">
      <button class="nav-link" id="dropbtn2" ><i class="fa fa-sign-in" style="font-size:20px"></i><font color="white">
      Login</font></button>
    </li>
    <div class="dwn-content" style="background-color:white" >
      <a class="nav-link" href="admin/login"><font color="white">Admin</font></a>
      <a class="nav-link" href="customer/login"><font color="white">Customer</font></a>
      <a class="nav-link" href="provider/login"><font color="white">Provider</font></a>
    </div></div>
    
	<div class="dropdwn" >
	<li class="nav-item">
      <button class="nav-link" id="dropbtn2" ><i class="fa fa-sign-in" style="font-size:20px"></i><font color="white">
      Register</font></button>
    </li>
    <div class="dwn-content">
      <a class="nav-link" href="customer/register"><font color="white">Customer</font></a>
      <a class="nav-link" href="provider/register"><font color="white">Provider</font></a>
    </div></div>
	<li class="nav-item">
      <button class="nav-link"><a style="color:black;text-decoration:none" href="admin/contact"><font color="white">
     <i class="fa fa-mobile-phone" style="font-size:20px"> Contact</i></font></a></button>
    </li>
    <!-- <li class="nav-item">
      <a class="nav-link" href="admin/login"><font color="black">
      Admin Login</font></a>
    </li>
    
	<li class="nav-item">
      <a class="nav-link" href="customer/register"><font color="black">
      Customer Register</font></a>
    </li>
	<li class="nav-item">
      <a class="nav-link" href="provider/register"><font color="black">
      Provider Register</font></a>
    </li> -->
	<li class="nav-item">
     <button class="nav-link"><a style="color:black;text-decoration:none" href="admin/aboutUs"><font color="white">
      <i class="fa fa-info-circle" style="font-size:20px">About Us</i></font></a></button>
    </li>
    <div class="dropdwn" >
    <li class="nav-item">
      <button class="nav-link" id="dropbtn3" ><i class="fa fa-group" style="font-size:20px"></i><font color="white">
      Join us</font></button>
    </li>
    <div class="dwn-content">
      <a class="nav-link" href="https://www.facebook.com/"><font color="white"><i class="fa fa-facebook" style="font-size:20px">Facebook</i></font></a>
      <a class="nav-link" href="https://www.twitter.com/"><font color="white"><i class="fa fa-twitter" style="font-size:20px">Twitter</i></font></a>
      <a class="nav-link" href="https://www.instagram.com/"><font color="white"><i class="fa fa-instagram" style="font-size:20px">Instagram</i></font></a>
    </div></div>
    <li class="nav-item">
     <button class="nav-link"><font color="white">
      <i class="fa fa-android" style="font-size:20px">Download app</i></font></a></button>
    </li>
  </ul>
  
</nav>
</div>

<br>
<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner" align="center">
    <div class="carousel-item active">
      <img src="https://images.unsplash.com/photo-1469371670807-013ccf25f16a?ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80" alt="Los Angeles" width="1300" height="500">
    </div>
    <div class="carousel-item">
      <img src="https://wallpapershome.com/images/pages/pic_h/17816.jpg" alt="Maldives" width="1300" height="500">
    </div>
    <div class="carousel-item">
      <img src="https://www.elsetge.cat/myimg/f/10-102268_dj-desktop-wallpaper-dj-wallpapers-download-free-on.jpg" alt="Hardwell" width="1300" height="500">
    </div>
    <div class="carousel-item">
      <img src="https://images.unsplash.com/photo-1519167758481-83f550bb49b3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1374&q=80" alt="New York" width="1300" height="500">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
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

</div></body>
</html>
