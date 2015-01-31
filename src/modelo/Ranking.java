package modelo;

public class Ranking {
	
	
	private String usuari;
	private int puntuacioMax;
	
	
	public Ranking() {
		
	}

	
	public Ranking(String usuari, int puntuacioMax) {
		
		this.usuari = usuari;
		this.puntuacioMax = puntuacioMax;
	}


	public String getUsuari() {
		return usuari;
	}


	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}


	public int getPuntuacioMax() {
		return puntuacioMax;
	}


	public void setPuntuacioMax(int puntuacioMax) {
		this.puntuacioMax = puntuacioMax;
	}
	
	



}
