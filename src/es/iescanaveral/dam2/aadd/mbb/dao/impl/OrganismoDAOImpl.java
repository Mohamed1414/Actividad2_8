package es.iescanaveral.dam2.aadd.mbb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.iescanaveral.dam2.aadd.mbb.dao.IOrganismoDAO;
import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;
import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConexionMYSQL;
import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConexionPostgres;
import es.iescanaveral.dam2.aadd.mbb.vo.Organismo;

public class OrganismoDAOImpl implements IOrganismoDAO {

	@Override
	public int insertarOrganismoBBDD(Organismo organismo) throws MundiException{
		int resultado = 0;
		try (Connection conexion = GestorConexionPostgres.obtenerConexion()) {

			String consulta = "SELECT * FROM T_ORGANISMO WHERE codigo_organismo = ?";
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
			sentenciaConsulta.setString(1, organismo.getCodOrganismo());
			ResultSet resultadoConsulta = sentenciaConsulta.executeQuery();

			if (resultadoConsulta.next())
				return resultado;
			else {

				String insercion = "INSERT INTO T_ORGANISMO (codigo_organismo, nombre, anyo_creacion, sede, url) VALUES (?, ?, ?, ?, ?);";
				PreparedStatement sentenciaInsercion = conexion.prepareStatement(insercion);
				sentenciaInsercion.setString(1, organismo.getCodOrganismo());
				sentenciaInsercion.setString(2, organismo.getNombre());
				sentenciaInsercion.setInt(3, organismo.getAnyoCreacion());
				sentenciaInsercion.setString(4, organismo.getSede());
				sentenciaInsercion.setString(5, organismo.getUrl());

				resultado = sentenciaInsercion.executeUpdate();
			}

		} catch (SQLException e) {
			throw new MundiException(MundiException.ERROR_INSERCION, e);
		}
		return resultado;
	}

	@Override
	public int actualizarOrganismoBBDD(Organismo organismo) throws MundiException{
		int resultado = 0;
		try (Connection conexion = GestorConexionPostgres.obtenerConexion()) {
			String update = "UPDATE T_ORGANISMO SET nombre = ?, anyo_creacion = ?, sede = ?, url = ? WHERE codigo_organismo = ?;";
			PreparedStatement sentencia = conexion.prepareStatement(update);
			sentencia.setString(1, organismo.getNombre());
			sentencia.setInt(2, organismo.getAnyoCreacion());
			sentencia.setString(3, organismo.getSede());
			sentencia.setString(4, organismo.getUrl());
			sentencia.setString(5, organismo.getCodOrganismo());

			resultado = sentencia.executeUpdate();

		} catch (SQLException e) {
			throw new MundiException(MundiException.ERROR_ACTUALIZACION, e);
		}
		return resultado;
	}

	@Override
	public int eliminarORganismoBBDD(Organismo organismo) throws MundiException{
		int resultado = 0;
		try (Connection conexion = GestorConexionPostgres.obtenerConexion()) {

			String consulta = "SELECT * FROM T_ORGANISMO WHERE codigo_organismo = ?";
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
			sentenciaConsulta.setString(1, organismo.getCodOrganismo());
			ResultSet resultadoConsulta = sentenciaConsulta.executeQuery();

			if (resultadoConsulta.next()) {
				String borrado = "DELETE FROM T_ORGANISMO WHERE codigo_organismo = ?;";
				PreparedStatement sentenciaBorrado = conexion.prepareStatement(borrado);
				sentenciaBorrado.setString(1, organismo.getCodOrganismo());
				resultado = sentenciaBorrado.executeUpdate();
			} else
				return resultado;
		} catch (SQLException e) {
			throw new MundiException(MundiException.ERROR_BORRADO, e);
		}
		return resultado;
	}
}
