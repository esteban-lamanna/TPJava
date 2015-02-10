<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Controlador.Controlador_encar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Controlador_encar contr=new Controlador_encar();
String codprod = request.getParameter("cod");
boolean confirm=contr.eliminaProducto(codprod);
if(confirm)
{
	session.setAttribute("confirm","bien");
}
else
{
	session.setAttribute("confirm","mal");
}

%>
</body>
</html>