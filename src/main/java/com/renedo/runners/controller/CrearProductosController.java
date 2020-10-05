package com.renedo.runners.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAOImpl;

/**
 * Servlet implementation class CrearProductosController
 */
@WebServlet("/crear-producto")
public class CrearProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

		Producto producto = new Producto();

		String mensaje = "";

		try {

			/// crear producto

			String nombre = request.getParameter("nombre");
			float precio = Float.parseFloat(request.getParameter("precio"));
			String imagen = request.getParameter("imagen");

			/// rellenar el objeto con los datos del formulario

			producto.setNombre(nombre);
			producto.setPrecio(precio);

			/// comprobar el ide del producto para saber si hay uno nuevo o modificarlo
			if (producto.getId() == 0) {

				dao.insert(producto);
				mensaje = "Producto guardado con exito";
				request.setAttribute("mensaje", mensaje);

				/// modificar
			} else {
				dao.getById(producto.getId());
				dao.update(producto);
				mensaje = "producto esta editado con exito";

			}

		} catch (Exception e) {

			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();

			// enviar datos a la vista

		}
		request.setAttribute(mensaje, "mensaje");
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}
}
