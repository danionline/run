package com.renedo.runners.vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.renedo.runners.vista.*;
import com.renedo.runners.modelo.ConnectionManager;

public class NombreDaoImpl implements NombreDao{

	private static NombreDaoImpl INSTANCE = null;
	
	
	public static synchronized NombreDaoImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new NombreDaoImpl();
		}

		return INSTANCE;
	}
	
	
	private String VISTANOMBRE = "SELECT *  vista_nombre vn ;";
	
	
	public ArrayList<NombreDao> getAll() {
		
		
		
		ArrayList<Nombre> registros = new ArrayList<Nombre>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(VISTANOMBRE);
				ResultSet rs = pst.executeQuery();) {
			
			while (rs.next()) {
				registros.add(mapper(rs));

			} // while

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return getAll();

	}

		


	private Nombre mapper(ResultSet rs) throws SQLException {
	
		Nombre n = new Nombre();
		n.setIdnombre(rs.getInt("id"));
		n.setNombre(rs.getString("nombre"));
		n.setNombrerol("nombrerol");
		n.setNombreusuario("nombreusuario");
		
		return n;
		
		
	}




	@Override
	public NombreDao getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NombreDao delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NombreDao insert(NombreDao pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NombreDao update(NombreDao pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
