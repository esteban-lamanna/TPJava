<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Controlador.Controlador_encar"%>
<%@page import="java.util.regex.*"%>
<%@page import="Servlets.Validador"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
			String dni = request.getParameter("dni");
	        String password = request.getParameter("password");
	        String confirm_password = request.getParameter("passwordconfirm");
	        String nombre = request.getParameter("nombre");
	        String apellido = request.getParameter("apellido");
	        String localidad = request.getParameter("localidad");
	        String direccion = request.getParameter("direccion");
	        String direnvios = request.getParameter("direnvios");
	        String edad = request.getParameter("edad");
	        String emailUsuario = request.getParameter("email");
	        Controlador_encar contr=new Controlador_encar();
	       
	        
	        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	       
	        Matcher m = p.matcher(emailUsuario);
	        Validador v = new Validador();
	        //Dao d = new Dao();
	        //Comienzo con las validaciones
	        /*
	         * Podemos hacer un monton de validaciones, por ejemplo:
	         * Campos no vacios, direccion de email valida, nombre de usuario y contraseña
	         * sin espacios y/o caracteres especiales.
	         */
	        
	        
	        if(dni.isEmpty() || password.isEmpty() ||  confirm_password.isEmpty() ||  nombre.isEmpty() || apellido.isEmpty() || localidad.isEmpty() || direccion.isEmpty() || direnvios.isEmpty() || edad.isEmpty() || emailUsuario.isEmpty())
	        {
	        	//campos vacios
	        	System.out.println("error por campo vacio");
	        	response.sendRedirect("Error.jsp");
	            
	        } else 
	        	{
	            //No hay campos vacios, veo que la direccion de email sea válida
		            if(!m.find())
		            {
		            	//direccion de email invalida.
		            	System.out.println("error direccion de email invalida");
		            	response.sendRedirect("Error.jsp");
		                
		            } else 
		            	{
		                //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
			                if(v.isUsernameOrPasswordValid(password))
			                {
			                	
			                    //Ahora verifico si la contraseña 1 y la contraseña 2 son iguales
			                    if(password.equals(confirm_password))
			                    {
			                    	
			                        try 
			                        {
			                            //d.conectar();
			                        	//falta verificar email o dni registrado
			                                if(false)
			                                {
			                                	//error, direccion y/o dni ya registrado
			                                	response.sendRedirect("Error.jsp");
			                                } else 
			                                {
			                                    
			                                    //Legado a este punto significa que todo esta correcto, por lo tanto ingreso a la DB
			                                	contr.nuevoUsuario(dni,password , confirm_password, nombre, apellido, direccion, direnvios, edad, emailUsuario,localidad);
			                                	response.sendRedirect("Index.jsp");
			                                    
			                                    //respuesta.setAttribute("error", null);
			                                }
			                            
			                            
			                             
			                        } catch (Exception e) { out.println("Ocurrio la sig exception: " +e); }
			                        
			                        
			                        
			                    } 
			                    else 
			                    {
			                    	System.out.println("Error por Contraseñas distintas");
			                    	// error las contraseñas son =
			                    	response.sendRedirect("Error.jsp");
			                        
			                    }
		                    
		                } 
			                else
			                
			                {
			                	//contraseña invalida
			                	System.out.println("Error por Contraseñas invalida");
			                	response.sendRedirect("Error.jsp");
			                   
			                }
	                
	                
	            }
	        }
	        
	        
	        %>
</body>
</html>