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
import Modelo.PlacaMadre;
import Modelo.Producto;

/**
 * Servlet implementation class PlacasMadres
 */
@WebServlet("/PlacasMadres")
public class PlacasMadres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlacasMadres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Controlador_encar contr=new Controlador_encar();
        ArrayList<Producto> prod=contr.buscaProductos("PLACAMADRE");
        for(int i=0;i<prod.size();i++)
        {
        	PlacaMadre pro=(PlacaMadre)prod.get(i);
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
            out.println("Cantidad Usb: <span>"+pro.getCantusb()+"</span><br />");
            out.println("Cantidad Usb 3.0: <span>"+pro.getCantusb30()+"</span><br />");
            out.println("Cantidad PCI-E x16: <span>"+pro.getCantPCIE()+"x16"+"</span><br />");
            out.println("video Onboard: <span>"+pro.getvOnboard()+"</span><br />");
            out.println("Sonido Onboard: <span>"+pro.getsOnboard()+"</span><br />");
            out.println("Chipset: <span>"+pro.getChipset()+"</span><br />");
            out.println("Cantidad Memoria Máxima: <span>"+pro.getCantmaxmem()+"</span><br />");
            out.println(" </p>");   
            out.println("<p class=\"price\">Precio: <strong> $"+pro.getPrecio()+"</strong></p>");
            out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+pro.getCodigo()+")\" />");
            out.println("</li>");
               //String id2=prod.get(i).getRutafoto();
               //System.out.println(id2);
        
              
        
            
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
