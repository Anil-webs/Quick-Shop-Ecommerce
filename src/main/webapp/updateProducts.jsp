<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList,com.model.ProductsModel,com.dao.ShoppingDAO" %>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update products</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<a href="Admin.jsp">Home</a>
		<div class="container" style="margin-top: 10%; ">
			<div class=row>
				<div class="col-md-4"></div>
				<div class="col-md-4">
				<%	ShoppingDAO sp = new ShoppingDAO();
					Integer productId = Integer.parseInt(request.getParameter("productId"));
					ProductsModel pm = sp.getUpdatableData(productId);
				%>
				<form method="post" action="updateServlet" class="form-group">
					<input type="hidden" id="productid" name="productid" class="form-control" value="<%=productId%>">
					<label>Product Name:</label>
					<input type="text" id="ProductName" name="ProductName" class="form-control" value="<%=pm.getProductName()%>">
					<label>Quantity:</label>
					<input type="text" id="quantity" name="quantity" class="form-control" value="<%=pm.getProductQuantity()%>">
					<label>Price:</label>
					<input type="text" id="price" name="price" class="form-control" value="<%=pm.getProductPrice()%>">
					<button type="submit" class="btn btn-primary">Update</button>
				</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</body>
</html>