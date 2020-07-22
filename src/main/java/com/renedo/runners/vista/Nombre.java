package com.renedo.runners.vista;

public class Nombre {
	
	private String nombre="";
	private String nombreusuario="";
	private String nombrerol="";

	
	
	private int idnombre;
	public Nombre() {
		super();
	
	}
	public Nombre(int idnombre, String nombre, String nombreusuario, String nombrerol) {
		super();
		this.idnombre = idnombre;
		this.nombre = nombre;
		this.nombreusuario = nombreusuario;
		this.nombrerol = nombrerol;
	}
	public int getIdnombre() {
		return idnombre;
	}
	public void setIdnombre(int idnombre) {
		this.idnombre = idnombre;
	}
	@Override
	public String toString() {
		return "nombre [nombre=" + nombre + ", nombreusuario=" + nombreusuario + ", nombrerol=" + nombrerol
				+ ", idnombre=" + idnombre + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getNombrerol() {
		return nombrerol;
	}
	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}
	
}
