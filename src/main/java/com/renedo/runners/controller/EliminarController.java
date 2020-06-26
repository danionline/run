package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import modelo.CarreraDao;
import modelo.Usuario;
import modelo.UsuarioDao;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet("/eliminar")
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// <td><a href="producto-eliminar?id=${p.id}">ELIMINAR</a></td>
				// recoger parametro
				String parametroId = request.getParameter("ide");
				int id = Integer.parseInt(parametroId);
				
				// llamr modelo
				UsuarioDao dao = UsuarioDao.getInstance();
				String mensaje  = "";
				Usuario u= new Usuario();
				
				try {
					u = dao.eliminarUsuario(id);
					mensaje = "Eliminado con exito el usuario " ;
					if(u.getId()!=id) {
						mensaje="No se encuentra el usuario en la base de datos";
					}
				} catch (Exception e) {
					mensaje = "Error " + e.getMessage();
					e.printStackTrace();
				}finally {
				
					// guardar datos en session para el mensaje de la vista
					request.setAttribute("mensaje", mensaje );
					
					// pedimos al cliente que realize una segunda REQUEST
					request.getRequestDispatcher("eliminarusuarios.jsp").forward(request, response);	
				}
				
			
			
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		}
}
