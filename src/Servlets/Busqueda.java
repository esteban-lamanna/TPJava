package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Fuente;
import Modelo.Gabinete;
import Modelo.Hd;
import Modelo.Memoria;
import Modelo.Micro;
import Modelo.PSonido;
import Modelo.PVideo;
import Modelo.PlacaMadre;
import Modelo.Producto;
import Modelo.RCable;
import Servlets.AgregaCarros.Prods;

import Controlador.Controlador_encar;

/**
 * Servlet implementation class Busqueda
 */
@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	
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
	    RCABLE
	  				}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busqueda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i;
		ArrayList<Producto> productos;
		Controlador_encar contr=new Controlador_encar();
		
		String nombre= request.getParameter("nombre");
		productos=contr.buscaProductosNombre(nombre);
		
		System.out.println("funciona");
		PrintWriter out=response.getWriter();
		for(i=0;i<productos.size();i++)
		{
		
			Prods valor = Prods.valueOf(productos.get(i).getTipo().toUpperCase());
		
		switch(valor)
		{
		case FUENTE:
			Fuente fuente=(Fuente)productos.get(i);
	        out.println("<li>");
	        out.println("<input name=\"Codigos\" id=\"Codigos\" value=\""+fuente.getCodigo()+"\" type=\"hidden\" />");
	        out.println(" <div class=\"image\">");
	        out.println("<a href=\"#\">");
	        out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
	        out.println("</a>"); 
	        out.println("</div>");
	        out.println("<p>");
	        out.println("Nombre: <span>"+fuente.getNombre()+"</span><br />");
	        out.println("Descripcion: <span>"+fuente.getDescripcion()+"</span><br />");
	        out.println("Modelo: <span>"+fuente.getModelo()+"</span><br />");
	        out.println("Watts: <span>"+fuente.getWatts()+" Watts</span><br />");
	        out.println("Amperaje: <span>"+fuente.getAmperaje()+" A</span><br />");
	        out.println(" </p>");   
	        out.println("<p class=\"price\">Precio: <strong> $"+fuente.getPrecio()+"</strong></p>");
	        out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+fuente.getCodigo()+")\" />");
	        out.println("</li>");
			break;
			
		case GABINETE:
			Gabinete gabinete=(Gabinete)productos.get(i);
      	  	out.println("<li>");
            out.println("<input name=\"Codigos\" value=\""+gabinete.getCodigo()+"\" type=\"hidden\" />");
            out.println(" <div class=\"image\">");
            out.println("<a href=\"#\">");
            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
            out.println("</a>");
            out.println("</div>");
            out.println("<p>");
            out.println("Nombre: <span>"+gabinete.getNombre()+"</span><br />");
            out.println("Descripcion: <span>"+gabinete.getDescripcion()+"</span><br />");
            out.println("Modelo: <span>"+gabinete.getModelo()+"</span><br />");
            out.println("Tamaño: <span>"+gabinete.getTamaño()+" Watts</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+gabinete.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+gabinete.getCodigo()+")\" />");
            out.println("</li>");  
			break;
		case HD:
	        Hd disco=(Hd)productos.get(i);
	        out.println("<li>");
	        out.println("<input name=\"Codigos\" value=\""+disco.getCodigo()+"\" type=\"hidden\" />");
	        out.println(" <div class=\"image\">");
	        out.println("<a href=\"#\">");
	        out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
	        out.println("</a>");
	        out.println("</div>");
	        out.println("<p>");
	        out.println("Nombre: <span>"+disco.getNombre()+"</span><br />");
	        out.println("Descripcion: <span>"+disco.getDescripcion()+"</span><br />");
	        out.println("Modelo: <span>"+disco.getModelo()+"</span><br />");
	        out.println("Capacidad: <span>"+disco.getCapacidad()+"</span><br />");
	        out.println("Interfaz: <span>"+disco.getInterfaz()+"</span><br />");
	        out.println("RPM: <span>"+disco.getRpm()+"</span><br />");
	        out.println("Buffer: <span>"+disco.getBuffer()+"</span><br />");
	        out.println(" </p>");   
	        out.println("<p class=\"price\">Precio: <strong> $"+disco.getPrecio()+"</strong></p>");
	        out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+disco.getCodigo()+")\" />");
	        out.println("</li>");
			break;
		case MEMORIA:
        	Memoria memoria=(Memoria)productos.get(i);
        	out.println("<li>");
            out.println("<input name=\"Codigos\" value=\""+memoria.getCodigo()+"\" type=\"hidden\" />");
            out.println(" <div class=\"image\">");
            out.println("<a href=\"#\">");
            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
            out.println("</a>");
            out.println("</div>");
            out.println("<p>");
            out.println("Nombre: <span>"+memoria.getNombre()+"</span><br />");
            out.println("Descripcion: <span>"+memoria.getDescripcion()+"</span><br />");
            out.println("Modelo: <span>"+memoria.getModelo()+"</span><br />");
            out.println("Frecuencia: <span>"+memoria.getFrecuencia()+"</span><br />");
            out.println("Capacidad: <span>"+memoria.getCantmen()+"</span><br />");
            out.println("Latencia: <span>"+memoria.getLatencia()+"</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+memoria.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+memoria.getCodigo()+")\" />");
            out.println("</li>");
			break;
		case MICRO:
        	Micro micro=(Micro)productos.get(i);
        	out.println("<li>");
            out.println("<input name=\"Codigos\" value=\""+micro.getCodigo()+"\" type=\"hidden\" />");
            out.println(" <div class=\"image\">");
            out.println("<a href=\"#\">");
            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
            out.println("</a>");
            out.println("</div>");
            out.println("<p>");
            out.println("Nombre: <span>"+micro.getNombre()+"</span><br />");
            out.println("Descripcion: <span>"+micro.getDescripcion()+"</span><br />");
            out.println("Modelo: <span>"+micro.getModelo()+"</span><br />");
            out.println("Frecuencia: <span>"+micro.getFrecuencia()+"</span><br />");
            out.println("Cache: <span>"+micro.getCaché()+"</span><br />");
            out.println("Socket: <span>"+micro.getSocket()+"</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+micro.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+micro.getCodigo()+")\" />");
            out.println("</li>");
			break;
		case PLACAMADRE:
        	PlacaMadre madre=(PlacaMadre)productos.get(i);
        	out.println("<li>");
            out.println("<input name=\"Codigos\" value=\""+madre.getCodigo()+"\" type=\"hidden\" />");
            out.println(" <div class=\"image\">");
            out.println("<a href=\"#\">");
            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
            out.println("</a>");
            out.println("</div>");
            out.println("<p>");
            out.println("Nombre: <span>"+madre.getNombre()+"</span><br />");
            out.println("Descripcion: <span>"+madre.getDescripcion()+"</span><br />");
            out.println("Modelo: <span>"+madre.getModelo()+"</span><br />");
            out.println("Cantidad Usb: <span>"+madre.getCantusb()+"</span><br />");
            out.println("Cantidad Usb 3.0: <span>"+madre.getCantusb30()+"</span><br />");
            out.println("Cantidad PCI-E x16: <span>"+madre.getCantPCIE()+"x16"+"</span><br />");
            out.println("video Onboard: <span>"+madre.getvOnboard()+"</span><br />");
            out.println("Sonido Onboard: <span>"+madre.getsOnboard()+"</span><br />");
            out.println("Chipset: <span>"+madre.getChipset()+"</span><br />");
            out.println("Cantidad Memoria Máxima: <span>"+madre.getCantmaxmem()+"</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+madre.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+madre.getCodigo()+")\" />");
            out.println("</li>");
			break;
		case PVIDEO:
        	PVideo video=(PVideo)productos.get(i);
      	  	out.println("<li>");
            out.println("<input name=\"Codigos\" value=\""+video.getCodigo()+"\" type=\"hidden\" />");
            out.println(" <div class=\"image\">");
            out.println("<a href=\"#\">");
            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
            out.println("</a>");
            out.println("</div>");
            out.println("<p>");
            out.println("Nombre: <span>"+video.getNombre()+"</span><br />");
            out.println("Descripcion: <span>"+video.getDescripcion()+"</span><br />");
            out.println("Modelo: <span>"+video.getModelo()+"</span><br />");
            out.println("Ancho del Bus: <span>"+video.getAnchobus()+"</span><br />");
            out.println("Cantidad de Memoria: <span>"+video.getCantmem()+"</span><br />");
            out.println("Frecuencia: <span>"+video.getFrecuencia()+"</span><br />");
            out.println("Pipelines: <span>"+video.getPipelines()+"</span><br />");
            out.println("Shaders: <span>"+video.getShaders()+"</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+video.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+video.getCodigo()+")\" />");
            out.println("</li>");   
			break;
		case PSONIDO:
        	PSonido sonido = (PSonido)productos.get(i);
        	out.println("<li>");
            out.println("<input name=\"Codigos\" value=\""+sonido.getCodigo()+"\" type=\"hidden\" />");
            out.println(" <div class=\"image\">");
            out.println("<a href=\"#\">");
            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
            out.println("</a>");
            out.println("</div>");
            out.println("<p>");
            out.println("Nombre: <span>"+sonido.getNombre()+"</span><br />");
            out.println("Descripcion: <span>"+sonido.getDescripcion()+"</span><br />");
            out.println("Modelo: <span>"+sonido.getModelo()+"</span><br />");
            out.println("Jacks: <span>"+sonido.getJacks()+"</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+sonido.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+sonido.getCodigo()+")\" />");
            out.println("</li>");
			break;
		case RCABLE:
	           	RCable cable=(RCable)productos.get(i);
	        	out.println("<li>");
	            out.println("<input name=\"Codigos\" value=\""+cable.getCodigo()+"\" type=\"hidden\" />");
	            out.println(" <div class=\"image\">");
	            out.println("<a href=\"#\">");
	            out.println("<img src=\"css/images/image1.jpg\" alt=\"\" />");
	            out.println("</a>");
	            out.println("</div>");
	            out.println("<p>");
	            out.println("Nombre: <span>"+cable.getNombre()+"</span><br />");
	            out.println("Descripcion: <span>"+cable.getDescripcion()+"</span><br />");
	            out.println("Modelo: <span>"+cable.getModelo()+"</span><br />");
	            out.println("Velocidad: <span>"+cable.getVelocidad()+"</span><br />");
	            out.println(" </p>");   
	            out.println("<p class=\"price\">Precio: <strong> $"+cable.getPrecio()+"</strong></p>");
	            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+cable.getCodigo()+")\" />");
	            out.println("</li>");
			break;
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
