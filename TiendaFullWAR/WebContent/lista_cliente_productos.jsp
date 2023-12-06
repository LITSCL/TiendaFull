<%@page import="cl.inacap.tiendafullejb.model.Categoria"%>
<%@page import="cl.inacap.tiendafullejb.model.Producto"%>
<%@page import="java.util.List"%>
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
Usuario usuario = (Usuario)session.getAttribute("usuario");
if (usuario != null && usuario.getTipo().equalsIgnoreCase("c") && request.getAttribute("filtro") == null) {  //Aca es cuando se verifica que el usuario esté autenticado.		
%>
	<table>
		<tr>
			<td>Cliente: <%=usuario.getNombre() + " " + usuario.getApellido()%></td>
			<td><a href="cerrar_sesion.jsp">Cerrar sesión</a></td>
		</tr>
	</table>
	<h3>Opciones</h3>
	<nav>
		<ul>
			<li><a href="FiltroUtils?opcion=1">Ver poductos</a></li>
		</ul>
	</nav>
	<hr>

	<form action="FiltroUtils" method="GET">
		<label for="nombreCategoria">Filtrar producto por nombre de categoría</label> 
		<select name="nombreCategoria" id="nombreCategoria">
			<c:forEach items="${categorias}" var="ca">

				<option value="${ca.nombre}">${ca.nombre}</option>

			</c:forEach>
		</select>
		<button type="submit" value="1" name="opcion">Filtrar</button>
	</form>
	<hr/>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descipción</th>
			<th>Precio</th>
			<th>Stock</th>
			<th>Stock Mínimo</th>
			<th>Nombre de categoría</th>
		</tr>
		<%
		List<Categoria> categorias = (List<Categoria>)request.getAttribute("categorias"); 
		List<Producto> productos = (List<Producto>)request.getAttribute("productos");
			  
		for (Producto pr : productos) {
			out.print("<tr>");
			out.print("<td>" + pr.getId() + "</td>");
			out.print("<td>" + pr.getNombre() + "</td>");
			out.print("<td>" + pr.getDescripcion() + "</td>");
			out.print("<td>" + pr.getPrecio() + "</td>");
			out.print("<td>" + pr.getStock() + "</td>");
			out.print("<td>" + pr.getStock_minimo() + "</td>");
		    for (Categoria ca : categorias) {
		    	if (pr.getCategoria_id() == ca.getId()) {
		        	out.print("<td>" + ca.getNombre() + "</td>");
		            break;
		        }
			}
		    out.print("</tr>");
		}      
		%>
	</table>
<% 
}
else if (usuario != null && usuario.getTipo().equalsIgnoreCase("c") && request.getAttribute("filtro") != null) { 		
%>
	<table>
		<tr>
			<td>Cliente: <%=usuario.getNombre() + " " + usuario.getApellido()%></td>
			<td><a href="cerrar_sesion.jsp">Cerrar sesión</a></td>
		</tr>
	</table>
	<h3>Opciones</h3>
	<nav>
		<ul>
			<li><a href="FiltroUtils?opcion=1">Ver poductos</a></li>
		</ul>
	</nav>
	<hr/>

	<form action="FiltroUtils" method="GET">
		<label for="categoria">Filtrar producto por nombre de categoría</label> 
		<select name="nombreCategoria" id="nombreCategoria">
			<c:forEach items="${categorias}" var="ca">

				<option value="${ca.nombre}">${ca.nombre}</option>

			</c:forEach>
		</select>
		<button type="submit" value="1" name="opcion">Filtrar</button>
	</form>
	<hr/>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descipción</th>
			<th>Precio</th>
			<th>Stock</th>
			<th>Stock Mínimo</th>
			<th>Nombre de categoría</th>
		</tr>
<%
List<Categoria> categorias = (List<Categoria>)request.getAttribute("categorias"); 
List<Producto> productos = (List<Producto>)request.getAttribute("productos");
	  
for (Producto pr : productos) {
	for (Categoria ca : categorias) {
    	if (pr.getCategoria_id() == ca.getId() && ca.getNombre().equals(request.getAttribute("filtro"))) {
        	out.print("<tr>");
			out.print("<td>" + pr.getId() + "</td>");
			out.print("<td>" + pr.getNombre() + "</td>");
			out.print("<td>" + pr.getDescripcion() + "</td>");
			out.print("<td>" + pr.getPrecio() + "</td>");
			out.print("<td>" + pr.getStock() + "</td>");
			out.print("<td>" + pr.getStock_minimo() + "</td>");
			out.print("<td>" + ca.getNombre() + "</td>");
			break;	
      	}
      	out.print("</tr>");
	}
}    
%>
	</table>
<%
}
else if (usuario != null && usuario.getTipo().equalsIgnoreCase("a")) {
%>
	<p>
		Solo los usuarios de tipo cliente pueden ver el contenido 
		<a href="pagina_principal_administrador.jsp">Volver al menu principal</a>
	</p>
<% 
}
else {
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


