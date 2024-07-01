package es.accenture.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import es.accenture.excepciones.ExcepcionPropia;

public class ControladorCerrarSesion implements IControlador {
	
	public ControladorCerrarSesion() {}

	@Override
	public String procesarPeticion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null) throw new ExcepcionPropia("La sesión ya está cerrada");
		session.invalidate();
		return "/Login.jsp";
	}

}
