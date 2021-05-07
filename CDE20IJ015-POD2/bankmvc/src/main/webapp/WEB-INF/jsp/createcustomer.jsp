<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/register.css" rel="stylesheet">
<title>Create Customer</title>
<style>
#message {
	color: red;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

/* Firefox */
input[type=number] {
	-moz-appearance: textfield;
}

body {
	font-family: sans-serif;
	background-image:url("images/empdash.jpg");
	background-size:1250px 800px;
	
}
.card
{
	width: 1000px; 
	height: 350px; 
	background: rgba(0, 0, 0, 0.3);  color: #f1f1f1;
	border-radius:40px;
}
td{
	padding-bottom:10px;
	font-size:20px;
	font-weight:bold;
	color:white;
}
input[type=submit]
{
	border-radius:20px;
}

</style>
</head>
<body>
	<div align="center">
		<%
		if (session.getAttribute("token") == null) {
		%>
		<c:redirect url="/403" />
		<%
		}
		%>
		<br>
		<br>
		<h1 style="font-weight: bold; color: white;font-size:2.5em;">Customer Sign Up</h1>
		<div id="login-box">
			<div class="card">
				<br>
				<br>
				<form:form action="/finishedCustomerCreation" method="post"
					modelAttribute="customer">
					<table>
						<tr>
							<td><label for="userid">Enter Customer Id:</label><span
								class="required" style="color: red;"> *</span></td>
							<td style="padding-right:30px;"><form:input type="text"
									class="form-control form-rounded" path="userid" name="Id"
									placeholder="Enter Id" autocomplete="off" required="required" />
							</td>
							<td><label for="username">Enter Username:</label><span
								class="required" style="color: red;"> *</span></td>
							<td><form:input type="text"
									class="form-control form-rounded" path="username"
									name="username" placeholder="Enter Username" autocomplete="off"
									required="required" /></td>
						</tr>
						<tr>
							<td><label for="password">Enter Password:</label><span
								class="required" style="color: red;"> *</span></td>
							<td><form:input type="password"
									class="form-control form-rounded" path="password"
									name="password" placeholder="Enter Password"
									required="required" /></td>
							<td><label for="dateOfBirth">Enter Date Of Birth:</label><span
								class="required" style="color: red;"> *</span></td>
							<td><form:input type="date"
									class="form-control form-rounded" id="date" path="dateOfBirth"
									name="dob" placeholder="Date of Birth" /></td>
						</tr>
						<tr>
							<td><label for="pan">Enter Pan Number: </label><span
								class="required" style="color: red;">*</span></td>
							<td><form:input type="text"
									class="form-control form-rounded" path="pan" name="pan"
									placeholder="Pan Number" autocomplete="off" required="required" />
							</td>
							<td><label for="address">Enter Address</label><span
								class="required" style="color: red;"> *</span></td>
							<td><form:input type="text"
									class="form-control form-rounded" path="address" name="address"
									placeholder="Address" autocomplete="off" required="required" />
							</td>
						</tr>
					</table>
					<input type="submit" class="btn" name="signup_submit" value="Create" />

				</form:form>
				<p id="message">${msg }</p>
			</div>
		</div>

	</div>
</body>
</html>