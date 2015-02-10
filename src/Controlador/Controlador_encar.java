package Controlador;

import java.util.*;

import org.apache.catalina.Session;
import java.sql.SQLException;
import DB.DBUsuarios;
import DB.DBProductos;
import Modelo.CarritoCompra;
import Modelo.Compra;
import Modelo.LineaProducto;
import Modelo.Producto;
import Modelo.Fuente;
import Modelo.Gabinete;
import Modelo.Hd;
import Modelo.Memoria;
import Modelo.Micro;
import Modelo.PlacaMadre;
import Modelo.PRed;
import Modelo.PSonido;
import Modelo.PVideo;
import Modelo.PWireless;
import Modelo.RCable;
import Modelo.Usuario;
import DB.DBCarros;
import DB.DBCompras;
import DB.DBLineascomp;

import DB.DBLineaCarro;
import Modelo.LineaCarro;

public class Controlador_encar 
{
static Usuario usuarioActual=new Usuario();
static Compra compraActual;
static Producto productoActual;
static LineaProducto lineaActual;
static CarritoCompra carroOld=new CarritoCompra();
static CarritoCompra carroNew=new CarritoCompra();
static CarritoCompra carroCompleto;
static String[] correcto;
static DBUsuarios UsuariosDB=new DBUsuarios();
static DBProductos ProductosDB=new DBProductos();
static DB.DBLineaCarro DBLineaCarro=new DBLineaCarro();
static DBLineascomp LineascompDB=new DBLineascomp();
static DBCarros CarrosDB=new DBCarros();
static DBCompras ComprasDB=new DBCompras();
static ArrayList<LineaProducto> LineaProductos;
static ArrayList<Compra> comprasActuales;
static ArrayList<Producto> productosActuales;

public CarritoCompra getCarroCompleto()
{
		return usuarioActual.getCarcomp();
	}
	public Usuario getUsuarioActual()
	{
		return usuarioActual;
}


public enum Prods {

