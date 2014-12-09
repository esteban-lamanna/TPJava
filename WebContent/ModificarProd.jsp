<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="Controlador.Controlador_encar"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
String codigo = request.getParameter("codigo");
String nombreprod = request.getParameter("nombreprod");
String modelo = request.getParameter("modelo");
String descripcion = request.getParameter("descripcion");
System.out.print("Descripcion "+descripcion);
float precio =  Float.parseFloat(request.getParameter("precio"));
String foto = request.getParameter("foto");
String tipo =request.getParameter("categoria");
System.out.println("El tipo es: " +tipo);
Controlador_encar contr=new Controlador_encar();

String taman=request.getParameter("taman");

String watts= request.getParameter("watts");
String amperaje= request.getParameter("amperaje");


String capHD =request.getParameter("capacidadhd"); 
String interfaz =request.getParameter("interfaz"); 
String rpm =request.getParameter("rpm"); 
String buffer =request.getParameter("buffer");

String frecuenciamem = request.getParameter("frecuenciamem");
String latencia=request.getParameter("latencia"); 
String capacidadmem=request.getParameter("capacidadmem");

String frecuenciamicro= request.getParameter("frecuenciamicro");
String cachemicro=request.getParameter("cachemicro");
String socketmicro=request.getParameter("socketmicro");

String cantusb=request.getParameter("cantusb");
String cantusb3=request.getParameter("cantusb3");
String cantpcie=request.getParameter("cantpcie");
String videoonboard=request.getParameter("videoonboard");
String sonidoonboard=request.getParameter("sonidoonboard");
String chipset=request.getParameter("chipset");
String cantmaxmemmo=request.getParameter("cantmaxmemmo");
String socketmo=request.getParameter("socketmo");

String frecuenciavideo=request.getParameter("frecuenciavideo");
String anchobus=request.getParameter("anchobus");
String cantmemvideo=request.getParameter("cantmemvideo");
String pipelines=request.getParameter("pipelines");
String shaders=request.getParameter("shaders");

String jacks=request.getParameter("jacks");

String velocidadr=request.getParameter("velocidadr");

String error;
error=contr.modificaProducto(nombreprod,modelo,descripcion,precio,capHD,interfaz,rpm,buffer,watts,amperaje,frecuenciamicro,cachemicro,socketmicro,jacks,taman,velocidadr,cantusb,cantpcie,videoonboard,sonidoonboard,chipset,cantusb3,cantmaxmemmo,frecuenciamem,latencia,capacidadmem,frecuenciavideo,anchobus,cantmemvideo,pipelines,shaders,socketmo,foto,tipo,codigo);

if(error!=null)
{ 
	session.setAttribute("confirm","mal");
	  
}
else
{
	session.setAttribute("confirm","bien");
}

response.sendRedirect("Modificaproductos.jsp");


%>
</body>
</html>