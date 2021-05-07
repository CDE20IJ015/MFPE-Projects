<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>JAKS Bank</title>
    <style>
    	body
    	{
    		background-image:url("images/bankbg.jpeg");
    		width:100%;
    		height:100%;
    	}
    	
    </style>
  </head>

<body>
    
    <div class="container">
      
      <div class="row">
          <div class="col-md-6">
              <div class="card">
               
                  <div class="box">
                   
                      <h2 style="color: white;">JAKS BANK</h2><br>
                      <p style="color:white;font-family:Georgia, serif;"> 
                      	<b>"BUILD YOUR BUSINESS WITH A BANK YOU TRUST!"</b><br><br>
                         <i>Tireless dedication energizes you to accomplish more today than yesterday.<br> 
                         We work hard to build a long lasting relationship with you to help  you reach your goals so you can enjoy your achievements.
                      </i></p> <br>
                       <!-- Button trigger modal -->
                    <form action="/employeelogin" method="get">
                    <input type="submit"  value="Employee Login" >
                    </form>
                    <form  action="/customerlogin" method="get">
                    <input type="submit"  value="Customer Login" >
                    </form>
                   
                </div>
          </div>
      </div>
  </div>
  

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

  </body>
</html>