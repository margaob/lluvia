package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.Principal;
import vista.VentanaJuego;


public class ModeloLluvia {
	
	private Controlador miCoordinador;
	VentanaJuego vj;

	static boolean[] control = new boolean[100];
		  
	//arrays on es iguarden les possibles combinacions amb les lletres de la partida
		  private static ArrayList<String> combinacions3lletres = new ArrayList<String>();
		  private static ArrayList<String> combinacions4lletres = new ArrayList<String>();
		  private static ArrayList<String> combinacions5lletres = new ArrayList<String>();
		  private static ArrayList<String> combinacions6lletres = new ArrayList<String>();
		  
		  //arrays amb les paraules de la base de dades que coincideixen amb les combinacions
		  private static ArrayList<String> paraulesCoincidents3lletres = new ArrayList<String>();
		  private static ArrayList<String> paraulesCoincidents4lletres = new ArrayList<String>();
		  private static ArrayList<String> paraulesCoincidents5lletres = new ArrayList<String>();
		  private static ArrayList<String> paraulesCoincidents6lletres = new ArrayList<String>();
		  
		  //paraules que ha encertat l'usuari
		  private static ArrayList<String> paraulesEncertades3lletres = new ArrayList<String>();
		  private static ArrayList<String> paraulesEncertades4lletres = new ArrayList<String>();
		  private static ArrayList<String> paraulesEncertades5lletres = new ArrayList<String>();
		  private static ArrayList<String> paraulesEncertades6lletres = new ArrayList<String>();
		  
		  private static ArrayList <Ranking> ranking = new  ArrayList<Ranking>();
		  private static int totalParaules=0;
		  private static int paraulesEncertades=0;
		  
		  public String usuarioLogeado;
		  
		  private Object [] rank = new Object[2];
  
		  public static int puntuacio=0;
		  
		  public void modeloLluvia(){
		
		  }
		
		
		public void setCoordinador(Controlador miCoordinador) {
			this.miCoordinador=miCoordinador;
			
		}
				
