package es.accenture.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import es.accenture.emisora.entidades.Usuario;

public class ModeloUsuario {
	private DataSource poolConexiones;
	
	public ModeloUsuario(DataSource poolConexiones) {
		this.poolConexiones = poolConexiones;
	}
	
	/**
	 * @return devuelve el usuario encontrado o null en caso de que no exista la combinación usuario/contraseña
	 */
	public Usuario getUsuario(String usuario, String password) throws SQLException {
		try (Connection con = poolConexiones.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM usuarios "
						+ "WHERE usuario = ? AND password = ?;")) {
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Usuario(rs.getInt("usuarioId"),
							rs.getString("nombre"),
							rs.getString("apellido"),
							rs.getString("dni"),
							rs.getString("email"),
							rs.getString("telefono"),
							rs.getString("direccion"),
							rs.getString("usuario"),
							rs.getString("password"));
				}
			}
		}
		return null;
	}
	
}
