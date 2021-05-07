<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  

  
</head>

<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">stockUP
	  
	  </a><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxGDl9hG7JE2Z4YhCgE3D2P4rjn0f0jRiXA&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
	  
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="about">About</a></li>
	  
     
      <li><a href="#">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      
      <li class="active"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
	<div class="col-md-6 col-sm-12" >
	
	
		<div class="login-main-text">
			<h2>
				stockUP<br> Login Page
			</h2>
			<p>Login or register from here to access.</p>
		</div>

	</div>
	
	
	
		<div style="background-image: url('images/stock1.jpg');">
		<div class="col-md-6 col-sm-12">
		
			<div class="login-form">
				<form action="/login" method="POST" model="userData" name="loginform">
					<div class="form-group">
						<label>User Name</label> <input type="text" id="inputName" name="userid" class="form-control"
							placeholder="User Name" required>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"  id="inputPassword" name="upassword" 
							class="form-control" placeholder="Password" required>
					</div>
					<button type="submit" name="submit" class="btn btn-black">Login</button>
					<div class="text-center d-flex justify-content-between mt-4"><p>${errormsg}</u></p></div>
				</form>
			</div>
		</div>
		</div>
	
	
	<script type="text/javascript">
		
	</script>
</body>
</html>
