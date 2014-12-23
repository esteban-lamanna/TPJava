<%@page import="Modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<!-- Top -->
<div id="top">
	
	<div class="shell">
		
		<!-- Header -->
		<div id="header">
			<h1 id="logo"><a href="#"></a></h1>
			<div id="navigation">
				<ul id="sddm">
				<%if(session.getAttribute("username")!= null)
					{
					if(session.getAttribute("EsAdmin").equals(1))
					{response.sendRedirect("MasterMenu.jsp");}
				%>
				<li><a href="EdicionUsuario.jsp"> Hola <%=session.getAttribute("username")%></a>
				</li>
				<li><a href="CerrarSesion.jsp">Cerrar Sesion</a>
				</li>
				  	<%} %>
				   
				    <%if(session.getAttribute("username")== null)
					{%>
					
					 <li>
				    <a href="#" 
				        onmouseover="mopen('m2')" 
				        onmouseout="mclosetime()">Ingresar</a></li>
				        <div id="m2" style="z-index: 3;" onmouseover="mcancelclosetime()" 
				            onmouseout="mclosetime()" align="center">
							  <form action="LoginCheck.jsp" method="get" class="login">
							    <input type="text" name="dni" class="input-login" placeholder="Dni" style="margin-bottom: 10px;">
							    <br>
							    <input type="password" name="password" class="input-login" placeholder="Password" style="margin-bottom: 15px;">
							    <br>
							    <input type="submit" value="Login" class="login-submit">
							  </form>
				        </div>
				   <li><a href="Registro.jsp">Registrarme</a></li>
				        	<%} %>
				   
				    <li class="last"><a href="#">Home</a></li>
				</ul>
						
			
				<div style="clear:both"></div>
			</div>
		</div>
		<!-- End Header -->
		
		<!-- Slider -->
		<div id="slider">
			<div id="slider-holder">
				<ul>
				    <li><a href="#"><img src="css/images/slide1.jpg" alt="" /></a></li>
				</ul>
			</div>
			<div id="slider-nav">
				<a href="#" class="prev">Previous</a>
				<a href="#" class="next">Next</a>
			</div>
		</div>
		<!-- <End Slider -->
		
	</div>
</div>
<!-- Top -->

