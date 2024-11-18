<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#username").blur(function(){
					var uname = $("#username").val();
					if(uname == "")
						{
							$("#userPara").text("Empty space is allowed!!").css({"color":"red"})
						}
					else
						{
						
						
					$.get('fieldCheck',
							{username: uname},
							function(info){
								if(info.includes("You can go forhead this username")){
									$("#userPara").text(info).css({"color":"green"})
								}else{
									$("#userPara").text(info).css({"color":"red"})
								}
								
						});
						}
				});
			});
		</script>
	</head>
	<body>
		<h1 style="text-align: center; margin-bottom: 15px; margin-top: 10px; color: green">Register Page</h1>
		<div class="container">
			<div class="row">
			<div class="col-md-4"></div>
				<div class="col-md-4">
					<div class="form-group">
						<form name="shopLogin" method="post" onsubmit="return display()" action="register">
							<label>FirstName:</label>
							<input type="text" name="firstname" id="firstname" placeholder=" NAME" class="form-control" onblur="fname()">
							<p id="fPara"><p>
							
							<label>UserName:</label>
							<input type="text" name="username" id="username" placeholder="USER NAME" class="form-control" onblur="userName()">
							<p id="userPara"><p>
							
							<label>Password:</label>
							<input type="password" name="psw" id="psw" placeholder="PASSWORD" class="form-control" onblur="password()">
							<p id="pswPara"><p>
							
							<label>Confirm Password:</label>
							<input type="password" name="Cpsw" id="Cpsw" placeholder="CONFIRM PASSWORD" class="form-control" onblur="Cpassword()">
							<p id="CpswPara"><p>
							
							<button type="submit" class="btn btn-primary">Register</button>
							<p>Do you have an account? <a href="login.jsp">Login</a></p>
						</form>
					</div>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<script>
			function fname(){
				var firstname = document.getElementById("firstname").value;
				if(firstname == ""){
					document.getElementById("fPara").innerHTML = "Enter First Name";
					document.getElementById("fPara").style.color = "red";
					return false;
				}else{
					document.getElementById("fPara").innerHTML = "";
					return true;
				}
			}
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
			function Cpassword(){
				var Password = document.getElementById("psw").value;
				var confirmPsw = document.getElementById("Cpsw").value;
				if(confirmPsw==""){
					document.getElementById("CpswPara").innerHTML="Enter confirm Password";
					document.getElementById("CpswPara").style.color = "red";
					return false;
				}
				else if(Password!=confirmPsw){
					document.getElementById("CpswPara").innerHTML="Passwords do not match";
					document.getElementById("CpswPara").style.color = "red";
					return false;
				}
				else{
					document.getElementById("CpswPara").innerHTML ="";
					return true;
				}
			}
			
			function display(){
				var isFirstname = fname();
				var isUsername = userName();
				var isPassword = password();
				var isCPassword = Cpassword();
				
				return isFirstname && isUsername && isPassword && isCPassword;
			}
		</script>
	</body>
</html>