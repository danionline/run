package com.renedo.runners.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDao {

	public static UsuarioDao INSTANCE = null;

	private UsuarioDao() {
		super();
	}

	public static synchronized UsuarioDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDao();
		}

		return INSTANCE;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> registros = new ArrayList<Usuario>();

		String sql = "SELECT  nombre, contrasena FROM usuario; ";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			while (rs.next()) {

				// recuperar columnas del resultset

				String nombre = rs.getString("nombre");
				String conse = rs.getString("contrasena");

				// crear pojo con datos del rs
				Usuario usuario = new Usuario();

				usuario.setNombre(nombre);
				usuario.setContrasena(conse);

				// guardar en ArrayList
				registros.add(usuario);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return registros;
	}

	public ArrayList<Usuario> buscarId(int ide) throws Exception {

		String sql = "Select ide,nombre from usuario ;";

		int ides = 0;
		int id = 0;
		String nombre = "";
		ArrayList<Usuario> registros = new ArrayList<Usuario>();
		registros = getAll();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			while (rs.next()) {

				// recuperar columnas del resultset
				for (Usuario usuario : registros) {
					ides = usuario.getId();
					nombre = usuario.getNombre();

					id = rs.getInt(ides);
					nombre = rs.getString(nombre);
					// crear pojo con datos del rs

					if ((id == ide)) {

						ide = rs.getInt("ide");
					}

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return registros;

	}

	public Usuario insertarUsuario(Usuario usu) throws Exception {

		String sql = "INSERT INTO usuario(ide,nombre,contrasena,imagen) VALUES (?,?,?,?)";

		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(sql);

		) {
			pst.setInt(1, usu.getId());
			pst.setString(2, usu.getNombre());
			pst.setString(3, usu.getContrasena());
			pst.setString(4, usu.getImagen());

			int affectRows = pst.executeUpdate();
			if (affectRows == 1) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usu;

	}

	public Usuario modificarUsuario(Usuario usu, int ide) throws Exception {

		String sql = "UPDATE usuario SET  nombre=?,contrasena=?,imagen=? WHERE ide =?;";

		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(sql);

		) {

			pst.setString(1, usu.getNombre());
			pst.setString(2, usu.getContrasena());
			pst.setString(3, usu.getImagen());

			pst.setInt(4, ide);

			int affectRows = pst.executeUpdate();

			if (affectRows == 1) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usu;

	}

	public Usuario eliminarUsuario(int ide) throws Exception {
		Usuario u = new Usuario();
		String sqldelete = "DELETE FROM usuario WHERE ide = ? ;";
		String sqlselect = "SELECT ide, nombre, contrasena, imagen FROM usuario ORDER BY ide DESC; ";
		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(sqlselect);

				PreparedStatement pstUpdate = con.prepareStatement(sqldelete);

				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				u.setId(ide);
			}
			pstUpdate.setInt(1, ide);
			int affedtedRows = pstUpdate.executeUpdate();

			if (affedtedRows == 1) {

			}
		}
		return u;
	}
}
