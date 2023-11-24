package es.iescanaveral.dam2.aadd.mbb.dao;

import java.util.List;

import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;
import es.iescanaveral.dam2.aadd.mbb.vo.*;

public interface IPaisDAO {

	public List<Pais> consultaPaisPorCapital(String inicial, String codigoContinente) throws MundiException;

	public String callConsultaPaisPorCapital(String codigoContinente) throws MundiException;

	public int actualizarPais(Pais pais) throws MundiException;
}
