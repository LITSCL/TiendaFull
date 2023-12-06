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

/**
 * Servlet implementation class CategoriaControlador
 */
@WebServlet("/CategoriaControlador")
public class CategoriaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioLocal servicioLocal; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaControlador() {
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
			List<Categoria> categorias = this.servicioLocal.getAllCategoria();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("lista_categorias.jsp").forward(request, response);
			break;
		case "2":
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String detalle = request.getParameter("detalle");
			Categoria ca = new Categoria();
			ca.setId(id);
			ca.setNombre(nombre);
			ca.setDetalle(detalle);
			String mensaje = servicioLocal.saveCategoria(ca);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("agregar_categoria.jsp").forward(request, response);
			break;
		case "3":
			int idEliminar = Integer.parseInt(request.getParameter("id"));
			String mensajeBorrar = servicioLocal.deleteCategoria(idEliminar);
			categorias = this.servicioLocal.getAllCategoria();
			request.setAttribute("categorias", categorias);
			request.setAttribute("mensajeBorrar", mensajeBorrar);
			if (mensajeBorrar != null) {
				request.getRequestDispatcher("eliminar_categoria.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("lista_categorias.jsp").forward(request, response);
			}
			
			break;
		case "4":
			int idModificar = Integer.parseInt(request.getParameter("id"));
			String nombreModificar = request.getParameter("nombre");
			String detalleModificar = request.getParameter("detalle");
			Categoria cat = new Categoria();
			cat.setId(idModificar);
			cat.setNombre(nombreModificar);
			cat.setDetalle(detalleModificar);
			servicioLocal.updateCategoria(cat);
			categorias = this.servicioLocal.getAllCategoria();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("lista_categorias.jsp").forward(request, response);
			break;
		case "5":
			List<Categoria> categoriaProductos = this.servicioLocal.getAllCategoria();
			request.setAttribute("categorias", categoriaProductos);
			request.getRequestDispatcher("agregar_producto.jsp").forward(request, response);
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
