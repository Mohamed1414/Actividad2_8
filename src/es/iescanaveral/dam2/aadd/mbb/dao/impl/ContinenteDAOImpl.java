package es.iescanaveral.dam2.aadd.mbb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import es.iescanaveral.dam2.aadd.mbb.dao.IContinenteDAO;
import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;
import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConexionMYSQL;
import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConexionPostgres;

public class ContinenteDAOImpl implements IContinenteDAO {
	public int crearContinente(String codigo, String nombre) throws MundiException{
		int resultado = 0;
		try (Connection conexion = GestorConexionPostgres.obtenerConexion()) {

			String consulta = "INSERT INTO T_CONTINENTE (cod_continente, nombre_continente) VALUES (? , ?);";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, codigo);
			sentencia.setString(2, nombre);
			resultado = sentencia.executeUpdate();
		} catch (Exception e) {
			throw new MundiException(MundiException.ERROR_INSERCION, e);
		}
		return resultado;
	}

	public int eliminarContinente(String codigoContinente) throws MundiException {
		int resultado = 0;
		try (Connection conexion = GestorConexionPostgres.obtenerConexion()) {
			String consulta = "DELETE FROM T_CONTINENTE WHERE cod_continente =  ? ;";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, codigoContinente);
			sentencia.executeUpdate();
		} catch (Exception e) {
			throw new MundiException(MundiException.ERROR_BORRADO, e);
		}
		return resultado;
	}
}
