<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
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

			<!--   <a href="./wishlist.html">
				<button class="btn btn-outline-warning my-2 mx-5 my-sm-0"
					type="submit">
					<i style="font-size: 20px" class="fa">WishList</i>
				</button>
			</a> <a href="./cart.html">
				<button class="btn btn-outline-warning my-2 my-sm-0" type="submit">
					<i style="font-size: 30px" class="fa">&#xf07a;</i>
				</button>	
			</a>	--> <a href="./login.html">
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
		<p style="color:red;">${invalid}</p>
		<form:form method="post" modelAttribute="credentials">
			<div class="form-group">
				<form:label path="uname" >User Name</form:label> 
				<form:input type="text" class="form-control" path= "uname" /> 
				<small id="uname" class="form-text text-muted"> We'll never share your details with anyone else.</small>
			</div>
			<div class="form-group">
				<form:label path ="password" >Password</form:label> 
				<form:input type="password" class="form-control" id="password" path="password" />
			</div>
	<!-- </div>
	 -->
	 <div class="center">
		<!-- <a href="./loginSubmit">
 -->
		<button type="submit" class="btn btn-primary">Submit</button>
		<!--         </a>
     -->
	</div>
	</form:form>
	</div>
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
