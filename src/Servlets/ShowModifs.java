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
import Modelo.PRed;
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
    	//Producto prod=contr.buscaProducto(Integer.parseInt(request.getParameter("codi")));   
    	Producto prod = contr.buscaProducto(Integer.parseInt(request.getParameter("codi")),request.getParameter("categ"));
		// TODO Auto-generated method stub
		String valori=request.getParameter("categ");		
		Prods valor = Prods.valueOf(valori.toUpperCase());		
		PrintWriter out=response.getWriter();	
		out.println("<label><span>Nombre del Producto </span> <input type='text' name='nombreprod' value=\""+prod.getNombre()+"\" id='nombreprod'></label>"); 
		out.println("<label><span>Modelo:</span> <input type='text' name='modelo' value=\""+prod.getModelo()+"\" id='modelo'></label>"); 
		out.println("<label><span>Descripcion:</span> <input type='text' name='descripcion' value=\""+prod.getDescripcion()+"\" id='descripcion'></label>"); 
      //  out.println("<label><span>Foto:</span> <input type='file' name='foto' value=\""+prod.getFoto()+"\" id='foto'></label>"); 
		  out.println("<label><span>Foto:</span> <input type='text' name='foto' value=\""+prod.getFoto()+"\" readonly='readonly' id='foto'></label>"); 
			
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
			out.println("<label><span>Frecuencia:</span> <input type='text' name='frecuencia' value=\""+mem.getFrecuencia()+"\" id='frecuencia'></label>"); 
			out.println("<label><span>Capacidad:</span> <input type='text' name='capacidad' value=\""+mem.getCantmen()+"\" id='capacidad'></label>"); 
			out.println("<label><span>Latencia:</span> <input type='text' name='latencia' value=\""+mem.getLatencia()+"\" id='latencia'></label>"); 
            
			break;
			
		case MICRO:
			Micro mic=(Micro)prod;
			out.println("<label><span>Frecuencia:</span> <input type='text' name='frecuencia' value=\""+mic.getFrecuencia()+"\" id='frecuencia'></label>"); 
			out.println("<label><span>Cache:</span> <input type='text' name='frecuencia' value=\""+mic.getFrecuencia()+"\" id='frecuencia'></label>"); 
			out.println("<label><span>Socket:</span> <input type='text' name='socket' value=\""+mic.getSocket()+"\" id='socket'></label>"); 
        	
			break;
		case PLACAMADRE:
			PlacaMadre pm=(PlacaMadre)prod;
			out.println("<label><span>Cant USB:</span> <input type='text' name='cantusb' value=\""+pm.getCantusb()+"\" id='cantusb'></label>"); 
			out.println("<label><span>Cant USB 3.0:</span> <input type='text' name='cantusb3' value=\""+pm.getCantusb30()+"\" id='cantusb3'></label>"); 
			out.println("<label><span>Cant Pci-E x16:</span> <input type='text' name='cantpcie' value=\""+pm.getCantPCIE()+"\" id='cantpcie'></label>"); 
			out.println("<label><span>Video Onboard:</span> <input type='text' name='videoonboard' value=\""+pm.getvOnboard()+"\" id='videoonboard'></label>"); 
			out.println("<label><span>Sonido Onboard:</span> <input type='text' name='sonidoonboard' value=\""+pm.getsOnboard()+"\" id='sonidoonboard'></label>"); 
			out.println("<label><span>Chipset:</span> <input type='text' name='chipset' value=\""+pm.getChipset()+"\" id='chipset'></label>"); 
			out.println("<label><span>Cant Max Mem:</span> <input type='text' name='cantmaxmemmo' value=\""+pm.getCantmaxmem()+"\" id='cantmaxmemmo'></label>"); 
			out.println("<label><span>Socket:</span> <input type='text' name='socketmo' value=\""+pm.getSocket()+"\" id='socketmo'></label>"); 
			break;
		case PVIDEO:
			PVideo video=(PVideo)prod;
			out.println("<label><span>Frecuencia:</span> <input type='text' name='frecuenciavideo' value=\""+video.getFrecuencia()+"\" id='frecuenciavideo'></label>"); 
			out.println("<label><span>Ancho del Bus:</span> <input type='text' name='anchobus' value=\""+video.getAnchobus()+"\" id='anchobus'></label>"); 
			out.println("<label><span>Cantidad de Memoria:</span> <input type='text' name='cantmemvideo' value=\""+video.getCantmem()+"\" id='cantmemvideo'></label>"); 
			out.println("<label><span>Pipelines:</span> <input type='text' name='pipelines' value=\""+video.getPipelines()+"\" id='pipelines'></label>"); 
			out.println("<label><span>Shaders:</span> <input type='text' name='shaders' value=\""+video.getShaders()+"\" id='shaders'></label>"); 
      	  
            
			break;
		case PSONIDO:
			PSonido sonido = (PSonido)prod;
			out.println("<label><span>Jacks:</span> <input type='text' name='jacks' value=\""+sonido.getJacks()+"\" id='jacks'></label>"); 

            
			break;
		case RCABLE:
			RCable cable=(RCable)prod;
			out.println("<label><span>Velocidad:</span> <input type='text' name='velocidadc' value=\""+cable.getVelocidad()+"\" id='velocidadc'></label>"); 

	           
			break;
			
		case PRED:
			PRed red=(PRed)prod;
		//	out.println("<label><span>Velocidad:</span> <input type='text' name='velocidadc' value=\""+cable.getVelocidad()+"\" id='velocidadc'></label>"); 

	           
			
 
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
