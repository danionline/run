package com.renedo.runners.producto;

import java.util.ArrayList;

import com.renedo.runners.categorias.Categoria;

public class Producto {

	private int id;
	private String nombre;
	private String imagen;
	private float precio;
	private Categoria categoria;
	

	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.imagen = "imagenes/camiseta.jpeg";
		this.categoria = new Categoria();
	}

	public Producto(String nombre) {
		this();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public int getCategoriaId() {
		
		return categoria.getId();
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio
				+ ", categoria=" + categoria + "]";
	}

}
