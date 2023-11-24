package es.iescanaveral.dam2.aadd.mbb.trabajo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DireccionJSON {
	@JsonProperty("street")
	private String calle;
	@JsonProperty("city")
	private String ciudad;
	@JsonProperty("zipcode")
	private int codigoPostal;
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public String toString() {
		return "DireccionJSON [calle=" + calle + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + "]";
	}
}
