package com.renedo.runners.categorias;

import java.util.ArrayList;

import com.renedo.runners.producto.CrudAble;

public interface CategoriaDAO extends CrudAble<Categoria> {

	ArrayList<Categoria> getAll();

}
