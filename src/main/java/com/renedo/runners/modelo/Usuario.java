package com.renedo.runners.modelo;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private String imagen;

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasena = "";
		this.imagen = "";
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String conse) {
		this.contrasena = conse;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Usuario(int id, String nombre, String contrasena, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contraseña=" + contrasena + ", imagen=" + imagen + "]";
	}

}
