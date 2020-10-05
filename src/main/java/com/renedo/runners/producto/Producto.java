package com.renedo.runners.producto;

import com.renedo.runners.categorias.Categoria;
import com.renedo.runners.usuario.ResumenUsuario;
import com.renedo.runners.usuario.Usuario;

public class Producto {

	private int id;
	private String nombre;
	private String imagen;
	private float precio;
	private Categoria categoria;
	private Usuario usuario;
	private ResumenUsuario resumen;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.imagen = "imagenes/camiseta.jpeg";
		this.categoria = new Categoria();
		this.usuario = new Usuario();
		this.resumen = new ResumenUsuario();
	}

	public Producto(int id, String nombre, String imagen, float precio, Categoria categoria, Usuario usuario,
			ResumenUsuario resumen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
		this.categoria = categoria;
		this.usuario = usuario;
		this.resumen = resumen;
	}

	public ResumenUsuario getResumen() {
		return resumen;
	}

	public void setResumen(ResumenUsuario resumen) {
		this.resumen = resumen;
	}

	public Producto(int id, String nombre, String imagen, float precio, Categoria categoria, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
		this.categoria = categoria;
		this.usuario = usuario;
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
				+ ", categoria=" + categoria + ", usuario=" + usuario + ", resumen=" + resumen + "]";
	}

}
