<%@ page language="java" contentType="text/html;  charset=UTF-8"
import="java.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <img class="card-img-top img-fluid" src="https://images.moneycontrol.com/static-mcnews/2017/11/shutterstock_353679257-770x433.jpg?impolicy=website&width=770&height=431" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell Assets</h4>
                        <p class="card-text">Select the assets which you want to sell.</p><br><br>
                     <!--   	<select id="lstFruits" multiple="multiple">
                      	<c:forEach items="${asset}" var="temp">
                        <option>${temp.assetid}</option>
                        <p> ${ fn:length(assets)}</p>
                        </c:forEach>
                        </select>    -->
                        
                        
                     <%--    
                        <% Map<String,Integer> stockIdList=new HashMap<String,Integer>();
                        Map<String,Integer> mfAssetList=new HashMap<String,Integer>();                        
                        %>
                        <% if(${temp.type}=="MF"){
                        	stockIdList.put(temp.assetid,temp.units);
                        }
                        else{stockIdList.put(temp.assetid,temp.units);}
                        %> 
                        --%>
                     <!--    <form:form action="/viewNetworth" method="POST" modelAttribute="SellObjectMap">
                         <c:forEach items="${asset}" var="temp" >
                         <input type="checkbox" id="${temp.assetid}" name="${temp.assetid}">${temp.assetid } &nbsp;&nbsp;&nbsp;<input type="number" id="quantity" name="quantity" min="1" max="${temp.units}"><br> 
                         </c:forEach>
                         
                         
                         </form:form> --> 
                         <%-- List<String> l=new ArrayList<>(); --%>
                         <form method="post" onSubmit=" return checker();" action="/viewNetworth" >
                         <table border="1" class=table style="margin-left: auto;margin-right: auto;">
                			<tr>
                    			<th scope=col>Asset Name</th>
                    			<th scope=col>Units to be sold</th>
                         	<tr>
                         	<c:forEach items="${asset}" var="temp" >
                        <tr>
                         <td scope=row><input type="checkbox" value="${temp.assetid}" name="selected">${temp.assetid } </td>
                         <td scope=row><input  type="number" id="quantity" name="quantity" value="0" min="0" max="${temp.units}"></td> 
                         </c:forEach>
                         </tr>
                         </table>
                         <button type="submit" name="submit"  class="btn btn-black btn-primary"> NetWorth</button>
                         </form>     
       
                         
                         
                         
                    </div>
                </div>
            </div>
            <script type="text/javascript" >
            	var a=document.getElementById("quantity")
            	function checker(){
                	var count=0;
					var l = document.getElementsByName("selected");
					for(var i=0;i<l.length;i++){
						if(l[i].checked)count++;
					}
					//console.log(count);
					 if(count==0){
						alert("Please select a value");
						return false;
					}else return true; 	
                }
            </script>
</body>
</html>