package com.renedo.runners.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.categorias.Categoria;
import com.renedo.runners.modelo.Carrera;
import com.renedo.runners.modelo.CarreraDao;
import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAO;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

		Producto producto = new Producto();
		Categoria categoria= new Categoria();
		
		String mensaje = "";

		try {

			/// crear producto
			int idint = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			float precio = Float.parseFloat(request.getParameter("precio"));
			String imagen = request.getParameter("imagen");
			
			
			/// insertar
			producto.setId(idint);
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setImagen(imagen);
			producto.setCategoria(categoria);

			dao.insert(producto);
			mensaje = "Producto guardado con exito";
			

			
			///modificar
			if (producto.getId() == idint) {
				dao.update(producto);
				mensaje = "producto esta editado con exito";
			}
			
		} catch (Exception e) {

			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();

		} finally {

			// enviar datos a la vista

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher("creareditarproducto.jsp").forward(request, response);

		}
	}
}
