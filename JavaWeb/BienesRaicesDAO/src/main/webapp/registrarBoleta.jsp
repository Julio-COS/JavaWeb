<%@page import="bean.VentaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Generar Boleta</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<form name="registrarBoleta" method="post" action="ServletBoleta?tipo=registrar" class="">
<div class="container" style="margin:20px">
	<div align="center" >
		<h1>Generar Boleta</h1>
	</div>
	<hr>

	<div align="left">
		<h2>Venta</h2>
		<table>
			<tr>
				<td><label class="col col-form-label">Registrar Codigo del Venta Para Formulario:</label></td>
				<td><input name="txtventa" type="text" class="form-control" placeholder="OBLIGATORIO"></td>
			</tr>
		</table>
	</div>
	
	<hr>
	
	<div align="left">
		<h2>Cliente</h2>
		<table>
			<tr>
				<td><label class="col col-form-label">Registrar Codigo del Cliente Para Formulario:</label></td>
				<td><input name="txtcod" type="text" class="form-control" placeholder="OBLIGATORIO"></td>
			</tr>
			
			
		</table>
	</div>

	
	<hr>
	<div>
		<input type="submit" value="Publicar" class="btn btn-success">
		<a href="menu.jsp"><input type="button" value="Cancelar" class="btn btn-danger"></a>
	</div>
</div>
</form>
</body>
</html>