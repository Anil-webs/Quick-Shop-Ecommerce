<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		
		<style>
			.ic{
				color: red;
			}
		</style>
	</head>
	<body>
		<h1 style="text-align: center; margin-bottom: 15px; margin-top: 10px; color: green">Login Page</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<div class="form-group">
						<form name="shopLogin" method="post" onsubmit="return display()" action="login">
							<label>UserName:</label>
							<input type="text" name="username" id="username" placeholder="USER NAME" class="form-control" onblur="userName()">
							<p id="userPara"><p>
							
							<label>Password:</label>
							<input type="password" name="psw" id="psw" placeholder="PASSWORD" class="form-control" onblur="password()">
							<p id="pswPara"><p>
							
							<input type="radio" id="Admin" name="Radio" value="Admin">
							<label for="Admin">Admin</label>
							<input type="radio" id="Customer" name="Radio" value="Customer">
							<label for="Customer">Customer</label>
							<p class="ic"> <% if(request.getAttribute("invalid")!= null){ out.println(request.getAttribute("invalid"));} %> </p>
							<button type="submit" class="btn btn-primary">Login</button>
							<p>Don't have an account? <a href="Register.jsp">Register</a></p>
						</form>
					</div>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<script>
		function userName(){
			var userName = document.getElementById("username").value;
			if(userName == ""){
				document.getElementById("userPara").innerHTML = "Enter UserName";
				document.getElementById("userPara").style.color = "red";
				return false;
			}else{
				document.getElementById("userPara").innerHTML = "";
				return true;
			}
		}
		function password(){
			var password = document.getElementById("psw").value;
			if(password == ""){
				document.getElementById("pswPara").innerHTML = "Enter Password";
				document.getElementById("pswPara").style.color = "red";
				return false;
			}else{
				document.getElementById("pswPara").innerHTML = "";
				return true;
			}
		}
		function display(){
			var isUsername = userName();
			var isPassword = password();
			
			return isUsername && isPassword;
		}
		</script>
	</body>
</html>

	