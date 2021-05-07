<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html>
<title>Shopping Site</title>
<head>
</head>
  <link
    rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
    crossorigin="anonymous"
  />
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
  />
  <link rel="stylesheet" href="./style.css" />
  <link rel="stylesheet" href="./rating.css" />

  <body>
  <%@include file="/WEB-INF/views/fragments/header.jspf"%>

    <div class="container">
      <div class="row mt-4 p-4" style="background-color:#e9ecf0">${message}</div>
      <div class="row">
        <!-- add a single item fech from database  -->
			<c:forEach var="item" items="${list}">
          <div class="card my-4 mx-4 color display" style="width: 18rem">
            <img
              src="${item.image_name}"
              class="card-img-top img-height"
              alt="..."
            />
            <div class="card-body">
              <h5 class="card-title">${item.name}</h5>
              <p class="card-text">
                ${item.description}
              </p>
              <h5 class="price">
                <b>Price : ${item.price}</b>
              </h5>
              <span id="rating"
                >Rating:${item.rating}
                <i style="font-size: 15px" class="fa">&#xf005;</i></span
              >
              <div class="date_field">
                Expected Date:<span class="date">12/10/2020</span>
              </div>
              <section class="o-container">
                <!-- Rating Stars Box -->
                <ul
                  class="c-rating-star u-text-center js-rating-star"
                  data-name="test"
                  id="${item.id}"
                >
                  <li class="c-rating-star__item" title="Poor" data-value="1">
                    <i class="fa fa-star fa-fw c-rating-star__icon"></i>
                  </li>
                  <li class="c-rating-star__item" title="Fair" data-value="2">
                    <i class="fa fa-star fa-fw c-rating-star__icon"></i>
                  </li>
                  <li class="c-rating-star__item" title="Good" data-value="3">
                    <i class="fa fa-star fa-fw c-rating-star__icon"></i>
                  </li>
                  <li
                    class="c-rating-star__item"
                    title="Excellent"
                    data-value="4"
                  >
                    <i class="fa fa-star fa-fw c-rating-star__icon"></i>
                  </li>
                  <li class="c-rating-star__item" title="WOW!!!" data-value="5">
                    <i class="fa fa-star fa-fw c-rating-star__icon"></i>
                  </li>
                </ul>
              </section>
              	<!-- <a href="addProductToCart?id=${item.id}">Add to Cart</a> -->
              	<a href="addProductToCart?id=${item.id}">
				<button class="btn btn-outline-primary my-2 mx-3 my-sm-0"
					type="submit">Add to Cart</button>
			</a>
              	<!--  <button class="btn btn-warning addcart" id="${item.id}" >Add to Cart</button> -->
      
            </div>
          </div>
          </c:forEach>
          
         
          
        <!-- close the loop  -->
      </div>
    </div>
    <%@include file="/WEB-INF/views/fragments/footer.jspf"%>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
      integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
      crossorigin="anonymous"
    ></script>
    <script src="rating.js"></script>
    <script>

      const date = document.getElementsByClassName("date");
      const myrating = document.getElementsByClassName("my-rating");
      var today = new Date();
      var tomorrow = new Date();
      tomorrow.setDate(today.getDate() + 7);
      tomorrow = JSON.stringify(tomorrow);
      tomorrow = tomorrow.slice(1, 11);
      tomorrow = tomorrow.split("-").reverse();
      console.log(tomorrow);
      tomorrow = tomorrow[0] + "-" + tomorrow[1] + "-" + tomorrow[2];
      for (i of date) {
        i.innerText = tomorrow;
      }

      const container = document.getElementsByClassName("o-container");
      for (let topElement = 0; topElement < container.length; topElement++) {
        container[topElement].addEventListener("click", function (e) {
          let id = e.target.parentElement.parentElement;
        
          let url='addProductRating/'+id.id+"/"+val;
          console.log(url);
          $.ajax({
            url: url,
            type: "POST",
            data: val,
            success: function () {
              alert("Save Complete");
            },
          });
        });
      }

      $('.addcart').click(function(e){
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
