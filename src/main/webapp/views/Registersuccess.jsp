<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration success</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="views/style.css">
</head>
<body>
	<div class="d-flex justify-content-center">
		<div class=container>
			<div>${user.name} Registration Success</div>

			<div>Your username is ${user.username }</div>


		</div>



		<input id="textBox" type="hidden" name="text" class="input"
			value="${user.name}">
	</div>
	<div class="d-flex justify-content-center">
		<button onclick="document.location='/loginpage'">Login</button>
	</div>


	</script>

</body>
</html>