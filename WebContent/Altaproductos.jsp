<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>CompuCom.com</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

	<link rel="stylesheet" href="css/Register.css" type="text/css" media="all" />
	<!--[if lte IE 6]>
		<style type="text/css" media="screen">
			.tabbed { height:420px; }
		</style>
	<![endif]-->
	<script src="js/altaprod.js" type="text/javascript"></script>	
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
	<script src="js/jquery.slide.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    
 <script type="text/javascript">
				$(document).ready(function() {
					$('#categoria').change(function(event){
					var cate=document.getElementById('categoria').options[document.getElementById('categoria').selectedIndex].value;		
					$.ajax({
					
							    type: "POST",
							    url: "ShowInputs",
							    data: {'categ':cate},
							      success: function(a) 
							      	{   $('#resultinput').html(a); 	}
						       });});});
		
</script>

</head>
<body>
  <!-- Top -->
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
				     <li class="last"><a href="#">Home</a></li>
				</ul>
						
			
				<div style="clear:both"></div>
			</div>
			    </div>
			    	</div>
</div>
       <div id="main" >
       <div class="shell">
       <div class="options" align="center"></div>
        
        <div id="content">       
    

    <form method="post" enctype="multipart/form-data" name="Registroprod" onsubmit="return validar()" class="dark-matter texto-form"  action="RegistroConUpload">

			<h1>Alta producto</h1>
		        	<p>
						<label>
				        	<span>Nombre del Producto:</span> <input type="text" id="nombreprod" name="nombreprod" >
						</label>
							<label>
				        	<span>Modelo:</span> <input type="text" id="modelo" name="modelo" >
						</label>
						<label>
				        	<span>Descripcion:</span> <input type="text" id="descripcion" name="descripcion" >
						</label>
					
						<label>
				        	<span>Precio:</span> <input type="text" id="precio" name="precio" >
						</label>
						<label>
				        	<span>Foto:</span> <input type="file" id="foto" name="foto" >
						</label>
						
						<label>
				        	<span>Seleccione una categoría:</span>  <select name="categoria" id="categoria" class="etiquetaTabla">
          <option value="def">Seleccione una opcion</option>
          <option value="gabinete">Gabinete</option>
          <option value="fuente">Fuentes</option>
          <option value="hd">HDD</option>
          <option value="memoria">Memorias Ram</option>
          <option value="micro">Microprocesadores</option>
          <option value="placamadre">Motherboards</option>
          <option value="pvideo">Placas de Video</option>
          <option value="red">Placas de Red</option>
          <option value="psonido">Placas de Sonido</option>
          <option value="rcable">Cable de Red</option>
          </select>
						</label>		
	</p>
	 <p type="text" id="resultinput" name="resultinput" ></p>
		             
     
      <% if(session.getAttribute("confirm")!="bien" && session.getAttribute("confirm")!=null )
{session.setAttribute("confirm",null);
	%><p><FONT FACE="arial" SIZE=9 COLOR=red>!!ERROR!! EL PRODUCTO INGRESADO YA EXISTE CON ESE NOMBRE Y ESE MODELO</FONT></p><%
}
else
{	if(session.getAttribute("confirm")=="bien")
	{
	session.setAttribute("confirm",null);
	%><div><FONT FACE="arial" SIZE=9 COLOR=red>PRODUCTO REGISTRADO CORRECTAMENTE</FONT></div><%
	}
 }%>
     <label>
				        	<span>&nbsp</span>
				        	<input type="button" value="Volver" onclick="location.href = 'Index.jsp' "> 
		
		<input type="submit" align="middle" class="login-submit-formulario" name="altaprod" value="Registrar producto" />
      
		</label>
    </form>  
      
      <!-- Formulario para subir las imagenes -->      
      
 
        </div>  <!-- End Content -->
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

 
				</body>
			
</html>