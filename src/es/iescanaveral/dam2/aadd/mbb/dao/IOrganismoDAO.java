package es.iescanaveral.dam2.aadd.mbb.dao;

import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;
import es.iescanaveral.dam2.aadd.mbb.vo.Organismo;

public interface IOrganismoDAO {
	public int insertarOrganismoBBDD(Organismo organismo) throws MundiException;

	public int actualizarOrganismoBBDD(Organismo organismo) throws MundiException;

	public int eliminarORganismoBBDD(Organismo organismo) throws MundiException;
}
