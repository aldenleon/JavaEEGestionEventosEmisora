package es.accenture.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IControlador {
	String procesarPeticion(HttpServletRequest request, HttpServletResponse response);
}
