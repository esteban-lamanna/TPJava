<%@page import="Controlador.Controlador_encar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
</head>
<body>
  <div align="center">
  <form action="index.jsp" method="POST" class="login">
    <input type="text" name="email" class="input-login" placeholder="Documento" autofocus style="margin-bottom: 10px;">
    <input type="password" name="password" class="input-login" placeholder="Password" style="margin-bottom: 15px;">
    <input type="submit" value="Login" class="login-submit">
  </form>
  </div>
</body>
</html>

