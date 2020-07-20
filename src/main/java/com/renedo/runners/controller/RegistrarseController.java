package com.renedo.runners.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<Usuario> asuario = null;
		asuario = dao.getAll();
		Usuario usu = new Usuario();

		String mensaje = "";

		try {
			String id = request.getParameter("ide");
			String nomb = request.getParameter("nombre");
			String cons = request.getParameter("conse");
			String imagen = request.getParameter("imagen");
			int ide = Integer.parseInt(id);
			for (Usuario usuario : asuario) {

				if (usuario.getId() == ide) {

					mensaje = "usuario esta en la base de datos";
				}
			}

			if ((nomb.length() >= 1 && nomb.length() <= 12) && (mensaje == "")) {

				usu.setId(ide);
				usu.setNombre(nomb);
				usu.setContrasena(cons);
				usu.setImagen(imagen);

				dao.insert(usu);

				mensaje = "Corredor guardado con exito";
			}

		} catch (Exception e) {

			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();

		} finally {

			// enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("usu", usu);
			request.getRequestDispatcher("registrarse.jsp").forward(request, response);

		} // finally

	}// doPost

}
