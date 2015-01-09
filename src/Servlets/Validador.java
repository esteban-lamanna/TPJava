package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Validador")
public class Validador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 char[] cadena = request.getParameter("pass").toLowerCase().toCharArray();
		 PrintWriter out=response.getWriter();
		 
	        //Compruebo la longitud
	        if (cadena.length <= 6)
	        {
	            out.println(false);
	        }
	       for (int i = 0; i < cadena.length; i++) 
	        {
	            //Compruebo que no existan caracteres especiales (solamento los que podrian ser usados para una inyeccion SQL o perjudicar en la consulta);
	            if (cadena[i] == ' '
	                    || cadena[i] == '='
	                    || cadena[i] == '?'
	                    || cadena[i] == '+'
	                    || cadena[i] == '*'
	                    || cadena[i] == '-'
	                    || cadena[i] == '%'
	                    || cadena[i] == '/'
	                    || cadena[i] == '.'
	                    || cadena[i] == ','
	                    || cadena[i] == ';'
	                    || cadena[i] == '!'
	                    || cadena[i] == '<'
	                    || cadena[i] == '>'
	                    || cadena[i] == ':') 
	            {
	            	out.println(false);
	            }
	 
	        }

		 out.println(true);
	    }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}
	public boolean isUsernameOrPasswordValid(String cadena1)
	{
	 char[] cadena = cadena1.toLowerCase().toCharArray();

	 
     //Compruebo la longitud
     if (cadena.length <= 6)
     {
         return false;
     }
     for (int i = 0; i < cadena.length; i++) 
     {
         //Compruebo que no existan caracteres especiales (solamento los que podrian ser usados para una inyeccion SQL o perjudicar en la consulta);
         if (cadena[i] == ' '
                 || cadena[i] == '='
                 || cadena[i] == '?'
                 || cadena[i] == '+'
                 || cadena[i] == '*'
                 || cadena[i] == '-'
                 || cadena[i] == '%'
                 || cadena[i] == '/'
                 || cadena[i] == '.'
                 || cadena[i] == ','
                 || cadena[i] == ';'
                 || cadena[i] == '!'
                 || cadena[i] == '<'
                 || cadena[i] == '>'
                 || cadena[i] == ':') 
         {
             return false;
         }

     }
	 return true;
	}

}


       

