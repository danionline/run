package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarreraDao {

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

		try (Connection con = ConnectionManager.getConnection();
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

	public boolean buscarId(int ide)throws Exception{
		
	
		
		String sql="Select id from carrera where id=? ;";
		boolean respuesta = false;
		int id=0;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			while (rs.next() && respuesta) {

				// recuperar columnas del resultset
				id = rs.getInt(ide);
				//crear pojo con datos del rs
				if(id==ide) {
					
					respuesta=false;
				}
				else {
					respuesta=true;
				}
				
			
		
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return respuesta;
		
	}

	public Carrera insertarCarrera(Carrera crs) throws Exception {

		String sql = "INSERT INTO carrera(id,nombre,tiempo,distancia) VALUES (?,?,?,?)";

		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(sql);

		) {
			pst.setInt(1, crs.getId());
			pst.setString(2, crs.getNombre());
			pst.setInt(3, crs.getTiempo());
			pst.setInt(4, crs.getDistancia());

			int affectRows = pst.executeUpdate();
			if (affectRows == 1) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return crs;

	}

	public Carrera modificarCarrera(Carrera crs, int ide) throws Exception {

		String sql = "UPDATE carrera SET  nombre=?,tiempo=?,distancia=? WHERE id =?;";

		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(sql);

		) {

			pst.setString(1, crs.getNombre());
			pst.setInt(2, crs.getTiempo());
			pst.setInt(3, crs.getDistancia());

			pst.setInt(4, ide);

			int affectRows = pst.executeUpdate();

			if (affectRows == 1) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return crs;

	}

	public String eliminarCarrera(int ide) throws Exception {

		String mensaje = "";
		String sqldelete = "DELETE FROM carrera WHERE id = ? ;";
		String sqlselect = "SELECT id, nombre, tiempo, distancia FROM carrera ORDER BY id DESC; ";
		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(sqlselect);

				PreparedStatement pstUpdate = con.prepareStatement(sqldelete);

				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				Carrera c = new Carrera();
				c.setId(ide);
			}
			pstUpdate.setInt(1, ide);
			int affedtedRows = pstUpdate.executeUpdate();

			if (affedtedRows == 1) {

			}
		}
		return mensaje;
	}
}
