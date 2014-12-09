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
    <script type="text/javascript">
    $(document).ready(function() {
   $('#categ').change(function(event){
					var cate=document.getElementById('categ').options[document.getElementById('categ').selectedIndex].value;
					switch(cate) 
					{
    case "gabinete":
     $.ajax({
						    type: "POST",
						    url: "Gabinetes",
						    success: function(a) {
					                $('#results').html(a);
						    }
					       });
   	
     break;
     
     case "fuente":
     
      $.ajax({
							    type: "POST",
							    url: "Fuentes",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
     
        break;
        
        case "hd":
       $.ajax({
							    type: "POST",
							    url: "HD",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        break;
        
        case "memoria":
        $.ajax({
							    type: "POST",
							    url: "Memorias",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
       
        break;
        
        case "micro":
        	$.ajax({
							    type: "POST",
							    url: "Micros",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        break;
        
        case "placamadre":
        $.ajax({
							    type: "POST",
							    url: "PlacasMadres",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
         break;
        
        case "pvideo":
       $.ajax({
							    type: "POST",
							    url: "PlacaVideo",
							    success: function(a) {
						                $('#results').html(a);
							    }
					});
   	
   		
        break;
        
        case "red":
        $.ajax({
							    type: "POST",
							    url: "PlacaRed",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
   	
        break;
        
        case "psonido":
        $.ajax({
							    type: "POST",
							    url: "PlacaSonido",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        
        break;
        
        case "rcable":
       $.ajax({
							    type: "POST",
							    url: "RedCable",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        break;
        
    default:
    	
    	break;
}
  });
						});
    </script>
    <script type="text/javascript">
   function agregar(codig)
				      {
					document.getElementById("codigoseleccionado").value = codig;
						    document.Mprod.submit(); 
				      }
 </script>
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
				

				    <li class="last"><a href="Index.jsp">Home</a></li>
				    <%} %>
				</ul>
				</div>		
			
				<div style="clear:both"></div>
			
		</div>
		<!-- End Header -->
        <div id="tituloPagina"> Modificación de Productos</div>
        <div>
        </div>
	</div>
</div><!-- End top -->
		
		<!-- Content -->
        <div id="main">
        
        <div id="content">
        
 		

    <form method="post"  name="Mprod" id="Mprod" onsubmit="return validar()" action="Modificaproductoseleccionado.jsp" >
      <table align="center" style="height: 353px; ">
        
       <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Categoria:</td>
          <td>
          <select name="categ" id="categ" class="etiquetaTabla">
          <option value="def">Seleccione una opcion</option>
          <option value="gabinete">Gabinete</option>
          <option value="fuente">Fuentes</option>
          <option value="hd">HDD</option>
          <option value="memoria">Memorias Ram</option>
          <option value="micro">Microprocesadores</option>
          <option value="placamadre">Motherboards</option>
          <option value="pvideo">Placas de Video</option>
          <option value="pred">Placas de Red</option>
          <option value="psonido">Placas de Sonido</option>
          <option value="rcable">Cable de Red</option>
          </select>
          </td>
          
          <input name="codigoseleccionado" id="codigoseleccionado" value="" type="hidden" />
          
        </tr>
          <tr valign="baseline">
          <p name="results" id="results"> </p>
        </tr>
         <td><input type="submit" align="middle" class="login-submit-formulario" name="modifprod" id="modifprod" value="Registrar producto" /></td>
      
      </table>
      <% if(session.getAttribute("confirm")=="mal")
{session.setAttribute("confirm",null);
	%><p><FONT FACE="arial" SIZE=9 COLOR=red>!!ERROR!! EL PRODUCTO NO SE HA PODIDO MODIFICAR YA QUE EXISTE OTRO PRODUCTO CON EL MISMO NOMBRE Y EL MISMO MODELO</FONT></p><%
}
else
{	if(session.getAttribute("confirm")=="bien")
	{
	session.setAttribute("confirm",null);
	%><div><FONT FACE="arial" SIZE=9 COLOR=red>PRODUCTO MODIFICADO CORRECTAMENTE</FONT></div><%
	}
 }%>
    </form>

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

 
				</body>
			
</html>