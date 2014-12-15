package DB;
import java.sql.*;

import Modelo.Compra;
import Modelo.Producto;
import Modelo.Usuario;
public class DBAdapter 
{
	static Connection conex;
	public DBAdapter()
	{
		{   
			try {  Class.forName("com.mysql.jdbc.Driver");
		             
		             conex=DriverManager.getConnection("jdbc:mysql://localhost/tpf", "root", "");
		             
		             
				} catch (ClassNotFoundException ex) 
					{
						
						
					} 
				
				
				
				catch (SQLException e) 
					{
					
					e.printStackTrace();
					
					}
			}
		
	}
	
	
	public void cargaDrv()
	{
		{   
			try {  Class.forName("com.mysql.jdbc.Driver");
		             
		             conex=DriverManager.getConnection("jdbc:mysql://localhost/TPF", "tpf", "tpf");
		             
		             
				} catch (ClassNotFoundException ex) 
					{
						
						
					} 
				
				
				
				catch (SQLException e) 
					{
					
					e.printStackTrace();
					
					}
			}
		
	}
		
}
	

