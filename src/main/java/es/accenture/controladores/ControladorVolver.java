package es.accenture.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorVolver implements IControlador {
	
	public ControladorVolver() {}

	@Override
	public String procesarPeticion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("datosUsuario") == null) {
			return "/Login.jsp";
		}
		return "/WEB-INF/BuscarEventos.jsp";
	}

}
