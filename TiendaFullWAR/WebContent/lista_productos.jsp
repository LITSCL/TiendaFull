<%@page import="cl.inacap.tiendafullejb.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
if (usuario != null && usuario.getTipo().equalsIgnoreCase("a")) { //Aca es cuando se verifica que el usuario est� autenticado.
%>
	<table>
		<tr>
			<td>Administrador: <%=usuario.getNombre() + " " + usuario.getApellido()%></td>
			<td><a href="cerrar_sesion.jsp">Cerrar sesi�n</a></td>
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
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descipci�n</th>
			<th>Precio</th>
			<th>Stock</th>
			<th>Stock M�nimo</th>
			<th>ID Categor�a</th>
			<th>Opci�n 1</th>
			<th>Opci�n 2</th>
		</tr>
		<c:forEach items="${productos}" var="pr">
			<tr>
				<td>${pr.id}</td>
				<td>${pr.nombre}</td>
				<td>${pr.descripcion}</td>
				<td>${pr.precio}</td>
				<td>${pr.stock}</td>
				<td>${pr.stock_minimo}</td>
				<td>${pr.categoria_id}</td>
				<td><a href="modificar_producto.jsp?id=${pr.id}&nombre=${pr.nombre}&descripcion=${pr.descripcion}&precio=${pr.precio}&stock=${pr.stock}&stockMinimo=${pr.stock_minimo}&categoria=${pr.categoria_id}">Modificar</a></td>
				<td><a href="eliminar_producto.jsp?id=${pr.id}">Eliminar</a></td>
			</tr>
		</c:forEach>
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
	<p>Debes iniciar sesi�n para poder ver el contenido</p>
<%
}
%>
</body>
</html>


