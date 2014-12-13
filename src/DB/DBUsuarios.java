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
		st.execute("INSERT INTO Usuarios VALUES('"+dni+"','"+pass+"','"+nombre+"','"+ape+"','"+direccion+"','"+direnvios+"','"+edad+"','"+mail+"','"+localidad+"')");
	
	} catch (SQLException t) 
		{
		
		t.printStackTrace();
	
		}	
	}
	
	public void ActualizaUsuario(Usuario user)
	{
		try
		{
		
		Statement st=conex.createStatement();
		st.execute("UPDATE Usuarios SET dni='"+user.getDni()+"',password='"+user.getContraseña()+"',nombre='"+user.getNombre()+"',apellido='"+user.getApellido()+
		"',direccion='"+user.getDireccion()+"',direnvio='"+user.getDirenvio()+"',edad='"+user.getEdad()+"',localidad='"+user.getLocalidad()+"'" +
		"mail='"+user.getMail()+"'");
	
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
				}
			return user;
		} catch (SQLException t) 
		{
		t.printStackTrace();
		return user;
		}
		}
		
		
	
}