<!-- Main -->
<div id="main">
	<div class="shell">
		
		<!-- Search, etc -->
		<div class="options">
			<div class="search">
				<form id="form1">
					<span class="field"><input type="text" class="blink" value="SEARCH" title="SEARCH" id="buscar"/></span>
					<input type="text" class="search-submit" value="" id="submit"/>
				</form>
			</div>
			<span class="left"><a href="#">Busqueda Avanzada</a></span>
			
			<div class="right">
				<span class="cart">
					<a href="#" class="cart-ico">&nbsp;</a>
					<strong>$0.00</strong>
				</span>
				<span class="left more-links">
					<a id="MiCuenta" href="#"></a>
				</span>
			</div>
		</div>
		<!-- End Search, etc -->
		
		<!-- Content -->
		<div id="content">
			
			<!-- Tabs -->
			<div class="tabs">
				<ul id="tabs">
				    <li><a id="tab1" class="active" ><span>Fuentes</span></a></li>
				    <li><a id="tab2"><span>Gabinete</span></a></li>
				    <li><a id="tab3"><span>HDD</span></a></li>
				    <li><a id="tab4"><span>Memoria</span></a></li>
				    <li><a id="tab5"><span>Micro</span></a></li>
				    <li><a id="tab6"><span>Mother</span></a></li>
				    <li><a id="tab7"><span>Placa Video</span></a></li>
				    <li><a id="tab8"><span>Placa Red</span></a></li>
				    <li><a id="tab9"><span>Placa Sonido</span></a></li>
				    <li><a id="tab10"><span>Cable Red</span></a></li>
				    <li><a id="tab11"><span>Busqueda</span></a></li>
				</ul>
			</div>
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
					
					// close layer when click-out
				//m2.onclick = mclose; 
				
				$(document).ready(function() {
					$('#submit').click(function(event) {
						deselecionar();
						var buscarVar = $('#buscar').val();
						var nodo = document.getElementById("tab11");
						nodo.className = "active";
					      $.ajax({
							    type: "POST",
							    url: "Busqueda",
							    data: {'nombre':buscarVar},
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
					});
				});

				
				
			      $.ajax({
					    type: "POST",
					    url: "Fuentes",
					    success: function(a) {
				                $('#results').html(a);
					    }
				       });
			      
			      function deselecionar()
			      {
			    	  	var nodo1 = document.getElementById("tab1");
			    	  	nodo1.classList.remove("active");
						var nodo2 = document.getElementById("tab2");
						nodo2.classList.remove("active");
						var nodo3 = document.getElementById("tab3");
						nodo3.classList.remove("active");
						var nodo4 = document.getElementById("tab4");
						nodo4.classList.remove("active");
						var nodo5 = document.getElementById("tab5");
						nodo5.classList.remove("active");
						var nodo6 = document.getElementById("tab6");
						nodo6.classList.remove("active");
						var nodo7 = document.getElementById("tab7");
						nodo7.classList.remove("active");
						var nodo8 = document.getElementById("tab8");
						nodo8.classList.remove("active");
						var nodo9 = document.getElementById("tab9");
						nodo9.classList.remove("active");
						var nodo10 = document.getElementById("tab10");
						nodo10.classList.remove("active");
						var nodo11 = document.getElementById("tab11");
						nodo11.classList.remove("active");
			      };
			      
					$(document).ready(function() {
						   $('#tab1').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab1");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "Fuentes",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	
			      
					$(document).ready(function() {
					   $('#tab2').click(function(){
						   deselecionar();
							var nodo = document.getElementById("tab2");
							nodo.className = "active";
					      $.ajax({
						    type: "POST",
						    url: "Gabinetes",
						    success: function(a) {
					                $('#results').html(a);
						    }
					       });
					   });
					});		
					
					$(document).ready(function() {
						   $('#tab3').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab3");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "HD",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	
					
					$(document).ready(function() {
						   $('#tab4').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab4");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "Memorias",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	

					$(document).ready(function() {
						   $('#tab5').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab5");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "Micros",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	
					
					$(document).ready(function() {
						   $('#tab6').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab6");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "PlacasMadres",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	
					
					$(document).ready(function() {
						   $('#tab7').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab7");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "PlacaVideo",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});		
					
					$(document).ready(function() {
						   $('#tab9').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab9");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "PlacaSonido",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	
					
					$(document).ready(function() {
						   $('#tab10').click(function(){
							   deselecionar();
								var nodo = document.getElementById("tab10");
								nodo.className = "active";
						      $.ajax({
							    type: "POST",
							    url: "RedCable",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
						   });
						});	
					
					function agregar(cod)
				      {
					
						      $.ajax({
						    	type: "POST",
						        url: "AgregaCarros",
							    data: {'cod':cod},
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
				      }
				</script> 
			<!-- Tabs -->
			
			<!-- Container -->
			<div id="container">
				
				<div class="tabbed">
					
					<!-- First Tab Content -->
					
					<div class="tab-content" style="display:block;">
						 <div class="items">
							<div class="cl">&nbsp;</div>
													<ul id="results">
							    					</ul>
							<div class="cl">&nbsp;</div>
						</div>
					</div>
					
					
					
					
							  <!--   <li>
							    	<div class="image">
							    		<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
							    	</div>
							    	<p>
							    		Item Number: <span>125515</span><br />
							    		Size List : <span>8/8.5/9.5/10/11</span><br />
							    		Brand Name: <a href="#">Adidas Shoes</a>
							    	</p>
							    	<p class="price">Wholesale Price: <strong>53 USD</strong></p>
							    </li>
							    </ul> -->


				</div>
				
				<!-- Brands -->
				<div class="brands">
					<h3>Brands</h3>
					<div class="logos">
						<a href="#"><img src="css/images/logo1.gif" alt="" /></a>
						<a href="#"><img src="css/images/logo2.gif" alt="" /></a>
						<a href="#"><img src="css/images/logo3.gif" alt="" /></a>
						<a href="#"><img src="css/images/logo4.gif" alt="" /></a>
						<a href="#"><img src="css/images/logo5.gif" alt="" /></a>
					</div>
				</div>
				<!-- End Brands -->
				
				<!-- Footer -->
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
				<!-- End Footer -->
				
			</div>
			<!-- End Container -->
			
		</div>
		<!-- End Content -->
		
	</div>
</div>
<!-- End Main -->
	
</body>
</html>