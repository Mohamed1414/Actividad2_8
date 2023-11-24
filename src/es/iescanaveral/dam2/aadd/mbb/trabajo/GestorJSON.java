package es.iescanaveral.dam2.aadd.mbb.trabajo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iescanaveral.dam2.aadd.mbb.utilidades.GestorConfiguracion;

public class GestorJSON {
	private static String RUTA_FICHERO_JSON= GestorConfiguracion.getInfoConfiguracion("ruta.json");
	
	public List<OrganismoJSON> obtenerListaOrganismosJSON() throws StreamReadException, IOException
	{
		List<OrganismoJSON> listaOrganismosJSON = null;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(RUTA_FICHERO_JSON)); 
			ObjectMapper mapeado = new ObjectMapper();
			listaOrganismosJSON = mapeado.readValue(buffer, new TypeReference<List<OrganismoJSON>>() {
			});
		} catch (StreamReadException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return listaOrganismosJSON;
	}
}
