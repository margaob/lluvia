package modelo;

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
			//driver oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//obtenim la connexió
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@192.168.56.101:1521:fbmoll",
					"alumne","alumne");
			if (con!=null){
	            //System.out.println("Conexió a base de dades OK");
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
	      con = null;
	   }
	
	
}