		public int registrarUsuario (String usuario, String pass){
			
			Connexio con= new Connexio();
			ResultSet usuariExiteix=null;
			
			try {
				
				// mirar que nombre usuario no exista!!
				Statement stmt = con.getConnection().createStatement();

				if (!buscarUsuario(usuario)){ // si no existe lo registramos
					stmt.executeUpdate("INSERT INTO usuarios VALUES ('"+usuario+"','"+pass+"')");
					JOptionPane.showMessageDialog(null, "Usuario creado con exito","Información",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					JOptionPane.showMessageDialog(null, "Este usuario ya existe","Información",JOptionPane.INFORMATION_MESSAGE);
				}

				stmt.close();
				con.desconnectar();
				
				return 0;
				
			} catch (SQLException e) {
	            System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se Registro");
				return -1;
			}
	
	}
		
	public void logearUsuario(String usuario, String pass){
		
		Connexio con= new Connexio();
		ResultSet passCorrecta=null;

		try {
			
		if (buscarUsuario(usuario)){ //si existe, comprobamos contraseña

			Statement stmt = con.getConnection().createStatement();
			
			//usuariExiteix=stmt.executeQuery("select count(*) from usuarios where usuario = '"+usuario+"'");
			passCorrecta=stmt.executeQuery("select count(*) from usuarios where pass = '"+pass+"'");
			
			int e=0;
							
			while(passCorrecta.next()) e=passCorrecta.getInt(1);
		
			if(e==0){
				//pass no coincideix
			JOptionPane.showMessageDialog(null, "La contraseña no coincide","Información",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				
				usuarioLogeado=usuario;
			}
		}			
		else{ //no existe usuario
			JOptionPane.showMessageDialog(null, "Este usuario no existe","Información",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
		
	}
		
	private boolean buscarUsuario(String usuario){
		
		Connexio con= new Connexio();
		ResultSet usuariExiteix=null;
		
		try {
			
			// mirar que nombre usuario no exista!!
			Statement stmt = con.getConnection().createStatement();
			
			usuariExiteix=stmt.executeQuery("select count(*) from usuarios where usuario = '"+usuario+"'");
			
			int e=0;
							
			while(usuariExiteix.next())
		        e=usuariExiteix.getInt(1);
		
		if(e==0){
			return false;
		}
		else{
			
			return true;
			
		}
		
		} //try
		
		catch (Exception e){
			
			System.out.println("Error :" +e.toString());
		}
		return false;

	}
		

	/**
	 * 
	 * Es carrega la partida a la finestre de Joc.
	 * Primer es reinicien els arrays del joc.
	 * Despres s'estableixen les lletres de la partida, es cerquen les combinacions possibles i despres es cerquen coincidenceis a la base de dades.
	 */
		public void iniciarPartida(){
			
			//reiniciar arrays
			
				combinacions3lletres.clear();
				combinacions4lletres.clear();
				combinacions5lletres.clear();
				combinacions6lletres.clear();
						  
				paraulesCoincidents3lletres.clear();
				paraulesCoincidents4lletres.clear();
				paraulesCoincidents5lletres.clear();
				paraulesCoincidents6lletres.clear();

				paraulesEncertades3lletres.clear();
				paraulesEncertades4lletres.clear();
				paraulesEncertades5lletres.clear();
				paraulesEncertades6lletres.clear();	
			
			puntuacio=0;
			

		char lletra1, lletra2, lletra3, lletra4, lletra5, lletra6;
		
		char [] alletra1 = new char []{'a','e','i','o','u','a','a','a','a','e','i','o','u','a','e','a','e','a','e'};
		char [] alletra2 = new char []{'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
		char [] alletra3 = new char []{'b','c','d','f','g','j','l','m','n','p','q','r','s','t'};
		
		int l1 = (int) (Math.random()*alletra1.length+0);
		lletra1 = alletra1[l1];
		
		int l2 = (int) (Math.random()*alletra2.length+0);
		lletra2 = alletra2[l2];
		
		int l3 = (int) (Math.random()*alletra1.length+0);
		lletra3 = alletra1[l3];
		
		int l4 = (int) (Math.random()*alletra3.length+0);
		lletra4 = alletra3[l4];
		
		int l5 = (int) (Math.random()*alletra1.length+0);
		lletra5 = alletra1[l5];
		
		int l6 = (int) (Math.random()*alletra3.length+0);
		lletra6 = alletra3[l6];
		

		miCoordinador.getVentanaJuego().posarLletres(lletra1, lletra2, lletra3, lletra4, lletra5, lletra6);
	
		char[] elements = new char[6];
		
		elements[0] = lletra1;
		elements[1] = lletra2;
		elements[2] = lletra3;
		elements[3] = lletra4;
		elements[4] = lletra5;
		elements[5] = lletra6;
		
		generarPermutacions(elements, "", 3,combinacions3lletres);
		generarPermutacions(elements, "", 4,combinacions4lletres);
		generarPermutacions(elements, "", 5,combinacions5lletres);
		generarPermutacions(elements, "", 6,combinacions6lletres);
		
		
		cercarCoincidents(combinacions3lletres, paraulesCoincidents3lletres,3);
		
		if (paraulesCoincidents3lletres.size() != 0){
			
			System.out.println("Palabras de 3 letras preparadas!");
		}
		
		
		cercarCoincidents(combinacions4lletres, paraulesCoincidents4lletres,4);
		
		if (paraulesCoincidents4lletres.size() != 0){
			
			System.out.println("Palabras de 4 letras preparadas!");
		}
		
		
		cercarCoincidents(combinacions5lletres, paraulesCoincidents5lletres,5);
		
		if (paraulesCoincidents5lletres.size() != 0){
			
			System.out.println("Palabras de 5 letras preparadas!");
		}
		cercarCoincidents(combinacions6lletres, paraulesCoincidents6lletres,6);
		
		if (paraulesCoincidents5lletres.size() != 0){
			
			System.out.println("Palabras de 6 letras preparadas!");
		}
		
		totalParaules = paraulesCoincidents3lletres.size()+ paraulesCoincidents4lletres.size()+ paraulesCoincidents5lletres.size() +paraulesCoincidents6lletres.size();
		
		prepararEncertades(paraulesCoincidents3lletres,paraulesEncertades3lletres);
		prepararEncertades(paraulesCoincidents4lletres,paraulesEncertades4lletres);
		prepararEncertades(paraulesCoincidents5lletres,paraulesEncertades5lletres);
		prepararEncertades(paraulesCoincidents6lletres,paraulesEncertades6lletres);
		
		
		miCoordinador.getVentanaJuego().omplirTaula3(paraulesEncertades3lletres);
		miCoordinador.getVentanaJuego().omplirTaula4(paraulesEncertades4lletres);
		miCoordinador.getVentanaJuego().omplirTaula5(paraulesEncertades5lletres);
		miCoordinador.getVentanaJuego().omplirTaula6(paraulesEncertades6lletres);

		//si no hi ha prous paraules per jugar una partida bé
		
		if ((totalParaules == 0) || (paraulesCoincidents5lletres.size()==0) ){
			
			System.out.println("No habia combinaciones suficientes disponibles y la partida se reiniciara");
			iniciarPartida();
		}

		}
		
		public static void prepararEncertades(ArrayList<String> coincidents, ArrayList<String> encertades){
		
		for (int i=1; i<=coincidents.size(); i++){
			encertades.add(""); 
		}
		
		}
		
		
		/**
		 * 
		 * es generen les posibles combinacions de 3,4,5 i 6 lletres amb les lletres donades
		 * @param elements
		 * @param actual
		 * @param num
		 * @param paraules
		 */
	    public static void generarPermutacions(char[] elements, String actual, int num, ArrayList<String> paraules) {
	        
	    	if(num==0) {
	    		
	    		//System.out.println(actual);
	            paraules.add(actual);
	        }
	        else {
	            for(int i=0; i<elements.length; i++ ){
	                if(control[i]==true) continue;
	                control[i]=true;
	                generarPermutacions(elements, actual+elements[i],num-1, paraules);
	                control[i]=false;
	            	}
	        }

	    }
	    
	    /**
	     * 
	     * Cercam les combinacions abans generades a les bases de dades
	     * @param combinacionsLletres
	     * @param paraulesCoincidents
	     * @param num
	     */
	    public static void cercarCoincidents(ArrayList<String> combinacionsLletres,ArrayList<String> paraulesCoincidents,int num){
	    	
	    	Connexio con= new Connexio();
	    	

	    	Statement stmt = null;
	    	ResultSet paralaExisteix =null;
	    	String taula = null;
	    	String columna = null;
	    	int w=0;
	    	
	    	if (num == 3){
	    		taula = "paraules3lletres";
	    		columna = "PARAULA3";
	    	}
	    	if (num == 4){
	    		taula = "paraules4lletres";
	    		columna = "PARAULA4";
	    	}
	    	if (num == 5){
	    		taula = "paraules5lletres";
	    		columna = "PARAULA5";
	    	}
	    	if (num == 6){
	    		taula = "paraules6lletres";
	    		columna = "PARAULA6";
	    	}

	    	//llevar combinacions repetides
	    	
	    	HashSet<String> hashSet = new HashSet<String>(combinacionsLletres);
	    	combinacionsLletres.clear();
	    	combinacionsLletres.addAll(hashSet);
			

	    	try{

				stmt = con.getConnection().createStatement();
				
	    			Iterator <String> nombreIterator = combinacionsLletres.iterator();
	    			
	    			while(nombreIterator.hasNext()){
	    				    				
	    				String elemento = nombreIterator.next();
	    				
	    				paralaExisteix=stmt.executeQuery("select count(*) from "+taula+" where "+columna+" like '"+elemento+"'");
	    				    				
	    				while(paralaExisteix.next())
	    			       w=paralaExisteix.getInt(1);
	    				
	    				if (w==1){

	    					paraulesCoincidents.add(elemento);

	    				}
	    			}
	    			
	    			con.desconnectar();

	    		} //try
	    		
	    	catch (Exception e){
				
				System.out.println("Error :" +e.toString());
			}
	    	
	    	//ordenam array alfabeticament
	        
	    	Collections.sort(paraulesCoincidents);
	    	


		}
	    
	 /**
	  * 
	  * Cada vegada que l'usuari escriu una paraula confirmam si aquesta es troba a l'array de paraules coincidents (paraules que es poden fer amab aquestes lletres)
	  * @param paraula
	  */
		public void comprovarParaules(String paraula) {

			int pos = 0;
			
			if (paraula.length() == 3){
				
				pos = paraulesCoincidents3lletres.indexOf(paraula);
				
				if ((pos >= 0) && (paraulesEncertades3lletres.get(pos).equals(""))){
					
					paraulesEncertades3lletres.add(pos, paraula); //insertam la paraula que coincideix
					paraulesEncertades3lletres.remove(pos+1); //borram el null que hem substituit
					miCoordinador.getVentanaJuego().omplirTaula3(paraulesEncertades3lletres);
					puntuacio=puntuacio+10;
					paraulesEncertades++;
					miCoordinador.getVentanaJuego().actualitzarPuntuacio(Integer.toString(puntuacio)+" puntos.");
				}
				else{
					if ((pos >= 0) && (paraulesEncertades3lletres.get(pos).equals(paraula))){
					
						miCoordinador.getVentanaJuego().actualitzarPuntuacio("Palabra repetida!");
					
					}
				}

			}
			
			if (paraula.length() == 4){
				
				pos = paraulesCoincidents4lletres.indexOf(paraula);
				
				if ((pos >= 0) && (paraulesEncertades4lletres.get(pos).equals(""))){
					
					paraulesEncertades4lletres.add(pos, paraula);
					paraulesEncertades4lletres.remove(pos+1);
					miCoordinador.getVentanaJuego().omplirTaula4(paraulesEncertades4lletres);
					puntuacio=puntuacio+30;
					paraulesEncertades++;
					miCoordinador.getVentanaJuego().actualitzarPuntuacio(Integer.toString(puntuacio)+" puntos.");
				}
				else{
					if ((pos >= 0) && (paraulesEncertades4lletres.get(pos).equals(paraula))){
					
						miCoordinador.getVentanaJuego().actualitzarPuntuacio("Palabra repetida!");
					
					}
				}
				
			}


			if (paraula.length() == 5){
		
				pos = paraulesCoincidents5lletres.indexOf(paraula);
				
				if ((pos >= 0) && (paraulesEncertades5lletres.get(pos).equals(""))){
					
					paraulesEncertades5lletres.add(pos, paraula);
					paraulesEncertades5lletres.remove(pos+1);
					miCoordinador.getVentanaJuego().omplirTaula5(paraulesEncertades5lletres);
					puntuacio=puntuacio+40;
					paraulesEncertades++;
					miCoordinador.getVentanaJuego().actualitzarPuntuacio(Integer.toString(puntuacio)+" puntos.");
				}
				else{
					if ((pos >= 0) && (paraulesEncertades5lletres.get(pos).equals(paraula))){
					
						miCoordinador.getVentanaJuego().actualitzarPuntuacio("Palabra repetida!");
					
					}
				}


			}
			
			if (paraula.length() == 6){
				
				pos = paraulesCoincidents6lletres.indexOf(paraula);
				
				if ((pos >= 0) && (paraulesEncertades6lletres.get(pos).equals(""))){
					
					paraulesEncertades6lletres.add(pos, paraula);
					paraulesEncertades6lletres.remove(pos+1);
					miCoordinador.getVentanaJuego().omplirTaula6(paraulesEncertades6lletres);
					puntuacio=puntuacio+75;
					paraulesEncertades++;
					miCoordinador.getVentanaJuego().actualitzarPuntuacio(Integer.toString(puntuacio)+" puntos.");
				}
				else{
					if ((pos >= 0) && (paraulesEncertades6lletres.get(pos).equals(paraula))){
					
						miCoordinador.getVentanaJuego().actualitzarPuntuacio("Palabra repetida!");
					
					}
				}

			}
			
			if (paraulesEncertades == totalParaules){
				
				puntuacio=puntuacio+200;
				
				JOptionPane.showMessageDialog(null, "Enhorabuena! Has encontrado todas las palabras!");
				
				entrarRanking();
				
				//controladorM.voureRanking();
				miCoordinador.getVentanaJuego().setVisible(false);
			

			}

		}

		/**
		 * Reiniam el joc per poder tornar jugar
		 * 
		 */
		public void novaPartida(){
			
			Principal p = new Principal();
			
			/*model = new ModeloLluvia();
			   
			//inicialitzam
			
			cMenu controladorM = new cMenu();
			VentanaMenu pantallaM = new VentanaMenu();
			
			controladorJ = new cJoc();
			pantallaJ = new VentanaJuego();
			
			cRanking controladorR = new cRanking();
			VentanaRanking pantallaR = new VentanaRanking();
			

			//passam per parametre els objectes creats
			pantallaM.setControlador(controladorM);
			controladorM.setPantalla(pantallaM);
			controladorM.setControladorJ(controladorJ);
			controladorM.setControladorR(controladorR);
			controladorM.setModelo(model);
			
			pantallaJ.setControladorJ(controladorJ);
			controladorJ.setPantalla(pantallaJ);
			controladorJ.setPantallaM(pantallaM);
			controladorJ.setControladorM(controladorM);
			controladorJ.setModelo(model);
			
			pantallaR.setControladorR(controladorR);
			controladorR.setPantalla(pantallaR);
			controladorR.setControladorM(controladorM);
			controladorR.setModelo(model);
*/
			//borrar paraules encertardes abans
			
			
			paraulesEncertades3lletres.clear();
			paraulesEncertades4lletres.clear();
			paraulesEncertades5lletres.clear();
			paraulesEncertades6lletres.clear();
			
			puntuacio=0;
			
			totalParaules=0;
			paraulesEncertades=0;

			iniciarPartida();
			
			vj.setVisible(true);
			
			
		}
		
		/**
		 * Omplir la taula del Ranking
		 * 
		 * 
		 */
		//public Object [] omplirRanking(){
		public void omplirRanking(){
			
			Connexio con= new Connexio();
	    	
	    	Statement stmt = null;
	    	ResultSet topRanking =null;
	    	
	    	int conta=0;
	    	
	    	try{

				stmt = con.getConnection().createStatement();
				

				topRanking=stmt.executeQuery("select usuario,puntuacion from estadisticas order by puntuacion desc");

		            while (topRanking.next() && conta < 20 ) {
		                for (int i = 0; i < 2; i++) {
		                        rank[i] = topRanking.getObject(i + 1);
		                        conta++;
		                }
		                
		                miCoordinador.getVentanaRanking().omplirRanking(rank);
		                
		            }

				
		            con.desconnectar();
		            
		        } catch (Exception e) {
				
				System.out.println("Error :" +e.toString());
			}
	    	
			//return rank;
			
		}
		
		
			public void omplirEstadistiques(){
			
			Connexio con= new Connexio();
	    	Statement stmt = null;
	    	ResultSet estats =null;
	    	usuarioLogeado = "marga";
	    	int maxPunt=0,maxPorcen=0, minPunt=100000, minPorcen=100, mitja=0, total = 0;
	    	try{

				stmt = con.getConnection().createStatement();

				estats=stmt.executeQuery("select * from estadisticas where usuario='"+usuarioLogeado+"'");

				while (estats.next() ) {

							//maxpuntacios
		                    if (estats.getInt(4)>maxPunt)maxPunt=estats.getInt(4); 
		                    //maxporcent
		                    if (((estats.getInt(6)*100)/estats.getInt(5))>maxPorcen) maxPorcen=(estats.getInt(6)*100)/estats.getInt(5);
		                    //minpunt
		                    if (estats.getInt(4)<minPunt)minPunt=estats.getInt(4);
		                    //minporcent
		                    if (((estats.getInt(6)*100)/estats.getInt(5))<minPorcen) minPorcen=(estats.getInt(6)*100)/estats.getInt(5);
		                    
		                    mitja+=estats.getInt(4);
		                    total++;
		                    
		         }
				
				System.out.println("Mitja: "+ mitja+" Total: "+ total);
				
				miCoordinador.getVentanaEstadisticas().mPuntuacion.setText(Integer.toString(maxPunt));
				miCoordinador.getVentanaEstadisticas().mPorcentaje.setText(Integer.toString(maxPorcen));
				miCoordinador.getVentanaEstadisticas().pPuntuacion.setText(Integer.toString(minPunt));
				miCoordinador.getVentanaEstadisticas().pPorcentaje.setText(Integer.toString(minPorcen));
				miCoordinador.getVentanaEstadisticas().lblmedia.setText(" "+Integer.toString(mitja/total));

		         con.desconnectar();
  
		        } catch (Exception e) {
				
				System.out.println("Error :" +e.toString());
			}

		}
		/**
		 * Si es superen les puntacions del ranking, es pot posar un nom i s'entra al ranking
		 * 
		 */
			
//CAMBIAR TOT METODE!			
		public void entrarRanking(){
			
			boolean entrarRanking = false;
			
	        Connexio con= new Connexio();
	    	
	    	Statement stmt = null;
	    	ResultSet topRanking =null;
	    	
	    	int conta = 0;
	    	
	    	
	    	try{

				stmt = con.getConnection().createStatement();
				

				topRanking=stmt.executeQuery("select usuario,puntuacion from estadisticas order by puntuacion desc");

		            
		    		ranking = new  ArrayList<Ranking>();
		    			

				    			while (topRanking.next() && conta < 10){
				    				
				    				Ranking r1 =new Ranking();
				    				
				    				r1.setPuntuacioMax(topRanking.getInt("puntuacion"));
				    				
				    				ranking.add(r1);
				    				
				    				conta++;
			
				    			}
				    			
				    			
				    			 Iterator <Ranking> it = ranking.iterator();
				 				
				 	        	
				 				while(it.hasNext()){
				 					
				 					Ranking r1 =it.next();
				 				
				 					
				 					if (puntuacio > r1.getPuntuacioMax()){
				 						entrarRanking = true;
				 						
				 					}
				 					
				 					
				 				}
//modificar aixo!!
		 				if (entrarRanking){
		 					
		 					String nomUsuari = JOptionPane.showInputDialog(
		 						   null,
		 						   "Introduce un nombre para insertar en el ranking",
		 						   JOptionPane.QUESTION_MESSAGE); 

		 						stmt.executeQuery("INSERT INTO ranking VALUES ('"+nomUsuari+"',"+puntuacio+")");
		 				}

		            con.desconnectar();
		            
		        } catch (Exception e) {
				
				System.out.println("Error :" +e.toString());
			}
			
			
			
		}
		
		/**
		 * Si s'acaba el temps de joc i no s'han trobat totes les paraules,es mostren totes les combinacions possibles.
		 * En cas de fer puntuació màxima s'entra al ranking.
		 * Es mostra el ranking.
		 */
		public void fiTemps() {
			
			vj.omplirTaula3(paraulesCoincidents3lletres);
			vj.omplirTaula4(paraulesCoincidents4lletres);
			vj.omplirTaula5(paraulesCoincidents5lletres);
			vj.omplirTaula6(paraulesCoincidents6lletres);
			
			JOptionPane.showMessageDialog(null, "Ohh! Se te ha acabado el tiempo!");

			entrarRanking();
			omplirRanking();
			vj.setVisible(true);
			vj.setVisible(false);
			
		}
		
		/**
		 * Es surt de l'aplicació en cas no trobarse a la pantalla de joc
		 * 
		 */
		public void Sortir() {
			

			int aux =JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere salir?", 
	        		"Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if(aux == JOptionPane.YES_OPTION){
	        	
	            		System.exit(0);
	            }
			
		}

	/**
	 * Es surt de la partida
	 * 
	 * @param s En insdica si desprs s'ha de sortir de l'aplicació o no
	 */
		public void sortirPartida(boolean s){
			
	 
	    		
	    		int aux =JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere salir?", 
	            		"Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(aux == JOptionPane.YES_OPTION){

	            		entrarRanking();
	            		
	            		if (s){
		 				System.exit(0);
	            		}

	            }
				

		}

	}
