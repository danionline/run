package com.renedo.runners.producto;

import java.util.ArrayList;

/**
 * Hereda los metodos basicos de la interfaz CrudAble Ademas definie un nuevo:
 * ArrayList<Producto> getAllByNombre( String nombre )
 * 
 * @author daniel
 *
 */
public interface ProductoDAO extends CrudAble<Producto> {

	/**
	 * IDevuelve un lista del array de productos completa de la base de datos
	 * 
	 * 
	 * @return Producto con datos si lo encuentra, si no existe retorna null
	 */

	ArrayList<Producto> getAll();

	ArrayList<Producto> getAllByNombre(String nombre);

	ArrayList<Producto> getAllRangoPrecio(int precioMinimo, int precioMaximo);

	/**
	 * Devuelve todas las categorias de los productos mediante una lista de arrays
	 * 
	 * @param idCategoria int ide de la categoria
	 * 
	 * @param i           int id del producto
	 * 
	 * @return Producto con datos si lo encuentra, si no existe retorna null
	 */

	ArrayList<Producto> getAllByCategoria(int idCategoria, int i);

	ArrayList<Producto> getLast(int i);

	/**
	 * Inserta si no existe un producto en la base de datos sino lanza una excepcion
	 * 
	 * @param Producto pojo
	 * 
	 * @return Producto con datos si lo encuentra, si no existe retorna null
	 */

	Producto insert(Producto pojo) throws Exception;

	/**
	 * Elimina si no existe un producto en la base de datos sino lanza una excepcion
	 * 
	 * @param id int ide del usuario
	 * 
	 * @return Producto con datos si lo encuentra, si no existe retorna null
	 */

	Producto delete(int id) throws Exception;

	Producto getById(int id) throws Exception;

	ArrayList<Producto> getProducto(int usuario, boolean validar);

}
