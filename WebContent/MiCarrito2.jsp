<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Padre"%>
<%@page import="Controlador.Controlador_encar"%>
<%@page import="Modelo.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/Register.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/Tablas.css" type="text/css" media="all" />
<title>Mi carrito</title>
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
       	<h1>Mi carrito</h1><br/>
       	<%
       	ArrayList<Producto> prods = new ArrayList();
       	Controlador_encar cont = new Controlador_encar();
       	prods = cont.getUsuarioActual().getCarcomp().getProductosCarro();
       			       	
       	%>
		        <div class="datagrid">
		        <table id="TablaProductosCarro">
			<thead><tr><th>Imagen</th><th>Nombre</th><th>Descripcion</th><th>Modelo</th><th>Cantidad</th><th>Precio</th><th>Comprar</th><th>Eliminar</th></tr></thead>
			
			<tfoot><tr><td colspan="8"><div id="paging"><ul><li><a href="#"><span>Previous</span></a></li><li><a href="#" class="active"><span>1</span></a></li><li><a href="#"><span>2</span></a></li><li><a href="#"><span>3</span></a></li><li><a href="#"><span>4</span></a></li><li><a href="#"><span>5</span></a></li><li><a href="#"><span>Next</span></a></li></ul></div></tr></tfoot>

			<tbody>
			<% int i = 0; 
			for(Producto pr : prods)
			{
				if(i % 2 == 0)
				{
			%>
			<tr><td><a href="#"> <img src="css/images/image1.jpg" alt="imagen"/></a><%// <%pr.getFoto();%></td><td><%=pr.getNombre() %></td>
			<td><%=pr.getDescripcion()%></td><td><%=pr.getModelo() %></td>
			<td><input  style="width: 40px;font: 15px 'Helvetica Neue', Helvetica, Arial, sans-serif;" type="text" name="cantidad" value="1"/></td>
			<td>$<%=pr.getPrecio() %></td>
				<td><input name="seleccionar" type="checkbox" checked="checked"/></td>
			<td><a id="eliminar" href="#"/><img src="css/images/cart_delete.png"/></a></td>
			<td style="display: none" ><%=pr.getCodigo() %></td>
			
			
			</tr>
			<% }
				else
				{%>
					<tr class="alt">
					<td><a href="#"> <img src="css/images/image1.jpg" alt="imagen"/></a><%// <%pr.getFoto();%></td>
					<td><%=pr.getNombre() %></td>
					<td><%=pr.getDescripcion()%></td>
					<td><%=pr.getModelo() %></td>
				
		<td><input  style="width: 40px;font: 15px 'Helvetica Neue', Helvetica, Arial, sans-serif;" type="text" name="cantidad" value="1"/></td>
		<td>$<%=pr.getPrecio() %></td>
		<td><input type="checkbox" name="seleccionar" checked="checked"/></td>
		<td><a id="eliminar" href="#"/><img src="css/images/cart_delete.png"/></a></td>
		<td style="display: none" ><%=pr.getCodigo() %></td>
		</tr>
		
					<%
				}
				i ++;
			}%>
	
			
			</tbody>
</table></div>
<div class="dark-matter" style="background-color: inherit; text-align: right ;">
<input type="button" value="Volver" style=" cursor: pointer;" onclick="location.href = 'Index.jsp' "> 
<input type="button"  style="background-color: green; color: white; cursor: pointer; " onclick="Comprar()" value="Comprar" >
				        	
</div>
				
	        </div>
	    </div>
 	 </div>
 	 
</body>

</html>
<script type="text/javascript" language="javascript">
function Comprar()
{
	debugger;
	
	var $filas = $("#TablaProductosCarro tbody").children('tr');
	var $filasParaComprar = $($filas).attr(,);
	    /*  $.ajax({
	    	type: "POST",
	        url: "QuitarDelCarrito",
		    data: {'cod':cod},
		    success: function(a) {
		    	 debugger;
	                $('#results').html(a);
	              
	                sumarCostoAcumulado();
	               contarProductosEnCarro();
	       
		    },
		    error: function (xhr, ajaxOptions, thrownError) {
		       
		        alert(thrownError);
		        }
});*/
}


</script>