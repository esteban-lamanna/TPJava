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
import Modelo.Producto;
import Modelo.PWireless;

/**
 * Servlet implementation class PWireless
 */
@WebServlet("/PlacaWireless")
public class PlacaWireless extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlacaWireless() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		out.println("<form action=\"AgregaCarros\" method=\"GET\">");
		out.println("<table border=1 align=\"center\">");
        out.println("<tr>");
        out.println("<td>");out.println("</td>");
        out.println("<td>Nombre");out.println("</td>");
        out.println("<td>Descripcion");out.println("</td>");
        out.println("<td>Modelo");out.println("</td>");
        out.println("<td>Velocidad");out.println("</td>");
        out.println("<td>Seguridad");out.println("</td>");
        out.println("<td>Precio");out.println("</td>");
        
        out.println("<td>Agregar al Carro");out.println("</td>");
        out.println("</tr>");
        Controlador_encar contr=new Controlador_encar();
        ArrayList<Producto> prod=contr.buscaProductos("PWIRELESS");
        for(int i=0;i<prod.size();i++)
        {
        	PWireless pro=(PWireless)prod.get(i);
        
               //String id2=prod.get(i).getRutafoto();
               //System.out.println(id2);
        	 out.println("<input type=\"text\" name=\"Codigos\" value=\""+pro.getCodigo()+"\">");
        out.println("<tr>");
        out.println("<td>"+pro.getFoto());out.println("</td>");
        out.println("<td>"+pro.getNombre());out.println("</td>");
        out.println("<td>"+pro.getDescripcion());out.println("</td>");
        out.println("<td>"+pro.getModelo());out.println("</td>");
        out.println("<td>"+pro.getVelocidad());out.println("</td>");
        out.println("<td>"+pro.getSeguridad());out.println("</td>");
        out.println("<td>"+"$"+prod.get(i).getPrecio());out.println("</td>");
        
        out.println("<td><input type=\"checkbox\" name=\"ArticulosSeleccionados\" value=\""+i+"\">");out.println("</td>");
        out.println("</td>"); 
        out.println("</tr>");
            
        }

        out.println("</table>");
        out.println("<input type=\"submit\" id=\"btnAgregar\" name=\"Agregar\" title=\"Agregar\" value=\"Agregar\">"); 
        out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
