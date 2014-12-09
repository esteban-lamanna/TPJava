package Modelo;

public class PVideo extends Producto
{
float frecuencia;
int anchobus;
int cantmem;
int pipelines;
int shaders;

public float getFrecuencia() {
	return frecuencia;
}
public void setFrecuencia(float frecuencia) {
	this.frecuencia = frecuencia;
}
public int getAnchobus() {
	return anchobus;
}
public void setAnchobus(int anchobus) {
	this.anchobus = anchobus;
}
public int getCantmem() {
	return cantmem;
}
public void setCantmem(int cantmem) {
	this.cantmem = cantmem;
}
public int getPipelines() {
	return pipelines;
}
public void setPipelines(int pipelines) {
	this.pipelines = pipelines;
}
public int getShaders() {
	return shaders;
}
public void setShaders(int shaders) {
	this.shaders = shaders;
}


}
