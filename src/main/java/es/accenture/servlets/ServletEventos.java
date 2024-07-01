package es.accenture.servlets;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import es.accenture.controladores.*;

/**
 * Servlet implementation class ServletEventos
 */
@WebServlet("/ServletEventos")
public class ServletEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/emisora")
	private DataSource poolConexiones;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String vista = null;
		switch (accion) {
		case "login":
			vista = new ControladorIniciarSesion(poolConexiones).procesarPeticion(request, response);
			request.getRequestDispatcher(vista).forward(request, response);
			break;
		case "logout":
			vista = new ControladorCerrarSesion().procesarPeticion(request, response);
			request.getRequestDispatcher(vista).forward(request, response);
			break;
		case "buscar":
			vista = new ControladorBuscarEventos(poolConexiones).procesarPeticion(request, response);
			request.getRequestDispatcher(vista).forward(request, response);
			break;
		case "volver":
			vista = new ControladorVolver().procesarPeticion(request, response);
			request.getRequestDispatcher(vista).forward(request, response);
			break;
		default:
			vista = new ControladorBuscarEventos(poolConexiones).procesarPeticion(request, response);
			request.getRequestDispatcher(vista).forward(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
