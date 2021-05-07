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
html {
	height: 100%;
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
	color: white;
	background: linear-gradient(to right, #9999ff, #e0ebeb);
	background-image:url("../images/custdashboard.jpg");
	background-size: 1300px 1200px;
	
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
	background-color: white;
}

.center {
	margin-left: auto;
	margin-right: auto;
}

.card {
	margin:  auto;
	float: none;
	width: 950px; 
	background: rgba(0, 0, 0, 0.4);  
	color: #f1f1f1;
}

.active {
	background-color:	#8B4513;
}
.card2
{
	width: 400px; 
	height: 400px; 
	background: rgba(0, 0, 0, 0.4); 
	color: #f1f1f1;
}
</style>
</head>




<body class="doodle">

	<%
	response.setHeader("cache-control", "no-cache , no-store , must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	if (session == null) {
	%>
	<c:redirect url="/403" />
	<%
	}
	%>
	<!--------------------- Navigation------------------>


	<ul>
		<li><div class="navbar-brand">&nbsp;&nbsp;&nbsp;JAKS Bank</div></li>
		<li style="float: right"><a class="active" href="/logout">Logout</a></li>
	</ul>

	<!--------------------- Details------------------>
	<div class="container-fluid">
		<br>
		<div class="card">
			<div class="card-body">
				<div align="center">
					<caption style="font-family: Bradley Hand ITC;">
						<h2>Customer Details</h2>
					</caption>
				</div>
				<br>
				<div align="center">
					<caption>
						<h4>Personal Details</h4>
					</caption>
				</div>
				<br>
				<table border="2" cellpadding="5" class="center" style="width: 900;">
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
						<br>
						<h4 style="color: white;">Account Details</h4>
					</div>
					<br>
				</caption>
				<table border="2" cellpadding="5" class="center" style="width: 900;">
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
				<br>
			</div>
		</div>
		<br>

		<!--------------------- Transaction details------------------>
		<div class="card">
			<div class="card-body">
				<div align="center">
					<caption>
						<h2>Transaction Details</h2>
					</caption>
					<br>
					<form action="/customerdashboard/getTransactionsInCustomerdashboard" method="post">
						<select style="font-family: serif; font-size: 25; font-weight: bold;" path="accountId" name="accountId">
							<c:forEach var="acc" items="${customer.accounts}">
								<option value="${acc.accountId }">Account No:
									${acc.accountId }</option>
							</c:forEach>
						</select> <br> <br> <input class="btn btn-success" type="submit"
							value="Submit" />

					</form>
					<br>
					<c:if test="${!empty transactions}">
						<table border="2" cellpadding="5" >

							<tr>
								<th>sourceAccountId</th>
								<th>sourceOwnerName</th>
								<th>targetAccountId</th>
								<th>targetOwnerName</th>
								<th>amount</th>
								<th>initiationDate</th>
								<th>reference</th>
							</tr>
							<c:forEach var="trans" items="${transactions}">
								<tr>

									<td><c:out value="${trans.sourceAccountId}" /></td>
									<td><c:out value="${trans.sourceOwnerName}" /></td>
									<td><c:out value="${trans.targetAccountId}" /></td>
									<td><c:out value="${trans.targetOwnerName}" /></td>
									<td><c:out value="${trans.amount}" /></td>
									<td><c:out value="${trans.initiationDate}" /></td>
									<td><c:out value="${trans.reference}" /></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
		<br>
		<div class="row" >
			<div class="col">
				<!--------------------- WITHDRAW------------------>
				<div class="card2" style="margin:0em 4em 0em 8em;">
					<div class="card-body">
						<h4 class="card-title">Withdraw Amount</h4>
						<form:form action="/withdraw" method="post"
							modelAttribute="accountinput">
							<form:select path="accountId" name="accountId">
								<c:forEach var="acc" items="${customer.accounts}">
									<form:option value="${acc.accountId }"></form:option>
								</c:forEach>
							</form:select>
							<br>
							<br>
							<label for="amount">Enter Amount:</label>
							<span class="required" style="color: red;"> *</span>
							<br>
							<input type="number" path="amount" name="amount"
								placeholder="Enter the amount" required="required" />
							<input type="hidden" name="reference" value="withdraw" />
							<br>
							<br>
							<h6>Minimum balance of 1000 Rs. should be maintained</h6>
							<br>
							<input type="submit" name="View" value="Withdraw Amount"
								class="btn btn-success" />
							<br>
						</form:form>
						<br>
						<p style="font-family: Bradley Hand ITC; color: cornflowerblue;"
							id="message">${msg}</p>
					</div>
				</div>

			</div>
			<!--------------------- TRANSFER------------------>
			<div class="col">
				<div class="card2" style="margin:0em 5em 0em 4em;">
					<div class="card-body">
						<h4 class="card-title">Transfer Amount</h4>
						<form:form action="/transfer" method="post"
							modelAttribute="accountinput">
							<form:select path="accountId" name="accountId">
								<c:forEach var="acc" items="${customer.accounts}">
									<form:option value="${acc.accountId }"></form:option>
								</c:forEach>
							</form:select>
							<br>
							<br>
							<label for="targetAccount">Enter Account No:</label>
							<span class="required" style="color: red;"> *</span>
							<br>
							<input type="number" name="targetAccount"
								placeholder="Enter the Target Account ID" required="required" />
							<br>
							<br>
							<label for="amount">Enter Amount:</label>
							<span class="required" style="color: red;"> *</span>
							<br>
							<input type="number" name="amount" placeholder="Enter the amount"
								/required="required">
							<input type="hidden" name="reference" value="transfer" />
							<br>
							<br>
							<h6>Minimum balance of 1000 Rs. should be maintained</h6>
							<br>
							<input type="submit" name="View" value="Transfer Amount"
								class="btn btn-success" />
							<br>
						</form:form>
						<br>
						<p style="color: cornflowerblue;" id="message">${transfermsg}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>