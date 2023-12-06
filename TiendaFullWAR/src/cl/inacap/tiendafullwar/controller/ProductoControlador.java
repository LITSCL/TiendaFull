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
 * Servlet implementation class ProductoControlador
 */
@WebServlet("/ProductoControlador")
public class ProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioLocal servicioLocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoControlador() {
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
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("lista_productos.jsp").forward(request, response);
			break;
		case "2":
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			int precio = Integer.parseInt(request.getParameter("precio"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			int stockMinimo = Integer.parseInt(request.getParameter("stockMinimo"));
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			Producto pr = new Producto();
			pr.setId(id);
			pr.setNombre(nombre);
			pr.setDescripcion(descripcion);
			pr.setPrecio(precio);
			pr.setStock(stock);
			pr.setStock_minimo(stockMinimo);
			pr.setCategoria_id(categoria);
			String mensaje = servicioLocal.saveProducto(pr);
			List<Categoria> categorias = this.servicioLocal.getAllCategoria();
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("agregar_producto.jsp").forward(request, response);
			break;
		case "3":
			int idEliminar = Integer.parseInt(request.getParameter("id"));
			servicioLocal.deleteProducto(idEliminar);
			productos = this.servicioLocal.getAllProducto();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("lista_productos.jsp").forward(request, response);
			break;
		case "4":
			int idModificar = Integer.parseInt(request.getParameter("id"));
			String nombreModificar = request.getParameter("nombre");
			String descripcionModificar = request.getParameter("descripcion");
			int precioModificar = Integer.parseInt(request.getParameter("precio"));
			int stockModificar = Integer.parseInt(request.getParameter("stock"));
			int stockMinimoModificar = Integer.parseInt(request.getParameter("stockMinimo"));
			int categoriaModificar = Integer.parseInt(request.getParameter("categoria"));
			Producto pro = new Producto();
			pro.setId(idModificar);
			pro.setNombre(nombreModificar);
			pro.setDescripcion(descripcionModificar);
			pro.setPrecio(precioModificar);
			pro.setStock(stockModificar);
			pro.setStock_minimo(stockMinimoModificar);
			pro.setCategoria_id(categoriaModificar);
			servicioLocal.updateProducto(pro);
			productos = servicioLocal.getAllProducto();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("lista_productos.jsp").forward(request, response);
			break;
		case "5":
			productos = this.servicioLocal.getAllProducto();
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
