package es.iescanaveral.dam2.aadd.mbb.trabajo;

import java.io.Serializable;
import java.time.Year;

import com.opencsv.bean.CsvBindByName;

public class OrganismoCSV implements Serializable{

	private static final long serialVersionUID = 1L;
	@CsvBindByName(column = "operacion", required = true)
	private char operacion;
	@CsvBindByName(column = "codigo", required = true)
	private String codigo;
	@CsvBindByName(column = "organismo", required = true)
	private String organismo;
	@CsvBindByName(column = "anyo_creacion", required = true)
	private int anyoCreacion;
	@CsvBindByName(column = "sede", required = false)
	private String sede;
	@CsvBindByName(column = "observacion", required = true)
	private String observacion;
	@CsvBindByName(column = "url", required = true)
	private String url;
	public char getOperacion() {
		return operacion;
	}
	public void setOperacion(char operacion) {
		this.operacion = operacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getOrganismo() {
		return organismo;
	}
	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}
	public int getAnyoCreacion() {
		return anyoCreacion;
	}
	public void setAnyoCreacion(int anyoCreacion) {
		this.anyoCreacion = anyoCreacion;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "OrganismoCSV [operacion=" + operacion + ", codigo=" + codigo + ", organismo=" + organismo
				+ ", anyoCreacion=" + anyoCreacion + ", sede=" + sede + ", observacion=" + observacion + ", url=" + url
				+ "]";
	}
}
