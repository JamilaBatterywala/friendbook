<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link rel="stylesheet" href="views/style.css">
</head>
<body>
<div class = "Registration">
<form id="LoginForm" >
  <label>
    <p class="label-txt">ENTER YOUR EMAIL</p>
    <input type="text" id = "email" name = "email" class="input">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR PASSWORD</p>
    <input type="password" id = "password" name = "password"class="input">
    <div class="line-box">
      <div class="line"></div>
    </div>
    
     
     </label>
    
  <button id = "Login" type="submit" formaction="/home" formmethod="post">Login</button>
  <br>
  <br>
 
  <p>New user ? 

</form>
 <a class="nav-link" href = "Registration">
  Click here to register
        <span class="sr-only">(current)</span></a>
  


</div>

<script type="text/javascript">
$(document).ready(function(){
    $('#Login').click(function()
    {   
       var user=$('#email').val();
       var pwd=$('#password').val();
       $.ajax({
            type: "POST",
            url:"login",
            data:{"email":user,"password":pwd},
            success: function (data) {
               if(data=='True'){
                 $(location).attr('href','home.jsp');
               }else{
                   alert('Please enter right credentials');
               }
            }
          });                                
        });
      });

</script>


</body>
</html>