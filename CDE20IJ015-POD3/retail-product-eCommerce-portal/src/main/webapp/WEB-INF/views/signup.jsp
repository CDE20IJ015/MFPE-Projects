<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<title>Shopping Site</title>
<head>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="./style.css" />
<body>
	<!-- navbar for the pages -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="home.html">ShopOne</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" id="search" />
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
					Search</button>
			</form>
			<!--  <a href="./wishlist.html">
				<button class="btn btn-outline-warning my-2 mx-5 my-sm-0"
					type="submit">
					<i style="font-size: 20px" class="fa">WishList</i>
				</button>
			</a> <a href="./cart.html">
				<button class="btn btn-outline-warning my-2 my-sm-0" type="submit">
					<i style="font-size: 30px" class="fa">&#xf07a;</i>
				</button>
			</a>	-->
			 <a href="./login.html">
				<button class="btn btn-outline-success my-2 mx-3 my-sm-0"
					type="submit">Login</button>
			</a> <a href="./signup.html">
				<button class="btn btn-outline-success my-2 mx-3 my-sm-0"
					type="submit">SignUp</button>
			</a>
		</div>
	</nav>

	<!-- login form for the user -->
	<div class="center">
		<form:form method="post" modelAttribute="credentials" action="/signup.html">
			<div class="form-group">
				<form:label path="firstName" for="firstName">First Name</form:label>
				<form:input type="text" class="form-control" id="firstName"
					aria-describedby="firstName" path="firstName" />
				<form:label path="lastName" for="lastName">Last Name</form:label>
				<form:input type="text" class="form-control" id="lastName"
					aria-describedby="lastName" path="lastName" />
				<form:label path="uname" for="uname">User Name</form:label>
				<form:input type="text" class="form-control" id="uname"
					aria-describedby="uname" path="uname" />
				<form:label path="email" for="email">Email address</form:label>
				<input type="email" class="form-control" id="email"
					aria-describedby="email" />
				<form:label path="address" for="uname">Address</form:label>
				<form:input type="text" class="form-control" id="address"
					aria-describedby="address" path="address" />
				<form:label path="zipCode" for="zipCode">Zip Code</form:label>
				<form:input type="text" class="form-control" id="zipCode"
					aria-describedby="zipCode" path="zipCode" />
			</div>
			<div class="form-group">
				<form:label path="upassword" for="upassword">Password</form:label>
				<form:input path="upassword" type="password" class="form-control" id="upassword" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password</label>
				<input type="password" class="form-control" id="confirmPassword" />
			</div>
	
	<div class="center">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
	</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>



</body>
</html>
