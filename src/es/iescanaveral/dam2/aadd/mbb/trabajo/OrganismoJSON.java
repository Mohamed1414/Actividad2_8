package es.iescanaveral.dam2.aadd.mbb.trabajo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganismoJSON {
	@JsonProperty("code")
	private String code;
	@JsonProperty("siglas")
	private String siglas;
	@JsonProperty("org")
	private String organismo;
	@JsonProperty("year")
	private int anyo;
	@JsonProperty("address")
	private DireccionJSON direccion;
	@JsonProperty("url")
	private String url;
	@JsonProperty("operation")
	private char operacion;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String sigla) {
		this.siglas = sigla;
	}
	public String getOrganismo() {
		return organismo;
	}
	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public DireccionJSON getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionJSON direccion) {
		this.direccion = direccion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public char getOperacion() {
		return operacion;
	}
	public void setOperacion(char operacion) {
		this.operacion = operacion;
	}
	@Override
	public String toString() {
		return "OrganismoJSON [code=" + code + ", sigla=" + siglas + ", organismo=" + organismo + ", anyo=" + anyo
				+ ", direccion=" + direccion + ", url=" + url + ", operacion=" + operacion + "]";
	}
}
