package com.renedo.runners.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.renedo.runners.categorias.*;

/**
 * Application Lifecycle Listener implementation class listenerCategorias
 *
 */
@WebListener
public class listenerCategorias implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
	
	final private  static CategoriaDAOImpl categoriaDAO = CategoriaDAOImpl.getInstance();  
	
    public listenerCategorias() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    			String mensaje="";
    	
      	 
    	         // cuando ejecutamos la App en el Servidor, al arrancar la 1º vez
    	    	mensaje= ( " Estamos arreglado la aplicación, y soy un evento " );
    	    	
    	    	
    	    	// Este contexto es para toda la aplicación y es accesible desde cualñquier JSP o Servlet    	
    	    	ServletContext contextoAplicacion = sce.getServletContext ();
    	    	
    	    	try {
    	    	
    	    		contextoAplicacion.setAttribute( "categorias" , categoriaDAO.getAll());
    	    		
    	    	} catch ( Exception e) {
    	    		
    	    		contextoAplicacion.setAttribute ( "mensaje" , mensaje );
    			}	
    	    	
    	    }
    		
}   
	

