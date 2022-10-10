<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored = "false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="views/style.css">
</head>
<body>
<%@include file = "navbar.jsp" %>

		<c:if test= "${list = null}">
			${message}
		</c:if>
	      <c:forEach var="user" items="${list}">
      <div class= "card" style="width: 20rem">
  <img class="card-img-top" src="<c:url value="/images/profilepic/${user.profilePic }"/>" alt="Card image cap">
  <div class="card-body">
    <p class="card-text">Name : ${user.name}</p>
    <p class="card-text">Username : ${user.username}</p>
   <form>
                <input type = "hidden" name = "senderid" value = ${uid }>
                <input type = "hidden" name = "recieverid" value = ${user.uid }>
                    <button id = "sendRequest" type="submit" formaction="search" formmethod="post">Send Follow Request </button>
                    </form>  
   </div>
</div>               
            </c:forEach>
  
<script type="text/javascript">
document.getElementById("sendRequest").addEventListener("click", myFunction);

function myFunction() {
  document.getElementById("sendRequest").innerHTML = "REQUEST SENT";
}

document.getElementById("sendRequest").onclick = function() {
    //disable
    this.disabled = true;
 
   
    
    

</script>
</body>
</html>