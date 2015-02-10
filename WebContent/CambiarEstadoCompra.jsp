<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Padre"%>
<%@page import="Controlador.Controlador_encar"%>
<%@page import="Modelo.Compra"%>
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
	
<title>Cambiar Estado Compra</title>
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
       	<h1>Cambiar Estado Compra</h1><br/>
       	<%
       	ArrayList<Compra> Comps = new ArrayList<Compra>();
       	Controlador_encar cont = new Controlador_encar();
       	Comps = cont.getCompras();		       	
       	%>
		<div class="datagrid">
			<table id="TablaCompras">
					<thead><tr><th>Codigo</th><th>Total</th><th>DNI</th><th>Fecha</th><th>Estado</th></tr></thead>
					<tbody>
					<% int i = 0; 
					for(Compra c : Comps)
					{
						if(i % 2 == 0)
						{
					%>
						<tr>
						<td><%= c.getCodcompra() %></td>
						<td><%= c.getTotalcompra()%></td>
						<td><%= c.getDni() %></td>
						<td><%= c.getFecha() %></td>
						<td><select name="estado" >
								<option value="P"<% if(c.getEstado().equals("P")){ %>selected="selected"<%}%>>Pendiente</option>
								<option value="E"<% if(c.getEstado().equals("E")){ %>selected="selected"<%}%>>En envio</option>
								<option value="R"<% if(c.getEstado().equals("R")){ %>selected="selected"<%}%>>Recibido</option>
							</select>
						</td>			
						</tr>
					<% }
					else
					{%>
						<tr class="alt">
						<td><%= c.getCodcompra() %></td>
						<td><%= c.getTotalcompra()%></td>
						<td><%= c.getDni() %></td>
						<td><%= c.getFecha() %></td>
						<td><select name="estado" >
								<option value="P"<% if(c.getEstado().equals("P")){ %>selected="selected"<%}%>>Pendiente</option>
								<option value="E"<% if(c.getEstado().equals("E")){ %>selected="selected"<%}%>>En envio</option>
								<option value="R"<% if(c.getEstado().equals("R")){ %>selected="selected"<%}%>>Recibido</option>
							</select>
						</td>				
						</tr>	
					<%}
						i ++;
					}%>
			
					
					</tbody>
			</table>
		</div>
	<div class="dark-matter" style="background-color: inherit; text-align: right ;">
		<input type="button" value="Cambiar" style="background-color: green; color: white; cursor: pointer;" onclick="return Comprar()" >
		<input type="button" value="Volver" style=" cursor: pointer;" onclick="location.href = 'MasterMenu.jsp' "> 
	</div>

			
	        </div>
	    </div>
 	 </div>
 	 
</body>

</html>

<script type="text/javascript">
	function Comprar()
	{  
		var arregloCodigos = new Array();
	    var arregloEstados = new Array();	
			var filas = $('#TablaCompras tbody tr');
	    filas.each(function () {
	        var Td = $(this).find(">td")[4];
	
	        var select = Td.children[0];
	     
	        var estado = select.value;
	            var codi = $(this).find(">td")[0].innerText;
	            arregloCodigos.push(codi); //aca tengo todos los codigos
	            arregloEstados.push(estado); //aca tengo todos los estados
	  	    });
	        
	        //ahora lo mando al servlet
	        
	        $.ajax({
		    	type: "POST",
		        url: "CambiarEstado",
			    data: {'codigos':arregloCodigos,'estados':arregloEstados},
			    success: function(a) {
		                alert("Estado cambiado satisfactoriamente");        
			    },
			    error: function (xhr, ajaxOptions, thrownError) {
			        alert(thrownError);
			        }
	        
	        
	    });
	}
</script>
