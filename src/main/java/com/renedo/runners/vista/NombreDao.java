package com.renedo.runners.vista;

import java.util.ArrayList;

import com.renedo.runners.producto.CrudAble;

public interface NombreDao extends CrudAble <NombreDao> {
	
	ArrayList<NombreDao> getAll();


}
