<%@page import="Modelo.Usuario"%>
<%@page import="Controlador.Controlador_encar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
 		Controlador_encar cont=new Controlador_encar();
        String dni=request.getParameter("dni");
        String pass=request.getParameter("password");
       
        if(cont.Login(dni,pass))
            {
        	Usuario usu=cont.buscaUsuario(dni);
            session.setAttribute("username",usu.getNombre());
            session.setAttribute("dni",usu.getDni());
            response.sendRedirect("Index.jsp");
            }
        else
            response.sendRedirect("Error.jsp");
        %>
</body>
</html>