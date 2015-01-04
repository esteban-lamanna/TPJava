package DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Date;  
import java.sql.*;


import Modelo.CarritoCompra;
import Modelo.LineaCarro;
import Modelo.Producto;
import Modelo.LineaProducto;

public class DBLineaCarro extends DBAdapter 
{
	DBProductos proddb;
		

	public void CreaLineaCarro(LineaCarro linea, int codigo_carro) throws SQLException
	{
		
				
		try {
			System.out.println(linea.getProducto().getCodigo());
			Statement st=conex.createStatement();
			st.execute("INSERT INTO lineaCarro(codigo_producto, codigo_carro) VALUES('"+linea.getProducto().getCodigo()+"','"+codigo_carro+"')");

                      
           
		} catch (SQLException sqle) 
		{
			throw sqle;
			//sqle.printStackTrace();
		}
	
	}
	
	public void EliminaLineaCarro(LineaCarro linea, int codigo_carro) throws SQLException
	{
		
				
		try {
			Statement st=conex.createStatement();
			st.execute("delete from lineacarro where codigo_producto = '"+linea.getProducto().getCodigo()+"' AND codigo_carro = '"+codigo_carro+"'");

                      
           
		} catch (SQLException sqle) 
		{
			throw sqle;
			//sqle.printStackTrace();
		}
	
	}
	
	
	public ArrayList<LineaProducto> buscaLineas(String codCarro)
	{
		LineaProducto lp=null;
		ArrayList<LineaProducto> ProductosCarro=new ArrayList<LineaProducto>();
		Producto prod;
		try
		{
			proddb=new DBProductos();
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM lineaCarro where codigo_carro='"+codCarro+"')");
		while(rs.next())
		{
		
			lp=new LineaProducto();
			lp.setCodC(rs.getInt("codigo_carro"));
			prod=proddb.buscaProducto(rs.getInt("codigo_producto"));
			lp.setProducto(prod);
			ProductosCarro.add(lp);
			
		}

		return ProductosCarro;
	} catch (SQLException t) 
	{
		
	t.printStackTrace();
	return ProductosCarro;
	}
		
		
	}
}