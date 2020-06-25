package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import modelo.UsuarioDao;

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
		UsuarioDao dao = UsuarioDao.getInstance();
		ArrayList<Usuario> asuario = null;
		asuario = dao.getAll();
		Usuario usu = new Usuario();
		String id="";
		String mensaje = "";

		try {
			 id = request.getParameter("ide");
			String nomb = request.getParameter("nombre");
			String cons = request.getParameter("conse");
			String imagen = request.getParameter("imagen");

			int ide = Integer.parseInt(id);
			for (Usuario usuario : asuario) {

				if (usuario.getId() == ide) {

					mensaje = "usuario esta en la base de datos";
					usu.setNombre(nomb);

				} else {

					response.sendRedirect("no esta en la base de datos");
				}
			}

		} catch (Exception e) {

			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();

		} finally {

			// enviar datos a la vista
			
		
	
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("usu", usu.getNombre());
			response.sendRedirect("iniciarsesion");

		}
	}
}
