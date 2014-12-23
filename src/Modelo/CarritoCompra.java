package Modelo;
import java.util.*;

public class CarritoCompra 
{
	ArrayList<Producto> productosCarro=new ArrayList<Producto>();
	int dni;
	private int codigo_carrito;
	
	public int getCodigo_carrito() {
		return codigo_carrito;
	}

	public void setCodigo_carrito(int codigo_carrito) {
		this.codigo_carrito = codigo_carrito;
	}

	public void añadeProducto(Producto p)
	{
		productosCarro.add(p);
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public ArrayList<Producto> getProductosCarro() 
	{
		return productosCarro;
	}
	public void setProductosCarro(ArrayList<Producto> productosCarro) 
	{
		this.productosCarro = productosCarro;
	}
}
