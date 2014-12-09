package DB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Modelo.Usuario;

public class colUsuarios 
{
	static List<Usuario> Usuarios= new ArrayList<Usuario>();
	
	public static Usuario buscaLoginUsuario(String dni,String pass,String[] correcto)
	{
		Usuario user;
		
		Iterator<Usuario>iterU=Usuarios.iterator();
		while (iterU.hasNext())
		{
			correcto[0]="no";
			correcto[1]="no";
			user=iterU.next();
			if(dni.equals(user.getDni()))
			{
				correcto[0]="ok";
				if(pass.equals(user.getContraseña()))
				{
						correcto[1]="ok";
						
				}
				return user;
			}
					
			
		}
		user=null;
		
		return user;
		
	}
	public static void añadeUsuario(Usuario user)
	{
		/*Usuarios.add(user);
		DBAdapter.añadeUsuario(user);*/
	}
	
	public static Usuario buscaUsuarioActivo(String dni)
	{
		Usuario user;
		
		Iterator<Usuario>iterU=Usuarios.iterator();
		while (iterU.hasNext())
		{
			user=iterU.next();
			if(dni.equals(user.getDni()))
			{
				return user;
			}
			
		}
		user=null;
		return user;
	}
}
