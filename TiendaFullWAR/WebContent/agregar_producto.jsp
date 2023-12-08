<%@page import="java.util.ArrayList"%>
<%@page import="cl.inacap.tiendafullejb.model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="cl.inacap.tiendafullejb.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
if (usuario != null && usuario.getTipo().equalsIgnoreCase("a")) { //Aca es cuando se verifica que el usuario esté autenticado.
%>
	<table>
		<tr>
			<td>Administrador: <%=usuario.getNombre() + " " + usuario.getApellido()%></td>
			<td><a href="cerrar_sesion.jsp">Cerrar sesión</a></td>
		</tr>
	</table>
	<h3>Opciones</h3>
	<nav>
		<ul>
			<li><a href="agregar_sucursal.jsp">Agregar Sucursal</a></li>
			<li><a href="CategoriaControlador?opcion=5">Agregar Producto</a></li>
			<li><a href="agregar_categoria.jsp">Agregar Categoria</a></li>
			<li><a href="SucursalControlador?opcion=1">Lista Sucursal</a></li>
			<li><a href="ProductoControlador?opcion=1">Lista Producto</a></li>
			<li><a href="CategoriaControlador?opcion=1">Lista Categoria</a></li>
		</ul>
	</nav>
	<hr>
	<form action="ProductoControlador" method="GET" id="formulario_agregar_producto"></form>
	<table>
		<tr>
			<td><label for="id">ID</label></td>
			<td><input type="number" name="id" form="formulario_agregar_producto" required></td>
		</tr>
		<tr>
			<td><label for="nombre">Nombre</label></td>
			<td><input type="text" name="nombre" form="formulario_agregar_producto" required></td>
		</tr>
		<tr>
			<td><label for="descripcion">Descripción</label></td>
			<td><input type="text" name="descripcion" form="formulario_agregar_producto" required></td>
		</tr>
		<tr>
			<td><label for="precio">Precio</label></td>
			<td><input type="number" name="precio"
				form="formulario_agregar_producto" required></td>
		</tr>
		<tr>
			<td><label for="stock">Stock</label></td>
			<td><input type="number" name="stock" form="formulario_agregar_producto" required></td>
		</tr>
		<tr>
			<td><label for="stockMinimo">Stock Minimo</label></td>
			<td><input type="number" name="stockMinimo" form="formulario_agregar_producto" required></td>
		</tr>
		<!-- Acá hay que traer las categorias, mostrarlas y que el administrador las elija (Se debe tomar el ID del objeto) -->
		<tr>
			<td><label for="categoria">Categoría</label></td>
			<td>
				<select name="categoria" id="categoria" form="formulario_agregar_producto">
					<%
					List<Categoria> categorias = new ArrayList<Categoria>();
					categorias = (List<Categoria>) request.getAttribute("categorias"); //Jamás deben haber archivos nulos en un JSP (Esta lista nunca debe ser nula).
					for (Categoria ca : categorias) {
						out.print("<option value=" + ca.getId() + ">" + ca.getNombre() + "</option>"); //Al administrador se le muestra el nombre, pero se envía el id.
					}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><button type="submit" value="2" form="formulario_agregar_producto" name="opcion">Agregar</button></td>
		</tr>
	</table>
	${mensaje}
<%
} else if (usuario != null && usuario.getTipo().equalsIgnoreCase("c")) {
%>
	<p>
		Solo los usuarios de tipo administrador pueden ver el contenido 
		<a href="pagina_principal_cliente.jsp">Volver al menu principal</a>
	</p>
<%
} else {
%>
	<center>
		<a href="index.html">Inicio</a>
	</center>
	<p>Debes iniciar sesión para poder ver el contenido</p>
<%
}
%>
</body>
</html>


