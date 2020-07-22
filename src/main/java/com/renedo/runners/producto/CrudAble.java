package com.renedo.runners.producto;

import java.util.ArrayList;

import com.renedo.runners.modelo.Usuario;
import com.renedo.runners.vista.Nombre;

/**
 * Vamos a definir la operaciones Básicas de CRUD P es una clase GENERICA se
 * diferencia porque siempre un una LETRA MAYUSCULA Esa P luego podemos
 * sustituirla por cualquier Clase
 * 
 * @author javaee
 *
 */
public interface CrudAble<P> {

	ArrayList<P> getAll();

	P getById(int id) throws Exception;

	P delete(int id) throws Exception;

	P insert(P pojo) throws Exception;

	P update(P pojo) throws Exception;

}
