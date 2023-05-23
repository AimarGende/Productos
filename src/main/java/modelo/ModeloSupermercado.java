package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSupermercado extends Conector{
	PreparedStatement pst;
	
	public ArrayList<Supermercado> getSupermercados (){
		ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
		
		try {
			conectar();
			pst=getCon().prepareStatement("SELECT * FROM supermercados");
			
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
		}
		
		return supermercados;
	}
	
	public Supermercado getSupermercado (int id){
		Supermercado supermercado = new Supermercado();
		
		try {
			conectar();
			pst=getCon().prepareStatement("SELECT * FROM supermercados WHERE id=?");
			pst.setInt(1, id);
			ResultSet result = pst.executeQuery();
			
			result.next();
			
			supermercado.setId(result.getInt("id"));
			supermercado.setNombre(result.getString("nombre"));
				
				
			cerrar();
			return supermercado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return supermercado;
	}
	
	public boolean insertarProductoSupermercado(int id_producto, String[] supermercados) {
		String sentencia="INSERT INTO productos_supermercados (id_producto,id_supermercado) VALUES(?,?)";
		
		conectar();
		try {
			pst=getCon().prepareStatement(sentencia);
			pst.setInt(1,id_producto);
			for (String string : supermercados) {
				pst.setInt(2,  Integer.parseInt(string));
				
				pst.execute();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
}
