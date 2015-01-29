package Servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Controlador.Controlador_encar;

/**
 * Servlet implementation class RegisterProd
 */

@MultipartConfig
@WebServlet("/RegisterProd")
public class RegisterProd extends Padre {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(false);
    	if(sesion==null)
    	{
    		sesion = request.getSession(true);
    	}
		String nombreprod = request.getParameter("nombreprod");
		String modelo = request.getParameter("modelo");
		String descripcion = request.getParameter("descripcion");
		float precio =  Float.parseFloat(request.getParameter("precio"));
		String foto = request.getParameter("foto");
		String tipo =request.getParameter("categoria");
		System.out.println(tipo);
		Controlador_encar contr= getControlador();

		String taman=request.getParameter("taman");

		String watts= request.getParameter("watts");
		String amperaje= request.getParameter("amperaje");


		String capHD =request.getParameter("capacidadhd"); 
		String interfaz =request.getParameter("interfaz"); 
		String rpm =request.getParameter("rpm"); 
		String buffer =request.getParameter("buffer");

		String frecuenciamem = request.getParameter("frecuenciamem");
		String latencia=request.getParameter("latencia"); 
		String capacidadmem=request.getParameter("capacidadmem");

		String frecuenciamicro= request.getParameter("frecuenciamicro");
		String cachemicro=request.getParameter("cachemicro");
		String socketmicro=request.getParameter("socketmicro");

		String cantusb=request.getParameter("cantusb");
		String cantusb3=request.getParameter("cantusb3");
		String cantpcie=request.getParameter("cantpcie");
		String videoonboard=request.getParameter("videoonboard");
		String sonidoonboard=request.getParameter("sonidoonboard");
		String chipset=request.getParameter("chipset");
		String cantmaxmemmo=request.getParameter("cantmaxmemmo");
		String socketmo=request.getParameter("socketmo");

		String frecuenciavideo=request.getParameter("frecuenciavideo");
		String anchobus=request.getParameter("anchobus");
		String cantmemvideo=request.getParameter("cantmemvideo");
		String pipelines=request.getParameter("pipelines");
		String shaders=request.getParameter("shaders");

		String jacks=request.getParameter("jacks");

		String velocidadr=request.getParameter("velocidadr");

		String error;
		error=contr.nuevoProducto(nombreprod,modelo,descripcion,precio,capHD,interfaz,rpm,buffer,watts,amperaje,frecuenciamicro,cachemicro,socketmicro,jacks,taman,velocidadr,cantusb,cantpcie,videoonboard,sonidoonboard,chipset,cantusb3,cantmaxmemmo,frecuenciamem,latencia,capacidadmem,frecuenciavideo,anchobus,cantmemvideo,pipelines,shaders,socketmo,foto,tipo);

		if(error!=null)
		{ 
			sesion.setAttribute("confirm",error);
			  
		}
		else
		{
			sesion.setAttribute("confirm","bien");
		}

		response.sendRedirect("Altaproductos.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);}
	
	}


