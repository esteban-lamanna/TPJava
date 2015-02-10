package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controlador.Controlador_encar;

/**
 * Servlet implementation class ModificarProd
 */
@WebServlet("/ModificarProd")
public class ModificarProd extends Padre {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProd() {
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
    	String error=null;
     	request.setAttribute("categ", request.getAttribute("categ"));
     	request.setAttribute("codigoseleccionado", request.getAttribute("codigo"));
		try {
		
    	//hago esto para q no salte la excepcion de querer convertir un null     		
    	float precio = 0.0f,jacks=0.0f;
    	int buffer = 0,frecuenciamem =0,capacidadmem=0,frecuenciamicro=0,cachemicro=0,cantusb=0,
    			cantusb3=0,cantpcie=0,cantmaxmemmo=0,frecuenciavideo=0,cantmemvideo=0,pipelines=0,
    					shaders=0,anchobus=0;
    			Boolean antena = true;
    	
    	
    	String codigo = request.getParameter("codigo");
		String nombreprod = request.getParameter("nombreprod");
		String modelo = request.getParameter("modelo");
		String descripcion = request.getParameter("descripcion");
	    precio =  Float.parseFloat(request.getParameter("precio"));
		String foto = request.getParameter("foto");
		String tipo =request.getParameter("categ");
		System.out.println(tipo);
		Controlador_encar contr= getControlador();

		String taman=request.getParameter("taman");

		String watts= request.getParameter("watts");
		String amperaje= request.getParameter("amperaje");


		String capHD =request.getParameter("capacidadhd"); 
		String interfaz =request.getParameter("interfaz"); 
		String rpm =request.getParameter("rpm"); 
		if(request.getParameter("buffer")!=null) buffer =Integer.parseInt(request.getParameter("buffer"));

		if(request.getParameter("frecuenciamem")!=null)	frecuenciamem = Integer.parseInt(request.getParameter("frecuenciamem"));
		String latencia=request.getParameter("latencia"); 
		
		if(request.getParameter("capacidadmem")!=null)capacidadmem=Integer.parseInt(request.getParameter("capacidadmem"));

		if(request.getParameter("frecuenciamicro")!=null)frecuenciamicro= Integer.parseInt(request.getParameter("frecuenciamicro"));
		if(request.getParameter("cachemicro")!=null)	cachemicro=Integer.parseInt(request.getParameter("cachemicro"));
		String socketmicro=request.getParameter("socketmicro");

		if(request.getParameter("cantusb")!=null)	cantusb= Integer.parseInt(request.getParameter("cantusb"));
		if(request.getParameter("cantusb3")!=null)	cantusb3=Integer.parseInt(request.getParameter("cantusb3"));
		if(request.getParameter("cantpcie")!=null)cantpcie=Integer.parseInt(request.getParameter("cantpcie"));
		String videoonboard=request.getParameter("videoonboard");
		String sonidoonboard=request.getParameter("sonidoonboard");
		String chipset=request.getParameter("chipset");
		if(request.getParameter("cantmaxmemmo")!=null)cantmaxmemmo=Integer.parseInt(request.getParameter("cantmaxmemmo"));
		String socketmo=request.getParameter("socketmo");

		if(request.getParameter("frecuenciavideo")!=null)frecuenciavideo=Integer.parseInt(request.getParameter("frecuenciavideo"));
		
		if(request.getParameter("cantmemvideo")!=null) cantmemvideo=Integer.parseInt(request.getParameter("cantmemvideo"));
		if(request.getParameter("pipelines")!=null)  pipelines=Integer.parseInt(request.getParameter("pipelines"));
		if(request.getParameter("shaders")!=null)shaders=Integer.parseInt(request.getParameter("shaders"));

		if(request.getParameter("jacks")!=null) jacks=  Float.parseFloat(request.getParameter("jacks"));

		String velocidadr=request.getParameter("velocidadr");
		String velocidadPR=request.getParameter("velocidadPR");
		String tecnologiaPR=request.getParameter("tecnologiaPR");
		if(request.getParameter("anchobus")!=null) anchobus=Integer.parseInt(request.getParameter("anchobus"));
		if(request.getParameter("antena")!=null) antena=Boolean.parseBoolean(request.getParameter("antena"));
		String seguridad=request.getParameter("seguridad");

		
		
			error=contr.modificaProducto(codigo,nombreprod,modelo,descripcion,precio,capHD,interfaz,rpm,buffer,
					watts,amperaje,frecuenciamicro,cachemicro,socketmicro,jacks,
					taman,velocidadPR,tecnologiaPR,cantusb,
					cantpcie,videoonboard,sonidoonboard,chipset,cantusb3,
					cantmaxmemmo,frecuenciamem,latencia,    capacidadmem ,frecuenciavideo,
					anchobus,cantmemvideo,pipelines,shaders,socketmo,foto,
					tipo,antena,seguridad);
		
			if(error!=null)
			{ 
				sesion.setAttribute("confirm",error);
				  
			}
			else
			{
				sesion.setAttribute("confirm","bien");
			//	sesion.setAttribute("categ",null);
			}
			System.out.print(error);

		} 
		
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			sesion.setAttribute("confirm",e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			sesion.setAttribute("confirm",e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			sesion.setAttribute("confirm",e.getMessage());
		}
		finally{		response.sendRedirect("Modificaproductoseleccionado.jsp");
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
