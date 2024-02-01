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
	<form action="UsuarioControlador" method="GET" id="formulario_login"></form> <!-- Se envian los datos las Servlet llamado UsuarioControlador. -->	
	<table>
		<tr>
			<td>ID</td>
			<td><input type="number" name="id" form="formulario_login" required></td> <!-- El input pertenece al formulario con ID=formulario_login (Tiene que ser requerido este campo para que el usuario no lo deje vacio (Si lo deja vacio, en el Server quedaría int id="")). -->			
		</tr>
		<tr>
			<td>Contraseña</td>
			<td><input type="text" name="password" form="formulario_login"></td>
		</tr>
		<tr>
			<td><button type="submit" value="1" form="formulario_login" name="opcion">Ingresar</button></td>
		</tr>
	</table>
${error}
<!-- Mostrando el error mediante una expresión de lenguaje. -->
<%
//Esto es otra forma de mostrar el error.
//if(request.getAttribute("error")!=null){
//out.print(request.getAttribute("error"));
//}
%>
</body>
</html>