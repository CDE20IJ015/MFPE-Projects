<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
  />
  <link rel="stylesheet" href="/style.css" />

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
       <!--  <a href="./login.html">
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
        </a>	 -->
      </div>
    </nav>
    <!-- body section of the page use jsp -->
    <!-- use loop to fetch the data and display it -->

    <img
      src="https://i1.wp.com/www.huratips.com/wp-content/uploads/2019/04/empty-cart.png?resize=603%2C288&ssl=1"
      style="width: 1000px; height: 500px"
    />

    <!-- close the loop  -->

    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
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
  </body>
</html>
