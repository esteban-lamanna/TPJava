package Servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.Controlador_encar;

/**
 * Servlet implementation class AgregaCompras
 */
@WebServlet("/AgregaCompras")
public class AgregaCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregaCompras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String[] indices= request.getParameterValues("ArticulosSeleccionados");
		String[] codigos= request.getParameterValues("Codigos");
		String[] cantidades= request.getParameterValues("Cantidades");
		int max=0;
		int a=0;
		int b;
		for(int p=0;p<codigos.length-1;p++)
		{
			a=Integer.parseInt(codigos[p]);
			b=Integer.parseInt(codigos[p+1]);
			if(a<b)
			{
				max=b;
			}
			else
			{
				max=a;
			}
			
			
		}
		int ultcod=Integer.parseInt(codigos[codigos.length-1]);
		String[] cod=new String[indices.length];
		String[] cant=new String[indices.length];
		int z=0;
		for(int j=0;j!=indices.length;j++) 
		{
			for (int i=0;i<=max;i++)
			{
				if(i==Integer.parseInt(indices[j]))
				{
					cod[z]=codigos[i];
					cant[z]=cantidades[i];
					z++;
					System.out.println("Producto numer "+codigos[i]);
					break;
				}
			}
		}
		if(cod.length!=0)
		{
		Controlador_encar contr=new Controlador_encar();
		contr.Comprar(cod, cant, "1");
		
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
