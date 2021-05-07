<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <title>Shopping Site</title>
  <head> </head>
  <link
    rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
    crossorigin="anonymous"
  />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="./style.css" />
     <body>
    <!-- navbar for the pages -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="home.html">ShopOne</a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
  
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <form class="form-inline my-2 my-lg-0">
            <input
              class="form-control mr-sm-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
              id="search"
            />
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
              Search
            </button>
          </form>
          <a href="./wishlist.html">
            <button
              class="btn btn-outline-warning my-2 mx-5 my-sm-0"
              type="submit"
            >
              <i style="font-size: 20px" class="fa">WishList</i>
            </button>
          </a>
          <a href="./cart.html">
            <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">
              <i style="font-size: 30px" class="fa">&#xf07a;</i>
            </button>
          </a>
          <a href="./login.html">
            <button
              class="btn btn-outline-success my-2 mx-3 my-sm-0"
              type="submit"
            >
              Login
            </button>
          </a>
          <a href="./signup.html">
            <button
              class="btn btn-outline-success my-2 mx-3 my-sm-0"
              type="submit"
            >
              SignUp
            </button>
          </a>
        </div>
      </nav>
    <!-- body section of the page use jsp -->
    <!-- use loop to fetch the data and display it -->
    <div class="container">
      <div class="row ">
        <!-- add a single item fech from database  -->      
             <c:forEach var="item" items="${list}">
            <div class="row my-4">
                <div class="card " style="width: 60rem;">
                  <h5 class="card-header">${item.vendorName}</h5>
                  <div class="card-body">
                    <h5 class="card-title"> 
                    <span >Rating : ${item.rating}
                        <i style="font-size: 25px" class="fa">&#xf005;</i>
                        ${productId} ${qty}</span>
                      </h5>
                    <p class="card-text">
                      Delivery Charge <span><b> ${item.deliveryCharge}</b></span>
                    </p><a href='/updateVendor/${item.vendorId}/${productId}/${qty}'>
                    <button  class="btn btn-warning changevendor" id="${item.vendorId}">Change the Vendor</button></a>

                  </div>
                </div>
                </div>
                 </c:forEach>
                </div>


        <!-- close the loop  -->
      </div>

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
    
        <script>
    
/*    $('.changevendor').click(function(e){
    	  const id=e.target.id;
    	  console.log(id);
    
    	  const url='http://localhost:8080/updateVendor/'+id+'/'+${productId}+'/'+${qty};
    	  console.log(url);
    	  
    	  console.log(${productId});
    	  $.ajax({
              url: url,
              type: "GET",
              success: function () {
                alert("Save Complete");
              },
            });
    	  
      });*/
      
    </script>
  </body>
</html>

