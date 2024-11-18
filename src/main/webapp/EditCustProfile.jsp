<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.model.RegisterModel,java.util.ArrayList" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit profile</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<a href="home.jsp">Home</a>
		<div class="container" style="margin-top: 10%; ">
			<div class=row>
				<div class="col-md-4"></div>
				<div class="col-md-4">
				<%
					ArrayList<RegisterModel> al = (ArrayList<RegisterModel>)session.getAttribute("customerData");
					for(int i=0;i<al.size(); i++){
						RegisterModel data = al.get(i);
				%>
				
				<form method="post" action="editProfileServlet" class="form-group">
					<label>FirstName:</label>
					<input type="text" id="fname" name="fname" class="form-control" value="<%=data.getFirstname() %>">
					
					<label>UserName:</label>
					<input type="hidden" id="uname" name="uname" class="form-control" value="<%=data.getUsername() %>">
					
					<label>Password:</label>
					<input type="text" id="psw" name="psw" class="form-control" value="<%=data.getPassword() %>">
					
					<button type="submit" class="btn btn-primary">Update</button>
				</form>
				</div>
				<%} %>
				<div class="col-md-4"></div>
			</div>
		</div>
	</body>
</html>