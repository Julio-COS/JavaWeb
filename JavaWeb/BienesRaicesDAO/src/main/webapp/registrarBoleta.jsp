<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.ClienteDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.MySqlCliente"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Generar Boleta</title>
	<link href="css/boleta.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>

<body>
	<div class="contenedor" style="margin:20px">
		<h1>Generar Boleta</h1>
		<hr>
		<div class="panel panel-bloque">
			<div class="panel panel-row">
				<form name="buscarCliente" method="post" action="ServletBoleta?tipo=buscarCliente" class="form-horizontal">
					<h2>Cliente</h2>
					<label class="col col-form-label">Codigo Cliente:</label>
					<input name="codCliente" type="text"class="texto" placeholder="OBLIGATORIO" required>
					<input type="submit" value="Buscar" class="btn btn-success" >
					<br>
					<input type="text" value="${sessionScope.cliente.getNombres()}" class="texto fila" placeholder="Nombre Cliente" disabled>
				</form>
			</div>
			
	
			<div class="panel panel-row">
				<form name="buscarVenta" method="post" action="ServletBoleta?tipo=buscarVenta" class="form-horizontal">
					<h2>Venta</h2>
					<input name="codVenta" type="text" class="texto" placeholder="OBLIGATORIO" required>
					<input type="submit" value="Buscar Venta" class="btn btn-success">
					<br>
					<input name="txtDepa" type="text" value="${sessionScope.venta.getStringDepartamento()}" class="texto columna" placeholder="Departamento" disabled>
					<input name="txtDist" type="text" value="${sessionScope.venta.getDistProv()}"  class="texto columna" placeholder="Distrito" disabled>
					<input name="txtNombre" type="text" value="${sessionScope.venta.getNombreVendedor()}" class="texto columna" placeholder="Nombre del Vendedor" disabled>
					<input name="txtPrecio" type="text" value="${sessionScope.venta.getPrecio()}" class="texto columna" placeholder="Precio" disabled>
				</form>
				<form method="post" action="ServletBoleta?tipo=registrarVenta">
					<input type="submit" value="Registrar Venta" class="btn btn-success">
				</form>
			</div>
		</div>
		<div class="panel panel-bloque">
			<h2>Boleta</h2>
			<div class="col-sm-7">
				<div class="card">
					<div class="card-body">
						<div class="d-flex col-sm-5 ml-auto">
							<label>Numero de Serie</label>
							<input type="text" name="nroSerie" class="form-control">
						</div>
						<br>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>nventa</th>
									<th>vendedor</th>
									<th>precio</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
			<form method="post" action="ServletBoleta?tipo=registrar">
				<input name="txtcod" type="hidden" value="${sessionScope.cliente.getCodigo()}" placeholder="Cod Cliente" required>
				<input name="txtventa" type="hidden" value="${sessionScope.venta.getNventa()}" placeholder="Cod Venta" required>
				<input type="submit" value="Publicar" class="btn btn-success">
				<a href="menu.jsp"><input type="button" value="Cancelar" class="btn btn-danger"></a>
			</form>
		</div>
	</div>
</body>
</html>