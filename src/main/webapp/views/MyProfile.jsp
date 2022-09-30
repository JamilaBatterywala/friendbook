<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored = "false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
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

<div class="container">
  <div class="row">
    <div class="col-sm">
     <img class = profilepic alt = "profilepic" width="200" height="200" src="<c:url value="/images/profilepic/${profilepic }"/>"/>
    </div>
    <div class="col-sm">
    <h4>
      ${name }
    </h4>
    <br>
    Fav Songs : ${favSongs}
    <br>
    Fav Books: ${favBooks }
    <br>
    Fav Places: ${favPlaces }
    <br>
  
    </div>
    <div class="col-sm">
    <br>
    <br>
    <button  data-toggle="modal" data-target="#exampleModal">
  Update Profile
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update Your Profile Here</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      
       <form  action="/MyProfile" method="post"
    enctype="multipart/form-data">
    <div>   
    <label>Upload Profile picture </label>
    <input class = "simpleinput" type="file" name="profile_pic"  />
     <input type= "hidden" name ="username" value = ${username }/>
    </div>
    <br>
  

<div>

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Fav Books:</label>
    <input type = "hidden" name ="uid" value = ${uid }> 
    <div class="col-sm-10">
      <input  type="text" class="form-control" name = "favBooks" placeholder="Books Name" value = ${favBooks }>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Fav Songs:</label>
    <div class="col-sm-10">
      <input  type="text" class="form-control" name = "favSongs" placeholder="Songs Name" value = ${favSongs }>
    </div>
  </div>
   <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Fav Places:</label>
    <div class="col-sm-10">
      <input   type="text" class="form-control" name = "favPlaces" placeholder="Places Name" value = ${favPlaces }>
    </div>
  </div>

  

 <div class="form-group row">
    <div class="col-sm-10">
    <button id = "signUp" type="submit" formaction="/MyProfile" formmethod="post">Update </button>
     
    </div>
    </div>
    </form>
    </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
    </div>
  </div>
</div>
<div class="container">
	  <div class="row">
  <!-- Button trigger modal -->
<button type="button"  style = "margin-left: 480px" class="btn btn-primary" data-toggle="modal" data-target="#followingmodal">
Followers
</button>

<!-- Modal -->
<div class="modal fade" id="followingmodal" tabindex="-1" role="dialog" aria-labelledby="followingmodal" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Followers</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-sm mt-2">
    <tbody>
      <c:forEach var="follower" items="${follower }">
                <tr>
                    <td><c:out value=" ${follower.followerid.name}" /></td>             
                </tr>
            </c:forEach>
    </tbody>
  </table>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
  
  


<button type="button" class="btn btn-primary" style = "margin-left: 60px"  data-toggle="modal" data-target="#followermodal">
Following
</button>

<!-- Modal -->
<div class="modal fade" id="followermodal" tabindex="-1" role="dialog" aria-labelledby="followermodal" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Following</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <table class="table table-bordered table-sm mt-2">
   
    <tbody>
      <c:forEach var="followings" items="${followings }">
                <tr>
                    <td><c:out value=" ${followings.followingid.name }" /></td>             
                </tr>
            </c:forEach>
    </tbody>
  </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>

</div>
  </div>   
  </div> 
  
      <div class="col-sm">
    <br>
    <br>
    <button style = "margin-left: 700px" data-toggle="modal" data-target="#uploadpost">
  Upload Post
</button>

<!-- Modal -->
<div class="modal fade" id="uploadpost" tabindex="-1" role="dialog" aria-labelledby="uploadpost" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Upload post</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      
       <form  action="/UploadPost" method="post"
    enctype="multipart/form-data">
    <div>   
    <label>Upload Post </label>
    <input class = "simpleinput" type="file" name="postpic"  />
     <input type= "hidden" name ="userid" value = ${uid }/>
      
    </div>
    <br>
    <button type = "submit"> Upload</button>
  
</form>
<div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
    </div>  
    
    <c:forEach items="${posts }" var="post" >
<div class= "card" style="width: 70rem">
<p> <img width="25" height="25" src="<c:url value="/images/profilepic/${post.userId.profilePic }"/> ">  ${post.userId.name }
  <img class="card-img-top" src="<c:url value="/images/posts/${post.postpic }"/>" alt="Card image cap">
  <div class="card-body">
   <button>Like</button>
   <button>Comment</button>
  </div>
</div>

</c:forEach>                     

</body>
</html>