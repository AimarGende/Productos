package modelo;

import java.util.ArrayList;

public class Supermercado {
	private int id;
	private String nombre;
	private ArrayList<Producto> productos;
	
	public Supermercado(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		productos= new ArrayList<Producto>();
	}

	public Supermercado() {

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
	
	

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Supermercado [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
	}

	
}
