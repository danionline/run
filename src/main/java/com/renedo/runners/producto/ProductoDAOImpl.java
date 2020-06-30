package com.renedo.runners.producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.renedo.runners.categorias.Categoria;
import com.renedo.runners.categorias.CategoriaDAOImpl;
import com.renedo.runners.modelo.ConnectionManager;

public class ProductoDAOImpl implements ProductoDAO {

	private static ProductoDAOImpl INSTANCE = null;

	private   final  static  Logger  LOG  =  Logger.getLogger (ProductoDAOImpl.class );
	
	
	private ProductoDAOImpl() {
		super();
	}

	public static synchronized ProductoDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoDAOImpl();
		}

		return INSTANCE;
	}

	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT " + "	 p.id     'id', " + "	 p.nombre 'nombre', " + "	 precio, "
			+ "	 imagen, " + "	 c.id     'id_categoria', " + "	 c.nombre 'nombre_categoria'	"
			+ " FROM producto p , categoria c " + " WHERE p.id_categoria  = c.id " + " ORDER BY p.id DESC LIMIT 500; ";

	private final String SQL_GET_BY_ID = " SELECT " + "	 p.id     'id', " + "	 p.nombre 'nombre', " + "	 precio, "
			+ "	 imagen, " + "	 c.id     'id_categoria', " + "	 c.nombre 'nombre_categoria'	"
			+ " FROM producto p , categoria c " + " WHERE p.id_categoria  = c.id AND p.id = ? ; ";

	// excuteUpdate => int numero de filas afectadas
	// TODO faltan campos imagen y precio

	private final String SQL_CATEGORIA = "SELECT p.id, p.nombre, p.precio , p.imagen ,c.nombre 'nombre_categoria' ,p.id_categoria \n" + 
			"FROM producto p, categoria c Where p.id_categoria =c.id AND c.id=? LIMIT ? ;";

	private final String SQL_INSERT = " INSERT INTO producto (nombre, imagen, precio , id_usuario, id_categoria ) VALUES ( ? , ?, ? , 1, 1 ) ; ";
	private final String SQL_UPDATE = " UPDATE producto SET nombre = ?, imagen = ?, precio = ? WHERE id = ? ; ";

	private final String SQL_DELETE = " DELETE FROM producto WHERE id = ? ; ";

	private final String SQL_GET="SELECT nombre, precio, imagen FROM producto;";
	
	public ArrayList<Producto> getAllByNombre(String nombre) {
		return null;
	}

	@Override
	

		
		public ArrayList<Producto> getAll() {
			
			ArrayList<Producto> registros = new ArrayList<Producto>();

			try ( Connection conexion = ConnectionManager.getConnection();
				  PreparedStatement pst = conexion.prepareStatement(SQL_GET);
				  ResultSet rs = pst.executeQuery();
			) {
				LOG.debug(pst);
				while (rs.next()) {
					registros.add(mapper(rs));
					
				} // while

			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
			return registros;

		}
	@Override
	public Producto getById(int id) throws Exception {
		Producto registro = new Producto();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				registro = mapper(rs);

			} else {
				throw new Exception("No se puede encontrar registro con id=" + id);
			}

		}

		return registro;
	}

	@Override
	public Producto delete(int id) throws Exception {

		// conseguir el producto antes de Eliminar
		Producto registro = getById(id);

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);

		) {

			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				throw new Exception("No se puedo eliminar el registro id = " + id);
			}

		} // try

		return registro;
	}

	@Override
	public Producto insert(Producto pojo) throws Exception {

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getImagen());
			pst.setFloat(3, pojo.getPrecio());
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {

				// conseguir el ID

				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						int id = rsKeys.getInt(1);
						pojo.setId(id);
					}

				}

			} else {

				throw new Exception("No se ha podido guardar el registro " + pojo);
			}

		}

		return pojo;
	}

	@Override
	public Producto update(Producto pojo) throws Exception {

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);

		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getImagen());
			pst.setFloat(3, pojo.getPrecio());
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se puede podificar el registro con id=" + pojo.getId());
			}

		}

		return pojo;
	}

	@Override
	public ArrayList<Producto> getAllRangoPrecio(int precioMinimo, int precioMaximo) {
		// TODO Auto-generated method stub
		return null;
	}

	private Producto mapper(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		p.setImagen(rs.getString("imagen"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getFloat("precio"));
		return p;
	}
	
	
	@Override
	public ArrayList<Producto> getAllByCategoria(int idCategoria, int numregistros) {

		ArrayList<Producto> registros = new ArrayList<Producto>();
	
		
		try (Connection con = ConnectionManager.getConnection();
				
				
				PreparedStatement pst = con.prepareStatement(SQL_CATEGORIA);
				

		) {
			pst.setInt(1,idCategoria);
			pst.setInt(2,numregistros);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {

				registros.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return registros;
	}

	@Override
	public ArrayList<Producto> getLast(int i) {

		return null;
	}

}
