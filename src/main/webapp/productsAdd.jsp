<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>products Add</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		
		<script>
		$(document).ready(function(){
			$("#id").blur(function(){
				var Productid = $("#id").val();
				$.get('productIdCheckingField',
						{productId: Productid},
						function(info){
							if(info.includes("You can go forhead this productId")){
								$("#paraId").text(info).css({"color":"green"})
							}else{
								$("#paraId").text(info).css({"color":"red"})
							}
							
					});
					}
			});
		});
		</script>
	</head>
	<body>
		<a href="Admin.jsp">Home</a>
		<div class="container" style="margin-top: 10%; ">
			<div class=row>
				<div class="col-md-4"></div>
				<div class="col-md-4">
				<form name="productlist" method="post" action="products" class="form-group">
					<label>ProductId:</label>
					<input type="text" id="id" name="id" class="form-control">
					<p id="paraId"></p>
					<label>Product Name:</label>
					<input type="text" id="pName" name="pName" class="form-control">
					<label>Quantity:</label>
					<input type="text" id="quantity" name="quantity" class="form-control">
					<label>Price:</label>
					<input type="text" id="price" name="price" class="form-control">
					<button type="submit" class="btn btn-primary">ADD</button>
				</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</body>
</html>