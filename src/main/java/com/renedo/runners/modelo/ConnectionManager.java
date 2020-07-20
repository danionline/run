package com.renedo.runners.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class ConnectionManager {


	public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
		
		Connection con = null;
		
		// comprobar que tengamos el .jar de MySQL
		Class.forName("com.mysql.jdbc.Driver");
		
		InitialContext initCtx=new InitialContext();;
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/runners");
		
		// establecer conexion DriverManager		
		// con = DriverManager.getConnection(URL, USUARIO, PASS);
		
		// // establecer conexion conexión del pool
		con = dataSource.getConnection(); 
		
		return con;
	};
	


}
