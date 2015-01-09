<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/Register.css" type="text/css" media="all" />
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.slide.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<title>LogIn</title>
</head>
 <body>
    <!-- Top -->
		
				<!-- Header -->
				<div id="header" style="color: #ff0000">
					<h1 id="logo"><a href="#"></a></h1>
			    </div>
       <div id="main" >
       <div class="shell">
       <div class="options"></div>
       	<div id="content">
       		  <br>
       		  <br>
       		  <br>
       		  <br>
			  <form action="LoginCheck" method="POST" class="dark-matter texto-form">
			  <h1>Login</h1>
			  <p>
			  	<div class="info">Mensaje de informacion que deseamos mostrar al usuario</div>
			    <label>
				  <span>Dni: </span> <input type="text" id="dni" name="dni" >
				</label>
				
			    <label>
				   <span>Contraseña: </span> <input type="password" id="password" name="password">
				</label>
				
			    <input type="submit" value="Login" >
			    
			  </p>
			  </form>
			  <br>
       		  <br>
	     </div>
	   </div>
 	 </div>
 	 
</body>


</html>

