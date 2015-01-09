package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Modelo.Usuario;



public class DBUsuarios extends DBAdapter
{
	public void CreaUsuario(Usuario user)
	{
		try
		{
		int dni=user.getDni();
		String pass=user.getContraseña();
		String nombre=user.getNombre();
		String ape=user.getApellido();
		String direccion=user.getDireccion();
		String direnvios=user.getDirenvio();
		int edad=user.getEdad();
		String mail=user.getMail();
		String localidad=user.getLocalidad();
		Statement st=conex.createStatement();
		System.out.println("Llego a crea usuarios con: "+dni);
		st.execute("INSERT INTO Usuarios VALUES("+dni+",'"+pass+"','"+nombre+"','"+ape+"','"+direccion+"','"+direnvios+"',"+edad+",'"+mail+"','"+localidad+"',0)");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
	}
	
	public void ActualizaUsuario(Usuario user)
	{
		try
		{

			PreparedStatement ps = conex.prepareStatement("UPDATE Usuarios SET password = ?, nombre = ?, apellido = ?, direccion = ?, direnvio = ?, edad = ?, localidad = ?, mail = ? WHERE dni = ?");


			ps.setString(1,user.getContraseña());
			ps.setString(2,user.getNombre());
			ps.setString(3,user.getApellido());
			ps.setString(4,user.getDireccion());
			ps.setString(5,user.getDirenvio());
			ps.setInt(6,user.getEdad());
			ps.setString(7,user.getLocalidad());
			ps.setString(8,user.getMail());
			ps.setInt(9,user.getDni());

			ps.executeUpdate();
			ps.close();
			
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
	}
	
	
	public Usuario validaUsuario(String id,String pass)
	{
		Usuario user=null;
		int dni = Integer.parseInt(id);
	try
	{
		PreparedStatement st=conex.prepareStatement("SELECT * FROM Usuarios where dni = ?");
		st.setInt(1,dni);
		ResultSet rs=st.executeQuery();
		if(	rs.next())
	{
		if(rs.getInt(1)==dni && rs.getString(2).equals(pass))
		{
			user=new Usuario();
			user.setDni(rs.getInt(1));
			user.setContraseña(rs.getString(2));
			user.setNombre(rs.getString(3));
			user.setApellido(rs.getString(4));
			user.setDireccion(rs.getString(5));
			user.setDirenvio(rs.getString(6));
			user.setEdad(rs.getInt(7));
			user.setMail(rs.getString(8));
			user.setLocalidad(rs.getString(9));
			user.setEsAdmin(rs.getInt(10));
			return user;
		}
	}
		
		rs.close();
		st.close();

	} catch (SQLException t) 
	{
	t.printStackTrace();
	
	}
	return user;
}
		
		public Usuario buscaUsuario(String id)
		{
			Usuario user=null;
			int dni = Integer.parseInt(id);
			try
			{
				Statement st=conex.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM usuarios where dni='"+dni+"'");

			if(rs.next())
				{
				user=new Usuario();
				user.setDni(rs.getInt(1));
				user.setContraseña(rs.getString(2));
				user.setNombre(rs.getString(3));
				user.setApellido(rs.getString(4));
				user.setDireccion(rs.getString(5));
				user.setDirenvio(rs.getString(6));
				user.setEdad(rs.getInt(7));
				user.setMail(rs.getString(8));
				user.setLocalidad(rs.getString(9));
				user.setEsAdmin(rs.getInt(10));
				}
			return user;
		} catch (SQLException t) 
		{
		t.printStackTrace();
		return user;
		}
		}
		
		
	
}
