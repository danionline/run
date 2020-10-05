package com.renedo.runners.usuario;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private Rol rol;

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasena = "";

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

	public Usuario(int id, String nombre, String contrasena, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contraseña=" + contrasena + "]";
	}

	public void setRol(Rol rol) {

		this.rol = rol;
	}

	public Rol getRol() {
		return rol;
	}

}
