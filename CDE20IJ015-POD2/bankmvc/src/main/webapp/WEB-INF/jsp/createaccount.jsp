<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="register.css" rel="stylesheet">
<title>Create Account</title>
<style>
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
/* Firefox */
input[type=number] {
	-moz-appearance: textfield;
}

input[type="text"], input[type="number"], select[type="text"] {
	display: inline-block;
	box-sizing: border-box;
	margin-bottom: 20px;
	padding: 4px;
	width: 220px;
	height: 32px;
	border: none;
	border-bottom: 1px solid #AAA;
	font-family: 'Roboto', sans-serif;
	font-weight: 400;
	font-size: 15px;
	transition: 0.2s ease;
}

input[type="text"]:focus, input[type="number"]:focus {
	border-bottom: 2px solid #16a085;
	color: #16a085;
	transition: 0.2s ease;
}

input[type="submit"] {
	margin-top: 28px;
	width: 120px;
	height: 32px;
	background: #16a085;
	border: none;
	border-radius: 15px;
	color: #FFF;
	font-family: 'Roboto', sans-serif;
	font-weight: 500;
	text-transform: uppercase;
	transition: 0.1s ease;
	cursor: pointer;
}

input[type="submit"]:hover, input[type="submit"]:focus {
	opacity: 0.8;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

input[type="submit"]:active {
	opacity: 1;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

body {
	margin: 0;
	font-family: sans-serif;
	color: white;
	background-image:url("images/empdash.jpg");
	background-size: 1250px 800px;
}

a {
	color: cyan;
}
td
{
	padding:5px;
	font-weight:bold;
	font-size:20px;
}
.card
{
	width: 1000px; 
	height: 400px;  
	background: rgba(0, 0, 0, 0.4);
	color: #f1f1f1;
	border-radius:40px;
}
</style>
</head>
<body>

	<%
	response.setHeader("cache-control", "no-cache , no-store , must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	if (session.getAttribute("userId") == null || session.getAttribute("token") == null) {
	%>
	<c:redirect url="/403" />
	<%
	}
	%>
	<div align="center">
		<div align="center">
		<br><br>
			<h1 class="signup" style="color:white;">Customer Account Creation</h1>
		</div>
		<div id="login-box">
			<div class="card">
				<br>
				<div align="center">
					<br>
				</div>
				<form:form action="/finishedAccountCreation" method="post"
					modelAttribute="account">
					<table>
						<tr>
							<td><label for="customerId">Enter Customer Id:</label><span
								class="required" style="color: red;"> *</span></td>
							<td><form:input type="text"
									class="form-control form-rounded" path="customerId"
									name="customerId" value="${customerId}" readonly="true" /></td>
							<td><label style="text-align: left;">Enter Account
									No:</label><span class="required" style="color: red;"> *</span></td>
							<td><input type="number" class="form-control form-rounded"
								path="accountId" name="accountId" placeholder="AccountId"
								autocomplete="off" required="required" /><br></td>
						</tr>
						<tr>
							<td><label style="text-align: left;">Enter Amount:</label><span
								class="required" style="color: red;"> *</span></td>
							<td><input type="number" class="form-control form-rounded"
								path="currentBalance" name="currentBalance" placeholder="Amount"
								autocomplete="off" required="required" /></td>

							<td><label style="text-align: left;">Select Account
									Type:</label><span class="required" style="color: red;"> *</span></td>
							<td><form:select type="text" class="form-select"
									path="accountType" placeholder="Account Type"
									name="accountType" autocomplete="off" required="required">
									<form:option value="Savings"></form:option>
									<form:option value="Current"></form:option>
								</form:select><br></td>
						</tr>
					</table>
					<label style="text-align:left;font-weight:bold;font-size:20px;">Enter Owner Name:</label>
					<span class="required" style="color: red;"> *</span>
					<form:input type="text" class="form-control form-rounded"
						path="ownerName" name="ownerName" placeholder="OwnerName"
						autocomplete="off" required="required" />
					<br>
					<input type="submit" name="signup_submit" value="Create" />

				</form:form>

				<p>
				<center style="color:white;font-size:20px;">
					<a href="/dashboard?custmsg=Customer Created">Go Back</a> and
					create account later...
				</center>
				</p>
			</div>

		</div>
	</div>
</body>
</html>
