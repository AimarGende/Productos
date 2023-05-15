package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProducto extends Conector{
	PreparedStatement pst;
	String sentencia;
	public boolean insertarProducto(Producto producto) {
		sentencia="INSERT INTO productos (codigo, nombre, cantidad, precio, caducidad)";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date(producto.getCaducidad().getTime()));
			
			pst.execute();
			
			cerrar();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean eliminarProducto(int id) {
		sentencia="DELETE FROM productos WHERE id=?";
		
		try {
			conectar();
			
			pst=getCon().prepareStatement(sentencia);
			
			pst.setInt(1, id);
			
			pst.execute();
			
			cerrar();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean actualizarProductos(Producto producto) {
		sentencia="UPDATE productos SET codigo=?,nombre=?,cantidad=?,precio=?,caducidad=? WHERE id=?";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date (producto.getCaducidad().getTime()));
			
			pst.setInt(1, producto.getId());
			
			pst.execute();
			
			cerrar();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public ArrayList<Producto> getProductos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		sentencia="SELECT * FROM productos";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				Producto producto = new Producto();
				
				producto.setCodigo(result.getString("codigo"));
				producto.setNombre(result.getString("nombre"));
				producto.setCantidad(result.getInt("cantidad"));
				producto.setPrecio(result.getDouble("precio"));
				producto.setCaducidad(result.getDate("caducidad"));
				
				productos.add(producto);
			}
			return productos;
		} catch (SQLException e) {
			return productos;
		}
	}
	
	public Producto getProducto(int id) {
		Producto producto = new Producto();
		sentencia="SELECT * FROM productos WHERE id=?";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			pst.setInt(1, id);
			
			ResultSet result = pst.executeQuery();
			result.next();
			
			producto.setCodigo(result.getString("codigo"));
			producto.setNombre(result.getString("nombre"));
			producto.setCantidad(result.getInt("cantidad"));
			producto.setPrecio(result.getDouble("precio"));
			producto.setCaducidad(result.getDate("caducidad"));
			
			return producto;
		} catch (SQLException e) {
			return producto;
		}
		
	}
}
