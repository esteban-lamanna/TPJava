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
			
					out.println("<label><span>Watts: </span> <input type='text' name='watts' id='watts'></label>");
					out.println("<label><span>Amperaje: </span> <input type='text' name='amperaje' id='amperaje'></label>");	break;

		case GABINETE:
			out.println("<label><span>Tamaño: </span> <input type='text' name='taman' id='taman'></label>");
			         	        
						break;
		
			
		case HD:
			out.println("<label><span>Capacidad: </span> <input type='text' name='capacidadHD' id='capacidadHD'></label>");
			out.println("<label><span>Interfaz: </span> <input type='text' name='interfaz' id='interfaz'></label>");
			out.println("<label><span>RPM: </span> <input type='text' name='rpm' id='rpm'></label>");
			out.println("<label><span>Buffer: </span> <input type='text' name='buffer' id='buffer'></label>");
         
	        
			break;
			
		case MEMORIA:
			out.println("<label><span>Frecuencia: </span> <input type='text' name='frecuenciamem' id='frecuenciamem'></label>");
			out.println("<label><span>Capacidad: </span> <input type='text' name='capacidadmem' id='capacidadmem'></label>");
			out.println("<label><span>Latencia: </span> <input type='text' name='latencia' id='latencia'></label>");
            
			break;
			
		case MICRO:
			out.println("<label><span>Frecuencia: </span> <input type='text' name='frecuenciamicro' id='frecuenciamicro'></label>");
			out.println("<label><span>Cache: </span> <input type='text' name='cachemicro' id='cachemicro'></label>");
			out.println("<label><span>Socket: </span> <input type='text' name='socketmicro' id='socketmicro'></label>");
        	
			break;
		case PLACAMADRE:
			out.println("<label><span>USB: </span> <input type='text' name='cantusb' id='cantusb'></label>");
			out.println("<label><span>USB 3.0: </span> <input type='text' name='cantusb3' id='cantusb3'></label>");
			out.println("<label><span>Cant Pci-E x16: </span> <input type='text' name='cantpcie' id='cantpcie'></label>");
			out.println("<label><span>Video on board: </span> <input type='text' name='videoonboard' id='videoonboard'></label>");
			out.println("<label><span>Sonido on board: </span> <input type='text' name='sonidoonboard' id='sonidoonboard'></label>");
			out.println("<label><span>Chipset: </span> <input type='text' name='chipset' id='chipset'></label>");
			out.println("<label><span>Cant max memoria: </span> <input type='text' name='cantmaxmemmo' id='cantmaxmemmo'></label>");
			out.println("<label><span>Socket: </span> <input type='text' name='socketmo' id='socketmo'></label>");
			break;
		case PVIDEO:
			out.println("<label><span>Frecuencia: </span> <input type='text' name='frecuenciavideo' id='frecuenciavideo'></label>");
			out.println("<label><span>Ancho del bus: </span> <input type='text' name='anchobus' id='anchobus'></label>");
			out.println("<label><span>Cantidad de memoria: </span> <input type='text' name='cantmemvideo' id='cantmemvideo'></label>");
			out.println("<label><span>Pipelines: </span> <input type='text' name='pipelines' id='pipelines'></label>");
			out.println("<label><span>Shaders: </span> <input type='text' name='shaders' id='shaders'></label>");
      	  
            
			break;
		case PSONIDO:
			out.println("<label><span>Jacks: </span> <input type='text' name='jacks' id='jacks'></label>");

            
			break;
		case RCABLE:
			out.println("<label><span>Velocidad: </span> <input type='text' name='velocidadc' id='v'></label>");

	           
			break;
			
		case RED:
			out.println("<label><span>Velocidad: </span> <input type='text' name='velocidadr' id=''></label>");
 
		break;
		
		case DEF:
		//	out.println("Seleccione una categoria");
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
