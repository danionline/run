package com.renedo.runners.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.modelo.Usuario;
import com.renedo.runners.modelo.UsuarioDaoImpl;

/**
 * Servlet implementation class RegistrarseController
 */
@WebServlet("/registrarse")
public class RegistrarseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
					mensaje = "Usuario guardado con exito";
				} catch (Exception e) {

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
