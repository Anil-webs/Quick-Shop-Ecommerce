<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList,com.model.ProductsModel" %>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>products</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<style>
			.btn {
				padding: 0;
			}
			.btn-info{
				background-color: white;
				color: #6495ED ;
				border: none;
			}
			
		</style>
	</head>
	<body>
		<a href="Admin.jsp">Home</a>
		<div class="container">
		<h2>Products</h2>
		<div class="row">
			<div class="col-md-12">
			<a href="productsAdd.jsp">Add New Products</a>
			<table class="table table-bordered">
				<thead class="thead-light">
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
					<%ArrayList<ProductsModel> data = (ArrayList<ProductsModel>)session.getAttribute("productsData");%>
					
					
					<%for(int i=0; i<data.size(); i++){
						ProductsModel getData = data.get(i);
					%>
						<tr>
							<td><%=getData.getProductId() %></td>
							<td><%=getData.getProductName() %></td>
							<td><%=getData.getProductQuantity() %></td>
							<td><%=getData.getProductPrice() %></td>
							<td>
								
								<a href="updateProducts.jsp?productId=<%= getData.getProductId() %>"><i class="fa-solid fa-pen"></i></a>
								
								  <!-- Trigger the modal with a button -->
								  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#deleteModal<%= getData.getProductId() %>"><i class="fa-solid fa-trash"></i></button>
								  <!-- Modal -->
								  <div class="modal fade" id="deleteModal<%= getData.getProductId() %>" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-body">
								          <p>Are you sure want to delete?</p>
								          </div>
								          <div class="modal-footer">
								          	<a href="deleteProduct?productId=<%= getData.getProductId() %>"><button type="button" class="btn btn-light">Yes</button></a>
								        	<button type="button" class="btn btn-light" data-dismiss="modal">No</button>
								          </div>   
								      </div>
								    </div>
								  </div>
							</td>
						</tr>
					<%}%>
				</thead>
			</table>
			</div>
			</div>
		</div>
	</body>
</html>