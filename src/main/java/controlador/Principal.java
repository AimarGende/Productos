package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.ModeloSupermercado;
import modelo.Producto;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		ModeloSeccion ms = new ModeloSeccion();
		ModeloSupermercado msuper = new ModeloSupermercado();
		HttpSession session = request.getSession();
		ArrayList<Producto> carrito = (ArrayList<Producto>)session.getAttribute("carrito");
		int productos =0;
		if(session.getAttribute("carrito")!=null) {
			productos=carrito.size();
		}
		request.setAttribute("productosCarrito", productos);
		request.setAttribute("Secciones", ms.getSecciones());
		request.setAttribute("Productos", mp.getProductos());
		request.setAttribute("SupermercadoProductos", mp.getProductos());
		request.setAttribute("Supermercados",msuper.getSupermercados());
		
		
		
		request.getRequestDispatcher("Principal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
