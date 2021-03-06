package com.renedo.runners.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.renedo.runners.usuario.Usuario;
import com.renedo.runners.usuario.UsuarioDaoImpl;

/**
 * <p>
 * Servlet implementation class RegistrarseController
 * </p>
 * <dl>
 * <dt>parametros de entrada</dt>
 * <dd>nombre String</dd>
 * <dd>conse String</dd>
 * <dd>consedos String</dd>
 * </dl>
 * 
 * <dl>
 * <dt>Explicacion</dt>
 * <dd>Es un Servlet que registra un nombre una contraseña, comprueba la
 * contraseña</dd>,
 * <dd>lo inserta en la base de datos con el dao, nos dirige a la clase de la
 * WEBapp</dd>
 * <dd>registrarse.jsp.</dd>
 * 
 * 
 * 
 * <dd>Si da una excepcion nos redirige a la clase login.jsp
 * 
 * 
 * <dd>Es un controlador que viene de la clase registrarse.jsp, donde esta el
 * mapa con el envio post desde la vista /registrarse.</dd>
 * </dl>
 */

@WebServlet("/registrarse")
public class RegistrarseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(RegistrarseController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDaoImpl dao = UsuarioDaoImpl.getInstance();

		Usuario usu = new Usuario();

		String mensaje = "";

		try {

			String nomb = request.getParameter("nombre");
			String cons = request.getParameter("conse");
			String consdos = request.getParameter("consedos");

			if (cons.contentEquals(consdos)) {

				usu.setNombre(nomb);
				usu.setContrasena(cons);

				try {

					dao.insert(usu);
					LOG.info("USUARIO GUARDADO" + usu);
					mensaje = "Usuario guardado con exito";
				} catch (Exception e) {

					LOG.error(e);
					mensaje = "Usuario no registrado, el nombre ya existe";
				}

			} else {

				mensaje = "La contraseña no coincide";
			}

		} catch (Exception e) {

			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			request.getRequestDispatcher("login.jsp").forward(request, response);

			e.printStackTrace();

		} finally {

			// enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("usu", usu);
			request.getRequestDispatcher("registrarse.jsp").forward(request, response);

		} // finally

	}// doPost

}
