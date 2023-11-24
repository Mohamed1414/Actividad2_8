package es.iescanaveral.dam2.aadd.mbb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.iescanaveral.dam2.aadd.mbb.dao.IPaisDAO;
import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;
import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConexionMYSQL;
import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConexionPostgres;
import es.iescanaveral.dam2.aadd.mbb.vo.Continente;
import es.iescanaveral.dam2.aadd.mbb.vo.Pais;

public class PaisDAOImpl implements IPaisDAO {
	
	
	public List<Pais> consultaPaisPorCapital(String inicial, String codigoContinente) throws MundiException
	{
		List<Pais> listaPaises = new ArrayList<Pais>();
		try (Connection conexion = GestorConexionPostgres.obtenerConexion()) {
			String consulta = "SELECT * FROM T_PAIS JOIN T_CONTINENTE ON (T_PAIS.cod_continente = T_CONTINENTE.cod_continente) WHERE T_PAIS.capital LIKE ? AND T_CONTINENTE.cod_continente = ?;";
			
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, inicial + "%");
			sentencia.setString(2, codigoContinente);
			ResultSet resultado = sentencia.executeQuery();
			
			while (resultado.next())
			{
				Pais americano = new Pais();
				Continente america = new Continente();
				america.setCodigoContinente(resultado.getString("cod_continente"));
				america.setNombreContinente(resultado.getString("nombre_continente"));
				americano.setContinente(america);
				americano.setCodigoPais(resultado.getInt("cod_pais"));
				americano.setNombrePais(resultado.getString("nombre_pais"));
				americano.setCapital(resultado.getString("capital"));
				
				listaPaises.add(americano);
			}
		} catch (Exception e) {
			throw new MundiException(MundiException.ERROR_CONSULTA, e);
		}	
		return listaPaises;
	}
	
	public String callConsultaPaisPorCapital(String codigoContinente) throws MundiException
	{
		String resultado = null;
		try(Connection conexion = GestorConexionPostgres.obtenerConexion(); 
				CallableStatement call = conexion.prepareCall("{? = CALL consultarPaisesPorInicial(?, ?)}"))
		{
			call.registerOutParameter(1, java.sql.Types.VARCHAR);
			call.setString(2, "Sa");
			call.setString(3, codigoContinente);
			call.executeUpdate();
			resultado = call.getString(1);
		}catch(Exception e)
		{
			throw new MundiException(MundiException.ERROR_CONSULTA, e);
		}
		return resultado;
	}
	
	public int actualizarPais(Pais pais) throws MundiException
	{
		int resultado = 0;
		try(Connection conexion = GestorConexionPostgres.obtenerConexion()) {	
			Statement sentencia = conexion.createStatement();
			resultado = sentencia.executeUpdate("UPDATE T_PAIS SET capital = '" + pais.getCapital() + "' WHERE cod_pais = " + pais.getCodigoPais() + ";");
			
			System.out.println("Pais actualizado correctamente");
		}catch (Exception e)
		{
			throw new MundiException(MundiException.ERROR_ACTUALIZACION, e);		
		}
		return resultado;
	}
}
