<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored = "false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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

 <c:forEach items="${Allposts }" var="post" >
<div class= "card" style="width: 70rem">
<p> <img width="25" height="25" src="<c:url value="/images/profilepic/${post.userId.profilePic }"/> ">  ${post.userId.name }
  <img class="card-img-top" src="<c:url value="/images/posts/${post.postpic }"/>" alt="Card image cap">
  <div class="card-body">
  <form>
  <input type= "hidden" name = "postId" value = ${post.postId }>
  <input type= "hidden" name = "userId" value = ${uid }>

  <button id = "like" type="submit" formaction="/home/like" formmethod="post">Like</button>
  </form>

  

      
      
       <form  action="/home/comment" method="post">
    <div class="form-group row">   
    <label for="inputPassword3" class="col-sm-3col-form-label">Comment :</label>

    <input class = "simpleinput" type="text" name="postComment" placeholder = "enter comment" />
      <input type= "hidden" name = "postId" value = ${post.postId }>
  <input type= "hidden" name = "userId" value = ${uid }>
   <input  type="submit" value = "Post"/>
    </div>
    <br>
   
  
</form>

<form >
  <input type= "hidden" name = "postId" value = ${post.postId }>
   <button id = "like" type="button" formaction="/home" formmethod="get" data-toggle="modal" data-target="#getLikes">View Likes</button>
<div class="modal fade" id="getLikes" tabindex="-1" role="dialog" aria-labelledby="getLikes" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Liked By:</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <table class="table table-bordered table-sm mt-2">
   
    <tbody>
      <c:forEach var="like" items="${Likes }">
      <c:if test= "${like.postId.postId eq post.postId}" >  
                <tr>
                    <td><c:out value=" ${like.userId.name }" /></td>             
                </tr>
               </c:if>   
            </c:forEach>
    </tbody>
  </table>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>

</div>
</form>

    

<form >
  <input type= "hidden" name = "postId" value = "${post.postId }">
   <label>View Comments : </label>
         <table class="table table-bordered table-sm mt-2">
   	
   		
    <tbody>
      <c:forEach var="comments" items="${Comments }">
      <c:set var = "postid" scope = "session" value = "${post.postId}"/>
  	<c:set var = "postidcomm" scope = "session" value ="${comments.postId.postId}"/>
    
    
     <c:if test= "${comments.postId.postId eq post.postId}" >  
      
  
                <tr>
                    <td><c:out value=" ${comments.userId.name }" /></td>   
                     <td><c:out value=" ${comments.postComment }" /></td>            
                </tr>
             </c:if>
            </c:forEach>
            

    </tbody>
  </table>

</form>
 

 
 
  </div>
<p> 
</div>
       
</c:forEach>

</body>
</html>