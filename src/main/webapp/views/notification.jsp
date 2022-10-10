<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notification</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="views/style.css">
</head>
<body>

	<%@include file="navbar.jsp"%>


	<c:forEach items="${requests }" var="req">
		<div class="card" style="width: 20rem">
			<img class="card-img-top"
				src="<c:url value="/images/profilepic/${req.senderid.profilePic }"/>"
				alt="Card image cap">
			<div class="card-body">
				<p class="card-text">Name : ${req.senderid.name}</p>
				<p class="card-text">Username : ${req.senderid.username}</p>
				<form>
					<input type="hidden" name="id" value=${req.id }> <input
						type="text" name="userid" value=${req.recieverid }> <input
						type="hidden" name="followerid" value=${req.senderid.uid }>
					<input type="hidden" name="followingid" value=${req.recieverid }>
					<input type="text" name="useridfollowing"
						value=${req.senderid.uid }>
					<button id="acceptrequest" type="submit" formaction="notification"
						formmethod="post">Accept Follow Request</button>
					<button id="declinerequest" type="submit"
						formaction="declinerequest" formmethod="post">Decline
						Request</button>
				</form>
			</div>
		</div>

	</c:forEach>

</body>
</html>