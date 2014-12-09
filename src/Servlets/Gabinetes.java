package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.Controlador_encar;
import Modelo.Gabinete;
import Modelo.Producto;

/**
 * Servlet implementation class Gabinetes
 */
@WebServlet("/Gabinetes")
public class Gabinetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gabinetes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Controlador_encar contr=new Controlador_encar();
		ArrayList<Producto> prod=contr.buscaProductos("gabinete");    
        for(int i=0;i<prod.size();i++)
        {
        	Gabinete pro=(Gabinete)prod.get(i);
        	  out.println("<li>");
              out.println("<input name=\"Codigos\" value=\""+pro.getCodigo()+"\" type=\"hidden\" />");
              out.println(" <div class=\"image\">");
              out.println("<a href=\"#\">");
              out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
              out.println("</a>");
              out.println("</div>");
              out.println("<p>");
              out.println("Nombre: <span>"+pro.getNombre()+"</span><br />");
              out.println("Descripcion: <span>"+pro.getDescripcion()+"</span><br />");
              out.println("Modelo: <span>"+pro.getModelo()+"</span><br />");
              out.println("Tamaño: <span>"+pro.getTamaño()+" Watts</span><br />");
              out.println(" </p>");   
              out.println("<p class=\"price\">Precio: <strong> $"+pro.getPrecio()+"</strong></p>");
              out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+pro.getCodigo()+")\" />");
              out.println("</li>");            
        }

       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
