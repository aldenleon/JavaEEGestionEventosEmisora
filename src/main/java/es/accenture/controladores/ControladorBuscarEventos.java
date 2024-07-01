package es.accenture.controladores;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import es.accenture.emisora.entidades.Evento;
import es.accenture.excepciones.ExcepcionPropia;
import es.accenture.modelos.ModeloEvento;

public class ControladorBuscarEventos implements IControlador {
	private DataSource poolConexiones;

	public ControladorBuscarEventos(DataSource poolConexiones) {
		this.poolConexiones = poolConexiones;
	}

	@Override
	public String procesarPeticion(HttpServletRequest request, HttpServletResponse response) {
		ModeloEvento modeloEvento = new ModeloEvento(poolConexiones);
		String nombreOdescripcion = request.getParameter("filtro");
		List<Evento> eventos = null;
		try {
			if (nombreOdescripcion == null) {
				eventos = modeloEvento.getEventos();
			} else {
				eventos = modeloEvento.getEventos(nombreOdescripcion);
				if (eventos.size() <= 0) {
					HttpSession session = request.getSession();
					if (session.getAttribute("datosUsuario") == null) {
						return "/Login.jsp";
					}
					request.setAttribute("error", "No hay resultados");
					return "/WEB-INF/BuscarEventos.jsp";
				}
			}
		} catch (SQLException e) {
			throw new ExcepcionPropia(e);
		}
		request.setAttribute("listadoEventos", eventos);
		return "/WEB-INF/MostrarEventos.jsp";
	}

}
