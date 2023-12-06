<%@page import="cl.inacap.tiendafullejb.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	<hr/>

	<form action="SucursalControlador" method="GET" id="formulario_modificar_sucursal"></form>
	<table>
		<tr>
			<td><label for="id">ID</label></td>
			<td><input type="number" name="id" form="formulario_modificar_sucursal" value="${param.id}" readonly></td>
		</tr>
		<tr>
			<td><label for="nombre">Nombre</label></td>
			<td><input type="text" name="nombre" form="formulario_modificar_sucursal" value="${param.nombre}" required></td>
		</tr>
		<tr>
			<td><label for="direccion">Dirección</label></td>
			<td><input type="text" name="direccion" form="formulario_modificar_sucursal" value="${param.direccion}" required></td>
		</tr>
		<tr>
			<td><label for="comuna">Comuna</label></td>
			<td><input type="text" name="comuna" form="formulario_modificar_sucursal" value="${param.comuna}" required></td>
		</tr>
		<tr>
			<td><label for="telefono">Telefono</label></td>
			<td><input type="number" name="telefono"form="formulario_modificar_sucursal" value="${param.telefono}" required></td>
		</tr>
		<tr>
			<td><button type="submit" value="4" form="formulario_modificar_sucursal" name="opcion">Modificar</button></td>
		</tr>
	</table>
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