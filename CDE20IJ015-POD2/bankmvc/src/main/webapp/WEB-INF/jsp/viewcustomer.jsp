<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/style/table.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
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
	color: white;
	background: linear-gradient(to right, #9999ff, #e0ebeb);
	background-image:url("images/empdash.jpg");
	background-size: 1250px 700px;
}


ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.active {
	background-color: #4c56af;
}

.center {
	margin-left: auto;
	margin-right: auto;
}
.card
{
	width: 900px; 
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

	if (session.getAttribute("token") == null) {
	%>
	<c:redirect url="/403" />
	<%
	}
	%>
	<br>
	<div style="margin: 1em 10em;">
		<h1 style="color:white;">
			<center>Customer Details</center>
		</h1>
		<br>
		<div class="card">
			<div class="card-body">
				<div align="center">
					<caption>
						<h5>Personal Details</h5>
					</caption>
					<br>
					<table class="center" border="2" cellpadding="7" style="width: 900;">
						<tr>
							<th>CUSTOMER ID</th>
							<th>CUSTOMER NAME</th>
							<th>DOB</th>
							<th>PAN</th>
							<th>ADDRESS</th>

						</tr>
						<tr>
							<td><c:out value="${customer.userid}" /></td>
							<td><c:out value="${customer.username}" /></td>
							<td><c:out value="${customer.dateOfBirth}" /></td>
							<td><c:out value="${customer.pan}" /></td>
							<td><c:out value="${customer.address}" /></td>
						</tr>
					</table>
					<caption>
						<div align="center">
							<br> <br>
							<h5 style="color: white;">Account Details</h5>
						</div>
					</caption>
					<br>
					<table border="2" cellpadding="5" style="width: 900;">
						<tr>
							<th>ACCOUNT ID</th>
							<th>CURRENT BALANCE</th>
							<th>ACCOUNT TYPE</th>
							<th>OWNER NAME</th>
						</tr>
						<c:forEach var="acc" items="${customer.accounts}">
							<tr>

								<td><c:out value="${acc.accountId}" /></td>
								<td><c:out value="${acc.currentBalance}" /></td>
								<td><c:out value="${acc.accountType}" /></td>
								<td><c:out value="${acc.ownerName}" /></td>
							</tr>
						</c:forEach>

					</table>

				</div>
			 <br>
				<div align="center">
					<br> <a href="/dashboard" style="color:cyan;text-decoration:underline;font-size:20px;">Back</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>