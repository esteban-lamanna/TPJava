package DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.CarritoCompra;

public class DBCarros extends DBAdapter
{
	public void GuardaCarro(CarritoCompra cc)
	{
		try
		{
		
		Statement st=conex.createStatement();
		for (int i=0;i<cc.getProductosCarro().size();i++)
		{
		st.execute("INSERT INTO carritos(dni,codigo) VALUES('"+cc.getDni()+","+cc.getProductosCarro().get(i).getCodigo()+"')");
		}
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
	}
	
	public ArrayList<Integer> BuscaProductos(String dni)
	{
		ArrayList<Integer> codigos=new ArrayList<Integer>();
		int dnis=Integer.parseInt(dni);	
	try
	{
		
		Statement st=conex.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Carritos where dni=" + dnis);
		
		while(rs.next())
		{
			codigos.add(rs.getInt("codigo"));
		}
	}
		catch (SQLException t) 
	{
		
	t.printStackTrace();
	}
		return codigos;
}
	
	public void EliminaCarro(int codigo, String dni)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("DELETE FROM carritos where dni='"+dni+"' and codigo='"+codigo+"'");
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
	}
}





