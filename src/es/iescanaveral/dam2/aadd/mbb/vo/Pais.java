package es.iescanaveral.dam2.aadd.mbb.vo;

public class Pais {

	private Continente continente;
	private int codigoPais;
	private String nombrePais;
	private String capital;
	public Continente getContinente() {
		return continente;
	}
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	public int getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@Override
	public String toString() {
		return "Pais [continente=" + continente + ", codigoPais=" + codigoPais + ", nombrePais=" + nombrePais
				+ ", capital=" + capital + "]";
	}
	
}
