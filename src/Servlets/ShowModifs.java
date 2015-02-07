package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controlador.Controlador_encar;
import Servlets.ShowInputs.Prods;
import Modelo.Producto;
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

/**
 * Servlet implementation class ShowModifs
 */
@WebServlet("/ShowModifs")
public class ShowModifs extends Padre {
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
	    RCABLE,
	    RED,
	    DEF
	  				}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowModifs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	Controlador_encar contr= getControlador();
    	Producto prod=contr.buscaProducto(Integer.parseInt(request.getParameter("codi")));   
		// TODO Auto-generated method stub
		String valori=request.getParameter("categ");		
		Prods valor = Prods.valueOf(valori.toUpperCase());		
		PrintWriter out=response.getWriter();	
		out.println("<label><span>Nombre del Producto </span> <input type='text' name='nombre' value=\""+prod.getNombre()+"\" id='nombre'></label>"); 
		out.println("<label><span>Modelo:</span> <input type='text' name='modelo' value=\""+prod.getModelo()+"\" id='modelo'></label>"); 
		out.println("<label><span>Descripcion:</span> <input type='text' name='descripcion' value=\""+prod.getDescripcion()+"\" id='descripcion'></label>"); 
        out.println("<label><span>Foto:</span> <input type='text' name='foto' value=\""+prod.getFoto()+"\" id='foto'></label>"); 
		out.println("<label><span>Precio:</span> <input type='text' name='precio' value=\""+prod.getPrecio()+"\" id='precio'></label>"); 
				
		switch(valor)
		{
		case FUENTE:
			Fuente pro=(Fuente)prod;
 out.println("<label><span>Watts:</span> <input type='text' name='watts' value=\""+pro.getWatts()+"\" id='watts'></label>"); 
 out.println("<label><span>Amperaje:</span> <input type='text' name='amperaje' value=\""+pro.getAmperaje()+"\" id='amperaje'></label>"); 
			break;

		case GABINETE:
			Gabinete gab=(Gabinete)prod;
			 out.println("<label><span>Tamaño:</span> <input type='text' name='tamaño' value=\""+gab.getTamaño()+"\" id='tamaño'></label>"); 
			break;
		
			
		case HD:
			 Hd disco=(Hd)prod;
			 out.println("<label><span>Capacidad:</span> <input type='text' name='capacidad' value=\""+disco.getCapacidad()+"\" id='capacidad'></label>"); 
			 out.println("<label><span>Interfaz:</span> <input type='text' name='interfaz' value=\""+disco.getInterfaz()+"\" id='interfaz'></label>"); 
			 out.println("<label><span>RPM:</span> <input type='text' name='rpm' value=\""+disco.getRpm()+"\" id='rpm'></label>"); 
			 out.println("<label><span>Buffer:</span> <input type='text' name='buffer' value=\""+disco.getBuffer()+"\" id='buffer'></label>"); 
			 
			break;
			
		case MEMORIA:
			Memoria mem=(Memoria)prod;
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Frecuencia:</td> <td><input class=\"inputTabla\" name=\"frecuenciamem\" type=\"text\" id=\"frecuenciamem\" value=\""+mem.getFrecuencia()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Capacidad:</td> <td><input class=\"inputTabla\" name=\"capacidadmem\" type=\"text\" id=\"capacidadmem\" value=\""+mem.getCantmen()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Latencia:</td> <td><input class=\"inputTabla\" name=\"latencia\" type=\"text\" id=\"latencia\" value=\""+mem.getLatencia()+"\" size=\"32\" /></td> </tr>");
            
			break;
			
		case MICRO:
			Micro mic=(Micro)prod;
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Frecuencia:</td> <td><input class=\"inputTabla\" name=\"frecuenciamicro\" type=\"text\" id=\"frecuenciamicro\" value=\""+mic.getFrecuencia()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cache:</td> <td><input class=\"inputTabla\" name=\"cachemicro\" type=\"text\" id=\"cachemicro\" value=\""+mic.getCaché()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Socket:</td> <td><input class=\"inputTabla\" name=\"socketmicro\" type=\"text\" id=\"socketmicro\" value=\""+mic.getSocket()+"\" size=\"32\" /></td> </tr>");
        	
			break;
		case PLACAMADRE:
			PlacaMadre pm=(PlacaMadre)prod;
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant USB:</td> <td><input class=\"inputTabla\" name=\"cantusb\" type=\"text\" id=\"cantusb\" value=\""+pm.getCantusb()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant USB 3.0:</td> <td><input class=\"inputTabla\" name=\"cantusb3\" type=\"text\" id=\"cantusb3\" value=\""+pm.getCantusb30()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant Pci-E x16:</td> <td><input class=\"inputTabla\" name=\"cantpcie\" type=\"text\" id=\"cantpcie\" value=\""+pm.getCantPCIE()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Video Onboard:</td> <td><input class=\"inputTabla\" name=\"videoonboard\" type=\"text\" id=\"videoonboard\" value=\""+pm.getvOnboard()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Sonido Onboard:</td> <td><input class=\"inputTabla\" name=\"sonidoonboard\" type=\"text\" id=\"sonidoonboard\" value=\""+pm.getsOnboard()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Chipset:</td> <td><input class=\"inputTabla\" name=\"chipset\" type=\"text\" id=\"chipset\" value=\""+pm.getChipset()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant Max Mem:</td> <td><input class=\"inputTabla\" name=\"cantmaxmemmo\" type=\"text\" id=\"cantmaxmemmo\" value=\""+pm.getCantmaxmem()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Socket:</td> <td><input class=\"inputTabla\" name=\"socketmo\" type=\"text\" id=\"socketmo\" value=\""+pm.getSocket()+"\" size=\"32\" /></td> </tr>");
			break;
		case PVIDEO:
			PVideo video=(PVideo)prod;
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Frecuencia:</td> <td><input class=\"inputTabla\" name=\"frecuenciavideo\" type=\"text\" id=\"frecuenciavideo\" value=\""+video.getFrecuencia()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Ancho del Bus:</td> <td><input class=\"inputTabla\" name=\"anchobus\" type=\"text\" id=\"anchobus\" value=\""+video.getAnchobus()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cantidad de Memoria:</td> <td><input class=\"inputTabla\" name=\"cantmemvideo\" type=\"text\" id=\"cantmemvideo\" value=\""+video.getCantmem()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Pipelines:</td> <td><input class=\"inputTabla\" name=\"pipelines\" type=\"text\" id=\"pipelines\" value=\""+video.getPipelines()+"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Shaders:</td> <td><input class=\"inputTabla\" name=\"shaders\" type=\"text\" id=\"shaders\" value=\""+video.getShaders()+"\" size=\"32\" /></td> </tr>");
      	  
            
			break;
		case PSONIDO:
			PSonido sonido = (PSonido)prod;
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Jacks:</td> <td><input class=\"inputTabla\" name=\"jacks\" type=\"text\" id=\"jacks\" value=\""+sonido.getJacks()+"\" size=\"32\" /></td> </tr>");

            
			break;
		case RCABLE:
			RCable cable=(RCable)prod;
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Velocidad:</td> <td><input class=\"inputTabla\" name=\"velocidadc\" type=\"text\" id=\"velocidadc\" value=\""+cable.getVelocidad()+"\" size=\"32\" /></td> </tr>");

	           
			break;
			
		case RED:
			
 
		break;
		
		case DEF:
			out.println("Seleccione una categoria");
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
