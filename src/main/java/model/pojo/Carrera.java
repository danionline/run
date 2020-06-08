package model.pojo;

public class Carrera {

	private int id;
	private String nombre;

	private int tiempo;
	private int distancia;

	public Carrera() {
		super();
		this.id = 0;
		this.distancia = 0;
		this.tiempo = 0;
		this.nombre = "";
	}

	public Carrera(int id, String nombre, int tiempo, int velocidad, int distancia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.distancia = distancia;

	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
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

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", tiempo=" + tiempo + ", distancia=" + distancia + "]";
	}

}
