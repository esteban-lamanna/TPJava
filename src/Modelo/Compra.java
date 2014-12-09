package Modelo;
import DB.DBAdapter;

import java.util.ArrayList;
import java.util.Date;  
import java.sql.*;
public class Compra 
{
	ArrayList<LineaProducto> LproductosCompra=new ArrayList<LineaProducto>();
	int i=0;
	float totalcompra=0;
	String estado;
	Date fecha;
	int codcompra;
	int dni;
	
public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
public int getCodcompra() {
		return codcompra;
	}
	public void setCodcompra(int codcompra) {
		this.codcompra = codcompra;
	}
public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
public ArrayList<LineaProducto> getLineasCompra() {
		return LproductosCompra;
	}
	public void setLineasCompra(ArrayList<LineaProducto> productosCompra) {
		LproductosCompra = productosCompra;
			}
	public void añadeLineaCompra(LineaProducto lp)
	{
		LproductosCompra.add(lp);
	}
	public float getTotalcompra() {
		return totalcompra;
	}
	public void setTotalcompra(float totalcompra) {
		this.totalcompra = totalcompra;
	}
	public void aumentaCompra(float pre)
	{
		this.totalcompra=this.totalcompra+pre;
	}

}
