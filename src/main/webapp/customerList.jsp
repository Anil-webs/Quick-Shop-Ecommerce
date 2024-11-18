<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList,com.model.RegisterModel" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>CustomerList</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<a href="Admin.jsp">Home</a>
		<div class="container">
		<h2>Customers List</h2>
		<table class="table table-bordered">
			<thead class="thead-light">
				<th>FirstName</th>
				<th>UserName</th>

				<%
				ArrayList<RegisterModel> customerDetails = (ArrayList<RegisterModel>) session.getAttribute("data");
				%>
				<%
				for (int i = 0; i < customerDetails.size(); i++) {
					RegisterModel data = customerDetails.get(i);
				%>

				<tr>
					<td><%=data.getFirstname()%></td>
					<td><%=data.getUsername()%></td>
				</tr>
				<%
				}
				%>
			</thead>
		</table>
		</div>
	</body>
</html>