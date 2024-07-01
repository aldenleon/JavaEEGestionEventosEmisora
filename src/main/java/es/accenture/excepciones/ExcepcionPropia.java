package es.accenture.excepciones;

public class ExcepcionPropia extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcepcionPropia() {
	}

	public ExcepcionPropia(String message) {
		super(message);
	}

	public ExcepcionPropia(Throwable cause) {
		super(cause);
	}

	public ExcepcionPropia(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionPropia(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
