package es.iescanaveral.dam2.aadd.mbb.vo;

public class Continente {

	private String codigoContinente;
	private String nombreContinente;
	
	public String getCodigoContinente() {
		return codigoContinente;
	}
	public void setCodigoContinente(String codigoContinente) {
		this.codigoContinente = codigoContinente;
	}
	public String getNombreContinente() {
		return nombreContinente;
	}
	public void setNombreContinente(String nombreContinenteString) {
		this.nombreContinente = nombreContinenteString;
	}
	@Override
	public String toString() {
		return "Continente [codigoContinente=" + codigoContinente + ", nombreContinente=" + nombreContinente + "]";
	}
}
