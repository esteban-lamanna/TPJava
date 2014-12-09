package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controlador.Controlador_encar;
import Controlador.Controlador_encar.Prods;
/**
 * Servlet implementation class AgregaCarros
 */
@WebServlet("/AgregaCarros")
public class AgregaCarros extends HttpServlet {
	
	public enum Prods {

	    FUENTE,
	    GABINETE,
	    HD,
	    MEMORIA,
	    MICRO,
	    PLACAMADRE,
	    PRED,
	    PSONIDO,
	    PVIDEO,
	    PWIRELESS,
	    RCABLE
	  				}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregaCarros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tipo;
		Controlador_encar contr=new Controlador_encar();
		System.out.println("funciona");
		String codigo= request.getParameter("cod");
		int codi=Integer.parseInt(codigo);
		
		tipo=contr.aņadeAlCarro(codi);
		Prods valor = Prods.valueOf(tipo.toUpperCase());
		
		switch(valor)
		{
		case FUENTE:
			response.sendRedirect("Fuentes");
			break;
		case GABINETE:
			response.sendRedirect("Gabinetes");
			break;
		case HD:
			response.sendRedirect("HD");
			break;
		case MEMORIA:
			response.sendRedirect("Memorias");
			break;
		case MICRO:
			response.sendRedirect("Micros");
			break;
		case PLACAMADRE:
			response.sendRedirect("PlacaMadres");
			break;
		case PVIDEO:
			response.sendRedirect("PlacaVideo");
			break;
		case PSONIDO:
			response.sendRedirect("PlacaSonido");
			break;
		case RCABLE:
			response.sendRedirect("RedCable");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
