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
	  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxGDl9hG7JE2Z4YhCgE3D2P4rjn0f0jRiXA&usqp=CAU" width="30" height="30"  alt="d-inline-block align-top">
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
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://poeticbusiness.co.uk/wp-content/uploads/2020/02/1580817669_maxresdefault.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Calculate Portfolio</h4>
                        <p class="card-text">Click to view my portfolio</p>
                        <form action="/viewNetworth" method="GET"><button type="submit" value="submit" class="btn btn-outline-primary">Calculate Portfolio</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://g.foolcdn.com/image/?url=https%3A//g.foolcdn.com/editorial/images/478127/sell-button.jpg&w=2000&op=resize" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell </h4>
                        <p class="card-text">Click to sell a stock</p>
                        <form action="/sellAssets" method="GET"><button type="submit" name="submit" class="btn btn-outline-success">Sell Stock</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
  


</body>
</html>
