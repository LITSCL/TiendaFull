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
import cl.inacap.tiendafullejb.model.Usuario;

/**
 * Servlet implementation class UsuarioControlador
 */
@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioLocal servicioLocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion == null) { //Si es nulo, no se puede evaluar en el Switch.
			opcion = "";
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		
		switch (opcion) {
		case "1":
			List<Usuario> usuarios = servicioLocal.getAllUsuario();
			
			Usuario usuario = null;
			
			for (Usuario us : usuarios) { //Se recorre la lista.
				if (us.getId() == (id) && us.getPassword().equals(password)) {
					usuario = us; //Si los datos coinciden se almacena el usuario.
					break;
				}
			}
			
			//Si los datos coinciden se crea la sesi�n y se redirecciona.
			if (usuario != null && usuario.getTipo().equalsIgnoreCase("c")) {
				request.getSession().setAttribute("usuario", usuario); //Aca se crea la sesi�n.
				response.sendRedirect("pagina_principal_cliente.jsp");
			}
			else if (usuario != null && usuario.getTipo().equalsIgnoreCase("a")) {
				request.getSession().setAttribute("usuario", usuario); //Aca se crea la sesi�n.
				response.sendRedirect("pagina_principal_administrador.jsp");
			}
			else {
				request.setAttribute("error", "Usuario incorrecto"); 
				request.getRequestDispatcher("formulario_login.jsp").forward(request, response); //Aca se envia un String que dice "Usuario incorrecto" al documento especificado.
			}
			break;
		default:
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String correo = request.getParameter("correo");
			String tipo = request.getParameter("tipo");
			Usuario us = new Usuario();
			us.setId(id);
			us.setPassword(password);
			us.setNombre(nombre);
			us.setApellido(apellido);
			us.setCorreo(correo);
			us.setTipo(tipo);
			String mensaje = servicioLocal.saveUsuario(us);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("formulario_registro.jsp").forward(request, response);
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
