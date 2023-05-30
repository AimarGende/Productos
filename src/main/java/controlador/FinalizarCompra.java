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
import modelo.Producto;

/**
 * Servlet implementation class FinalizarCompra
 */
@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Producto> carrito= (ArrayList<Producto>) session.getAttribute("carrito");
		ModeloProducto mp = new ModeloProducto();
		
		for (Producto producto : carrito) {
			producto.setCantidad(producto.getCantidad()-1);
			mp.actualizarProducto(producto);
		}
		
		session.invalidate();
		request.setAttribute("msg", "Muchas gracias por su compra");
		
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
