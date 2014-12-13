package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jrockit.jfr.settings.JSONElement;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import Controlador.Controlador_encar;
import Modelo.Usuario;

/**
 * Servlet implementation class BusquedaUsuario
 */
@WebServlet("/BusquedaUsuario")
public class BusquedaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json = new JsonParser();

		String dni= request.getParameter("dni");
		Controlador_encar contr=new Controlador_encar();
		System.out.println(dni+" en servlet ");
		Usuario user=contr.buscaUsuario(dni);
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.println(user);
		// TODO Auto-generated method stub
	}

}
