package controlador;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.Producto;

/**
 * Servlet implementation class BuscadorCodigo
 */
@WebServlet("/BuscadorCodigo")
public class BuscadorCodigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorCodigo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		ModeloSeccion ms = new ModeloSeccion();
		ArrayList<Producto> productos = mp.getProductos();

		//Con for each
		
		ArrayList<Producto> productosBuscados = new ArrayList<Producto>();
		
		for (Producto producto : productos) {
			if(producto.getCodigo().contains((request.getParameter("codigo")))) {
				productosBuscados.add(producto); 
			}
		}
		request.setAttribute("Productos", productosBuscados);
		/*
		//Con Iterator
		Iterator<Producto> it = productos.iterator();
		
		while(it.hasNext()) {
			Producto producto = (Producto) it.next();
			if(producto.getCodigo().contains((request.getParameter("codigo")))) {
				
				productos.remove(producto); 
			}
		}
		request.setAttribute("Productos", productos);
		*/
		
		request.setAttribute("Secciones", ms.getSecciones());
		request.getRequestDispatcher("Principal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
