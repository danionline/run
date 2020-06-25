package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carrera;
import modelo.CarreraDao;


/**
 * Servlet implementation class FormularioCarreraController
 */
@WebServlet("/registro")
public class FormularioCarreraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormularioCarreraController() {
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

		CarreraDao dao = CarreraDao.getInstance();
	
		
		Carrera crs = new Carrera();
		
		

		String mensaje = "";

		String idint = request.getParameter("ide");
		String nomb = request.getParameter("nombre");
		String tiem = request.getParameter("tiempo");
		String dist = request.getParameter("distancia");

		//parametro de la vista insertar
	
		String idec = request.getParameter("idcrear");
		int idcrear=Integer.parseInt(idec);
		
		
		
		int ide = Integer.parseInt(idint);
		int tiempo = Integer.parseInt(tiem);
		int distancia = Integer.parseInt(dist);
		
		
		
		try {

			
	
			//validacion del nombre
			if (nomb.length() >= 1 && nomb.length() <= 12) {

					///editar 
				if (dao.buscarId(ide)!=true) {
					mensaje = "Corredor modificado con exito";
					crs.setId(ide);
					crs.setNombre(nomb);
					crs.setTiempo(tiempo);
					crs.setDistancia(distancia);

					dao.modificarCarrera(crs, ide);
				}else {
					mensaje="no identificador encontrado";
				}
				
				///insertar
			
				if(idcrear==0) {

						crs.setId(ide);
						crs.setNombre(nomb);
						crs.setTiempo(tiempo);
						crs.setDistancia(distancia);

						dao.insertarCarrera(crs);

						mensaje = "Corredor guardado con exito";
					}
			}
			
		} catch (Exception e) {

			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();

		} finally {

			// enviar datos a la vista

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher("crearCarrera.jsp").forward(request, response);

		} // finally

	}// doPost
}
