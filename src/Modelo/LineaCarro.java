package Modelo;

public class LineaCarro {
	private String dni;

	private Producto prod;
	
	public Producto getProducto() {
		return prod;
	}
	public void setProducto(Producto prod) {
		this.prod = prod;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
