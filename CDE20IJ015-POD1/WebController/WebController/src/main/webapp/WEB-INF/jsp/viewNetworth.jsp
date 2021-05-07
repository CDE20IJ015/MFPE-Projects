<%@ page language="java" contentType="text/html;  charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
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
      <li class="active"><a href="Home">Portfolio and sell Stocks</a></li>
      <li><a href="sharePrice">Show Share Price</a></li>
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
						src="https://cdn.corporatefinanceinstitute.com/assets/net-worth.jpeg"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title">Calculate Networth</h4>
						
						<p class="card-text">Your Networth is : ${networth}</p>
						<br> 
						<c:if test="${assetMap != null}" >
						<br>
						
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>Asset</th>
										<th>Units Sold</th>
									</tr>
								</thead>
								<tbody>
										<%-- <c:forEach items="${sold}" var="asset">
								</c:forEach>
								<td><c:out value="{}" </td> --%>


										<c:forEach items="${assetMap}" var="temp">
										<tr>
											<td>${temp.key}</td>
											<td>${temp.value}</td>
										</tr>
										</c:forEach>
								</tbody>
							</table>
							
						
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>