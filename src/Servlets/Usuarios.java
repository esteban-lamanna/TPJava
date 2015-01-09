package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controlador.Controlador_encar;
import java.util.regex.*;
import Servlets.Validador;
import java.util.*;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends Padre {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
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
        Controlador_encar contr = getControlador();
       
        
        
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
        	//response.sendRedirect("Error.jsp");
            
        }else{
	        //No hay campos vacios, veo que la direccion de email sea válida
		    if(!m.find())
			{
		     System.out.println("error direccion de email invalida");
			}
		    else{
	
			    //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
			    if(!v.isUsernameOrPasswordValid(password))
				{
			    	System.out.println("error contraseña invalida");
				}
				    else
				    {
						//Ahora verifico si la contraseña 1 y la contraseña 2 son iguales
						if(!password.equals(confirm_password))
						{
							System.out.println("error contraseñas distintas");              	
						}
							else
							{
								if(contr.buscaUsuario(dni)==null)
								{
									//El usuario no existe, por lo tanto lo Inserto a la DB
								    contr.nuevoUsuario(dni,password , confirm_password, nombre, apellido, direccion, direnvios, edad, emailUsuario,localidad);
								    HttpSession session = request.getSession(true);
								    session.setAttribute("dni",dni);
								    session.setAttribute("username", nombre);
						            session.setAttribute("EsAdmin",0);
								    response.sendRedirect("Index.jsp");
								}
								else
								{
									//El usuario existe, por lo tanto actualizo la DB
									contr.modificaUsuario(dni,password, confirm_password, apellido, direccion, localidad, direnvios, nombre, emailUsuario, edad);
									 HttpSession session = request.getSession(true);
									   
									    session.setAttribute("username", nombre);
							            session.setAttribute("EsAdmin",0);
									response.sendRedirect("Index.jsp");
								}
					            
							}
				    }
		    }
        }
	}

}
