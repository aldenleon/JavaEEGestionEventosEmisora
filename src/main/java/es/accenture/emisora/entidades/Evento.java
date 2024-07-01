package es.accenture.emisora.entidades;

public class Evento {
	private int eventoId;
	private String nombre;
	private String descripcion;
	private String lugar;
	private String duracion;
	private String tipoEvento;
	private int asientosDisp;
	
	public Evento(int eventoId, String nombre, String descripcion, String lugar,
			String duracion, String tipoEvento, int asientosDisp) {
		this.eventoId = eventoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.duracion = duracion;
		this.tipoEvento = tipoEvento;
		this.asientosDisp = asientosDisp;
	}

	public Evento() {}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getAsientosDisp() {
		return asientosDisp;
	}

	public void setAsientosDisp(int asientosDisp) {
		this.asientosDisp = asientosDisp;
	}
	
}
