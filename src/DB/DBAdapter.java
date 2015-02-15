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
		             
		            // conex=DriverManager.getConnection("jdbc:mysql://localhost/tpf", "root", "");
		            //en el server: pass: mVQ5t0w0Ov 
			conex=DriverManager.getConnection("jdbc:mysql://mysql13631-basedatos.jelastic.hostdime.com/tpf", "root", "mVQ5t0w0Ov");
		//	https://mysql13631-basedatos.jelastic.hostdime.com/
				} catch (ClassNotFoundException ex) 
					{
					System.out.println("No se pudo conectar a la BD");
					ex.printStackTrace();
						
					} 
				
				
				
				catch (SQLException e) 
					{
					System.out.println("No se pudo conectar a la BD");
					e.printStackTrace();
					
					}
			}
		
	}
	
	
	public void cargaDrv()
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
		
}
	

