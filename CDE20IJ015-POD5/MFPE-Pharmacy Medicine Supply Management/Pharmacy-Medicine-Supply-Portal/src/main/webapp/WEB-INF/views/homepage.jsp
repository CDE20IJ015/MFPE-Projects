
<%@ include file="common/header.jspf"%>

<article>

	<h1 class="text-center p-5" 
style="
box-shadow: 0 2px 2px 0 rgba(1, 1, 1, 1);
background-color:#00bfff;
color: #ffffff;
font-size: 45px;
font-family: cursive;"
>Home Page</h1>

	<div class="row">
		<div class="col">
			<!-- Dummy tag for maintaining structure of cards -->
		</div>
		<div class="col">
			<div class="card bg-light text-center" style="width: 18rem; height:20rem;">
				<img class="card-img-top" src="https://cdn.dribbble.com/users/2526497/screenshots/6175813/image.png" alt="img medical representative" width="30" height="120">
				<div class="card-body">
					<h5 class="card-title">Medical Representatives</h5>
					<p class="card-text">Click here to view medical representatives
						schedule for doctors visit.</p>

					<a class="btn btn-primary" href="/user/schedule">Medical
						Representative</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card bg-light text-center" style="width: 18rem; height:20rem;">
				<img class="card-img-top" src="https://www.webretailer.com/wp-content/uploads/2018/08/Busy-warehouse.jpg" alt="img medicine stock" width="30" height="120">
				<div class="card-body">
					<h5 class="card-title">Medicine Stock</h5>
					<p class="card-text">Click here to view detailed list of
						medicines present in stock</p>
<br>
					<a class="btn btn-primary" href="/user/medicineStock">Medicine
						Stock</a>
				</div>
			</div>
		</div>

		<div class="col">
			<!-- Dummy tag for maintaining structure of cards -->
		</div>
	</div>

</article>




<%@ include file="common/footer.jspf"%>