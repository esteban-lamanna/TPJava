package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
import Modelo.RCable;
import Servlets.Busqueda.Prods;

/**
 * Servlet implementation class ShowInputs
 */
@WebServlet("/ShowInputs")
public class ShowInputs extends HttpServlet {
	
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
    public ShowInputs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String valori=request.getParameter("categ");
		Prods valor = Prods.valueOf(valori.toUpperCase());
		PrintWriter out=response.getWriter();
		
		switch(valor)
		{
		case FUENTE:		        
 out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Watts:</td> <td><input class=\"inputTabla\" name=\"watts\" type=\"text\" id=\"watts\" value=\"\" size=\"32\" /></td> </tr>");
 out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Amperaje:</td> <td><input class=\"inputTabla\" name=\"amperaje\" type=\"text\" id=\"amperaje\" value=\"\" size=\"32\" /></td> </tr>");  	          	        
			break;

		case GABINETE:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Tamaño:</td> <td><input class=\"inputTabla\" name=\"taman\" type=\"text\" id=\"taman\" value=\"\" size=\"32\" /></td> </tr>");
			         	        
						break;
		
			
		case HD:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Capacidad:</td> <td><input class=\"inputTabla\" name=\"capacidadhd\" type=\"text\" id=\"capacidadhd\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Interfaz:</td> <td><input class=\"inputTabla\" name=\"interfaz\" type=\"text\" id=\"interfaz\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">RPM:</td> <td><input class=\"inputTabla\" name=\"rpm\" type=\"text\" id=\"rpm\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Buffer:</td> <td><input class=\"inputTabla\" name=\"buffer\" type=\"text\" id=\"buffer\" value=\"\" size=\"32\" /></td> </tr>");
	               
	        
			break;
			
		case MEMORIA:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Frecuencia:</td> <td><input class=\"inputTabla\" name=\"frecuenciamem\" type=\"text\" id=\"frecuenciamem\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Capacidad:</td> <td><input class=\"inputTabla\" name=\"capacidadmem\" type=\"text\" id=\"capacidadmem\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Latencia:</td> <td><input class=\"inputTabla\" name=\"latencia\" type=\"text\" id=\"latencia\" value=\"\" size=\"32\" /></td> </tr>");
            
			break;
			
		case MICRO:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Frecuencia:</td> <td><input class=\"inputTabla\" name=\"frecuenciamicro\" type=\"text\" id=\"frecuenciamicro\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cache:</td> <td><input class=\"inputTabla\" name=\"cachemicro\" type=\"text\" id=\"cachemicro\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Socket:</td> <td><input class=\"inputTabla\" name=\"socketmicro\" type=\"text\" id=\"socketmicro\" value=\"\" size=\"32\" /></td> </tr>");
        	
			break;
		case PLACAMADRE:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant USB:</td> <td><input class=\"inputTabla\" name=\"cantusb\" type=\"text\" id=\"cantusb\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant USB 3.0:</td> <td><input class=\"inputTabla\" name=\"cantusb3\" type=\"text\" id=\"cantusb3\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant Pci-E x16:</td> <td><input class=\"inputTabla\" name=\"cantpcie\" type=\"text\" id=\"cantpcie\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Video Onboard:</td> <td><input class=\"inputTabla\" name=\"videoonboard\" type=\"text\" id=\"videoonboard\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Sonido Onboard:</td> <td><input class=\"inputTabla\" name=\"sonidoonboard\" type=\"text\" id=\"sonidoonboard\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Chipset:</td> <td><input class=\"inputTabla\" name=\"chipset\" type=\"text\" id=\"chipset\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cant Max Mem:</td> <td><input class=\"inputTabla\" name=\"cantmaxmemmo\" type=\"text\" id=\"cantmaxmemmo\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Socket:</td> <td><input class=\"inputTabla\" name=\"socketmo\" type=\"text\" id=\"socketmo\" value=\"\" size=\"32\" /></td> </tr>");
			break;
		case PVIDEO:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Frecuencia:</td> <td><input class=\"inputTabla\" name=\"frecuenciavideo\" type=\"text\" id=\"frecuenciavideo\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Ancho del Bus:</td> <td><input class=\"inputTabla\" name=\"anchobus\" type=\"text\" id=\"anchobus\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Cantidad de Memoria:</td> <td><input class=\"inputTabla\" name=\"cantmemvideo\" type=\"text\" id=\"cantmemvideo\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Pipelines:</td> <td><input class=\"inputTabla\" name=\"pipelines\" type=\"text\" id=\"pipelines\" value=\"\" size=\"32\" /></td> </tr>");
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Shaders:</td> <td><input class=\"inputTabla\" name=\"shaders\" type=\"text\" id=\"shaders\" value=\"\" size=\"32\" /></td> </tr>");
      	  
            
			break;
		case PSONIDO:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Jacks:</td> <td><input class=\"inputTabla\" name=\"jacks\" type=\"text\" id=\"jacks\" value=\"\" size=\"32\" /></td> </tr>");

            
			break;
		case RCABLE:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Velocidad:</td> <td><input class=\"inputTabla\" name=\"velocidadc\" type=\"text\" id=\"velocidadc\" value=\"\" size=\"32\" /></td> </tr>");

	           
			break;
			
		case RED:
			out.println("<tr valign=\"baseline\"><td nowrap=\"nowrap\" class=\"etiquetaTabla\" align=\"right\">Velocidad:</td> <td><input class=\"inputTabla\" name=\"velocidadr\" type=\"text\" id=\"velocidadr\" value=\"\" size=\"32\" /></td> </tr>");  
 
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
