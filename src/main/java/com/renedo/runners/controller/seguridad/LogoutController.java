package com.renedo.runners.controller.seguridad;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.renedo.runners.controller.Alerta;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String idioma = "es";
		String mensaje = "";
		
		// recuperar cookie de Idioma para mensaje de salida		
		Cookie[] cookies = request.getCookies();
		if ( cookies != null ) {
			for ( Cookie c : cookies ) {			
				if ( "cIdioma".equals(c.getName()) ) {   // cookie encontrada
					idioma = c.getValue();
					break;
				}			
			}
		}	
			
		switch (idioma) {
		case "es":
			mensaje = "Adios nos vemos pronto";
			break;
			
		case "eu":
			mensaje = "Agur eta ohore";
			break;	

		default:
			mensaje = "You are wellcome to the hell";
			break;
		}
	
		
		request.setAttribute("alerta", new Alerta("success", mensaje ));

		
		// ATENCIION hacer lo ultimo, no antes de trabajar con las cookies
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		
		//usuarios conectados recuperar y actualizar
		ServletContext sc = request.getServletContext();
		int usuariosConectados = (int)sc.getAttribute("usuarios_conectados");
		sc.setAttribute("usuarios_conectados", --usuariosConectados);
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
