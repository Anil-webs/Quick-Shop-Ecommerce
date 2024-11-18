<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList,com.model.RegisterModel,com.model.ProductsModel" %>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>    
<%
    HttpSession sessions = request.getSession(false); // Correct variable name
    if (session == null || session.getAttribute("name") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		
		<style>
			a{
				text-decoration: none;
			}
			a:hover{
				text-decoration: none;
				cursor: default;
			}
			.card-body {
				width: 100%;
				padding: 0px;
				height: 100%;
			}
			.card-header{
				cursor: default;
			}
		</style>
	</head>
	<body>
		<!-- navbar start-->
			<jsp:include page="Navbar.jsp"></jsp:include>
		<!-- navbar end-->
		
		<!-- Welcome Note-->
		<h1 style="text-align: center; margin-bottom: 15px; margin-top: 10px; color: green">Welcome <%= session.getAttribute("name") %></h1>
		
		<!-- products List -->
		<div class="container">
		<h2>Products</h2>
		<table class="table table-bordered">
			<thead class="thead-light">
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Like/Dislike</th>
					
					<%ArrayList<ProductsModel> getProducts = (ArrayList<ProductsModel>)session.getAttribute("productsData");%>
					<%for(int i=0;i<getProducts.size();i++){
						ProductsModel Products = getProducts.get(i);
					%>
					<tr>
					<td><%=Products.getProductId() %></td>
					<td><%=Products.getProductName() %></td>
					<td><%=Products.getProductQuantity() %></td>
					<td><%=Products.getProductPrice() %></td>
					<td>
						 <form method="get" action="actionServlet">
							<input type="hidden" name="productId" value="<%= Products.getProductId() %>">
							
                            <button type="button" class="btn" data-toggle="modal" data-target="#myModal<%= Products.getProductId() %>">
                             
          						<i class="fa-regular fa-thumbs-up" id="likeIconLink"></i>

                             </button>
                               <!-- The Modal start-->
							  <div class="modal" id="myModal<%= Products.getProductId() %>">
							    <div class="modal-dialog modal-sm">
							      <div class="modal-content">
							        <!-- Modal body -->
							        <div class="modal-body">
							         	<h5 class="modal-title" style="text-align: center;">Are you sure want to Like</h5>
							        </div>
							        
							         <!-- Modal footer -->
							        <div class="modal-footer">
							          <button type="submit" class="btn btn-success" name="action" value="like" id="likeLink">Yes</button>
							          
							          <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
							        </div>
							        
							      </div>
							    </div>
							  </div>
							  <!-- The Modal end-->
							  
							  
                             <button type="submit" class="btn" name="action" value="dislike" id="dislikeLink">
          							<i class="fa-regular fa-thumbs-down" id="dislikeIconLink"></i>
                             </button>
                             
						 </form>
					</td>
				</tr>
				<%}%>
			</thead>
		</table>
			
		</div>
		
		<script>
			$(document).ready(function(){
			  $("#likeLink").click(function(){
			  	$('.toast').toast({delay:1000})
			    $('.toast').toast('show');
			  });
			});
		</script>
	</body>
</html>