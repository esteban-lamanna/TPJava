<%@page import="Controlador.Controlador_encar"%>
<%@page import="java.util.regex.*"%>
<%@page import="Servlets.Validador"%>
<%@page import="Servlets.Products"%>
<%@page import="Modelo.Producto"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>

	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/Register.css" type="text/css" media="all" />
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.slide.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <script src="js/modifprod.js"></script>

	<title>CompuCom.com</title>
	

	
    
 <script type="text/javascript">
				$(document).ready(function() {
				debugger;
					var cate=document.getElementById('categ').value;
					var cod=document.getElementById('codigo').value;
					if(cod>0 && cate!="")
						{
					$.ajax({
					
							    type: "POST",
							    url: "ShowModifs",
							    data : 'categ='+cate+'&codi='+cod,
							      success: function(a) 
							      	{   
							    	  $('#resultinput').html(a); 	},
							    	  error:function(e)
							    	  {
							    		  $("#resultinput").val("Ha habido un error");
							    	  },
					
						       });
						}
				});
						
					
					
</script>

</head>
<body>
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
				  	<%
				  	} 
				
				
				if(session.getAttribute("username")== null)
					{response.sendRedirect("Login.jsp");
					
					}
					%>
				     <li class="last"><a href="MasterMenu.jsp">Home</a></li>
				</ul>
						
			
				<div style="clear:both"></div>
			</div>
			    </div>
			    	</div>
</div>
<!-- Header -->

	
	<div id="main" >
       <div class="shell">
       <div class="options"></div>
       	<div id="content">


			
    <form method="post"  name="Modifprod" onsubmit="return validar()"  class="dark-matter" action="ModificarProd" >
    
    <h1>Modificación de producto</h1>  
    
	       
						<label>
				        	<span>Categoría:</span> 
				 
			 <input id="categ" name="categ" type="text" value="<%=request.getParameter("categ")%>" readonly="readonly" />
		
		
						</label>          
	        
	      
          <label>  
				<span>Codigo:
				</span> 
				
				<input name="codigo" class="inputTabla" type="text" id="codigo" value="<%=request.getParameter("codigoseleccionado")%>" size="32" readonly="readonly" />
				
				
		</label>     
        
          <p name="resultinput" id="resultinput"> </p>
          
        
         <input type="submit" align="middle" class="login-submit-formulario" name="modifprod" id="modifprod" value="Modificar producto" />
        
    
      <% if(session.getAttribute("confirm")!="bien" && session.getAttribute("confirm")!=null)
{session.setAttribute("confirm",null);
%>
<script> alert("El producto no se pudo modificar.");location.href="MasterMenu.jsp";</script>
<%
}
      else
      {	if(session.getAttribute("confirm")=="bien")
      	{
      	session.setAttribute("confirm",null);
      	session.setAttribute("modificarProducto",null);
      	%>
      	<script>
      	$("#content").css('opacity') == '90%';
      	alert("PRODUCTO MODIFICADO CORRECTAMENTE");
      	location.href="MasterMenu.jsp";
      	</script>
      	<% 
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
</div>
</div>

 
				</body>
			
</html>