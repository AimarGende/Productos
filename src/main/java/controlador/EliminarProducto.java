package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		
		if(mp.eliminarProducto(Integer.parseInt(request.getParameter("id")))){
			request.setAttribute("msg", "Se ha eliminado correctamente");
		}else {
			request.setAttribute("msg", "No se ha eliminado el producto");
		}
		
		if(mp.eliminarProductoSupermercado(Integer.parseInt(request.getParameter("id")))){
			request.setAttribute("msg", "Se ha eliminado correctamente");
		}else {
			request.setAttribute("msg", "No se ha eliminado el producto");
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
