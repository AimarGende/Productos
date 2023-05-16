package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSeccion extends Conector{
	PreparedStatement pst;
	String sentencia;
	public boolean insertarSeccion(Seccion seccion) {
		sentencia="INSERT INTO secciones (nombre) VALUES(?)";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			
			pst.setString(2, seccion.getNombre());
			
			pst.execute();
			
			cerrar();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean eliminarSeccion(int id) {
		sentencia="DELETE FROM secciones WHERE id=?";
		
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
	
	public boolean actualizarSeccion(Seccion seccion) {
		sentencia="UPDATE secciones SET nombre=? WHERE id=?";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			
			pst.setString(2, seccion.getNombre());
			
			pst.execute();
			
			cerrar();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public ArrayList<Seccion> getSecciones(){
		ArrayList<Seccion> secciones = new ArrayList<Seccion>();
		
		sentencia="SELECT * FROM secciones";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				Seccion seccion= new Seccion();
				
				seccion.setId(result.getInt("id"));
				seccion.setNombre(result.getString("nombre"));
				
				
				secciones.add(seccion);
			}
			return secciones;
		} catch (SQLException e) {
			return secciones;
		}
	}
	
	public Seccion getSeccion(int id){
		Seccion seccion= new Seccion();
		
		sentencia="SELECT * FROM secciones WHERE id=?";
		
		try {
			conectar();
			pst=getCon().prepareStatement(sentencia);
			pst.setInt(1, id);
			
			ResultSet result = pst.executeQuery();
			result.next();

			seccion.setId(result.getInt("id"));
			seccion.setNombre(result.getString("nombre"));
				
			return seccion;
		} catch (SQLException e) {
			return seccion;
		}
	}
	
}
