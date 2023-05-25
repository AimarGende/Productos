package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.ModeloSupermercado;
import modelo.Producto;

/**
 * Servlet implementation class InsertarProducto
 */
@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto producto = new Producto();
		ModeloProducto mp = new ModeloProducto();
		ModeloSeccion ms = new ModeloSeccion();
		ModeloSupermercado msuper = new ModeloSupermercado();
		
		producto.setCodigo(request.getParameter("codigo"));
		producto.setNombre(request.getParameter("nombre"));
		producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));	
		
		try {
			producto.setCaducidad(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("caducidad")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		producto.setSeccion(ms.getSeccion(Integer.parseInt(request.getParameter("id_seccion"))));
		
		if(mp.getCodigo(producto.getCodigo())) {
			request.setAttribute("msg", "Codigo duplicado");
		}
		else if(producto.getPrecio()<0 || producto.getCantidad()<0) {
			request.setAttribute("msg", "Cantidad o precio negativas");
		}
		else if(producto.getCaducidad().before(new Date())) {
			request.setAttribute("msg", "La fecha es de un dia anterior a este");
		}
		else if(request.getParameter("id_seccion").equals("0")) {
			request.setAttribute("msg", "Escoga una seccion");
		}
		else {
			if(mp.insertarProducto(producto)) {
				request.setAttribute("msg", "Se ha insertado el producto correctamente");
				if(request.getParameterValues("supermercados")!=null){
					request.setAttribute("msg", "Escoga supermercado");
					msuper.insertarProductoSupermercado(mp.maxId(), request.getParameterValues("supermercados"));
				}
			}
			else {
				request.setAttribute("msg", "No se ha insertado el producto");
			}
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
