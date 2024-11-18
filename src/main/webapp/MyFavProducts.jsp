<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList,com.model.LikedProductsModel" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>My fav products</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
	</head>
	<body>
		<!-- navbar start-->
			<jsp:include page="Navbar.jsp"></jsp:include>
		<!-- navbar end-->
		<h1 style="text-align: center; margin-bottom: 15px; margin-top: 10px; color: #CD6155">Your favourite products</h1>
		<div class="container">
			<p>You are liked <%=session.getAttribute("likesCount") %> products</p>
			<table class="table table-bordered">
				<thead class="thead-light">
					<th>ProductName</th>
					<th>Price</th>
					
					<%
						ArrayList<LikedProductsModel> likedList = (ArrayList<LikedProductsModel>)session.getAttribute("likedList");
					
						for(int i=0;i<likedList.size();i++){
							LikedProductsModel list = likedList.get(i);
					%>
					<tr>
						<td><%=list.getProductName() %></td>
						<td><%=list.getPrice() %></td>
					</tr>
					<%} %>
				</thead>	
			</table>
		</div>
	</body>
</html>