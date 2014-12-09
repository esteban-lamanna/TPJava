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
import Modelo.PVideo;

/**
 * Servlet implementation class PlacaVideo
 */
@WebServlet("/PlacaVideo")
public class PlacaVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlacaVideo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Controlador_encar contr=new Controlador_encar();
		ArrayList<Producto> prod=contr.buscaProductos("PVIDEO");
		for(int i=0;i<prod.size();i++)
	        {
	        	PVideo pro=(PVideo)prod.get(i);
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
	              out.println("Ancho del Bus: <span>"+pro.getAnchobus()+"</span><br />");
	              out.println("Cantidad de Memoria: <span>"+pro.getCantmem()+"</span><br />");
	              out.println("Frecuencia: <span>"+pro.getFrecuencia()+"</span><br />");
	              out.println("Pipelines: <span>"+pro.getPipelines()+"</span><br />");
	              out.println("Shaders: <span>"+pro.getShaders()+"</span><br />");
	              out.println(" </p>");   
	              out.println("<p class=\"price\">Precio: <strong> $"+pro.getPrecio()+"</strong></p>");
	              out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+pro.getCodigo()+")\" />");
	              out.println("</li>");            
	        }
		}
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
