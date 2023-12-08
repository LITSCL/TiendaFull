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
session.invalidate(); //Aca se esta cerrando la sesión.
response.sendRedirect("index.html"); //Eedirecciona automaticamente a "index.html".
%>
</body>
</html>