package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;

/**
 * Servlet implementation class EliminarDeCarrito
 */
@WebServlet("/EliminarDeCarrito")
public class EliminarDeCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarDeCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ArrayList<Producto> carrito= (ArrayList<Producto>) session.getAttribute("carrito");
		ArrayList<Producto> nuevoCarrito = new ArrayList<Producto>();
		
		for (Producto producto : carrito) {
			if(producto.getId()!=Integer.parseInt(request.getParameter("id"))) {
				nuevoCarrito.add(producto);
			}
		}
		session.setAttribute("carrito", nuevoCarrito);
		
		request.getRequestDispatcher("VerCarrito").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
