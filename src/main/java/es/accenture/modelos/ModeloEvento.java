package es.accenture.modelos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import es.accenture.emisora.entidades.Evento;

public class ModeloEvento {
	private DataSource poolConexiones;
	
	public ModeloEvento(DataSource poolConexiones) {
		this.poolConexiones = poolConexiones;
	}
	
	public List<Evento> getEventos() throws SQLException {
		List<Evento> res = new ArrayList<>();
		try (Connection con = poolConexiones.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM eventos;")) {
			while (rs.next()) {
				res.add(new Evento(rs.getInt("eventoId"),
						rs.getString("nombre"),
						rs.getString("descripcion"),
						rs.getString("lugar"),
						rs.getString("duracion"),
						rs.getString("tipoEvento"),
						rs.getInt("asientosDisp")));
			}
		}
		return res;
	}
	
	public List<Evento> getEventos(String criterio) throws SQLException {
		List<Evento> res = new ArrayList<>();
		try (Connection con = poolConexiones.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM eventos "
						+ "WHERE nombre LIKE ? OR descripcion LIKE ?;")) {
			pstmt.setString(1, '%' + criterio + '%');
			pstmt.setString(2, '%' + criterio + '%');
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					res.add(new Evento(rs.getInt("eventoId"),
							rs.getString("nombre"),
							rs.getString("descripcion"),
							rs.getString("lugar"),
							rs.getString("duracion"),
							rs.getString("tipoEvento"),
							rs.getInt("asientosDisp")));
				}
			}
		}
		return res;
	}
}
