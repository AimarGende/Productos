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
import modelo.ProductoComparatorCodigo;

/**
 * Servlet implementation class OrdenarPorCodigo
 */
@WebServlet("/OrdenarPorCodigo")
public class OrdenarPorCodigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenarPorCodigo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoComparatorCodigo comparator = new ProductoComparatorCodigo();
		ModeloProducto mp = new ModeloProducto();
		ModeloSeccion ms = new ModeloSeccion();
		ArrayList<Producto> productos = mp.getProductos();
		String orden = request.getParameter("orden");
		if(orden.equals("Ascendente")) {
			productos.sort(comparator);
		}else {
			productos.sort(comparator.reversed());
		}
		
		
		
		
		request.setAttribute("Secciones", ms.getSecciones());
		request.setAttribute("Productos", productos);
		
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
