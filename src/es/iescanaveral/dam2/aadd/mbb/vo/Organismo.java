package es.iescanaveral.dam2.aadd.mbb.vo;

import java.io.Serializable;
import java.time.Year;

public class Organismo implements Serializable{

	private static final long serialVersionUID = 1L;	
	private String codOrganismo;
	private String nombre;
	private int anyoCreacion;
	public int getAnyoCreacion() {
		return anyoCreacion;
	}
	public void setAnyoCreacion(int anyoCreacion) {
		this.anyoCreacion = anyoCreacion;
	}
	private String sede;
	private String url;
	public String getCodOrganismo() {
		return codOrganismo;
	}
	public void setCodOrganismo(String codOrganismo) {
		this.codOrganismo = codOrganismo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Organismo [codOrganismo=" + codOrganismo + ", nombreString=" + nombre + ", sede=" + sede
				+ ", url=" + url + "]";
	}
}
