<%@page import="Controlador.Controlador_encar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Modelo.Producto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<--! <link rel="stylesheet" href="css/Register.css" type="text/css" media="all" />-->
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.slide.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>

<title>Mi carrito</title>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
	    type: "POST",
	    url: "MiCarro",
	    data: {"dni",<%session.getAttribute("dni");%>}
	    success: function(a) {
            $('#contenido').html(a);
    }
	});
})

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
       	
		
   		<%
   		Controlador_encar controler = new Controlador_encar();
   		
   		for(int i =0; i<controler.levantaCarro().size();i++){ 
   		
   		Producto pro = new Producto();
   		pro = controler.levantaCarro().get(i);
   		%>
   		
   		
		<%} %>
		</table>
		<div id="contenido">
		</div>
	        </div>
	    </div>
 	 </div>
 	 
</body>


</html>