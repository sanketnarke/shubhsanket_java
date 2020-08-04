<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
<body style="background-color: black">
<font color=white>

<h4 style="color: red;">${requestScope.mesg}</h4>
<form name="myform"  method="post">
		<table style="background-color: white; margin: auto;"align="center" >
			<caption> Customer Reset Password</caption>
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" required /></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type="password" name="password" required /></td>
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
</font>
</body>
</html>