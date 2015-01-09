package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controlador.Controlador_encar;
import DB.DBCarros;
import Modelo.CarritoCompra;
import Modelo.Usuario;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends Padre {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		Controlador_encar cont= getControlador();
        String dni=request.getParameter("dni");
        String pass=request.getParameter("password");
       
        
        if(cont.Login(dni,pass))
            {
        	HttpSession sesion = request.getSession(false);
        	if(sesion==null)
        	{
        		sesion = request.getSession(true);
        	}
        	
        	//le creo el carrito
        	DBCarros carro = new DBCarros();
        	CarritoCompra carrito=	carro.BuscaCarro(dni);
        	
        	Usuario usu = cont.getUsuarioActual();
        
         //   usu.setCarcomp(carrito);
            cont.SetCarroComprasAUsuario(carrito);
            
        	sesion.setAttribute("username",usu.getNombre());
            sesion.setAttribute("dni",usu.getDni());
            sesion.setAttribute("EsAdmin",usu.getEsAdmin());
            sesion.setAttribute("bandera", 1);
            response.sendRedirect("Index.jsp");
            }
        else
            response.sendRedirect("Error.jsp");
	}

}
