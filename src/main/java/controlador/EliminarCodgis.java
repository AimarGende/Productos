package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;

/**
 * Servlet implementation class EliminarCodgis
 */
@WebServlet("/EliminarCodgis")
public class EliminarCodgis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCodgis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] codigos= request.getParameter("codigos").split(",");
		ModeloProducto mp = new ModeloProducto();
		boolean salir = false;
		
		int i=0;
		while(i<codigos.length && !salir) {
			if(!mp.getCodigo(codigos[i])) {
				i=codigos.length;
				salir=true;
			}
			i++;	
		}
		
		if(!salir) {
			mp.eliminarProductos(codigos);
		}
		
		request.getRequestDispatcher("Principal").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
