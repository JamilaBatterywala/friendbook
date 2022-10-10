<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored = "false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Friends-Book</a>
    </div>
    <ul class="navbar-nav mr-auto">
     <li class="nav-item active">
        <a class="nav-link" href = "MyProfile">
         <img class = profilepic alt = "profilepic" width="25" height="25" src="<c:url value="/images/icons/myprofileicon.png"/>"/>
        <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href = "home" >
         <img class = profilepic alt = "profilepic" width="25" height="25" src="<c:url value="/images/icons/homeicon.jpg"/>"/>
         <span class="sr-only">(current)</span></a>
      </li>
     <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" name = "username" placeholder="Search" label="Search">
      <button  formmethod="get" formaction="/search" type="submit">
	<img class = profilepic alt = "profilepic" width="25" height="25" src="<c:url value="/images/icons/searchicon.jpg"/>"/>

	</button>
    </form>
       <li class="nav-item active">
        <a class="nav-link" href = "notification" >
			 <img class = profilepic alt = "notification" width="25" height="25" src="<c:url value="/images/icons/notificationicon.png"/>"/>
		 <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="nav-item active">
        <a class="nav-link" href="#">
        	<img class = profilepic alt = "profilepic" width="25" height="25" src="<c:url value="/images/profilepic/${profilepic }"/>"/>
         <span class="sr-only">(current)</span></a>
      </li>
      
     <li class="nav-item active">
        <a class="nav-link" href="#">Username : ${username } <span class="sr-only">(current)</span></a>
      </li>
      <form>
       <li class="nav-item active">
        <button  formmethod="get" formaction="/logout" type="submit">
        Logout
        </button>
        
      </li>
      </form>
      
       
    </ul>
  </div>
</nav>