package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloProducto;
import modelo.Producto;
import java.util.ArrayList;

/**
 * Servlet implementation class AnadirAlCarrito
 */
@WebServlet("/AnadirAlCarrito")
public class AnadirAlCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirAlCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Producto> carrito=new ArrayList<Producto>();
		ModeloProducto mp = new ModeloProducto();
		Producto producto = mp.getProducto(Integer.parseInt(request.getParameter("id")));
		if(producto.getCantidad()==0) {
			request.setAttribute("msg", "No se puede anadir el producto al carrito ya que no queda stock");
		}
		else {
			if(session.getAttribute("carrito")==null) {
				carrito=new ArrayList<Producto>();
				carrito.add(producto);
				request.setAttribute("msg", "Carrito creado y producto añadido");
			}else {
				carrito=(ArrayList<Producto>)session.getAttribute("carrito");
				carrito.add(producto);
				request.setAttribute("msg", "Producto añadido a carrito existente");

			}
			session.setAttribute("carrito", carrito);
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
