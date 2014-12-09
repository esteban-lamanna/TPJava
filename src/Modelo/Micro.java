package Modelo;

public class Micro extends PlacaMadre
{
float Frecuencia;
int caché;
String socket;

public float getFrecuencia() {
	return Frecuencia;
}
public void setFrecuencia(float frecuencia) {
	Frecuencia = frecuencia;
}
public int getCaché() {
	return caché;
}
public void setCaché(int caché) {
	this.caché = caché;
}
public String getSocket() {
	return socket;
}
public void setSocket(String socket) {
	this.socket = socket;
}


}
