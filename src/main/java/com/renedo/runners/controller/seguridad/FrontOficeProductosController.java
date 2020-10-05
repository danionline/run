package com.renedo.runners.controller.seguridad;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAOImpl;
import com.renedo.runners.usuario.Usuario;

/**
 * Servlet implementation class FrontOficeProductosController
 */
@WebServlet("/views/frontoffice/productos")
public class FrontOficeProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontOficeProductosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String validados = request.getParameter("validados");
		boolean validar= Boolean.parseBoolean(validados);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ArrayList<Producto> productosPendientes = new ArrayList<Producto>();
		ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance();
		Usuario usuarioSession = (Usuario) request.getSession().getAttribute("usuario_login");
		int idUsuario = usuarioSession.getId();
		
		
		try {

			if (validados == null) {

				productos = daoProducto.getProducto(idUsuario , validar);
			} else {

				productosPendientes = daoProducto.getProducto(idUsuario, validar);
			}

			// productos = daoProducto.getAll();

		} catch (Exception e) {
			e.getMessage();

		} finally {
			request.setAttribute("productos", productos);
			request.setAttribute("productosPendientes",productosPendientes);
			request.getRequestDispatcher("productos.jsp").forward(request, response);
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
