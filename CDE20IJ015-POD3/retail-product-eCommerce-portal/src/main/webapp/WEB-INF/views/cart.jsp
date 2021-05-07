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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="./style.css" />

<body>
	<%@include file="/WEB-INF/views/fragments/header.jspf"%>

	<!-- body section of the page use jsp -->
	<!-- use loop to fetch the data and display it -->

	<div class="container">
		<div class="row">
			<c:forEach var="item" items="${list}">
				<!-- add a single item fech from database  -->
				<div class="col-sm">
					<div class="card my-4 color" style="width: 18rem">
						<img src="${item.product.image_name}"
							class="card-img-top img-height" alt="..." />
						<div class="card-body">
							<h5 class="card-title">${item.product.name}</h5>
							<p class="card-text">${item.product.description}</p>

							<h5 class="price">
								<b>Price :${item.product.price}</b>
							</h5>
							<br>
							<span id="rating">Rating : ${item.product.rating} <i
								style="font-size: 15px" class="fa">&#xf005;</i>
							</span>
							<div class="form-group edit-rating">
			
								<div class="right">
									<button class="btn btn-outline-primary round increase"
										type="submit">
										<i style="font-size: 20px" class="fa">&#xf067; </i>
									</button>
									<b class="qty" value="${item.qty}">${item.qty}</b>
									<button class="btn btn-outline-primary round decrease"
										type="submit">
										<i style="font-size: 20px" class="fa">&#xf068; </i>
									</button>
								</div>
							</div>
							<p>
								<a href="/vendors/${item.product.id}/${item.qty}"
									class="vendors btn btn-success">More Offers</a>
							</p>
							<button 
								class="updateCart btn btn-danger" id="${item.product.id}" >Update Cart</button>
								 <a
								href="/removeCart/${item.product.id}"
								class="removeCart btn btn-danger">Remove Cart</a>
							<div>
								<span id="zipCode">Delivering to ZipCode:${item.zipCode}
								</span> <br> <span id="expectedDeliveryDate">Expected
									Delivery Date:<br>${item.expectedDeliveryDate}
								</span>
							</div>
						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<div class="table">
      <table id="example" style="width: 100%">
        <thead>
          <tr>
            <th>Price</th>
            <th>Delivery Charge</th> 
            <th>Total</th> 
            
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${productTotal}</td>        
            <td>${delivery}</td>
            <td>${total}</td>
          </tr>
        </tbody>
        <tfoot>
          
        </tfoot>
      </table>
    </div>
    
  <%@include file="/WEB-INF/views/fragments/footer.jspf"%>


	<!-- close the loop  -->



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
		const increase = document.getElementsByClassName("increase");
		const decrease = document.getElementsByClassName("decrease");
		const qty = document.getElementsByClassName("qty");
		const updateCart = document.getElementsByClassName("updateCart");
		const removeCart = document.getElementsByClassName("removeCart");
		
		for (let i = 0; i < increase.length; i++) {
			console.log("insideeeeeeeeeeeeeeeeeeeeeeeeeeee");
			increase[i].addEventListener("click", function(e) {
				qty[i].innerText = parseInt(qty[i].innerText) + 1;

			});
			decrease[i].addEventListener("click", function(e) {
				if (parseInt(qty[i].innerText) === 0) {
					return;
				}
				qty[i].innerText = parseInt(qty[i].innerText) - 1;
				
			});

			updateCart[i].addEventListener("click", function(e) {
				  const id=e.target.id;
		    	  console.log(id);
		    	  console.log(qty[i].innerText);
		    	  const url= "updateCart/"+id+"/"+parseInt(qty[i].innerText);
		    
		    	  $.ajax({
		              url: url,
		              type: "GET",
		             
		              success: function () {
		                alert("Save Complete");
		              },
		            });
			});


			
		}
	
		
	</script>
</body>

</html>
