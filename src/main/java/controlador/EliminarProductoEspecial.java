package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.Producto;


/**
 * Servlet implementation class EliminarProductoEspecial
 */
@WebServlet("/EliminarProductoEspecial")
public class EliminarProductoEspecial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoEspecial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		
		Producto producto = mp.getProducto(Integer.parseInt(request.getParameter("id")));

		if(producto.getCantidad()>0) {
			producto.setCantidad(producto.getCantidad()-1);
			mp.actualizarProducto(producto);
		}
		else if(producto.getCantidad()==0 && !mp.getSupermercadoProducto(producto.getId()).isEmpty()){
			mp.eliminarProductoSupermercado(producto.getId());
		}
		else if(producto.getCantidad()==0 && mp.getSupermercadoProducto(producto.getId()).isEmpty()) {
			mp.eliminarProducto(producto.getId());
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
