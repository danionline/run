package com.renedo.runners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.renedo.runners.modelo.Usuario;
import com.renedo.runners.modelo.UsuarioDaoImpl;

/**
 * Servlet implementation class IncioSesionController
 */
@WebServlet("/sesion")
public class IncioSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IncioSesionController() {
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
		String id = "";

		boolean usuariosi = false;

		HttpSession sesion = request.getSession();

		try {

			String nomb = request.getParameter("nombre");
			String cons = request.getParameter("contrasena");
			usu.setNombre(nomb);
			usu.setContrasena(cons);

			for (Usuario usuario : asuario) {

				if (usuario.getNombre().equalsIgnoreCase(nomb) & (usuario.getContrasena().equalsIgnoreCase(cons))) {

					usuariosi = true;
				}

			}
			if (usuariosi == false) {

				sesion.invalidate();
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				sesion.setMaxInactiveInterval(60 * 5);
				sesion.setAttribute("usulogin", usu);

				request.getRequestDispatcher("index.jsp").forward(request, response);

			}

		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();

		}
	}
}
