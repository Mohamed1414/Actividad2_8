package es.iescanaveral.dam2.aadd.mbb.excepciones;

public class MundiException extends Exception {

	public static final long serialVersionUID = 1L;
	public static final long ERROR_CONSULTA = 1;
	public static final long ERROR_INSERCION = 2;
	public static final long ERROR_ACTUALIZACION = 3;
	public static final long ERROR_BORRADO = 4;

	private long codigoError;

	public MundiException(long codigoError, Exception excepcion) {
		super(excepcion);
		this.setCodigoError(codigoError);
	}

	public long getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(long codigoError) {
		this.codigoError = codigoError;
	}
}