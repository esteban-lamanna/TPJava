package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Servlets.AgregaCarros.Prods;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import Controlador.Controlador_encar;

/**
 * Servlet implementation class QuitarDelCarrito
 */
@WebServlet("/QuitarDelCarrito")
public class QuitarDelCarrito extends Padre {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitarDelCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(false);
    	if(sesion==null)
    	{
    		sesion = request.getSession(true);
    	}
		
		String codigo= request.getParameter("cod");
		int codi=Integer.parseInt(codigo);
		Controlador_encar cont = getControlador();
		
			String tipo;
			try {
				cont.eliminaDelCarroMemoria(codi);
				tipo = Controlador_encar.eliminaDelCarro(codi,sesion.getAttribute("dni").toString()); //elimina de BD
			
			Prods valor = Prods.valueOf(tipo.toUpperCase());
			
			//request.getRequestDispatcher("MiCarrito.jsp").forward(request, response);
			//response.sendRedirect("MiCarrito.jsp");	
			//return;
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
			/*
			 * String tipo;
		productoActual=ProductosDB.buscaProducto(codigo);
		carroNew.setDni(usuarioActual.getDni());
		carroNew.añadeProducto(productoActual);
		tipo=productoActual.getTipo();
		return tipo;
			 */
	}
	 catch (SQLException e) {
		 e.printStackTrace();
 		PrintWriter out=response.getWriter();
 		out.println("Problema al eliminar el producto al carro");
	}
	}
}


