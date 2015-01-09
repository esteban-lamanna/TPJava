package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controlador.Controlador_encar;
import Modelo.Gabinete;
import Modelo.Producto;

/**
 * Servlet implementation class Gabinetes
 */
@WebServlet("/Gabinetes")
public class Gabinetes extends Padre {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gabinetes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        Controlador_encar contr = getControlador();
        ArrayList<Producto> prod=contr.buscaProductos("gabinete");
        ArrayList<Producto>prodsCarroActual = new ArrayList<Producto>();
        if(contr.getCarroCompleto()!=null){
        if(contr.getCarroCompleto().getProductosCarro()!=null)
        {
        	
        
        prodsCarroActual = contr.getCarroCompleto().getProductosCarro();
        }
        }
        HttpSession sesion = request.getSession(false);
        if(sesion == null)
        {
        	sesion = request.getSession(true);
        }
        Boolean agregado;
        for(int i=0;i<prod.size();i++)
        {
        	agregado=false;
        	
        	for (int j=0;j< prodsCarroActual.size();j++)
        	{
				
				if(prod.get(i).getCodigo()==prodsCarroActual.get(j).getCodigo())
				{
					agregado=true;
				}
        	}
        	Gabinete pro=(Gabinete)prod.get(i);
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
              out.println("Tama�o: <span>"+pro.getTama�o()+" Watts</span><br />");
              out.println(" </p>");   
              out.println("<p class=\"price\">Precio: <strong> $"+pro.getPrecio()+"</strong></p>");
              
             
             
              
             
           
              if(sesion.getAttribute("dni")!=null && sesion.getAttribute("dni")!="")
              {
              if(!agregado)
              {
              out.println("<input type=\"button\" id=\"btnAgregar\" title=\"Agregar\" value=\"Agregar\" onclick=\"agregar("+pro.getCodigo()+")\" />");
              }
              else
              {
              out.println("<input type=\"button\" id=\"btnQuitar\" title=\"Quitar\" value=\"Quitar\" onclick=\"quitar("+pro.getCodigo()+")\" />");
                   
              }
              out.println("</li>");
              }
              
      }
        }

       
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
