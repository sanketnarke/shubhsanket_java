<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body style="background-color: white">
<font color=black>
<h4 style="color: red;">${requestScope.mesg}</h4>
<form method="post" modelAttribute="customer" style="max-width:400px;margin:auto">
  <div class="container">
    <h2><center>Register</center></h2>
    <p>Please fill in this form to create an account.</p>
    <hr>
		<table align="center" >
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" id="email" required/></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="pname" id="pname" required/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" id="password" required /></td>
			</tr>
			<tr>
				<td>Enter Address</td>
				<td><input type="text" name="Address" id="Address" required/></td>
			</tr>
			<tr>
				<td>Phone No </td>
				<td><input type="tel" name="contact" id="contact" pattern="[0-9]{10}" placeholder="(eg. 0123456789)" required /></td>
			</tr>
			<tr>
	<td colspan="2">
    By creating an account you agree to our <a href="#">Terms & Privacy</a>.
    </td>
	</tr>
			<tr>
			<td></td>
				<td><input type="submit" value="Register " style="background-color:Green"/></td>
			</tr>
			
		</table>
		</div>
		<div class="container signin">
    <p>Already have an account? <a href="/EventMgmt/provider/login">Sign in</a>.</p>
  </div>
			<div class="backbutton" align="center">
			<button type="button" onclick="window.location='http://localhost:7070/EventMgmt/index.jsp';return false">Back</button>
			</div>
	</form>

</body>
</html>