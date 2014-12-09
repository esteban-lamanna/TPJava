package DB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Modelo.Producto;

public class colProductos 
{
 static List<Producto> Productos= new ArrayList<Producto>();
 
	 public static Producto buscaProducto(String prodNombre)
	 {
		 Producto producto=null;
		 Iterator<Producto>iterP=Productos.iterator();
		 while (iterP.hasNext())
			{
				producto=iterP.next();
				if(producto.getNombre().equals(prodNombre))
				{
					return producto;
				}
				
			}
			return producto;
	 }
		public static void añadeProducto(Producto prod)
		{
			Productos.add(prod);
			
		}
				 
	 }
	

