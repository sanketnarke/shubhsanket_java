<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
<h4 style="color: red;">${requestScope.mesg}</h4>
<form name="myform"  method="post" style="max-width:500px;margin:auto">
		<table style="background-color: white; margin: auto;"align="center" >
			<caption> Customer Reset Password</caption>
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" required /></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type="password" name="password" required/></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cpass" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
			
		</table>
		<br/>
		<br/>
			<div class="backbutton" align="center">
			<a href="login">Back</a>
			</div>
	</form>

</body>
</html>