<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String nombre=(String)session.getAttribute("nombre");
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sesión cerrada</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div align="center" style="margin: 220px" >
		<h1>Su sesión a sido finalizado: <%=nombre%></h1>
		<br><br>
		<img src="icon/check.svg" width="100" height="100">
		<br><br>
		<a href="login.jsp"> <input type="button" value="Regresar a Login" class="btn btn-primary"> </a>
	</div>
</body>
</html>