
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
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

#message
{
	color : red; 
}
#accmsg
{
	color : green; 
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
			
			input::-webkit-outer-spin-button,
			input::-webkit-inner-spin-button {
			-webkit-appearance: none;
			margin: 0;
			}

			/* Firefox */
			input[type=number] {
			-moz-appearance: textfield;
			}
			ul {
			list-style-type: none;
			margin: 0;
			padding-left:30;
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
			background-color: #3e7cb9;
			}

			.active {
			background-color:#3e7cb9 ;
			}
			body
			{
				margin: 0;
				font-family: sans-serif;
				background-image:url("images/empdash.jpg");
				background-size: 1250px 853px;
			}
			.card
			{
				width: 360px;
				height:270px; 
  				background: rgba(0, 0, 0, 0.4); /* Black background with 0.5 opacity */
  				color: #f1f1f1;
  				border-radius:40px;
			
			}
			.btn
			{
				background:#3e7cb9;
				color:white;
			}
		</style>


</head>
<body >


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

	<nav class="navbar navbar-default">
		<div class="container-fluid">
	    	<div class="navbar-header">
	      		<a class="navbar-brand" style="color:white;font-size:25px;font-weight:bold;">JAKS BANK</a>
	    	</div>
    		<ul class="nav navbar-nav navbar-right" style="float:right">
      			<li><a class="active"  href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
    		</ul>
  		</div>
	</nav>
	<div class="container-fluid">
	<h2 style="text-align:center;color:white;">Employee Dashboard</h2>	
	<br>
	<div class="row">
		<div class="col-xs-12 col-sm-6 col-lg-4">
			<div style="margin: 2em 1em;">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Create Customer</h4><br>
						<br><br>
						<br> <a href="/createCustomer" class="btn">Create</a>
					</div>
					<p style="color: cyan; padding-left: 20;" id="message"> ${custmsg}</p>
				</div>
			</div>
		</div>


		<div class="col-xs-12 col-sm-6 col-lg-4">
			<div style="margin: 2em 1em;">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Create Account for Customer</h4><br>
						<form action="/createAccount" method="post">
							<input type="text" name="customerId" placeholder="Enter the CustomerId" autocomplete="off"/>
							<br> <br><br> <input type="submit" name="View" value="Create Account" class="btn" />
						</form>
						<p style="color:cyan; " id="message">${accmsg}</p>
					</div>
				</div>
			</div>
		</div>

  <div class="col-xs-12 col-sm-6 col-lg-4">
			<div style="margin: 2em 1em;">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Delete Customer</h4><br>
						<form action="/deleteCustomer" method="post">
							<input type="text" name="customerId" id="customerId" placeholder="Enter the customerId" autocomplete="off"/>
							<br><br><br><input type="submit" name="Delete" value="Delete" class="btn" />
						</form>
						<p style="color: cyan; " id="message">${deletemsg}</p>
					</div>
					
				</div>
			</div>
		</div>
	</div>


	<div class="row">

		<div class="col-xs-12 col-sm-6 col-lg-4">
			<div style="margin: 2em 1em;">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">View the Customer</h4><br>
						<form action="/viewCustomer" method="get">
							<input type="text" name="userId" id="userId" placeholder="Enter the CustomerId" autocomplete="off"/>
							<br><br><br> <input type="submit" name="View" value="View"
								class="btn" />
						</form>
						<p style="color: cyan; " id="message">${viewmsg}</p>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-xs-12 col-sm-6 col-lg-4">
			<div style="margin: 2em 1em;">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Deposit Amount</h4><br>
						<form action="/deposit" method="post">
							<input type="number"  name="accountId" placeholder="Enter the AccountId" autocomplete="off"/><br><br>	
							<input type="number" name="amount" placeholder="Enter the amount" autocomplete="off"/>
							<br> <br>
							<input type="submit" name="View" value="Deposit Amount" class="btn" />
						</form>
						<p style="color:cyan; " id="message">${msg}</p>
						
					</div>
				</div>
			</div>
		</div>

        <div class="col-xs-12 col-sm-6 col-lg-4">
			<div style="margin: 2em 1em;">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Service Charge Deduction</h4><br>
                        <p class="card-text">Charges will be deducted for not maintaining minimum balance </p>
						<form action="/deductServiceTax" method="post"><br><br>
                         <input type="submit" name="View" value="Deduct" class="btn" />
						</form>
						<p style="color: cyan; " id="message">${servicemsg}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>
