package Modelo;
import java.util.ArrayList;

import DB.DBAdapter;

public class Usuario 
{
int dni;
String nombre;
String apellido;
String direccion;
String localidad;
String direnvio;
String contraseña;
String mail;
int EsAdmin;

int edad;
CarritoCompra carcomp;
ArrayList<Compra> compras;


public String getMail() 
{
	return mail;
}
public void setMail(String mail) 
{
	this.mail = mail;
}

	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDirenvio() {
		return direnvio;
	}
	public void setDirenvio(String direnvio) {
		this.direnvio = direnvio;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public CarritoCompra getCarcomp() 
	{
		return carcomp;
	}
	public void setCarcomp(CarritoCompra carcomp) {
		this.carcomp = carcomp;
	}
	public ArrayList<Compra> getCompras() {
		if(compras == null)
		{
			compras = new ArrayList<Compra>();
		}
		return compras;
	}
	public void setCompras(ArrayList<Compra> comp)
	{
		this.getCompras().addAll(comp);
		
	}

	
	public void añadeCompra(Compra compr)
	{
		this.getCompras().add(compr);
	}
	public void cargaUsuario(int dni,String pass,String nom,String apell,String direc,String envio,String mail,String localidad,int edad)
	{
		this.setApellido(apell);
		this.setContraseña(pass);
		this.setDireccion(direc);
		this.setDirenvio(envio);
		this.setDni(dni);
		this.setLocalidad(localidad);
		this.setEdad(edad);
		
	}
	public CarritoCompra AñadeCarrito()
	{
		CarritoCompra car=new CarritoCompra();
		car.setDni(String.valueOf(this.dni));
		carcomp=car;
		return carcomp;
		
	}
	public int getEsAdmin() {
		return EsAdmin;
	}
	public void setEsAdmin(int esAdmin) {
		EsAdmin = esAdmin;
	}
	
}

