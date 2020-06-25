package producto;

import java.util.ArrayList;

/**
 * Hereda los metodos basicos de la interfaz CrudAble
 * Ademas definie un nuevo:  ArrayList<Producto> getAllByNombre( String nombre )
 * @author javaee
 *
 */
public interface ProductoDAO extends CrudAble<Producto> {

	
	ArrayList<Producto> getAllByNombre( String nombre );
	
	ArrayList<Producto> getAllRangoPrecio( int precioMinimo, int precioMaximo );

	ArrayList<Producto> getAllByCategoria(int idCategoria, int i);

	ArrayList<Producto> getLast(int i);
	
	
}
