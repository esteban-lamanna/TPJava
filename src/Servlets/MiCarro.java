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

/**
 * Servlet implementation class MiCarro
 */
@WebServlet("/MiCarro")
public class MiCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiCarro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		out.println("<form action=\"AgregaCompras\" method=\"GET\">");
		out.println("<table border=1 align=\"center\">");
		out.println("<tr>");
        out.println("<td>Nombre");out.println("</td>");
        out.println("<td>Descripcion");out.println("</td>");
        out.println("<td>Modelo");out.println("</td>");
        out.println("<td>Precio");out.println("</td>");
        out.println("<td>Cantidad");out.println("</td>");
        out.println("<td>Seleccionar");out.println("</td>");
        
        
        out.println("</tr>");
        Controlador_encar contr=new Controlador_encar();
        ArrayList<Producto> prods=contr.levantaCarro();
        for(int i=0;i<prods.size();i++)
        {        	      
        out.println("<tr>");
        out.println("<input type=\"text\" name=\"Codigos\" value=\""+prods.get(i).getCodigo()+"\">");
        out.println("<td>"+prods.get(i).getNombre());out.println("</td>");
        out.println("<td>"+prods.get(i).getDescripcion());out.println("</td>");
        out.println("<td>"+prods.get(i).getModelo());out.println("</td>");
        out.println("<td>"+"$"+prods.get(i).getPrecio());out.println("</td>");
        out.println("<td><input type=\"number\" name=\"Cantidades\" id=\"Cantidades\" min=\"1\" max=\"99\" step=\"1\" value=\"1\">");out.println("</td>");
        out.println("<td><input type=\"checkbox\" name=\"ArticulosSeleccionados\" value=\""+i+"\">");out.println("</td>");
        out.println("</td>");
        out.println("</tr>");
            
        }

        out.println("</table>");
        out.println("<input type=\"submit\" id=\"btnComprar\" name=\"Comprar\" title=\"Comprar\" value=\"Comprar\">");
        out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
