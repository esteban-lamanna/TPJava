package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controlador.Controlador_encar;
import Modelo.Gabinete;
import Modelo.Producto;
import Modelo.PVideo;

/**
 * Servlet implementation class PlacaVideo
 */
@WebServlet("/PlacaVideo")
public class PlacaVideo extends Padre {
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
        Controlador_encar contr = getControlador();
        ArrayList<Producto> prod=contr.buscaProductos("PVIDEO");
        ArrayList<Producto>prodsCarroActual = new ArrayList<Producto>();
        if(contr.getCarroCompleto()!=null){
        if(contr.getCarroCompleto().getProductosCarro()!=null)
        {
        	
        
        prodsCarroActual = contr.getCarroCompleto().getProductosCarro();
        }
        }
        Boolean agregado;
        for(int i=0;i<prod.size();i++)
        {
        	agregado=false;
        	
        	for (int j=0;j< prodsCarroActual.size();j++)
        	{
				
				if(prod.get(i).getCodigo()==prodsCarroActual.get(j).getCodigo())
				{
					agregado=true;
				}
        	}
	        	PVideo pro=(PVideo)prod.get(i);
	        	  out.println("<li>");
	              out.println("<input name=\"Codigos\" value=\""+pro.getCodigo()+"\" type=\"hidden\" />");
	              out.println(" <div class=\"image\">");
	              out.println("<a href=\"#\">");
	              out.println("<img src=\""+pro.getFoto()+"\">");
	             // out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
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
	              HttpSession sesion = request.getSession(false);
	              if(sesion == null)
	              {
	              	sesion = request.getSession(true);
	              }
	              System.out.print(sesion.getAttribute("dni"));
	              
	             
	           
	              if(sesion.getAttribute("dni")!=null && sesion.getAttribute("dni")!="")
	              {
	              if(!agregado)
	              {
	              out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+pro.getCodigo()+")\" />");
	              }
	              else
	              {
	              out.println("<input type=\"button\" id=\"btnQuitar\" title=\"Quitar\" value=\"Quitar\" onclick=\"quitar("+pro.getCodigo()+")\" />");
	                   
	              }
	              out.println("</li>");
	              }
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
