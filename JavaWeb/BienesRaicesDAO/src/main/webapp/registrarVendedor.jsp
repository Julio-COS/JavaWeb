<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
 <form name="registrarVendedor" method="post" action="ServletVendedor?tipo=registrar" class="form-horizontal">
 <div class="container">
 	<br>
	<div align="left" class="card" style="width: 25rem;">
		<div class="card-body">
			<h2>Datos del Vendedor</h2>
			<table>
				<tr>
					<td><label class="col col-form-label">Nombre:</label></td>
					<td><input name="txtNombre" type="text" class="form-control" placeholder="OBLIGATORIO"></td>
				</tr>
				<tr>
					<td><label class="col col-form-label">Celular:</label></td>
					<td><input name="txtCelular" type="text" class="form-control"></td>
				</tr>
				<tr>
					<td><label class="col col-form-label">Telefono:</label></td>
					<td><input name="txtTelefono" type="text" class="form-control" ></td>
				</tr>
				<tr>
					<td><label class="col col-form-label">Correo:</label></td>
					<td><input name="txtCorreo" type="text" class="form-control" placeholder="OBLIGATORIO"></td>
				</tr>
			</table>
		</div>
	</div>
	
	<div>
		<br>
		<input type="submit" value="Agregar Vendedor" class="btn btn-success">
		<a href="menu.jsp"><input type="button" value="Cancelar" class="btn btn-danger"></a>
	</div>
</div>
</form>
	
</body>
</html>