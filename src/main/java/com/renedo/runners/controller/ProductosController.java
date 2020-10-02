package com.renedo.runners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.modelo.Carrera;
import com.renedo.runners.modelo.CarreraDao;
import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAO;
import com.renedo.runners.producto.ProductoDAOImpl;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/productos")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

		ArrayList<Producto> productos = null;
		productos = dao.getAll();

		request.setAttribute("productos", productos);

		request.getRequestDispatcher("productos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// llamar a la base datos para conseguir los productos

	}

}
