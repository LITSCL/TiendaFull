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
Usuario usuario = (Usuario)session.getAttribute("usuario");
if (usuario != null && usuario.getTipo().equalsIgnoreCase("c")) {  //Aca es cuando se verifica que el usuario est� autenticado.		
%>
	<table>
		<tr>
			<td>Has iniciado sesi�n correctamente cliente: <%=usuario.getNombre() + " " + usuario.getApellido()%></td>
			<td><a href="cerrar_sesion.jsp">Cerrar sesi�n</a></td>
		</tr>
	</table>
	<h3>Opciones</h3>
	<nav>
		<ul>
			<li><a href="FiltroUtils?opcion=1">Ver poductos</a></li>
		</ul>
	</nav>
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
	<p>Debes iniciar sesi�n para poder ver el contenido</p>
<%
}
%>
</body>
</html>