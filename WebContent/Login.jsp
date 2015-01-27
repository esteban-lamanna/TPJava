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

<script type="text/javascript">


//Funcion para validar Enteros
function validarEntero(valor)
{ 
     //intento convertir a entero. 
     //si era un entero no le afecta, si no lo era lo intenta convertir 
     valor = parseInt(valor); 

     	//Compruebo si es un valor numérico 
     	if (isNaN(valor)) 
		{ 
           	 //entonces (no es numero) devuelvo false 
           	 return false; 
     	}
		else{ 
           	 //En caso contrario (Si era un número) devuelvo el valor 
           	 return true; 
     		} 
}

//Funcion para validar Logueo
function validarLogin(dni, pass)
{ 
	 $.ajax({
		    type: "GET",
		    url: "LoginCheck",
		    async: false,
		    data: {'dni':dni, 'password':pass},
		    success: function (result){ $('#dniValidacion').val(result);},
   });
}

//Funcion para validar PASSWORD
function validarPass(pass)
{
	 $.ajax({
			type: "POST",
		    url: "Validador",
		    async: false,
		    data: {'pass':pass},
		    success: function (result){ $('#passValidacion').val(result);},
 });}

function validarEnvio(){ 
	$('#divMensaje').empty();
	var bandera=true;
	var error="<ul>";
	
   	//valido longitud DNI 
   	var dni=$('#dni').val().trim();
   	if (dni.length<1)
   	{ 
      	 error=error+"<li>Tiene que escribir su dni</li>";
      	 bandera=false; 
   	}
   	else{
   		//Valido que DNI sea entero
   		res = validarEntero(dni);
	   	if (!res)
	   	{ 
	       error=error+"<li>Tiene que introducir un número entero en su dni</li>"; 
	       bandera=false; 
	   	}
   	}

  	//valido longitud PASSWORD 
  	var pass = $("#password").val().trim();
   	if (pass.length<1)
   	{ 
      	error=error+"<li>Tiene que escribir su password</li>"; 
      	bandera=false; 
   	}
   	else
   	{
   	  	//Valido existencia PASSWORD
   		validarPass(pass);
   	   	var contra = $('#passValidacion').val();
   		if(contra == 'false')
   		{
   			
   			 error=error+"<li>Debe ingresar una contraseña sin caracteres especiales y de más de 6 caracteres</li>";
   			 bandera=false;
   		}
   	}
  	
	if(error == "<ul>")
   	{
		validarLogin(dni, pass);
		var respuesta=$('#dniValidacion').val();
		if(respuesta == 'false')
		{
			error=error + "<li>DNI y/o Contraseña incorrectos</li>";
			bandera=false;
		}
   	}
	
	if(bandera == true)
   	{
   		return true;
   	}
   	else
	{
   		error=error+"</ul>";
   		$('#divMensaje').show();
   		$('#divMensaje').append(error);
   		return false;
	}
  	
}
</script>
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
			  <h1>Login<input type="text" id="dniValidacion" style="display: none;" ><input type="text" id="passValidacion" style="display: none;"></h1>
			  <p>
			  	<div class="error" style="display: none; background-image: none;" id="divMensaje"></div>
			    <label>
				  <span>Dni: </span> <input type="text" id="dni" name="dni" >
				</label>
				
			    <label>
				   <span>Contraseña: </span> <input type="password" id="password" name="password">
				</label>
				
			    <input type="submit" onclick="return validarEnvio()" value="Login" >
			    
			  </p>
			  </form>
			  <br>
       		  <br>
	     </div>
	   </div>
 	 </div>
 	 
</body>


</html>

