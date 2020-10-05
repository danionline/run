package com.renedo.runners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAOImpl;

/**
 * Servlet implementation class EliminarProductoController
 */
@WebServlet("/producto-eliminar")
public class EliminarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarProductoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		String mensaje = "";
		int id = Integer.parseInt(request.getParameter("id"));

		Producto producto = new Producto();

		try {
			mensaje = "Eliminando " + producto.getNombre();
			dao.delete(id);

		} catch (Exception e) {
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
		}

		// enviar datos a la vista
		ArrayList<Producto> productos = dao.getAll();
		request.setAttribute("productos", productos);
		request.setAttribute("mensaje", mensaje);

		// ir a la nueva vista o jsp
		request.getRequestDispatcher("productos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
