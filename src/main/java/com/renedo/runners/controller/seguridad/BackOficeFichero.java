package com.renedo.runners.controller.seguridad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.modelo.ConnectionManager;

/**
 * Servlet implementation class BackOficeFichero
 */
@WebServlet("/views/backoffice/index")
public class BackOficeFichero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackOficeFichero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * 1.tiene que recoger el texto del fichero
	 * 
	 * 
	 * 4.cada vez que la inserccion con un comit da fallo no debe insertar y hacer
	 * un contador de error 5.por ultimo debe de hacer un rollback y deshacer los
	 * cambios 6.debe hacer la inserccion en la base de datos corregido el fallo
	 * 
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/// dana,pedro,hola,ander,mundo

		// final String PATH_FICHERO =
		// "/home/javaee/eclipse-workspace/supermercado-java/src/main/resources/personas.txt";
		final String FICHERO = "personas.txt"; // busca el fichero en la carpeta => src/main/resources
		String mensaje = "";

		int numLineas = 0;
		int numInsert = 0;
		int numErroresCampos = 0;
		int numLineasDuplicadas = 0;
		int numErroresNombresDuplicados = 0;
		long tiempo = System.currentTimeMillis();

		// INSERT INTO usuario (nombre,contrasenia,id_rol) VALUES
		// ('persona','e10adc3949ba59abbe56e057f20f883e',1);
		// final int ID_ROL_USER = 1;
		// final String PASSWORD = "e10adc3949ba59abbe56e057f20f883e"; // 123456 en MD5

		final String SQL = " INSERT INTO usuario (nombre,contrasenia,id_rol) VALUES ( ? ,'111',1); ";

		/******** Logica de programacion **********/

		int cont = 0;

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);
				BufferedReader br = new BufferedReader(
						new FileReader(getClass().getClassLoader().getResource(FICHERO).getFile()));) {

			// Cuando establecemos una conexion en Java, siempre es autocomitable
			// Con esta linea le decimos que no lo sea y deberemos hacer un COMMIT para
			// guardar los cambios temporales
			conexion.setAutoCommit(false);
			String linea = br.readLine(); // obviar la 1º linea, que son la cabecera

			for (int i = 0; i < br.read(); i++) {

				cont++;

			}

			boolean camposlineaserror = false;
			String lineaduplicada = br.readLine();
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(";");
				
				
				try {
					numLineas++;
					if (campos.length != 6) {
						numErroresCampos++;
					} else {
						
						pst.setString(1, campos[0]);
						
						int affectedRows = pst.executeUpdate();
						if (affectedRows != 1) {
							numErroresCampos++;
							camposlineaserror= linea.equalsIgnoreCase(lineaduplicada);
							lineaduplicada= br.readLine();
						} else {
							numInsert++;

						}

					}

					// capturar posibles Excepciones para poder seguir dentro del FOR
				} catch (Exception e) {
					if(camposlineaserror){
					   numLineasDuplicadas++;
					}
					numErroresNombresDuplicados++;
				}

			} // end while

			conexion.commit();

		} catch (FileNotFoundException e) {
			mensaje = "Lo sentimos pero el fichero no existe en la ruta: <b>" + FICHERO + "</b>";

		} catch (Exception e) {

			mensaje = e.getMessage();
			e.printStackTrace();

		} finally {

			request.setAttribute("mensaje", mensaje);
			request.setAttribute("fichero", FICHERO);
			request.setAttribute("numero_lineas", numLineas);
			request.setAttribute("numLineasDuplicadas", numLineasDuplicadas);
			request.setAttribute("numero_insercciones", numInsert);
			request.setAttribute("numero_errores_campos", numErroresCampos);
			request.setAttribute("numero_errores_nombre", numErroresNombresDuplicados);
			request.setAttribute("cont", cont);
			tiempo = System.currentTimeMillis();

			request.getRequestDispatcher("vistabackfichero.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
