package com.renedo.runners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.renedo.runners.categorias.Categoria;
import com.renedo.runners.categorias.CategoriaDAOImpl;
import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAO;
import com.renedo.runners.producto.ProductoDAOImpl;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(InicioController.class);
	private static final ProductoDAO productoDAO = ProductoDAOImpl.getInstance();
	private static final CategoriaDAOImpl categoriaDAO = CategoriaDAOImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cabecera = "Tabla de Productos por Categorias";

		ArrayList<Producto> productos = new ArrayList<Producto>();
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias = categoriaDAO.getAll();

		String paramIdCategoria = request.getParameter("idCategoria");

		LOG.trace("exito");
		if (paramIdCategoria != null) {

			int idParamCategoria = Integer.parseInt(paramIdCategoria);
			productos = productoDAO.getAllByCategoria(idParamCategoria, 10);

		} else {

			productos = productoDAO.getLast(10);
		}

		request.setAttribute("cabecera", cabecera);
		request.setAttribute("productos", productos);
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("categoria.jsp").forward(request, response);

	}

}
