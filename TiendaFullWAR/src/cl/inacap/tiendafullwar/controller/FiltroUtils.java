package cl.inacap.tiendafullwar.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.tiendafullejb.business.ServicioLocal;
import cl.inacap.tiendafullejb.model.Categoria;
import cl.inacap.tiendafullejb.model.Producto;

/**
 * Servlet implementation class FiltroUtils
 */
@WebServlet("/FiltroUtils")
public class FiltroUtils extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioLocal servicioLocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltroUtils() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "1":
			List<Producto> productos = this.servicioLocal.getAllProducto();
			List<Categoria> categorias = this.servicioLocal.getAllCategoria();
			
			String filtro = request.getParameter("nombreCategoria");
			request.setAttribute("filtro", filtro);
			request.setAttribute("categorias", categorias);
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("lista_cliente_productos.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
