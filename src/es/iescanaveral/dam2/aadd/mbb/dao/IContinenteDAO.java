package es.iescanaveral.dam2.aadd.mbb.dao;

import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;

public interface IContinenteDAO {

	public int crearContinente(String codigo, String nombre) throws MundiException;

	public int eliminarContinente(String codigoContinente) throws MundiException;
}
