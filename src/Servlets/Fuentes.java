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
import Modelo.Fuente;
import Modelo.Producto;

/**
 * Servlet implementation class Fuentes
 */
@WebServlet("/Fuentes")
public class Fuentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fuentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
        Controlador_encar contr=new Controlador_encar();
        ArrayList<Producto> prod=contr.buscaProductos("fuente");
        for(int i=0;i<prod.size();i++)
        {
        Fuente pro=(Fuente)prod.get(i);
        out.println("<li>");
        out.println("<input name=\"Codigos\" id=\"Codigos\" value=\""+pro.getCodigo()+"\" type=\"hidden\" />");
        out.println(" <div class=\"image\">");
        out.println("<a href=\"#\">");
        out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
        out.println("</a>"); 
        out.println("</div>");
        out.println("<p>");
        out.println("Nombre: <span>"+pro.getNombre()+"</span><br />");
        out.println("Descripcion: <span>"+pro.getDescripcion()+"</span><br />");
        out.println("Modelo: <span>"+pro.getModelo()+"</span><br />");
        out.println("Watts: <span>"+pro.getWatts()+" Watts</span><br />");
        out.println("Amperaje: <span>"+pro.getAmperaje()+" A</span><br />");
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
