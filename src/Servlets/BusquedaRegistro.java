package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controlador.Controlador_encar;
import Modelo.Usuario;

/**
 * Servlet implementation class BusquedaRegistro
 */
@WebServlet("/BusquedaRegistro")
public class BusquedaRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String dni= request.getParameter("dni");
		Controlador_encar contr=new Controlador_encar();
		System.out.println(dni+" en servlet ");
		Usuario user=contr.buscaUsuario(dni);
		if (user!=null)
		{
			System.out.println("Ya existe ese dni");
			out.println("No");
			
		}
		else
		{
			System.out.println("Se puede usar");
			out.println("Yes");
		}
		
		// TODO Auto-generated method stub
	}
	
	
		
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		// TODO Auto-generated method stub
	}

}
