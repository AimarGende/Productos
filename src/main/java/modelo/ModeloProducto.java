package modelo;

import java.sql.PreparedStatement;

public class ModeloProducto extends Conector{
	PreparedStatement pst;
	String sentencia;
	public boolean insertarProducto(Producto producto) {
		sentencia="INSERT INTO PRODUCTOS (codigo, nombre, cantidad, rpecio, caducidad)";
		
		
		return false;
	}
}
