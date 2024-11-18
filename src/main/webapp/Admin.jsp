<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>    
<%
    HttpSession sessions = request.getSession(false); // Correct variable name
%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>AdminHome</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<!-- navbar start-->
			<jsp:include page="AdminNavbar.jsp"></jsp:include>
		<!-- navbar end-->
		<h1 style="text-align: center; margin-bottom: 15px; margin-top: 10px; color: green">Welcome admin</h1>
</body>
</html>