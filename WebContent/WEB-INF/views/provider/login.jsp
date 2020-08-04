<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background: #ddd;
  color: white;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid black;
}

/* Set a style for the submit button */
.btn {
  background-color: Green;
  color: white;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
</head>
<body>
<h4 style="color: green;">${requestScope.mesg1}</h4>
<h4 style="color: red;">${requestScope.mesg}</h4>
	<form  method="post" style="max-width:500px;margin:auto">
			<h2 style="font-size:36px"><font color="#ddd"><center>Login</center></h2>
			<div class="input-container">
    <i class="fa fa-user icon" style="font-size:36px"></i>
    <input class="input-field" type="text" placeholder="Enter email id" name="em">
  </div>

  <div class="input-container">
    <i class="fa fa-unlock-alt icon" style="font-size:36px"></i>
    <input class="input-field" type="password" placeholder="Enter Password" name="pass">
  </div>


  <button type="submit" class="btn">Login</button>
			<a href="register">Register</a>|<td><a href="forgot">Forgot Password</a></td><br/>
			
		<br/>
		<br/>
			<div class="backbutton" align="center">
			<button  type="button" onclick="window.location='http://localhost:7070/EventMgmt/index.jsp';return false"><i class="fa fa-arrow-left "></i>&nbsp Back</button>
			</div>
	</form>

</body>
</html>