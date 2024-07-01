package es.accenture.controladores;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import es.accenture.emisora.entidades.Usuario;
import es.accenture.excepciones.ExcepcionPropia;
import es.accenture.modelos.ModeloUsuario;

public class ControladorIniciarSesion implements IControlador {
	private DataSource poolConexiones;

	public ControladorIniciarSesion(DataSource poolConexiones) {
		this.poolConexiones = poolConexiones;
	}

	@Override
	public String procesarPeticion(HttpServletRequest request, HttpServletResponse response) {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		if (usuario.isEmpty() || password.isEmpty()) {
			request.setAttribute("error", "Usuario/Password son obligatorios");
			return "/Login.jsp";
		}
		Usuario u = null;
		try {
			u = new ModeloUsuario(poolConexiones).getUsuario(usuario, password);
		} catch (SQLException e) {
			throw new ExcepcionPropia(e);
		}
		if (u == null) {
			request.setAttribute("error", "Usuario/Password incorrecta");
			return "/Login.jsp";
		}
		HttpSession session = request.getSession();
		session.setAttribute("datosUsuario", u);
		return "/WEB-INF/BuscarEventos.jsp";
	}

}
