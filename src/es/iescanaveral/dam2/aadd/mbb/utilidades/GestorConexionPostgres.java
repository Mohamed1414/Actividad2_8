package es.iescanaveral.dam2.aadd.mbb.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexionPostgres {
	public static Connection obtenerConexion()
	{
		String URL_MYSQL= GestorConfiguracion.getInfoConfiguracion("url.postgres");
		String USUARIO_MYSQL= GestorConfiguracion.getInfoConfiguracion("usuario.postgres");
		String PASS_MYSQL= GestorConfiguracion.getInfoConfiguracion("pass.postgres");
		String DRIVER_MYSQL = GestorConfiguracion.getInfoConfiguracion("driver.postgres");
		Connection conexion = null;
		try {
			Class.forName(DRIVER_MYSQL);		
			conexion = DriverManager.getConnection(URL_MYSQL, USUARIO_MYSQL, PASS_MYSQL);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}
