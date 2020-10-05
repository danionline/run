package com.renedo.runners.controller.seguridad;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import com.renedo.runners.categorias.Categoria;
import com.renedo.runners.producto.Producto;
import com.renedo.runners.producto.ProductoDAOImpl;
import com.renedo.runners.usuario.Usuario;



/**
 * Servlet implementation class FrontOficeFormularioController
 */
@WebServlet("/views/frontoffice/formulario")
public class FrontOficeCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontOficeCrearController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Ir al Formulario y enviamos un producto inicializado 
		Producto p = new Producto();
		request.setAttribute("producto", p);
		// las categorias estan disponibles a traves del Listenner
		request.getRequestDispatcher("formulario.jsp").forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Producto producto = new Producto();
		ProductoDAOImpl dao= ProductoDAOImpl.getInstance();
		
		// recoger parametros del formulario
		String idParametro = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String imagen = request.getParameter("imagen");
		String categoriaId = request.getParameter("categoria_id");
		
		try {
		
			int id = Integer.parseInt(idParametro);
			int idCategoria = Integer.parseInt(categoriaId);
			float precioFloat = Float.parseFloat(precio);
			
			// crear objeto con esos parametros
			producto.setId(id);
			producto.setNombre(nombre);
			producto.setImagen(imagen);
			producto.setPrecio(precioFloat);
			
			Categoria c = new Categoria();
			c.setId(idCategoria);
			producto.setCategoria(c);		
			
			
			// recuperar usuario de session y setearlo en el producto
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usuario_login");
			

			
			
			
					
	
			
							
				dao.insert(producto);
			
			
	
		}catch (Exception e) {				
			
			
		}finally {
		
			
			request.setAttribute("producto", producto);
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}	
	}


}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	