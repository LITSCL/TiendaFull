<%@page import="cl.inacap.tiendafullejb.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
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

	<form action="SucursalControlador" method="GET" id="formulario_agregar_sucursal"></form>
	<table>
		<tr>
			<td><label for="id">ID</label></td>
			<td><input type="number" name="id" form="formulario_agregar_sucursal" required></td>
		</tr>
		<tr>
			<td><label for="nombre">Nombre</label></td>
			<td><input type="text" name="nombre" form="formulario_agregar_sucursal" required></td>
		</tr>
		<tr>
			<td><label for="direccion">Dirección</label></td>
			<td><input type="text" name="direccion" form="formulario_agregar_sucursal" required></td>
		</tr>
		<tr>
			<td><label for="comuna">Comuna</label></td>
			<td><input type="text" name="comuna" form="formulario_agregar_sucursal" required></td>
		</tr>
		<tr>
			<td><label for="telefono">Telefono</label></td>
			<td><input type="number" name="telefono" form="formulario_agregar_sucursal" required></td>
		</tr>
		<tr>
			<td><button type="submit" value="2" form="formulario_agregar_sucursal" name="opcion">Agregar</button></td>
		</tr>
	</table>
	${mensaje}
<%
} else if (usuario != null && usuario.getTipo().equalsIgnoreCase("c")) {
%>
<p>
		Solo los usuarios de tipo administrador pueden ver el contenido <a href="pagina_principal_cliente.jsp">Volver al menu principal</a>
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


