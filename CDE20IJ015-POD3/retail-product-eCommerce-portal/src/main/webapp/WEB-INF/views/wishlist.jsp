<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<a href="./wishlist.html">
				<button class="btn btn-outline-warning my-2 mx-5 my-sm-0"
					type="submit">
					<i style="font-size: 20px" class="fa">WishList</i>
				</button>
			</a> <a href="./cart.html">
				<button class="btn btn-outline-warning my-2 my-sm-0" type="submit">
					<i style="font-size: 30px" class="fa">&#xf07a;</i>
				</button>
			</a> <!-- <a href="./login.html">
				<button class="btn btn-outline-success my-2 mx-3 my-sm-0"
					type="submit">Login</button>
			</a> <a href="./signup.html">
				<button class="btn btn-outline-success my-2 mx-3 my-sm-0"
					type="submit">SignUp</button>
			</a>	 -->
		</div>
	</nav>
	<!-- body section of the page use jsp -->
	<!-- use loop to fetch the data and display it -->
	<c:forEach var="item" items="${list}">
		<div class="container">
			<div class="row">
				<!-- add a single item fech from database  -->
				<div class="col-sm">
					<div class="card my-4 color" style="width: 18rem">
						<img src="${item.image_name}" class="card-img-top img-height"
							alt="..." />
						<div class="card-body">
							<h5 class="card-title">${item.name}</h5>
							<p class="card-text">${item.description}</p>

							<h5 class="price">
								<b>Price :${item.price}</b>
							</h5>
							<br>
							<span id="rating">Rating : ${item.rating} <i
								style="font-size: 15px" class="fa">&#xf005;</i></span>
								<br>
								 <button class="btn btn-warning addcart" id="${item.id}" >Add to Cart</button>
								 <!-- <a
								href="vendor.html" class="btn btn-primary">Show Vendors</a> -->
						</div>
					</div>
				</div>
	
	<!-- close the loop  -->
	</div>
	</div>
	</c:forEach>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
		
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
		<script>
	      $('.addcart').click(function(e){
	    	  var tomorrow = new Date();
	    	  tomorrow = JSON.stringify(tomorrow);
	          tomorrow = tomorrow.slice(1, 11);
	          tomorrow = tomorrow.split("-").reverse();
	          console.log(tomorrow);
	          tomorrow = tomorrow[0] + "-" + tomorrow[1] + "-" + tomorrow[2];
	         

	    	  const id=e.target.id;
	    	  console.log(id);
	    	  console.log(tomorrow);
	    	  const url= 'addProductToCart/'+id+'/'+tomorrow;
	    	  console.log(url);
	    	  console.log(typeof url);
	    	  $.ajax({
	              url: url,
	              type: "POST",
	              data:{
	            	  expectedDeliveryDate:tomorrow
	              },
	              success: function () {
	                alert("Save Complete");
	              },
	            });
	    	  
	      });
		</script>
</body>
</html>

