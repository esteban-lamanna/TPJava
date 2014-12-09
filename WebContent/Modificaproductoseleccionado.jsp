    <%@page import="Controlador.Controlador_encar"%>
<%@page import="java.util.regex.*"%>
<%@page import="Servlets.Validador"%>
<%@page import="Servlets.Products"%>
<%@page import="Modelo.Producto"%>


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
	<script src="js/modifprod.js" type="text/javascript"></script>
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
	<script src="js/jquery.slide.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    
 <script type="text/javascript">
				$(document).ready(function() {
				
					var cate=document.getElementById('categoria').value;
					var cod=document.getElementById('codigo').value;
					
					$.ajax({
					
							    type: "POST",
							    url: "ShowModifs",
							    data : 'categ='+cate+'&codi='+cod,
							      success: function(a) 
							      	{   $('#resultinput').html(a); 	}
						       });});	
					
				
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
        <div id="tituloPagina"> Modificación de  Producto</div>
        <div>
        </div>
	</div>
</div><!-- End top -->
		
		<!-- Content -->
        <div id="main">
        
        <div id="content">
        
 		

    <form method="post"  name="Modifprod" onsubmit="return validar()" action="ModificarProd.jsp" >
      <table align="center" style="height: 353px; ">
         <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Categoria:</td>
          <td><input name="categoria" class="inputTabla" type="text" id="categoria" value="<%=request.getParameter("categ")%>" size="32" readonly="readonly"  /></td>
         
        </tr>
        
        <tr valign="baseline">
          <td nowrap="nowrap" class="etiquetaTabla" align="right">Codigo:</td>
          <td><input name="codigo" class="inputTabla" type="text" id="codigo" value="<%=request.getParameter("codigoseleccionado")%>" size="32" readonly="readonly" /></td>
         
        </tr>
                 
         <tr valign="baseline">
                 
          <td /><p name="resultinput" id="resultinput"> </p></td>
        </tr>
        
         <td><input type="submit" align="middle" class="login-submit-formulario" name="modifprod" id="modifprod" value="Modificar producto" /></td>
      
      </table>
     
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