package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.Producto;

/**
 * Servlet implementation class BuscadorNombre
 */
@WebServlet("/BuscadorNombre")
public class BuscadorNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorNombre() {
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
		ArrayList<Producto> productosBuscados = new ArrayList<Producto>();
		
		for (Producto producto : productos) {
			if(producto.getNombre().contains( request.getParameter("nombre"))) {
				productosBuscados.add(producto);
			}
		}
		request.setAttribute("Secciones", ms.getSecciones());
		request.setAttribute("Productos", productosBuscados);
		
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
