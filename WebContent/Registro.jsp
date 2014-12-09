
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>CompuCom.com</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if lte IE 6]>
		<style type="text/css" media="screen">
			.tabbed { height:420px; }
		</style>
	<![endif]-->
	
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
	<script src="js/jquery.slide.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
	
</head>
<body>

<!-- Header -->
<div id="topFormularios">
<div class="shell">
		<div id="header">
			<h1 id="logo"><a href="#"></a></h1>
			<div id="navigation">
				<ul id="sddm">
				<%if(session.getAttribute("DniUsuario")!= null)
					{%>
				<li>Hola <%=session.getAttribute("username")%>
				</li>
				
				<li><a href="CerrarSesion.jsp">Cerrar Sesion</a>
				</li>
				<%} %>
				 <%if(session.getAttribute("DniUsuario")== null)
					{%>
				 	 <li>
				    <a href="#" 
				        onmouseover="mopen('m2')" 
				        onmouseout="mclosetime()">Ingresar</a></li>
				        <div id="m2" onmouseover="mcancelclosetime()" 
				            onmouseout="mclosetime()" align="center">
							  <form action="LoginCheck.jsp" method="get" class="login">
							    <input type="text" name="dni" class="input-login" placeholder="Dni"  style="margin-bottom: 10px;"/>
							    <br/>
							    <input type="password" name="password" placeholder="Password" class="input-login"  style="margin-bottom: 15px;"/>
							    <br/>
							    <input type="submit" value="Login" class="login-submit"/>
							  </form>
				        </div>	      
				    <%} %>
				    <li class="last"><a href="Index.jsp">Home</a></li>
				</ul>
				</div>		
			
				<div style="clear:both"></div>
			
		</div>
		<!-- End Header -->
        <div id="tituloPagina"> Alta de Nuevo Usuario</div>
	</div>
</div><!-- End top -->
		
		<!-- Content -->
        <div id="main">
        
        <div id="content">
        
 		

    <form method="post"  name="Registro" onsubmit="return validar()" action="RegisterCheck.jsp">
      <table align="center">
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Nombre:</td>
          <td><input class="inputTabla" name="nombre" type="text" id="nombre" value="" size="32" /></td>
          <td>
          
          </td>
        </tr>
        <tr valign="baseline">
        
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Apellido:</td>
          <td><input class="inputTabla" name="apellido" type="text" id="apellido" value="" size="32" /></td>
        </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Dni:</td>
          <td><input class="inputTabla" name="dni" type="text" id="dni" value="" size="32" /></td>
          <td>Sin puntos intermedios
          </td>
        </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Direccion:</td>
          <td><input name="direccion" class="inputTabla" type="text" id="direccion" value="" size="32" /></td>
        </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Email:</td>
          <td><input  name="email" class="inputTabla" type="text" id="email" value="" size="32" /></td>
        </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Direccion de envíos:</td>
          <td><input name="direnvios" class="inputTabla"  type="text" id="direnvios" value="" size="32" /></td>
        </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Localidad:</td>
          <td><input name="localidad" class="inputTabla" type="text" id="localidad" value="" size="32" /></td>
          </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Edad:</td>
          <td><input name="edad" class="inputTabla" type="text" id="edad" value="" size="32" /></td>
          <td>2 dígitos
          </td>
          </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Contraseña:</td>
          <td><input name="password" class="inputTabla" type="password" id="contraseña" value="" size="32" /></td>
          <td>Mínimo 7 caracteres
          </td>
          </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Confirma contraseña:</td>
          <td><input name="passwordconfirm" class="inputTabla" type="password" id="passwordconfirm" value="" size="32" /></td>
          </tr>
        <tr valign="baseline">
          <td nowrap="nowrap" align="right">&nbsp;</td>
          <td><input type="submit" align="middle" class="login-submit-formulario"  name="alta" value="Darme de alta" /></td>
        </tr>
        <input type="hidden" name="dniconfirm" id="dniconfirm">
      </table>
     
    </form>

      
       </div>
        
        <!-- End Content -->
        </div>
        
        <!-- End shell -->
   

		<div id="footer">
					<div class="left">
						<a href="#">Home</a>
						<span>|</span>
						<a href="#">Support</a>
						<span>|</span>
						<a href="#">My Account</a>
						<span>|</span>
						<a href="#">The Store</a>
						<span>|</span>
						<a href="#">Contact</a>
					</div>
					<div class="right">
						&copy; Sitename.com. Design by <a href="http://chocotemplates.com" target="_blank" title="CSS Templates">ChocoTemplates.com</a>
					</div>
	  </div>
	<!-- End footer -->

 
 


<script type="text/javascript">
function validarEntero(valor)
{ 
     	//intento convertir a entero. 
     //si era un entero no le afecta, si no lo era lo intenta convertir 
     valor = parseInt(valor); 

     	//Compruebo si es un valor numérico 
     	if (isNaN(valor)) 
{ 
           	 //entonces (no es numero) devuelvo el valor cadena vacia 
           	 return ""; 
     }
else{ 
           	 //En caso contrario (Si era un número) devuelvo el valor 
           	 return valor; 
     	} 
}
</script>

