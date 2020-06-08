package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.pojo.Carrera;
import modelo.conexion.ConnectionManagerRunner;

public class CarreraDao {

	public static String SQLNOMBRE = " SELECT nombre FROM carrera ;";

	public static CarreraDao INSTANCE = null;

	private CarreraDao() {
		super();
	}

	public static synchronized CarreraDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CarreraDao();
		}

		return INSTANCE;
	}

	public ArrayList<Carrera> getAll() {

		ArrayList<Carrera> registros = new ArrayList<Carrera>();

		String sql = "SELECT id, nombre, tiempo, distancia FROM carrera ORDER BY id DESC; ";

		try (Connection con = ConnectionManagerRunner.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			while (rs.next()) {

				// recuperar columnas del resultset
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int distancia = rs.getInt("distancia");
				int tiempo = rs.getInt("tiempo");

				// crear pojo con datos del rs
				Carrera carrera = new Carrera();
				carrera.setId(id);
				carrera.setNombre(nombre);
				carrera.setDistancia(distancia);
				carrera.setTiempo(tiempo);
				// guardar en ArrayList
				registros.add(carrera);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return registros;
	}
}
