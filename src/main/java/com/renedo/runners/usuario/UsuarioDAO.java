package com.renedo.runners.usuario;

import java.util.ArrayList;

import com.renedo.runners.producto.CrudAble;

public interface UsuarioDAO extends CrudAble<Usuario> {

	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * 
	 * @param palabraBuscada palabra a buscar
	 * @return {@code ArrayList<Usuario>}
	 * 
	 *         Ej: si palabraBuscada = "a" <br>
	 *         lista [ "ander", "pepe", "manolo"] <br>
	 *         retorna ["ander","manolo"] <br>
	 * 
	 *         SQL = SELECT id, nombre FROM alumno WHERE nombre LIKE '%a%' ORDER BY
	 *         nopmbre ASC;
	 * 
	 */
	ArrayList<Usuario> getAllByNombre(String palabraBuscada);

	/**
	 * Busca si existe el usuario en la base datsos
	 * 
	 * @param nombre   String nombre del usuario
	 * @param password String contraseña para acceder
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */
	Usuario existe(String nombre, String password);

	/**
	 * Inserta si no existe el usuario en la base de datos sino lanza una excepcion
	 * 
	 * @param pojo Usuario
	 * 
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */

	Usuario insert(Usuario pojo) throws Exception;

	/**
	 * Modifica si existe el usuario en la base de datos sino lanza una excepcion
	 * 
	 * @param pojo Usuario
	 * 
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */

	Usuario update(Usuario pojo) throws Exception;

	/**
	 * Eliminar si existe el usuario en la base de datos sino lanza una excepcion
	 * 
	 * @param id int ide del usuario
	 * 
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */

	Usuario delete(int id) throws Exception;
}
