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
<title>Edicion Usuario Admin</title>
<script type="text/javascript">

function validarBusqueda()
{  
	var dni = $('#dni').val();
	      $.ajax({
			    type: "POST",
			    dataType: "json",
			    url: "BusquedaRegistro",
			    data: {'dni':dni},
			    success: function (result){
			    	if(result == false)
			    		{
			    			//alert('DNI VALIDO');
			    			return true;
			    		}
			    	else
			    		{
			    			alert('DNI INVALIDO');
			    			$('#dni').focus(); 
			    			return false;
			    		}
			    },
	      });
}
</script>
</head>
<body>
<div id="topFormularios">
<div id="topAdmin">
		<div class="shell">
	
				<!-- Header -->
				<div id="header" style="color: #ff0000">
					<h1 id="logo"><a href="#"></a></h1>
					<div id="navigation">
				<ul id="sddm">
				<%if(session.getAttribute("username")!= null)
					{
					if(session.getAttribute("EsAdmin").equals(0))
					{response.sendRedirect("Index.jsp");}
				%>
					<li><a href="EdicionUsuario.jsp"> Hola <%=session.getAttribute("username")%></a></li>
					<li><a href="CerrarSesion.jsp">Cerrar Sesion</a></li>
					
					
				  	<%} 
				
				if(session.getAttribute("username")== null)
					{response.sendRedirect("Login.jsp");
					
					}%>
					
				     <li class="last"><a href="MasterMenu.jsp">Home</a></li>
				</ul>
						
			
				<div style="clear:both"></div>
			</div>
			    </div>
			    	</div>
</div>
</div>
	    

	<div id="main" >
		 <div class="shell">
		 <div class="options"></div>
	       	   <div id="content">
							<form action="BusquedaEdicion" Method="post" class="dark-matter texto-form" >
								<h1>Busqueda Usuario</h1>
								<label>
									<span>DNI: </span><input type="text" name="dni" id="dni" /> 
								</label>
								<label>
						        	<input type="button" value="Volver" onclick="location.href = 'MasterMenu.jsp' "> 
						        	<input type="submit" onclick="return validarBusqueda();" value="Edicion Usuario" />
				        		</label>
								 
							</form>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
			  </div>
	    </div>
 	 </div>
</body>
</html>