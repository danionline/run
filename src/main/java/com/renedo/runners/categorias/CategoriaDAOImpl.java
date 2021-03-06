package com.renedo.runners.categorias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.renedo.runners.carrera.ConnectionManager;
import com.renedo.runners.producto.Producto;

public class CategoriaDAOImpl implements CategoriaDAO {

	private final static Logger LOG = Logger.getLogger(CategoriaDAOImpl.class);
	private static CategoriaDAOImpl INSTANCE = null;

	private CategoriaDAOImpl() {
		super();
	}

	public static synchronized CategoriaDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAOImpl();
		}

		return INSTANCE;
	}

	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombrecategoria FROM categoria ORDER BY nombrecategoria ASC; ";

	@Override
	public ArrayList<Categoria> getAll() {

		ArrayList<Categoria> registros = new ArrayList<Categoria>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
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

	// TODO implementar estos metodos cuando necesitemos

	@Override
	public Categoria getById(int id) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Categoria delete(int id) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Categoria insert(Categoria pojo) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Categoria update(Categoria pojo) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	private Categoria mapper(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombrecategoria"));
		return c;
	}

	@Override
	public ArrayList<Producto> getProducto() {
		// TODO Auto-generated method stub
		return null;
	}

}
