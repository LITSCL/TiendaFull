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
	<form action="UsuarioControlador" method="GET" id="formulario_registro"></form> <!-- Se envian los datos las Servlet llamado UsuarioControlador. -->
	<table>
		<tr>
			<td>ID</td>
			<td><input type="number" name="id" form="formulario_registro" drequired></td> <!-- El input pertenece al formulario con ID=formulario_login (Tiene que ser requerido este campo para que el usuario no lo deje vacio (Si lo deja vacio, en el Server quedaría int id="")). -->
		</tr>
		<tr>
			<td>Contraseña</td>
			<td><input type="text" name="password" form="formulario_registro" required></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre" form="formulario_registro" required></td>
		</tr>
		<tr>
			<td>Apellido</td>
			<td><input type="text" name="apellido" form="formulario_registro" required></td>
		</tr>
		<tr>
			<td>Correo</td>
			<td><input type="text" name="correo" form="formulario_registro" required></td>
		</tr>
		<tr>
			<td>Tipo</td>
			<td>
				<!-- Es importante llamar a todos los radio con el mismo nombre, para que cuando el usuario seleccione una las otras se desactiven. -->
				<label><input type="radio" name="tipo" value="a" id="tipo_0" form="formulario_registro" required>Administrador</label><br/> 
				<label><input type="radio" name="tipo" value="c" id="tipo_2" form="formulario_registro" required>Cliente</label><br/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Registrarse" form="formulario_registro"></td>
		</tr>
	</table>
<%
if (request.getAttribute("mensaje") != null) {
	out.print(request.getAttribute("mensaje"));
}
%>
</body>
</html>