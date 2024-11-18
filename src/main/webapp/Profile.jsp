<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList,com.model.RegisterModel" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<title>Profile</title>
		<style>
			.table-position{
				padding-top: 10%;
			}
		</style>
	</head>
	<body>
		<!-- navbar start-->
			<jsp:include page="Navbar.jsp"></jsp:include>
		<!-- navbar end-->
		<div class="container table-position">
			<div class="row">
					<table class="table table-bordered">
						<thead class="thead-light">
							<th>FirstName</th>
							<th>UserName</th>
							<th>Password</th>
							<th>Edit</th>
	
							<%
								ArrayList<RegisterModel> data = (ArrayList<RegisterModel>) session.getAttribute("customerData");
							%>
							<%
								for (int i = 0; i < data.size(); i++) {
									RegisterModel getData = data.get(i);
							%>
							<tr>
								<td><%=getData.getFirstname()%></td>
								<td><%=getData.getUsername()%></td>
								<td><%=getData.getPassword()%></td>
								<td><a href="EditCustProfile.jsp"> <i
										class="fa-solid fa-pen"></i>
								</a></td>
							</tr>
							<%
								}
							%>
						</thead>
					</table>
			</div>
		</div>
	</body>
</html>