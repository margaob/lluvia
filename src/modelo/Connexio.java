package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connexio {

	Connection con=null;

	/** 
	 * Constructor de la conexio de la BD
	 */
	
	public Connexio() {
		
			
		try{
			//driver postgre
			Class.forName("org.postgresql.Driver");
			//obtenim la connexió
			con = DriverManager.getConnection
			("jdbc:postgresql://127.0.0.1/accesodatos?" + "user=openpg&password=openpgpwd");
			if (con!=null){
	            System.out.println("Conexión a base de datos OK");
	         }

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Permet retornar la connexió
	 */
	public Connection getConnection(){
	      return con;
	   }

	public void desconnectar(){
		
		try{
			con.close();

		}
		catch (Exception e){
			e.printStackTrace();
		}  
	 }

}
