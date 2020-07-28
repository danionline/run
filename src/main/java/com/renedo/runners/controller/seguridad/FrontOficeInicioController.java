package com.renedo.runners.controller.seguridad;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.modelo.ResumenUsuario;
import com.renedo.runners.modelo.Usuario;
import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAOImpl;

/**
 * Servlet implementation class FrontOficeInicioController
 */
@WebServlet("/views/frontoffice/inicio")
public class FrontOficeInicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontOficeInicioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuarioSession = (Usuario) request.getSession().getAttribute("usuario_login");
		int idUsuario = usuarioSession.getId();

		// TODO recuperar datos de una VIEW
		Producto total = daoProducto.getResumenByUsuario(idUsuario);
		ResumenUsuario resumen = total.getResumen();

		request.setAttribute("productosTotal", resumen.getProductosTotal());
		request.setAttribute("productosAprobados", resumen.getProductosAprobados());
		request.setAttribute("productosPendientes", resumen.getProductosPendientes());

		// CUIDADO: mirar la URL del servlet "/views/frontoffice/inicio"
		// cuando hacemos forward se pierde lo ultimo de la url y se le suma la variabel
		// pagina
		// ----------------------------------------------------------------------------------------
		// el forward resuleve la url de la siguiente manera:
		//
		// "/views/frontoffice/inicio" + "index.jsp" = "/views/frontoffice/index.jsp"
		// ------------------------------------------------------------------------------------------
		String pagina = "index.jsp";

		request.getRequestDispatcher(pagina).forward(request, response);

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
