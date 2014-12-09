package Modelo;

public class PlacaMadre extends Producto
{
String socket;
int cantusb;
int cantPCIE;
String vOnboard;
String sOnboard;
String Chipset;
int cantusb30;
int cantmaxmem;

public String getSocket() {
	return socket;
}
public void setSocket(String socket) {
	this.socket = socket;
}
public int getCantusb() {
	return cantusb;
}
public void setCantusb(int cantusb) {
	this.cantusb = cantusb;
}
public int getCantPCIE() {
	return cantPCIE;
}
public void setCantPCIE(int cantPCIE) {
	this.cantPCIE = cantPCIE;
}
public String getvOnboard() {
	return vOnboard;
}
public void setvOnboard(String vOnboard) {
	this.vOnboard = vOnboard;
}
public String getsOnboard() {
	return sOnboard;
}
public void setsOnboard(String sOnboard) {
	this.sOnboard = sOnboard;
}
public String getChipset() {
	return Chipset;
}
public void setChipset(String chipset) {
	Chipset = chipset;
}
public int getCantusb30() {
	return cantusb30;
}
public void setCantusb30(int cantusb30) {
	this.cantusb30 = cantusb30;
}
public int getCantmaxmem() {
	return cantmaxmem;
}
public void setCantmaxmem(int cantmaxmem) {
	this.cantmaxmem = cantmaxmem;
}



}
