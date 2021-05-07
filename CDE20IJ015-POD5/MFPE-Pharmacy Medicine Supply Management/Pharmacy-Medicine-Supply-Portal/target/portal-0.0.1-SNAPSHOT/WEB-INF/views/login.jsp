<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


<link rel="stylesheet" type="text/css" href="login.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #00bfff;
}
.container-fluid{
background-image: url('https://familiesusa.org/wp-content/uploads/2019/07/Prescription-Drugs.jpg');
}
.flip-card {
	background-color: transparent;
	width: 300px;
	height: 300px;
	perspective: 1000px;
	padding: 5px;
}

.flip-card-inner {
	position: relative;
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 0.6s;
	transform-style: preserve-3d;
	box-shadow: 0 4px 8px 0 rgba(0.5, 0.5, 0.5, 0.5);
}

.flip-card:hover .flip-card-inner {
	transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
	position: absolute;
	width: 100%;
	height: 100%;
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
}

.flip-card-front {
	background-color: #bbb;
	color: black;
}
.nav-item{
color:#1e90ff;
}
.flip-card-back {
	
	color: white;
	transform: rotateY(180deg);
	padding: 5px;
}
.display-4{
top-padding:5px;
box-shadow: 0 4px 8px 0 rgba(2, 2, 2, 2);
background-color:transparent;
color: #191970;
font-size: 50px;
}
</style>

</head>

<!-- <body style="background-image: url('https://morphinewithdrawals.org/wp-content/uploads/2017/05/morphine-withdrawals.jpg');">
 -->
<body style="background-img:url('https://www.crushpixel.com/big-static15/preview4/shopping-cart-foreground-laptop-drugs-1950890.jpg');">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark" color=#1e90ff;> <!-- Brand/logo -->
	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="navbar navbar-darkblue bg-dark" href="#" > <img
				src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500"
				width="30" height="30" class="d-inline-block align-top" alt="" font-size=35;>
				Cognizant Pharmacy
		</a></li>

	</ul>
	</nav>


	<!--                   -->




	<div class="container-fluid">

		<!-- Demo content-->
		<div class="container">
			<div class="row">

				<div class="col-lg-10 col-xl-7 mx-auto">
					<h3 align="center" class="display-4" style="
box-shadow: 0 2px 2px 0 rgba(1, 1, 1, 1);
background-color:#00bfff;
color: #ffffff;
font-size: 50px;
font-family: ui-serif;">${loginMessage}</h3>
					<p align="center" class="text-muted mb-4"></p>

					<form:errors path="usercredentials.*" />

					<form:form action="/user/homepage" modelAttribute="usercredentials"
						method="post">
						<div class="form-group mb-3">
							<input id="userid" type="text" name="userid"
								placeholder="Username" required="" autofocus=""
								class="form-control rounded-pill border-0 shadow-sm px-4">
						</div>
						<div class="form-group mb-3">
							<input id="password" type="password" name="password"
								placeholder="Password" required=""
								class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
						</div>

						<button type="submit" name="submit"
							class="btn btn-success btn-block text-uppercase mb-2 rounded-pill shadow-sm">LOGIN</button>
						<div class="text-center d-flex justify-content-between mt-4">
							<p>${errormsg}</u>
							</p>
						</div>
					</form:form>
				</div>
			</div>
		
		<!-- End -->


	
	<!-- End -->







	<div class="container" center>
		<div class="row" >

			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<img
							src="https://epsilon.aeon.co/images/afef287f-dd6f-4a6a-b8a6-4f0a09330657/idea_sized-kendal-l4ikccachoc-unsplash.jpg"
							alt="Avatar" style="width: 400px; height: 340px;">
					</div>
				<div class="flip-card-back">
					
					<img
							src="https://i.pinimg.com/236x/48/ab/4d/48ab4d536b113b7e5bba57c8341c89e3.jpg"
							alt="Avatar" style="width: 260px; height: 340px;">
						

					</div>
		</div>
			</div>


			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<img
							src="https://pharmaceutical-journal.com/wp-content/uploads/2021/01/asian-pharmacist-ss-19-1456x967.jpg"
							alt="Avatar" style="width:400px; height: 340px;">
					</div>
					<div class="flip-card-back">
					
					<img
							src="https://i.pinimg.com/236x/be/85/fd/be85fd39d500b600f5bc4dbbbca5f8e0.jpg"
							alt="Avatar" style="width: 260px; height: 340px; ">
						

					</div>
				</div>
			</div>


			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<img
							src="https://images.unsplash.com/photo-1563213126-a4273aed2016?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1350&q=80"
							alt="Avatar" style="width: 400px; height: 340px;">
					</div>
					<div class="flip-card-back">
						<img
				
							src="https://i.pinimg.com/originals/a8/0a/e3/a80ae39284c8097ac6c53e264293acd5.jpg"
							alt="Avatar" style="width: 260px; height: 340px;">
				</div>
					</div>
				</div>
			</div>
</div>
</div>

</div>		

</body>
</html>