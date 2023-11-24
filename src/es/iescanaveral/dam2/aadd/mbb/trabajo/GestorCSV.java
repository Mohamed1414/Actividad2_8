package es.iescanaveral.dam2.aadd.mbb.trabajo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConfiguracion;

public class GestorCSV {

private static String RUTA_FICHERO_CSV= GestorConfiguracion.getInfoConfiguracion("ruta.csv");
	
	/* Lista de los organismos de nuestro archivo CSV*/
	public List<OrganismoCSV> obtenerListaOrganismosCSV() throws IOException
	{
		// Fichero de entrada
		FileReader fileReader = new FileReader(RUTA_FICHERO_CSV);
		List<OrganismoCSV> listaTitulacionesCSV = new CsvToBeanBuilder(fileReader).withSeparator('|').withType(OrganismoCSV.class).build().parse();

		return listaTitulacionesCSV;
	}
}