<script type="text/javascript">
// Copyright 2006-2007 javascript-array.com

var timeout	= 500;
var closetimer	= 0;
var ddmenuitem	= 0;

// open hidden layer
function mopen(id)
{	
// cancel close timer
mcancelclosetime();

// close old layer
if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

// get new layer and show it
ddmenuitem = document.getElementById(id);
ddmenuitem.style.visibility = 'visible';

}
// close showed layer
function mclose()
{
if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}

// go close timer
function mclosetime()
{
closetimer = window.setTimeout(mclose, timeout);
}

// cancel close timer
function mcancelclosetime()
{
if(closetimer)
{
window.clearTimeout(closetimer);
closetimer = null;
}
}


function valida_envia()
{ 
	
   	//valido el nombre 
    var bien = true;
   	var errores = "";
   	if (document.getElementById("dni").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir su dni"; 
      	    
      	 bien =false; 
      	 
   	} 

   	if (document.Registro.password.value.length==0)
   	{ 
   		errores+="\n Tiene que escribir su password"; 
      	 
      	 bien=false; 
   	}
	if (document.Registro.passwordconfirm.value.length==0)
   	{ 
      	 errores+="\n Tiene que escribir su confirmacion de password"; 
      	
      	 bien= false; 
   	} 
	if (document.Registro.nombre.value.length==0)
   	{ 
      	 errores+="\n Tiene que escribir su nombre"; 
      	// document.Registro.nombre.focus(); 
      	 bien= false; 
   	} 
	if (document.Registro.apellido.value.length==0)
   	{ 
      	 errores+="\n Tiene que escribir su Apellido"; 
      	 //document.Registro.apellido.focus(); 
      	 bien= false; 
   	} 
	if (document.Registro.direccion.value.length==0)
   	{ 
      	 errores+= "\n Tiene que escribir su Direccion"; 
      	 //document.Registro.direccion.focus(); 
      	 bien= false; 
   	} 
	if (document.Registro.direnvios.value.length==0)
   	{ 
      	 errores+= "\n Tiene que escribir su Direccion de envios"; 
      	 //document.Registro.direnvios.focus(); 
      	 bien= false; 
   	} 
	if (document.Registro.localidad.value.length==0)
   	{ 
      	 errores+="\n Tiene que escribir su Localidad"; 
      	 //document.fvalida.localidad.focus(); 
      	 bien= false; 
   	} 
	if (document.Registro.edad.value.length==0)
   	{ 
      	 errores+="\n Tiene que escribir su Edad"; 
      	 //document.Registro.edad.focus(); 
      	 bien= false; 
   	} 
	if (document.Registro.email.value.length==0)
   	{ 
      	errores+="\n Tiene que escribir su email"; 
      	 //document.Registro.email.focus(); 
      	 bien= false; 
   	}
	if(!validarEmail( document.Registro.email.value))
		{
		errores+="\n Direccion email incorrecta";
		bien= false;
		}
   	//valido la edad. tiene que ser entero mayor que 18 
   	
   edad = document.Registro.edad.value; 
   	edad = validarEntero(edad) ;
   	document.Registro.edad.value=edad; 
   	if (edad=="")
   	{ 
      	 errores+="\n Tiene que introducir un número entero en su edad"; 
      //	document.Registro.edad.focus() ;
       bien= false; 
   	}else if (edad<18){ 
         	 errores+="\n Debe ser mayor de 18 años."; 
         	 document.Registro.edad.focus(); 
         	 bien= false; 
      	 } 
  	

	if(bien) 
		{
		errores+="Muchas gracias por Registrarse";
		}

   	//el formulario se envia 
   	alert(errores); 
    if(bien)
    	{
 //  	document.Registro.submit();
	return true;
		}
    else
    	{return false;}
   
}
</script>


<script type="text/javascript">
				
	function validarEmail( email ) 
	{
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!expr.test(email))
    	{
        return false;
    	}
    else
    	{
    	return true;
    	}
	}
</script>

<script type="text/javascript">
				
				$(document).ready(function() {
					$('#dni').change(function(event) {
						
						var dni = $('#dni').val();
					      $.ajax({
							    type: "POST",
							    url: "BusquedaRegistro",
							    data: {'dni':dni},
							    success: function(a) {
						                $('#results').html(a);
						                
						                
						                var b = $.trim(a);
						                if(b == 'No')
						                	{
						                	   	$('#dniconfirm').val("No");
						                	
						                	}
						                else
						                	{
						                	
						                	$('#dniconfirm').val("Yes");
						                	}
							    }
						       });
					});
				});
				</script>
				<script type="text/javascript">
				function validadni()
				{ 
					
					if (document.getElementById('dniconfirm').value == "No")
						{
						 alert("Tiene Ese Dni ya esta en uso");
						return false;
						}
					else
						{
						return true;
						}
				}
				</script>

<script type="text/javascript">
				function validar()
				{
					if(validadni() && valida_envia())
						{
						return true;
						}
					else
						{
						return false;
						}
				
}
				</script>
				</body>
			
</html>