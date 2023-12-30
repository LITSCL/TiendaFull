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
import cl.inacap.tiendafullejb.model.Sucursal;

/**
 * Servlet implementation class SucursalControlador
 */
@WebServlet("/SucursalControlador")
public class SucursalControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioLocal servicioLocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SucursalControlador() {
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
				List<Sucursal> sucursales = this.servicioLocal.getAllSucursal();
				request.setAttribute("sucursales", sucursales);
				request.getRequestDispatcher("lista_sucursales.jsp").forward(request, response);
				break;
			case "2":
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				String direccion = request.getParameter("direccion");
				String comuna = request.getParameter("comuna");
				int telefono = Integer.parseInt(request.getParameter("telefono"));
				Sucursal su = new Sucursal();
				su.setId(id);
				su.setNombre(nombre);
				su.setDireccion(direccion);
				su.setComuna(comuna);
				su.setTelefono(telefono);
				String mensaje = servicioLocal.saveSucursal(su);
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("agregar_sucursal.jsp").forward(request, response);
				break;
			case "3":
				int idEliminar = Integer.parseInt(request.getParameter("id"));
				servicioLocal.deleteSucursal(idEliminar);
				sucursales = this.servicioLocal.getAllSucursal();
				request.setAttribute("sucursales", sucursales);
				request.getRequestDispatcher("lista_sucursales.jsp").forward(request, response);
				break;
			case "4":
				int idModificar = Integer.parseInt(request.getParameter("id"));
				String nombreModificar = request.getParameter("nombre");
				String direccionModificar = request.getParameter("direccion");
				String comunaModificar = request.getParameter("comuna");
				int telefonoModificar = Integer.parseInt(request.getParameter("telefono"));
				Sucursal sucu = new Sucursal();
				sucu.setId(idModificar);
				sucu.setNombre(nombreModificar);
				sucu.setDireccion(direccionModificar);
				sucu.setComuna(comunaModificar);
				sucu.setTelefono(telefonoModificar);
				servicioLocal.updateSucursal(sucu);
				sucursales = this.servicioLocal.getAllSucursal();
				request.setAttribute("sucursales", sucursales);
				request.getRequestDispatcher("lista_sucursales.jsp").forward(request, response);
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
