package com.renedo.runners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAO;
import com.renedo.runners.producto.ProductoDAOImpl;

/**
 * Servlet implementation class CrearProductosController
 */
@WebServlet("/crear-producto")
public class CrearProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final ProductoDAO DAO = ProductoDAOImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearProductosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Producto prod = new Producto();
		String i = request.getParameter("id");
		int idi = Integer.parseInt(i);

		try {

			prod = DAO.getById(idi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("producto", prod);
		request.getRequestDispatcher("editarproducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Producto producto = new Producto();

		try {

			/// crear producto

			String nombre = request.getParameter("nombre");
			int precio = Integer.parseInt(request.getParameter("precio"));
			int id = Integer.parseInt(request.getParameter("id"));

			/// rellenar el objeto con los datos del formulario

			producto.setId(id);
			producto.setNombre(nombre);
			producto.setPrecio(precio);

			/// comprobar el ide del producto para saber si hay uno nuevo o modificarlo
			if (producto.getId() == 0) {

				DAO.insert(producto);

				/// modificar
			} else {

				DAO.update(producto);

			}

		} catch (Exception e) {

			e.printStackTrace();

			// enviar datos a la vista

		} finally {
			ArrayList<Producto> productos = new ArrayList<Producto>();
			productos = DAO.getAll();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("productos.jsp").forward(request, response);
		}
	}
}