    FUENTE,
    GABINETE,
    HD,
    MEMORIA,
    MICRO,
    PLACAMADRE,
    PRED,
    PSONIDO,
    PVIDEO,
    PWIRELESS,
    RCABLE
  				}
public boolean Login(String dni,String pass)
{
	boolean band = false;
	UsuariosDB=new DBUsuarios();
	usuarioActual=UsuariosDB.validaUsuario(dni,pass);
	if(usuarioActual!=null)
	{
		band = true;
		this.LevantaCarroOld(dni);
		carroNew=new CarritoCompra();
	}
	return band;
}

public void SetCarroComprasAUsuario(CarritoCompra carro)
{
	usuarioActual.setCarcomp(carro);
}
public void LevantaCarroOld(String dni)
{
	carroOld.getProductosCarro().clear();
	ArrayList<Integer> codigos=CarrosDB.BuscaProductos(dni);
	for(int codigo: codigos)
	{
		System.out.print("CODIGO SALIDO DEL ARRAY "+codigo);
		carroOld.añadeProducto(ProductosDB.buscaProducto(codigo));
	}
	
}


public ArrayList<Compra> getCompras()
{
	return ComprasDB.getCompras();
}


public void saveEstadoCompras(String codigos[],String estados[])
{
	ArrayList<Compra> compras = new ArrayList<Compra>();
	for(int i=0;i<codigos.length;i++){
		Compra com = new Compra();
		com.setEstado(estados[i]);
		com.setCodcompra(Integer.valueOf(codigos[i]));

		compras.add(com);
	}
	ComprasDB.GuardarEstadoCompra(compras);
	}


public void modificaUsuario(String dni,String pass,String valpass,String apellido,String direccion,String localidad,String direnvio,String nombre,String mail, String edad)
{
	UsuariosDB=new DBUsuarios();
	usuarioActual.setDni(Integer.parseInt(dni));
	usuarioActual.setContraseña(pass);
	usuarioActual.setNombre(nombre);
	usuarioActual.setApellido(apellido);
	usuarioActual.setDireccion(direccion);
	usuarioActual.setLocalidad(localidad);
	usuarioActual.setDirenvio(direnvio);
	usuarioActual.setEdad(Integer.parseInt(edad));
	usuarioActual.setMail(mail);
	UsuariosDB.ActualizaUsuario(usuarioActual);
	
}



public void levantaCompras()
{
	comprasActuales=ComprasDB.buscaCompras(usuarioActual.getDni());
	usuarioActual.setCompras(comprasActuales);
}

public String nuevoProducto(String nombre,String modelo,String descripcion,float precio,String capHD,String interfazHD,String rpmHD,String bufferHD,
		String wattsF,String amperajeF,String frecM,String cacheM,String SocketM,String jacksS,String tamañoG,String velocidadPR,String cantUSBMO,
		String cantpcieMO,String vonboardMO,String sonboardMO,String chipsetMO,String USB30MO,String cantmaxmemMO,String frecMem,String latenciaMem,String cantmemMem,String frecvga,
		String abusvga,String cantmemVGA,String pipelsvga,String shadersvga,String socket,String foto,String tipo)
		{
	
			String error=null;
			String strRutaImagen;			
	         //Instanciamos la clase que corrige la ruta del archivo
	         Util.CorregirRuta ruta1 = new Util.CorregirRuta(foto,"\\", "\\\\");
	         //CORREGIR LA RUTA
	         foto = ruta1.obtenerRutaCorregidaWindows();      
	         
	         
			//foto.replaceAll("\\", "/");			    
			productoActual=ProductosDB.buscaProducto(nombre, modelo);
			if(productoActual!=null)
			{
				error="El nombre y modelo de ese producto ya existe en el sistema";
				return error;
				
			}
			else
			{
				System.out.print("Podemos Crearlo");
				Prods enumval = Prods.valueOf(tipo.toUpperCase());
				switch(enumval)
				{
				case FUENTE:
				Fuente fu=new Fuente();
				fu.setDescripcion(descripcion);
				fu.setFoto(foto);
				fu.setModelo(modelo);
				fu.setNombre(nombre);
				fu.setPrecio(precio);
				fu.setTipo(tipo);
				fu.setAmperaje(Float.parseFloat(amperajeF));
				fu.setWatts(Integer.parseInt(wattsF));
				ProductosDB.añadeProducto(fu);
				break;
				
			    case GABINETE:
			    	 Gabinete gab=new Gabinete();
			    	 gab.setDescripcion(descripcion);
			    	 gab.setFoto(foto);
			    	 gab.setModelo(modelo);
			    	 gab.setNombre(nombre);
			    	 gab.setPrecio(precio);
			    	 gab.setTipo(tipo);
			    	 gab.setTamaño(tamañoG);
			    	 ProductosDB.añadeProducto(gab);
			    	  break;
			    	  
			    	  
			      case HD:
			    	  Hd hard=new Hd();
			    	  hard.setDescripcion(descripcion);
			    	  hard.setFoto(foto);
			    	  hard.setModelo(modelo);
			    	  hard.setNombre(nombre);
			    	  hard.setPrecio(precio);
			    	  hard.setTipo(tipo);
			    	  hard.setBuffer(Integer.parseInt(bufferHD));
			    	  hard.setCapacidad(capHD);
			    	  hard.setInterfaz(interfazHD);
			    	  hard.setRpm(rpmHD);
			    	  ProductosDB.añadeProducto(hard);
			    	  break;
			    	  
			    	  
			      case MEMORIA:
			    	  Memoria mem=new Memoria();
			    	  mem.setDescripcion(descripcion);
			    	  mem.setFoto(foto);
			    	  mem.setModelo(modelo);
			    	  mem.setNombre(nombre);
			    	  mem.setPrecio(precio);
			    	  mem.setTipo(tipo);
			    	  mem.setCantmen(Integer.parseInt(cantmemMem));
			    	  mem.setFrecuencia(Float.parseFloat(frecMem));
			    	  mem.setLatencia(latenciaMem);
			    	  ProductosDB.añadeProducto(mem);
			    	  break;
			    	  
			      case MICRO:
			    	  Micro micro=new Micro();
			    	  micro.setDescripcion(descripcion);
			    	  micro.setFoto(foto);
			    	  micro.setModelo(modelo);
			    	  micro.setNombre(nombre);
			    	  micro.setPrecio(precio);
			    	  micro.setTipo(tipo);
			    	  micro.setCaché(Integer.parseInt(cacheM));
			    	  micro.setFrecuencia(Float.parseFloat(frecM));
			    	  micro.setSocket(SocketM);
			    	  ProductosDB.añadeProducto(micro);
			    	  break;
			    	  
			    	  
			      case PLACAMADRE:
			    	  PlacaMadre plat=new PlacaMadre();
			    	  plat.setDescripcion(descripcion);
			    	  plat.setFoto(foto);
			    	  plat.setModelo(modelo);
			    	  plat.setNombre(nombre);
			    	  plat.setPrecio(precio);
			    	  plat.setTipo(tipo);
			    	  plat.setCantusb(Integer.parseInt(cantUSBMO));
			    	  plat.setCantPCIE(Integer.parseInt(cantpcieMO));
			    	  plat.setCantmaxmem(Integer.parseInt(cantmaxmemMO));
			    	  plat.setCantusb30(Integer.parseInt(USB30MO));
			    	  plat.setChipset(chipsetMO);
			    	  plat.setSocket(socket);
			    	  plat.setvOnboard(vonboardMO);
			    	  plat.setsOnboard(sonboardMO);
			    	  ProductosDB.añadeProducto(plat);
			    	  break;
			    	  
			    	  
			      case PRED:
			    	  PRed pr=new PRed();
			    	  pr.setDescripcion(descripcion);
			    	  pr.setFoto(foto);
			    	  pr.setModelo(modelo);
			    	  pr.setNombre(nombre);
			    	  pr.setPrecio(precio);
			    	  pr.setTipo(tipo);
			    	  pr.setVelocidad(velocidadPR);
			    	  ProductosDB.añadeProducto(pr);
			    	  break;
			    	  
			    	  
			      case PSONIDO:
			    	  PSonido ps=new PSonido();
			    	  ps.setDescripcion(descripcion);
			    	  ps.setFoto(foto);
			    	  ps.setModelo(modelo);
			    	  ps.setNombre(nombre);
			    	  ps.setPrecio(precio);
			    	  ps.setTipo(tipo);
			    	  ps.setJacks(Float.parseFloat(jacksS));
			    	  ProductosDB.añadeProducto(ps);
			    	  break;
			    	  
			      case PVIDEO:
			    	  PVideo pv=new PVideo();
			    	  pv.setDescripcion(descripcion);
			    	  pv.setFoto(foto);
			    	  pv.setModelo(modelo);
			    	  pv.setNombre(nombre);
			    	  pv.setPrecio(precio);
			    	  pv.setTipo(tipo);
			    	  pv.setAnchobus(Integer.parseInt(abusvga));
			    	  pv.setCantmem(Integer.parseInt(cantmemVGA));
			    	  pv.setFrecuencia(Float.parseFloat(frecvga));
			    	  pv.setPipelines(Integer.parseInt(pipelsvga));
			    	  pv.setShaders(Integer.parseInt(shadersvga));
			    	  ProductosDB.añadeProducto(pv);
			    	  break;
			      
			      	case RCABLE:
			    	  RCable cab=new RCable();
			    	  cab.setDescripcion(descripcion);
			    	  cab.setFoto(foto);
			    	  cab.setModelo(modelo);
			    	  cab.setNombre(nombre);
			    	  cab.setPrecio(precio);
			    	  cab.setTipo(tipo);
			    	  cab.setVelocidad(velocidadPR);
			    	  ProductosDB.añadeProducto(cab);
			    	  break;
				
				}			
			}				
			return error;			
		}

public String modificaProducto(String codigo,String nombre,String modelo,String descripcion,
		float precio,String capHD,String interfazHD,String rpmHD,int bufferHD,
		String wattsF,String amperajeF,int frecM,int cacheM,String SocketM,float jacksS,
		String tamañoG,String velocidadPR,String tecnologiaPR,int cantUSBMO,
		int cantpcieMO,String vonboardMO,String sonboardMO,String chipsetMO,int USB30MO,
		int cantmaxmemMO,int frecMem,String latenciaMem,int cantmemMem,int frecvga,
		int abusvga,int cantmemVGA,int pipelsvga,int shadersvga,String socket,String foto,
		String tipo,boolean antena,String seguridad) throws NumberFormatException, SQLException
{
	try{
	String error= null;
	 Util.CorregirRuta ruta1 = new Util.CorregirRuta(foto,"\\", "\\\\");
     //CORREGIR LA RUTA
     foto = ruta1.obtenerRutaCorregidaWindows();      
	//foto.replaceAll("\\", "/");			    
	productoActual=ProductosDB.buscaProducto(Integer.parseInt(codigo),tipo);
	
	
	if(productoActual==null)
	{
		error="El producto no existe en el sistema";
		return error;
		
	}
	else
	{
	
	Prods enumval = Prods.valueOf(productoActual.getTipo().toUpperCase());
	switch(enumval)
	{
	
	case FUENTE:
	Fuente fu=(Fuente)productoActual;
	fu.setDescripcion(descripcion);
	fu.setFoto(foto);
	fu.setModelo(modelo);
	fu.setNombre(nombre);
	fu.setPrecio(precio);
	fu.setTipo(tipo);
	fu.setAmperaje(Float.parseFloat(amperajeF));
	fu.setWatts(Integer.parseInt(wattsF));
	ProductosDB.modificaProducto(fu);
	break;
	
    case GABINETE:
    	 Gabinete gab=(Gabinete)productoActual;
    	 gab.setDescripcion(descripcion);
    	 gab.setFoto(foto);
    	 gab.setModelo(modelo);
    	 gab.setNombre(nombre);
    	 gab.setPrecio(precio);
    	 gab.setTipo(tipo);
    	 gab.setTamaño(tamañoG);
    	 ProductosDB.modificaProducto(gab);
    	  break;
    	  
    	  
      case HD:
    	  Hd hard=(Hd)productoActual;
    	  hard.setDescripcion(descripcion);
    	  hard.setFoto(foto);
    	  hard.setModelo(modelo);
    	  hard.setNombre(nombre);
    	  hard.setPrecio(precio);
    	  hard.setTipo(tipo);
    	  hard.setBuffer(bufferHD);
    	  hard.setCapacidad(capHD);
    	  hard.setInterfaz(interfazHD);
    	  hard.setRpm(rpmHD);
    	  ProductosDB.modificaProducto(hard);
    	  break;
    	  
    	  
      case MEMORIA:
    	  Memoria mem=(Memoria)productoActual;
    	  mem.setDescripcion(descripcion);
    	  mem.setFoto(foto);
    	  mem.setModelo(modelo);
    	  mem.setNombre(nombre);
    	  mem.setPrecio(precio);
    	  mem.setTipo(tipo);
    	  mem.setCantmen(cantmemMem);
    	  mem.setFrecuencia(frecMem);
    	  mem.setLatencia(latenciaMem);
    	  ProductosDB.modificaProducto(mem);
    	  break;
    	  
      case MICRO:
    	  Micro micro=(Micro)productoActual;
    	  micro.setDescripcion(descripcion);
    	  micro.setFoto(foto);
    	  micro.setModelo(modelo);
    	  micro.setNombre(nombre);
    	  micro.setPrecio(precio);
    	  micro.setTipo(tipo);
    	  micro.setCaché(cacheM);
    	  micro.setFrecuencia(frecM);
    	  micro.setSocket(SocketM);
    	  ProductosDB.modificaProducto(micro);
    	  break;
    	  
    	  
      case PLACAMADRE:
    	  PlacaMadre plat=(PlacaMadre)productoActual;
    	  plat.setDescripcion(descripcion);
    	  plat.setFoto(foto);
    	  plat.setModelo(modelo);
    	  plat.setNombre(nombre);
    	  plat.setPrecio(precio);
    	  plat.setTipo(tipo);
    	  plat.setCantusb(cantUSBMO);
    	  plat.setCantPCIE(cantpcieMO);
    	  plat.setCantmaxmem(cantmaxmemMO);
    	  plat.setCantusb30(USB30MO);
    	  plat.setChipset(chipsetMO);
    	  plat.setSocket(socket);
    	  plat.setvOnboard(vonboardMO);
    	  plat.setsOnboard(sonboardMO);
    	  ProductosDB.modificaProducto(plat);
    	  break;
    	  
    	  
      case PRED:
    	  PRed pr=(PRed)productoActual;
    	  pr.setDescripcion(descripcion);
    	  pr.setFoto(foto);
    	  pr.setModelo(modelo);
    	  pr.setNombre(nombre);
    	  pr.setPrecio(precio);
    	  pr.setTipo(tipo);
    	  pr.setVelocidad(velocidadPR);
    	  ProductosDB.modificaProducto(pr);
    	  break;
    	  
    	  
      case PSONIDO:
    	  PSonido ps=(PSonido)productoActual;
    	  ps.setDescripcion(descripcion);
    	  ps.setFoto(foto);
    	  ps.setModelo(modelo);
    	  ps.setNombre(nombre);
    	  ps.setPrecio(precio);
    	  ps.setTipo(tipo);
    	  ps.setJacks(jacksS);
    	  ProductosDB.modificaProducto(ps);
    	  break;
    	  
      case PVIDEO:
    	  PVideo pv=(PVideo)productoActual;
    	  pv.setDescripcion(descripcion);
    	  pv.setFoto(foto);
    	  pv.setModelo(modelo);
    	  pv.setNombre(nombre);
    	  pv.setPrecio(precio);
    	  pv.setTipo(tipo);
    	  pv.setAnchobus(abusvga);
    	  pv.setCantmem(cantmemVGA);
    	  pv.setFrecuencia(frecvga);
    	  pv.setPipelines(pipelsvga);
    	  pv.setShaders(shadersvga);
    	  ProductosDB.modificaProducto(pv);
    	  break;
      case PWIRELESS:
    	  PWireless PW=(PWireless)productoActual;
    	  PW.setDescripcion(descripcion);
    	  PW.setFoto(foto);
    	  PW.setModelo(modelo);
    	  PW.setNombre(nombre);
    	  PW.setPrecio(precio);
    	  PW.setTipo(tipo);
    	  PW.setSeguridad(seguridad);
    	  PW.setVelocidad(velocidadPR);
    	  ProductosDB.modificaProducto(PW);
    	  break;
      	case RCABLE:
    	  RCable cab=(RCable)productoActual;
    	  cab.setDescripcion(descripcion);
    	  cab.setFoto(foto);
    	  cab.setModelo(modelo);
    	  cab.setNombre(nombre);
    	  cab.setPrecio(precio);
    	  cab.setTipo(tipo);
    	  cab.setVelocidad(velocidadPR);
    	  ProductosDB.modificaProducto(cab);
    	  break;
	
	}

	}
	return error;
	}
	catch(Exception e)
	{
		return e.getMessage();
	}
	
}

public ArrayList<Producto> buscaProductosNombre(String nombre)
{
	productosActuales=ProductosDB.buscaProductos(nombre);
	return productosActuales;
}

public Float buscaPrecioProductoCodigo(int codigo)
{
	Producto prod = ProductosDB.buscaProducto(codigo);
	return prod.getPrecio();
	
}

public ArrayList<Producto> buscaProductos(String tipo)
{
	Prods enumval = Prods.valueOf(tipo.toUpperCase());
	switch(enumval)
	{
	case FUENTE:
		productosActuales=ProductosDB.buscaFuentes();
	break;
	
    case GABINETE:
    	productosActuales=ProductosDB.buscaGabinetes();
    	  break;
    	  
    	  
      case HD:
    	  productosActuales=ProductosDB.buscaHds();
    	  break;
    	  
    	  
      case MEMORIA:
    	  productosActuales=ProductosDB.buscaMemorias();
    	  break;
    	  
      case MICRO:
    	  
    	  productosActuales=ProductosDB.buscaMicros();
    	  break;
    	  
    	  
      case PLACAMADRE:
    	  productosActuales=ProductosDB.buscaPlacasMadres();
    	  break;
    	  
    	  
      case PRED:
    	  productosActuales=ProductosDB.buscaPredss();
    	  break;
    	  
    	  
      case PSONIDO:
    	  productosActuales=ProductosDB.buscaPsonidos();
    	  break;
    	  
      case PVIDEO:
    	  productosActuales=ProductosDB.buscaPlacaVideos();
    	  break;
      case PWIRELESS:
    	  productosActuales=ProductosDB.buscaPWireless();
    	  break;
      	case RCABLE:
      		productosActuales=ProductosDB.buscaRcables();
    	  break;
	
	}
	return productosActuales;	
}


public Usuario buscaUsuario(String dni)
{
	System.out.println(dni+" en control ");
	Usuario usu=UsuariosDB.buscaUsuario(dni);
	return usu;
}

public void nuevoUsuario(String dni,String pass,String valpass,String nombre,String apellido,String direccion,String direnvio,String edad,String mail,String localidad)
{
	if(pass.equals(valpass))
	{
	UsuariosDB=new DBUsuarios();
	usuarioActual=UsuariosDB.validaUsuario(dni,pass);
	System.out.println("Llego al controlador nuevo usuario");	
	if(usuarioActual!=null)
		{
			System.out.print("Ya existe");
		}
		else
		{
			
			usuarioActual=new Usuario();
			usuarioActual.setDni(Integer.parseInt(dni));
			usuarioActual.setContraseña(pass);
			usuarioActual.setNombre(nombre);
			usuarioActual.setApellido(apellido);
			usuarioActual.setDireccion(direccion);
			usuarioActual.setDirenvio(direnvio);
			usuarioActual.setEdad(Integer.parseInt(edad));
			usuarioActual.setMail(mail);
			usuarioActual.setLocalidad(localidad);
			carroNew=new CarritoCompra();
			carroNew.setDni(String.valueOf(usuarioActual.getDni()));
			usuarioActual.setCarcomp(carroNew);
			UsuariosDB.CreaUsuario(usuarioActual);
			CarrosDB.CreaCarro(String.valueOf(usuarioActual.getDni()));
		}
	}
	else
	{
		System.out.print("Mal los passwords");
		
	}
}

public  void Comprar(String codprods[],String cantidades[])
	{
		Compra compraActual=new Compra();
		compraActual.setDni(usuarioActual.getDni());
		compraActual.setTotalcompra(0.0f);
		compraActual.setEstado("Pendiente");
		compraActual=ComprasDB.CreaCompra(compraActual);
		try{
		for (int i=0;i<codprods.length;i++)
		{
			
			productoActual=ProductosDB.buscaProducto(Integer.parseInt(codprods[i]));
			lineaActual=new LineaProducto();
			lineaActual.setCantidad(Integer.parseInt(cantidades[i]));
			lineaActual.setProducto(productoActual);
			lineaActual.calculaSubtotlinea();
			lineaActual.setCodC(compraActual.getCodcompra());
			compraActual.setTotalcompra(compraActual.getTotalcompra()+lineaActual.getSubtotlinea());
			LineascompDB.CreaLineaCompra(lineaActual);
			compraActual.añadeLineaCompra(lineaActual);
			
		}
		ComprasDB.GuardaCompra(compraActual);}
		catch(Exception e)
		{
			throw e;
		}
		//usuarioActual.añadeCompra(compraActual);
	}
public String añadeAlCarro(int codigo_producto, String dni) throws SQLException
{ 
	String tipo;
		System.out.print(dni);
		productoActual=ProductosDB.buscaProducto(codigo_producto);
		usuarioActual.getCarcomp().añadeProducto(productoActual);//lo agrego al carrito en memoria
		LineaCarro linea = new LineaCarro();
		linea.setDni(dni);
		linea.setProducto(productoActual);
			try {
				DBLineaCarro.CreaLineaCarro(linea, usuarioActual.getCarcomp().getCodigo_carrito()); //lo agrego al carrito en BD
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	Exception e = new Exception();
				throw e;
			}
			tipo=productoActual.getTipo();
			return tipo;
	
}

public ArrayList<Producto> levantaCarro()
{
	carroCompleto= new CarritoCompra();
	carroCompleto.getProductosCarro().clear();
	carroCompleto.getProductosCarro().addAll(carroNew.getProductosCarro());
	carroCompleto.getProductosCarro().addAll(carroOld.getProductosCarro());
	return carroCompleto.getProductosCarro();

}
public static void eliminaDelCarro(Vector<String> prods,String dni)
{
	boolean old=false;

	for (int i=0;i<prods.size();i++)
	{
		for(int j=0;j<carroNew.getProductosCarro().size();j++)
		{
			if(Integer.parseInt(prods.get(i)) == carroNew.getProductosCarro().get(j).getCodigo())
			{
				carroNew.getProductosCarro().remove(j);
				old=true;
			}
		}
		
		if(old)
		{
			CarrosDB.EliminaCarro(Integer.parseInt(prods.get(i)), dni);
		}
	}
}

public Producto buscaProducto(int codigo)
{	
	return ProductosDB.buscaProducto(codigo);
}

public Producto buscaProducto(int codigo,String categoria)
{	
	try {
		return ProductosDB.buscaProducto(codigo,categoria);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public  void eliminaDelCarroMemoria(int codigo)
{
	String tipo;
	productoActual=ProductosDB.buscaProducto(codigo);
	tipo=productoActual.getTipo();
	
		for(int j=0;j<usuarioActual.getCarcomp().getProductosCarro().size();j++)
		{
			if(codigo== usuarioActual.getCarcomp().getProductosCarro().get(j).getCodigo())
			{
				usuarioActual.getCarcomp().getProductosCarro().remove(j);
				
			}
		
		
	}
		}

public static String eliminaDelCarro(int codigo, String dni) throws SQLException
{
	String tipo;
	productoActual=ProductosDB.buscaProducto(codigo);
	tipo=productoActual.getTipo();
	
	usuarioActual.getCarcomp().eliminaProducto(productoActual);//lo elimino del carrito en memoria
	LineaCarro linea = new LineaCarro();
	linea.setProducto(productoActual);
	linea.setDni(dni);
	try {
		DBLineaCarro.EliminaLineaCarro(linea, usuarioActual.getCarcomp().getCodigo_carrito()); //lo elimino al carrito en BD
	} catch (SQLException e) {
		throw e;
	}
	tipo=productoActual.getTipo();
	return tipo;
}
	

public ArrayList<Producto>BusquedaExhaustiva(String parametro)
{
	ArrayList<Producto> productos=new ArrayList<Producto>();
	return productos;
}

	public boolean eliminaProducto(String cod)
	{
		int codigo=Integer.parseInt(cod);
		return(ProductosDB.borraProducto(codigo));
	}

}

		
		



