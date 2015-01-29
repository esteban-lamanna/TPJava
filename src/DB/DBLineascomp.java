package DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Date;  
import java.sql.*;
import Modelo.Producto;
import Modelo.LineaProducto;

public class DBLineascomp extends DBAdapter 
{
	DBProductos proddb;
		
	public void CreaLineaCompra(LineaProducto lp)
	{
		try
		{			
		Statement st=conex.createStatement();
		st.execute("INSERT INTO lineacomp(codcompra,codigo,cantidad,subtotal) VALUES('"+lp.getCodC()+"','"+lp.getProducto().getCodigo()+"','"+lp.getCantidad()+"','"+lp.getSubtotlinea()+"')");

	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
	}
	
	
	public ArrayList<LineaProducto> buscaLineas(String codCompra)
	{
		LineaProducto lp=null;
		ArrayList<LineaProducto> ProductosCarro=new ArrayList<LineaProducto>();
		Producto prod;
		try
		{
			proddb=new DBProductos();
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM lineaprod where codcompra='"+codCompra+"')");
		while(rs.next())
		{
		
			lp=new LineaProducto();
			lp.setCodC(rs.getInt("codCompra"));
			lp.setCantidad(rs.getInt("cantidad"));
			lp.setSubtotlinea(rs.getFloat("subtotal"));
			prod=proddb.buscaProducto(rs.getString("nombre"), rs.getString("modelo"));
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
