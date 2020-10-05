package com.renedo.runners.producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.renedo.runners.carrera.ConnectionManager;
import com.renedo.runners.categorias.Categoria;
import com.renedo.runners.usuario.ResumenUsuario;
import com.renedo.runners.usuario.Usuario;

public class ProductoDAOImpl implements ProductoDAO {

	private static ProductoDAOImpl INSTANCE = null;

	private final static Logger LOG = Logger.getLogger(ProductoDAOImpl.class);

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

	private final String SELECT_CAMPOS = "SELECT u.id 'usuario_id', u.nombre 'usuario_nombre', p.id  'producto_id', p.nombre 'producto_nombre', precio, imagen, c.id 'categoria_id', c.nombre 'categoria_nombre' ";

	private final String FROM_INNER_JOIN = " FROM producto p , categoria c, usuario u WHERE p.id_categoria  = c.id AND p.id_usuario = u.id  ";

	private final String SQL_GET_BY_USUARIO_PRODUCTO_VALIDADO = SELECT_CAMPOS + FROM_INNER_JOIN
			+ " AND fecha_validar IS NOT NULL AND p.id_usuario = ? \n" + "ORDER BY p.id DESC LIMIT 500; ";

	private final String SQL_GET_BY_USUARIO_PRODUCTO_SIN_VALIDAR = SELECT_CAMPOS + FROM_INNER_JOIN
			+ " AND fecha_validar IS NULL AND p.id_usuario = ? \n" + "ORDER BY p.id DESC LIMIT 500; ";

	private final String SQL = "SELECT COUNT(producto.id) as \"productosTotal\", COUNT(producto.fecha_crear) as \"productosAprobados\" ,Count(producto.fecha_validar )as \"productosPendientes\" FROM producto  where producto.id_usuario = ? LIMIT 200; ";

	private final String SQL_GET_USUARIO = "SELECT  p.id, p.nombre, c.nombre, p.imagen , p.precio FROM producto p , usuario u , categoria c WHERE p.id_usuario = u.id AND p.id_categoria = c.id AND p.id_usuario = ? AND p.fecha_validado IS NULL ORDER BY id_usuario ASC;";

	private final String SQL_ALL = "SELECT  p.id, p.nombre, p.imagen, c.nombrecategoria, p.precio FROM producto p , usuario u , categoria c WHERE p.id_usuario = u.id AND p.id_categoria = c.id ORDER BY id_usuario ASC LIMIT 200;";

	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = SELECT_CAMPOS + FROM_INNER_JOIN + " AND fecha_validar IS NOT NULL "
			+ " ORDER BY p.id DESC LIMIT 500; ";

	private final String SQL_GET_BY_ID = " SELECT " + "	 p.id     'id', " + "	 p.nombre 'nombre', " + "	 precio, "
			+ "	 imagen, " + "	 c.id     'id_categoria', " + "	 c.nombre 'nombre_categoria'	"
			+ " FROM producto p , categoria c " + " WHERE p.id_categoria  = c.id AND p.id = ? ; ";

	// excuteUpdate => int numero de filas afectadas
	// TODO faltan campos imagen y precio

	private final String SQL_CATEGORIA = "SELECT p.id, p.nombre, p.precio , p.imagen ,c.nombrecategoria ,p.id_categoria\n"
			+ "FROM producto p, categoria c Where p.id_categoria =c.id AND c.id=? LIMIT ?;";

	private final String SQL_INSERT = "INSERT INTO producto (id , nombre , precio   ) VALUES (? ,?, ?);";
	private final String SQL_UPDATE = " UPDATE producto SET nombre = ?, precio = ? WHERE id=? ; ";

	private final String SQL_DELETE = " DELETE FROM producto WHERE id = ? ; ";

	public ArrayList<Producto> getAllByNombre(String nombre) {
		return null;
	}

	public ArrayList<Producto> getProducto(int idUsuario, boolean validar) {

		ArrayList<Producto> registros = new ArrayList<Producto>();

		String sql = (validar) ? SQL_GET_BY_USUARIO_PRODUCTO_VALIDADO : SQL_GET_BY_USUARIO_PRODUCTO_SIN_VALIDAR;

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(sql);) {

			// TODO mirar como hacerlo con una SQL, "IS NOT NULL" o "IS NULL"
			// pst.setBoolean(1, isValidado); // me sustitulle con un 1 o 0
			pst.setInt(1, idUsuario);
			pst.setBoolean(1, validar);

			LOG.debug(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					registros.add(mapper(rs));
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return registros;
	}

	public Producto getResumenByUsuario(int idUsuario) {
		ResumenUsuario resul = new ResumenUsuario();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto producto = new Producto();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);) {

			pst.setInt(1, idUsuario);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					// mapper de RS al POJO

					resul.setIdUsuario(rs.getInt(idUsuario));
					resul.setProductosTotal(rs.getInt("productosTotal"));
					resul.setProductosAprobados(rs.getInt("productosAprobados"));
					resul.setProductosPendientes(rs.getInt("productosPendientes"));
					producto.setResumen(resul);

					productos.add(producto);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return producto;
	}

	public ArrayList<Producto> getAll() {

		ArrayList<Producto> registros = new ArrayList<Producto>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_ALL);
				ResultSet rs = pst.executeQuery();) {
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

			pst.setString(2, pojo.getNombre());

			pst.setFloat(3, pojo.getPrecio());
			pst.setInt(1, pojo.getId());

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
		p.setId(rs.getInt("id"));
		p.setImagen(rs.getString("imagen"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getFloat("precio"));
		Categoria g = new Categoria();
		g.setId(rs.getInt("id"));
		g.setNombre(rs.getString("nombrecategoria"));
		p.setCategoria(g);
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		p.setUsuario(u);
		return p;
	}

	@Override
	public ArrayList<Producto> getAllByCategoria(int idCategoria, int numregistros) {

		ArrayList<Producto> registros = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pst = con.prepareStatement(SQL_CATEGORIA);

		) {
			pst.setInt(1, idCategoria);
			pst.setInt(2, numregistros);
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

	@Override
	public ArrayList<Producto> getProducto() {
		// TODO Auto-generated method stub
		return null;
	}

}
