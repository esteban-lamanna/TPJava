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

<title>Registro</title>


<script type="text/javascript">

//Funcion para validar DNI
function validarExistenciaDNI(dni)
{
	      $.ajax({
			    type: "POST",
			    url: "BusquedaRegistro",
			    data: {'dni':dni},
			    success: function (result){ return result;},
	      });
}

//Funcion para validar EMAIL
function validarEmail( email ) 
{
expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
if (expr.test(email))
	{
	return true;
	}
else
	{
    alert("Error: La dirección de correo " + email + " es incorrecta.");
    return false;
	}
}

//Funcion para validar EDAD
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
           	 return valor; 
     		} 
}


function validarEnvio(){ 
	
   	//valido longitud DNI 
   	var dni=$('#dni').val().trim();
   	var respuesta=validarExistenciaDNI(dni);
   	if (dni.length<1)
   	{ 
      	 alert("Tiene que escribir su dni");
      	 $('#dni').focus(); 
      	 return false;
   	}

   	//valido existencia DNI
   	if(respuesta==true)
   		{
   			alert("Tiene que ingresar otro DNI");
   			$('#dni').focus();
   			return false;
   		}
  	//valido longitud PASSWORD 
   	if ($('#password').val().trim().length<1)
   	{ 
      	alert("Tiene que escribir su password"); 
      	$('#password').focus(); 
      	return false; 
   	}
  	
  	//valido longitud PASSWORD CONFIRMATION
	if ($('#passwordconfirm').val().trim().length<1)
   	{ 
      	 alert("Tiene que escribir su confirmacion de password"); 
      	 $('#passwordconfirm').focus(); 
      	 return false; 
   	} 
  	
	//valido longitud NOMBRE
	if ($('#nombre').val().trim().length<1)
   	{ 
      	 alert("Tiene que escribir su nombre"); 
      	 $('#nombre').focus();  
      	 return false; 
   	} 
	
	//valido longitud APELLIDO
	if ($('#apellido').val().trim().length<1)
   	{ 
      	 alert("Tiene que escribir su Apellido"); 
      	 $('#apellido').focus(); 
      	 return false; 
   	} 
	
	//valido longitus DIRECCION
	if ($('#direccion').val().trim().length<1)
   	{ 
      	 alert("Tiene que escribir su Direccion"); 
      	 $('#direccion').focus(); 
      	 return false; 
   	} 
	
	//valido longitud DIRECCION ENVIOS
	if ($('#direnvios').val().trim().length<1)
   	{ 
      	 alert("Tiene que escribir su Direccion de envios"); 
      	 $('#direnvios').focus(); 
      	 return false; 
   	} 
	
	//valido longitud LOCALIDAD
	if ($('#localidad').val().trim().length<1)
   	{ 
      	 alert("Tiene que escribir su Localidad"); 
      	 $('#localidad').focus(); 
      	 return false; 
   	} 
	
	//valido longitud EDAD
	var edad = $('#edad').val().trim();
	if (edad.length<1)
   	{ 
      	 alert("Tiene que escribir su Edad"); 
      	 $('#edad').focus(); 
      	 return false; 
   	} 
	
    //valido EDAD entero mayor de 18
   	edad = validarEntero(edad);
   	if (edad!=false)
   	{ 
       alert("Tiene que introducir un número entero en su edad."); 
       $('#edad').focus();
       return false; 
   	}else
   	{ 
      	 if (edad<18){ 
         	 alert("Debe ser mayor de 18 años."); 
         	 $('#edad').focus(); 
         	 return false; 
      	 } 
  	} 
	
	//valido longitud EMAIL
	var email=$('#email').val().trim();
	if (email.length<1)
   	{ 
      	 alert("Tiene que escribir su email"); 
      	 $('#email').focus(); 
      	 return false; 
   	}
	
	//Valido el EMAIL
	if(validarEmail(email))
		{
			return true;
		}
	else
		{
			return false;
		}
    

   	//el formulario se envia 
   	alert("Muchas gracias por Registrarse"); 
  //Envio el fomrulario
   	return $('#Registro').submit();
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
		        <form id="Registro" class="dark-matter texto-form" action="RegisterCheck.jsp" method="post" >
		        	<h1>Registro</h1>
		        	<p>
						<label>
				        	<span>Dni: </span> <input type="text" id="dni" >
						</label>
						<label>
				        	<span>Contraseña: </span> <input type="password" id="password">
						</label>
						<label>
				            <span>Confirma contraseña: </span> <input type="password" id="passwordconfirm">
						</label>
						<label>
				            <span>Nombre: </span> <input type="text" id="nombre">
						</label>
						<label>
				            <span>Apellido: </span> <input type="text" id="apellido">
						</label>
						<label>
				            <span>Dirección: </span> <input type="text" id="direccion">
						</label>
						<label>
				            <span>Dirección de Envios: </span> <input type="text" id="direnvios">
						</label>
						<label>
				            <span>Localidad: </span> <input type="text" id="localidad">
						</label>
						<label>
				            <span>Edad: </span> <input type="text" id="edad">
						</label>
						<label>
				            <span>Mail: </span> <input type="text" id="email">
				        </label>
				        <label>
				        	<span>&nbsp</span>
				        	<input type="button" value="Volver" onclick="location.href = 'Index.jsp' "> 
				        	<input type="button" value="Registrarse" onclick="validarEnvio()">
				        	
				        </label>
				       </p> 
			     </form>
	        </div>
	    </div>
 	 </div>
 	 
</body>
</html>