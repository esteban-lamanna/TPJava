package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controlador.Controlador_encar.Prods;
import Modelo.LineaProducto;
import Modelo.Producto;
import Modelo.CarritoCompra;
import Modelo.Usuario;
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

public class DBProductos extends DBAdapter
{
	public enum Prods {

	    FUENTE,
	    GABINETE,
	    HD,
	    MEMORIA,
	    MICRO,
	    PLATAFORMA,
	    PLACAMADRE,
	    PRED,
	    PSONIDO,
	    PVIDEO,
	    PWIRELESS,
	    RCABLE
	  }
	
	
	public Producto buscaProducto(String nombre,String modelo)
	{
		
		Producto prod=null;
		try
		{
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos");
		while(rs.next())
		{
		if(rs.getString("nombre").equals(nombre) && rs.getString("modelo").equals(modelo))
			{
			prod=new Producto();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));

			}
		}
		
		return prod;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return prod;
	}
		
		
	}
	
	public ArrayList<Producto> buscaProductos(String nombre)
	{
		ArrayList<Producto> prods=new ArrayList<Producto>();
		prods.addAll(buscaFuentes(nombre));
		prods.addAll(buscaGabinetes(nombre));
		prods.addAll(buscaHds(nombre));
		prods.addAll(buscaMemorias(nombre));
		prods.addAll(buscaMicros(nombre));
		prods.addAll(buscaPlacasMadres(nombre));
		prods.addAll(buscaPlacaVideos(nombre));
		prods.addAll(buscaPredss(nombre));
		prods.addAll(buscaPsonidos(nombre));
		prods.addAll(buscaPWireless(nombre));
		prods.addAll(buscaRcables(nombre));
		return prods;
	}
	
	public Producto buscaProducto(int codigo,String tipo) throws SQLException
	{
		Producto prod=null;
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Prods enumval = Prods.valueOf(tipo.toUpperCase());
		switch(enumval)
		{
		case FUENTE:
			productos=this.buscaFuentes();
		break;
		
	    case GABINETE:
	    	productos=this.buscaGabinetes();
	    	  break;
	    	  
	    	  
	      case HD:
	    	  productos=this.buscaHds();
	    	  break;
	    	  
	    	  
	      case MEMORIA:
	    	  productos=this.buscaMemorias();
	    	  break;
	    	  
	      case MICRO:
	    	  
	    	  productos=this.buscaMicros();
	    	  break;
	    	  
	    	   case PLACAMADRE:
	    	  productos=this.buscaPlacasMadres();
	    	  break;
	    	  
	    	  
	      case PRED:
	    	  productos=this.buscaPredss();
	    	  break;
	    	  
	    	  
	      case PSONIDO:
	    	  productos=this.buscaPsonidos();
	    	  break;
	    	  
	      case PVIDEO:
	    	  productos=this.buscaPlacaVideos();
	    	  break;
	      case PWIRELESS:
	    	  productos=this.buscaPWireless();
	    	  break;
	      	case RCABLE:
	      		productos=this.buscaRcables();
	    	  break;		
		}
	    	  for (Producto p : productos) {
	    		  if(p.getCodigo() == codigo)
	    		  {
	    			prod = p;	    			
	    		  }				
			}
		
		return prod;
		
		
	}
	
	public Producto buscaProducto(int codigo)
	{
		Producto prod=null;
		try
		{
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where codigo= '"+codigo+"'");;
		while(rs.next())
		{
		if(rs.getInt("codigo")==(codigo))
			{
			prod=new Producto();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			return prod;
			}
		}
		return prod;
		
		
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return prod;
	}
		
		
	}
	
	
	public Producto buscaProducto(String modelo)
	{
		Producto prod=null;
		try
		{
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos");
		while(rs.next())
		{
		if(rs.getString("modelo").equals(modelo))
			{
			prod=new Producto();
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));

			}
		}
		
		return prod;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return prod;
	}
		
		
	}
	
	
	public void añadeProducto(Fuente prod)

	{
		
		try
		{
PreparedStatement preparedStatement = conex.prepareStatement("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,wattsF,amperajeF) VALUES (?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, prod.getNombre());
            preparedStatement.setString(2, prod.getModelo());
            preparedStatement.setString(3, prod.getDescripcion()); 
            preparedStatement.setFloat(4, prod.getPrecio());
            preparedStatement.setString(5, prod.getFoto()); 
            preparedStatement.setString(6, prod.getTipo()); 
            preparedStatement.setInt(7, prod.getWatts()); 
            preparedStatement.setFloat(8, prod.getAmperaje()); 
            
            
            preparedStatement.executeUpdate();
            
            ResultSet tableKeys = preparedStatement.getGeneratedKeys();
            tableKeys.next();
            
            
            int autoGeneratedID = tableKeys.getInt(1);
           System.out.println("Codigo autogenerado "+autoGeneratedID);
            
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(Gabinete prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,tamañoG) VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getTamaño()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
		
	
	public void añadeProducto(Hd prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo," +
		"buffeHD,capHD,interfazHD,rpmHD) VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getBuffer()+"','"+prod.getCapacidad()+"','"+prod.getInterfaz()+
		"','"+prod.getRpm()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(Memoria prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo," +
				"cantmemMEM,frecMEM,latenciaMEM) VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getCantmen()+"','"+prod.getFrecuencia()+"','"+prod.getLatencia()+
		"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(Micro prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo," +
		"cacheM,frecM,socket) VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getCaché()+"','"+prod.getFrecuencia()+"','"+prod.getSocket()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
		
	}
	public void añadeProducto(PlacaMadre prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,socket,cantusbMO,usb30MO,cantpcieMO,vonboardMO,sonboardMO,chipsetMO," +
				"cantmaxmemMO) VALUES('"+prod.getNombre()+
				"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"','"+prod.getTipo()+"','"+prod.getSocket()+"','"+prod.getCantusb()+"'," +
						"'"+prod.getCantusb30()+"','"+prod.getCantPCIE()+"','"+prod.getvOnboard()+"','"+prod.getsOnboard()+"','"+prod.getChipset()+"','"+prod.getCantmaxmem()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(PRed prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,velocidadPR" +
		") VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getVelocidad()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(PSonido prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,jacksS" +
		") VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getJacks()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(PVideo prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,abusvga,cantmemVGA,frecVGA,pipelsvga,shadersvga" +
		") VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getAnchobus()+"','"+prod.getCantmem()+"','"+prod.getFrecuencia()+
		"','"+prod.getPipelines()+"','"+prod.getShaders()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(PWireless prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,seguridad,velocidadPR" +
		") VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getSeguridad()+"','"+prod.getVelocidad()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void añadeProducto(RCable prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("INSERT INTO Productos(nombre,modelo,descripcion,precio,foto,tipo,velocidadPR" +
		") VALUES('"+prod.getNombre()+
		"','"+prod.getModelo()+"','"+prod.getDescripcion()+"','"+prod.getPrecio()+"','"+prod.getFoto()+"'," +
		"'"+prod.getTipo()+"','"+prod.getVelocidad()+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(Fuente prod)
	{
		try
		{
		
Statement st=conex.createStatement();
st.execute("UPDATE Productos set nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'"
+",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"',wattsF='"+prod.getWatts()+"'" +
",amperajeF='"+prod.getAmperaje()+"' where codigo='"+prod.getCodigo()+"'");

	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(Gabinete prod)
	{
		try
		{
Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
		",precio="+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"',tamañoG='"+prod.getTamaño()+"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(RCable prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+
				"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"',precio='"+prod.getPrecio()+"'" +
",foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"',velocidadPR='"+prod.getVelocidad()+"'" +
		"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(PWireless prod)
	{
		try
		{
		
Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"',seguridad='"+prod.getSeguridad()+"'," +
		"velocidadPR='"+prod.getVelocidad()+"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(PVideo prod)
	{
		try
		{
		
Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"'" +
",abusvga='"+prod.getAnchobus()+"',cantmemVGA='"+prod.getCantmem()+"',frecVGA='"+prod.getFrecuencia()+"'" +
",pipelsvga='"+prod.getPipelines()+"',shadersvga='"+prod.getShaders()+"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(PSonido prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"'," +
		"jacksS='"+prod.getJacks()+"'where codigo='"+prod.getCodigo()+"'");
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(PRed prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"'" +
				",velocidadPR='"+prod.getVelocidad()+"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(PlacaMadre prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"',socket='"+prod.getSocket()+"',cantusbMO='"+prod.getCantusb()+"',usb30MO='"+prod.getCantusb30()+"',cantPCIEMO='"+prod.getCantPCIE()+"',vOnboardMO='"+prod.getvOnboard()+"',sOnboardMO='"+prod.getsOnboard()+"',ChipsetMO='"+prod.getChipset()+"',cantmaxmemMO='"+prod.getCantmaxmem()+"'   " +
		"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(Micro prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"'" +
		",cacheM='"+prod.getCaché()+"',frecM='"+prod.getFrecuencia()+"',socket='"+prod.getSocket()+"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
		
	}
	public void modificaProducto(Memoria prod)
	{
		try
		{
		
Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"'" +
",cantmemMEM='"+prod.getCantmen()+"',frecMEM='"+prod.getFrecuencia()+"',latenciaMEM='"+prod.getLatencia()+"'where codigo='"+prod.getCodigo()+"'");
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public void modificaProducto(Hd prod)
	{
		try
		{
		
		Statement st=conex.createStatement();
st.execute("UPDATE Productos SET nombre='"+prod.getNombre()+"',modelo='"+prod.getModelo()+"',descripcion='"+prod.getDescripcion()+"'" +
",precio='"+prod.getPrecio()+"',foto='"+prod.getFoto()+"',tipo='"+prod.getTipo()+"'" +
"buffeHD='"+prod.getBuffer()+"',capHD='"+prod.getCapacidad()+"',interfazHD='"+prod.getInterfaz()+"',rpmHD='"+prod.getRpm()+"'where codigo='"+prod.getCodigo()+"'");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
		
	}
	public ArrayList<Producto> buscaHds()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Hd prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='HD'");
		while(rs.next())
		{
			prod=new Hd();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setBuffer(rs.getInt("buffehd"));
			prod.setCapacidad(rs.getString("caphd"));
			prod.setInterfaz(rs.getString("interfazHD"));
			prod.setRpm(rs.getString("rpmHD"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaMemorias()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Memoria prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='memoria'");
		while(rs.next())
		{
			prod=new Memoria();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setCantmen(rs.getInt("cantmemmem"));
			prod.setFrecuencia(rs.getFloat("frecmem"));
			prod.setLatencia(rs.getString("latenciamem"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaMicros()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Micro prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='micro'");
		while(rs.next())
		{
			prod=new Micro();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setCaché(rs.getInt("cacheM"));
			prod.setFrecuencia(rs.getFloat("frecm"));
			prod.setSocket(rs.getString("SocketM"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaPlacasMadres()

	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PlacaMadre prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='Placamadre'");
		while(rs.next())
		{
			prod=new PlacaMadre();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setSocket(rs.getString("socket"));
			prod.setCantusb(rs.getInt("cantusbMO"));
			prod.setCantusb30(rs.getInt("usb30MO"));
			prod.setCantPCIE(rs.getInt("cantpcieMO"));
			prod.setvOnboard(rs.getString("vonboardMO"));
			prod.setsOnboard(rs.getString("sonboardMO"));
			prod.setChipset(rs.getString("chipsetMO"));
			prod.setCantmaxmem(rs.getInt("cantmaxmemMO"));
			System.out.println(prod.getCodigo());
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaPredss()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PRed prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='PRED'");
		while(rs.next())
		{
			prod=new PRed();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setVelocidad(rs.getString("velocidadpr"));
			prod.setDescripcion(rs.getString("Descripcion"));
			
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaPsonidos()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PSonido prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='PSonido'");
		while(rs.next())
		{
			prod=new PSonido();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setJacks(rs.getFloat("jacksS"));
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaPlacaVideos()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PVideo prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='PVIDEO'");
		while(rs.next())
		{
			prod=new PVideo();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setAnchobus(rs.getInt("abusvga"));
			prod.setCantmem(rs.getInt("cantmemVGA"));
			prod.setFrecuencia(rs.getFloat("frecvga"));
			prod.setPipelines(rs.getInt("pipelsvga"));
			prod.setShaders(rs.getInt("shadersvga"));
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaPWireless()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PWireless prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='PWIRELESS'");
		while(rs.next())
		{
			prod=new PWireless();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setSeguridad(rs.getString("seguridad"));
			prod.setVelocidad("velocidadPR");
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaRcables()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			RCable prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='RCABLE'");
		while(rs.next())
		{
			prod=new RCable();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setVelocidad(rs.getString("velocidadPR"));
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaGabinetes()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Gabinete prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='gabinete'");
		while(rs.next())
		{
			prod=new Gabinete();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setTamaño(rs.getString("tamañog"));
			prod.setDescripcion(rs.getString("Descripcion"));
		
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaFuentes()
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Fuente prod;
			
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Productos where tipo='fuente'");
		while(rs.next())
		{
			prod=new Fuente();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setAmperaje(rs.getFloat("amperajef"));
			prod.setWatts(rs.getInt("wattsF"));
			prod.setDescripcion(rs.getString("Descripcion"));
			
			productos.add(prod);
		}
		System.out.println("cantidad = " + productos.size());

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaFuentes(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Fuente prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='fuente' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new Fuente();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setAmperaje(rs.getFloat("amperajef"));
			prod.setWatts(rs.getInt("wattsF"));
			prod.setDescripcion(rs.getString("Descripcion"));
			
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaGabinetes(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
				Gabinete prod;
			nombre="%"+nombre+"%";
			PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='gabinete' and nombre like ?");
			st.setString(1,nombre);
			ResultSet rs=st.executeQuery();
			while(rs.next())
		{
			prod=new Gabinete();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setTamaño(rs.getString("tamañog"));
			prod.setDescripcion(rs.getString("Descripcion"));
		
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaPWireless(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PWireless prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='PWIRELESS' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new PWireless();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setSeguridad(rs.getString("seguridad"));
			prod.setVelocidad("velocidadPR");
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaRcables(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			RCable prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='RCABLE' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new RCable();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setVelocidad(rs.getString("velocidadPR"));
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaPlacaVideos(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PVideo prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='PVIDEO' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new PVideo();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setAnchobus(rs.getInt("abusvga"));
			prod.setCantmem(rs.getInt("cantmemVGA"));
			prod.setFrecuencia(rs.getFloat("frecvga"));
			prod.setPipelines(rs.getInt("pipelsvga"));
			prod.setShaders(rs.getInt("shadersvga"));
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaPsonidos(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PSonido prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='PSonido' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new PSonido();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setJacks(rs.getFloat("jacksS"));
			prod.setDescripcion(rs.getString("Descripcion"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public ArrayList<Producto> buscaPredss(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PRed prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='PRED' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new PRed();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setVelocidad(rs.getString("velocidadpr"));
			prod.setDescripcion(rs.getString("Descripcion"));
			
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaPlacasMadres(String nombre)

	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			PlacaMadre prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='Placamadre' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new PlacaMadre();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setSocket(rs.getString("socket"));
			prod.setCantusb(rs.getInt("cantusbMO"));
			prod.setCantusb30(rs.getInt("usb3.0MO"));
			prod.setCantPCIE(rs.getInt("cantpcieMO"));
			prod.setvOnboard(rs.getString("vonboardMO"));
			prod.setsOnboard(rs.getString("sonboardMO"));
			prod.setChipset(rs.getString("chipsetMO"));
			prod.setCantmaxmem(rs.getInt("cantmaxmemMO"));
			
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaMicros(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Micro prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='micro' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new Micro();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setCaché(rs.getInt("cacheM"));
			prod.setFrecuencia(rs.getInt("frecm"));
			prod.setSocket(rs.getString("SocketM"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaMemorias(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Memoria prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='memoria' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new Memoria();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setCantmen(rs.getInt("cantmemmem"));
			prod.setFrecuencia(rs.getFloat("frecmem"));
			prod.setLatencia(rs.getString("latenciamem"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}	
	public ArrayList<Producto> buscaHds(String nombre)
	{
		ArrayList<Producto> productos=new ArrayList<Producto>();
		try
		{
			Hd prod;
		nombre="%"+nombre+"%";
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Productos where tipo='HD' and nombre like ?");
		st.setString(1,nombre);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			prod=new Hd();
			prod.setCodigo(rs.getInt("codigo"));
			prod.setFoto(rs.getString("foto"));
			prod.setModelo(rs.getString("modelo"));
			prod.setNombre(rs.getString("nombre"));
			prod.setPrecio(rs.getFloat("precio"));
			prod.setTipo(rs.getString("tipo"));
			prod.setDescripcion(rs.getString("Descripcion"));
			prod.setBuffer(rs.getInt("buffehd"));
			prod.setCapacidad(rs.getString("caphd"));
			prod.setInterfaz(rs.getString("interfazHD"));
			prod.setRpm(rs.getString("rpmHD"));
			productos.add(prod);
		}

		return productos;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return productos;
	}
		
	}
	public boolean borraProducto(int codigo)
	{
		try
		{
			
			Statement st=conex.createStatement();
			st.execute("DELETE FROM Productos where codigo='"+codigo+"'");
			return true;
		
		
		}

		
	 catch (SQLException t) 
	{
		return false;
	//t.printStackTrace();
	
	}
		
	}

}
