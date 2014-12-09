package Modelo;
public class LineaProducto 
{ 
	int cantidad;
	float subtotlinea;
	Producto producto;
	int codC;
	
	
	public int getCodC() {
		return codC;
	}
	public void setCodC(int codC) {
		this.codC = codC;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getSubtotlinea() {
		return subtotlinea;
	}
	public void setSubtotlinea(float subtotlinea) {
		this.subtotlinea = subtotlinea;
	}
	
	public void calculaSubtotlinea()
	{
		this.subtotlinea=this.getProducto().getPrecio()*this.getCantidad();
	}

	
}
