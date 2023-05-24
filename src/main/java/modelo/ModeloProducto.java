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
		sentencia="INSERT INTO productos (codigo, nombre, cantidad, precio, caducidad,id_seccion) VALUES (?,?,?,?,?,?)";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date(producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getSeccion().getId());
			
			pst.execute();
			
			cerrar();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	public boolean getCodigo(String codigo) {
		sentencia="SELECT codigo FROM productos WHERE codigo=?";
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			pst.setString(1, codigo);
			
			ResultSet result = pst.executeQuery();
			result.next();
			
			if(codigo.equals(result.getString("codigo"))) {
				return true;
			}
			else {
				return false;
			}
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
	
	public boolean eliminarProductos(String[] codigos) {
		sentencia="DELETE FROM productos WHERE codigo =?";
		
		try {
			conectar();
			
			pst=getCon().prepareStatement(sentencia);
			
			for (String string : codigos) {
				pst.setString(1,string);
				pst.execute();
			}
			cerrar();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean actualizarProducto(Producto producto) {
		sentencia="UPDATE productos SET codigo=?,nombre=?,cantidad=?,precio=?,caducidad=?, id_seccion=? WHERE id=?";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date (producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getSeccion().getId());
			pst.setInt(7, producto.getId());
			
			pst.execute();
			
			cerrar();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

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
				ModeloSeccion ms = new ModeloSeccion();
				
				producto.setId(result.getInt("id"));
				producto.setCodigo(result.getString("codigo"));
				producto.setNombre(result.getString("nombre"));
				producto.setCantidad(result.getInt("cantidad"));
				producto.setPrecio(result.getDouble("precio"));
				producto.setCaducidad(result.getDate("caducidad"));
				producto.setSeccion(ms.getSeccion(result.getInt("id_seccion")));
				
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
		ModeloSeccion ms = new ModeloSeccion();
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			pst.setInt(1, id);
			
			ResultSet result = pst.executeQuery();
			result.next();
			
			producto.setId(result.getInt("id"));
			producto.setCodigo(result.getString("codigo"));
			producto.setNombre(result.getString("nombre"));
			producto.setCantidad(result.getInt("cantidad"));
			producto.setPrecio(result.getDouble("precio"));
			producto.setCaducidad(result.getDate("caducidad"));
			producto.setSeccion(ms.getSeccion(result.getInt("id_seccion")));
			
			return producto;
		} catch (SQLException e) {
			return producto;
		}
		
	}
	
	public ArrayList<Supermercado> getSupermercadoProducto(int id_producto){
		ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM	supermercados WHERE id IN (SELECT id_supermercado FROM productos_supermercados WHERE id_producto=?)");
			pst.setInt(1, id_producto);
			
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				Supermercado supermercado = new Supermercado();	
				
				supermercado.setId(result.getInt("id"));
				supermercado.setNombre(result.getString("nombre"));
				
				supermercados.add(supermercado);
			}
			
			cerrar();
			return supermercados;
		} catch (SQLException e) {

			e.printStackTrace();
			return supermercados;
		}

	}
	
	public int maxId() {
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT MAX(id) FROM productos");

			
			ResultSet result = pst.executeQuery();
			result.next();
			int maxId= result.getInt(1);
			cerrar();
			return maxId;
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean eliminarProductoSupermercado(int id_producto) {
		sentencia="DELETE FROM productos_supermercados WHERE id_producto=?";
		
		try {
			conectar();
			
			pst=getCon().prepareStatement(sentencia);
			
			pst.setInt(1, id_producto);
			
			pst.execute();
			
			cerrar();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
