<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
      <a class="navbar-brand" href="#">stockUP</a>
	  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxGDl9hG7JE2Z4YhCgE3D2P4rjn0f0jRiXA&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="Home">Portfolio and sell Stocks</a></li>
      <li class="active"><a href="sharePrice">Show Share Price</a></li>
      <li><a href="mutualFund">Show Mutual Fund</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      
		<form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
    </ul>
  </div>
</nav>


    <br>
    <div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 ">
				<div class="card text-center shadow-lg">
					<img class="card-img-top img-fluid"
						src="https://moneyexcel.com/wp-content/uploads/2018/06/stock-price.png"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						
						
							<table class="table table-bordered">
		<th>Share Id     </th>
		<th>Share Name     </th>
		<th>Share Value     </th>
		
		<c:forEach items="${share}" var="shr">
			<tr>
				<td>${shr.shareId}</td>
				<td>${shr.shareName}</td>
				<td>${shr.shareValue}</td>
				
				
			</tr>
		</c:forEach>
	</table>
							
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
  


</body>
</html>
