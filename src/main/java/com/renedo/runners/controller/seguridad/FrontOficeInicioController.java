package com.renedo.runners.controller.seguridad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renedo.runners.producto.ProductoDAOImpl;
import com.renedo.runners.vista.Nombre;

/**
 * Servlet implementation class FrontOficeInicioController
 */
@WebServlet("/views/frontoffice/inicio")
public class FrontOficeInicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontOficeInicioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ProductoDAOImpl dao= ProductoDAOImpl.getInstance();
		
		Nombre nomb= new Nombre();
		
		
		//TODO llamar al dao
		
		request.setAttribute("productos", dao.getAll());
		request.setAttribute("nombre", nomb);
		
		request.getRequestDispatcher("ini.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
