package es.iescanaveral.dam2.aadd.mbb;

import java.util.List;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import es.iescanaveral.dam2.aadd.mbb.dao.IContinenteDAO;
import es.iescanaveral.dam2.aadd.mbb.dao.IOrganismoDAO;
import es.iescanaveral.dam2.aadd.mbb.dao.IPaisDAO;
import es.iescanaveral.dam2.aadd.mbb.dao.impl.ContinenteDAOImpl;
import es.iescanaveral.dam2.aadd.mbb.dao.impl.OrganismoDAOImpl;
import es.iescanaveral.dam2.aadd.mbb.dao.impl.PaisDAOImpl;
import es.iescanaveral.dam2.aadd.mbb.excepciones.MundiException;
import es.iescanaveral.dam2.aadd.mbb.trabajo.GestorJSON;
import es.iescanaveral.dam2.aadd.mbb.trabajo.OrganismoCSV;
import es.iescanaveral.dam2.aadd.mbb.trabajo.OrganismoJSON;
import es.iescanaveral.dam2.aadd.mbb.vo.Organismo;
import es.iescanaveral.dam2.aadd.mbb.vo.Pais;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GestorJSON gestor = new GestorJSON();
		IOrganismoDAO gestorOrganismos = new OrganismoDAOImpl();
		IPaisDAO tratarPaises = new PaisDAOImpl();
		IContinenteDAO tratarContinentes = new ContinenteDAOImpl();
		try {
			while (true) {
				System.out.println("-----------------------------");
				System.out.println("1. Consulta pais por capital");
				System.out.println("2. Crear continente");
				System.out.println("3. Actualizar pais");
				System.out.println("4. Eliminar continente");
				System.out.println("5. Call consulta pais por capital");
				System.out.println("6. Tratamiento de organismos");
				System.out.println("7. Salir");
				System.out.println("-----------------------------");

				switch (sc.nextInt()) {

				case 1:
					List<Pais> listaPaises = tratarPaises.consultaPaisPorCapital("Sa", "02");
					if (!listaPaises.isEmpty()) {
						for (Pais pais : listaPaises) {
							System.out.println(pais.getCapital() + " capital de" + pais.getNombrePais() + "("
									+ pais.getCodigoPais() + ") pertenece al continente "
									+ pais.getContinente().getNombreContinente() + "("
									+ pais.getContinente().getCodigoContinente() + ")");
						}
					} else {
						System.out.println("Lista de paises vacía");
					}
					break;
				case 2:
					crearContinentes(tratarContinentes);
					break;
				case 3:
					Pais city = new Pais();
					city.setCapital("Capital City");
					city.setCodigoPais(107);
					tratarPaises.actualizarPais(city);
					break;
				case 4:
					eliminarContinentes(tratarContinentes);
					break;
				case 5:
					System.out.println("La consulta de los paises ha dado el siguiente resultado: \n");
					System.out.println(tratarPaises.callConsultaPaisPorCapital("02"));
					break;
				case 6:
					List<OrganismoJSON> listaOrganismos = gestor.obtenerListaOrganismosJSON();

					for (OrganismoJSON organismoJson : listaOrganismos) {
						Organismo organismo = mapearOrganismoJson(organismoJson);
						switch (organismoJson.getOperacion()) {
						case 'I':
							insertarOrganismo(organismo, gestorOrganismos);
							break;
						case 'M':
							actualizarOrganismo(organismo, gestorOrganismos);
							break;
						case 'B':
							eliminarOrganismo(organismo, gestorOrganismos);
							break;
						}
					}
					break;
				case 7:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertarOrganismo(Organismo organismo, IOrganismoDAO gestor) throws MundiException {
		if (gestor.insertarOrganismoBBDD(organismo) == 0) {
			System.out.println(
					"El organismo " + organismo.getNombre() + "  a insertar ya se encontraba en la Base de Datos");
			System.out.println("---------------------------------------");

		} else {
			System.out.println("El organismo " + organismo.getNombre() + " fue añadido a la Base de datos");
			System.out.println("---------------------------------------");
		}
	}

	public static void actualizarOrganismo(Organismo organismo, IOrganismoDAO gestor) throws MundiException {
		if (gestor.actualizarOrganismoBBDD(organismo) == 0) {
			System.out.println("No se pudo actualizar el organismo " + organismo.getNombre());
			System.out.println("---------------------------------------");
		} else {
			System.out.println("El organismo " + organismo.getNombre() + " se ha actualizado correctamente");
			System.out.println("---------------------------------------");
		}
	}

	public static void eliminarOrganismo(Organismo organismo, IOrganismoDAO gestor) throws MundiException {
		if (gestor.eliminarORganismoBBDD(organismo) == 0) {
			System.out.println("El organismo " + organismo.getNombre() + " no se encontraba en la base de datos");
			System.out.println("---------------------------------------");
		} else {
			System.out.println("El organismo " + organismo.getNombre() + " fue borrado a la Base de datos");
			System.out.println("---------------------------------------");
		}

	}

	public static Organismo mapearOrganismoJson(OrganismoJSON organismoJson) {
		Organismo organismo = new Organismo();
		organismo.setUrl(organismoJson.getUrl());
		organismo.setCodOrganismo(organismoJson.getCode());
		organismo.setAnyoCreacion(organismoJson.getAnyo());
		organismo.setNombre(organismoJson.getOrganismo());
		organismo.setSede(organismoJson.getDireccion().getCiudad());

		return organismo;
	}

	public static Organismo mapearOrganismoCSV(OrganismoCSV organismoCsv) {
		Organismo organismo = new Organismo();
		organismo.setUrl(organismoCsv.getUrl());
		organismo.setCodOrganismo(organismoCsv.getCodigo());
		organismo.setAnyoCreacion(organismoCsv.getAnyoCreacion());
		organismo.setNombre(organismoCsv.getOrganismo());
		organismo.setSede(organismoCsv.getSede());

		return organismo;
	}

	public static void eliminarContinentes(IContinenteDAO tratarContinentes) throws MundiException {
		try {
			if (tratarContinentes.eliminarContinente("06") != 0) {
				System.out.println("Se ha eliminado el continente correctamente");
			} else {
				System.out.println("No se ha podido eliminar el continente por que no se encontraba en la base de datos");
			}
		} catch (Exception e) {
			throw new MundiException(MundiException.ERROR_BORRADO, e);
		}

	}

	public static void crearContinentes(IContinenteDAO tratarContinentes) throws MundiException{
		try {
			if (tratarContinentes.crearContinente("06", "Antártida") != 0) {
				System.out.println("Se ha creado el continente correctamente");
			} else {
				System.out.println("No se ha podido crear el continente por que ya se encontraba en la base de datos");
			}

		} catch (Exception e) {
			throw new MundiException(MundiException.ERROR_INSERCION, e);
		}
	}
}
