<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formulario de Publicación y Venta de Propiedades Inmuebles</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<script type="text/javascript" src="ajax/ajax_busqueda_javascript.js"></script>
</head>
<body>
<form name="frmPublicacionYVenta" method="post" action="ServletVenta?tipo=registrar" class="">

<div class="container" style="margin:20px">
	<div align="center" >
		<h1>Formulario de Publicación y Venta de Propiedades Inmuebles</h1>
	</div>
	<hr>

	<div align="center">
		<h2 align="left">Datos</h2>
		<table class="table">
			<tr>
				<td>Departamento</td>
				<td>
				<select name="cmbDepa" class="form-select">
					<option value="0">Seleccionar</option>
					<option value="1">Ancash</option>
					<option value="2">Arequipa</option>
					<option value="3">Ayacucho</option>
					<option value="4">Cajamarca</option>
				</select> 
				</td>
			</tr>
		
		
			<tr>
				<td>Tipo</td>
				<td> 
					<input type="radio" name="chkradio" value="Venta" checked>
					<label>Venta</label>
					<input type="radio" name="chkradio" value="Renta">
					<label>Renta</label>
				</td>
			</tr>
			
			<tr>
				<td>Distrito/Provincia</td>
				<td><input name="txtDistPro" type="text" class="form-control" ></td>
				<td>Plantas</td>
				<td><select name="cmbPlantas" class="form-select">
					<option value="0">Seleccionar</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					</select> 
				</td>
			</tr>
			
			<tr>
				<td>Mts. Terreno</td>
				<td colspan="2"><input name="txtMtsTerreno" type="text" class="form-control"></td>
			</tr>
			
			<tr>
				<td>Recamaras</td>
				<td><input name="txtRecamara" type="text" class="form-control" placeholder="0,1,2,3,..." ></td>
				<td>Mts. Construccion</td>
				<td><input name="txtMtsConstruccion" type="text" class="form-control"></td>
			</tr>
			<tr>
				<td>Baños</td>
				<td><input name="txtBanios" type="text" class="form-control" placeholder="0,1,2,3,..." ></td>
				<td>Precio</td>
				<td><input name="txtPrecio" type="text" class="form-control"></td>
			</tr>
			
			<tr>
				<td>Cochera</td>
				<td><input name="txtCochera" type="text" class="form-control" placeholder="0,1,2,3,..." ></td>
				<td>Patio</td>
				<td>
					<input type="radio" name="chkradio1" value="Si">
					<label>Si</label>
					<input type="radio" name="chkradio1" value="No">
					<label>No</label>
				</td>
				<td>Amueblado</td>
				<td>
					<input type="radio" name="chkradio2" value="Si">
					<label>Si</label>
					<input type="radio" name="chkradio2" value="No">
					<label>No</label>
				</td>
			</tr>
			
			<tr>
				<td>Bardeado</td>
				<td>
					<input type="radio" name="chkradio3" value="Si">
					<label>Si</label>
					<input type="radio" name="chkradio3" value="No">
					<label>No</label>
				</td>
				<td>Enrejado</td>
				<td>
					<input type="radio" name="chkradio4" value="Si">
					<label>Si</label>
					<input type="radio" name="chkradio4" value="No">
					<label>No</label>
				</td>
			</tr>
		</table>
	</div>
	
	<hr>
	
	<div align="left">
		<h2>Vendedor</h2>
		<table>
			<tr>
				<td><label class="col col-form-label">Buscar Vendedor Disponibles:</label></td>
				<td><input name="vendedor" type="text" class="form-control" ></td>
				<td><input type="button" onclick="javascript:ajax_listado()" name="btnAjax" value="Buscar" class="btn btn-primary"></td>
			</tr>
			<tr>
				<td><label class="col col-form-label">Lista:</label></td>
				<td><div id="resultados">&nbsp;</div></td>
			</tr>
			<tr>
				<td><label class="col col-form-label">Registrar Codigo del Vendedor Para Formulario:</label></td>
				<td><input name="txtVendedor" type="text" class="form-control" placeholder="OBLIGATORIO"></td>
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