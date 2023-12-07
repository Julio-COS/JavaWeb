<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Login</title>
	</head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link href="css/img.css" rel="stylesheet">
<body class="bodyForm">
	<div class="img">
	<form name="login" method="post" action="ServletUsuario?tipo=sesion">
		<div>
			<div class="form-outline mb-4" align="center">
				<h3>INGRESAR</h3>
		  	</div>
			<div class="form-outline mb-4">
				<label class="col-sm-1 col-form-label">Usuario:</label>
		    	<input type="text" name="txt_login" class="form-control">
		  	</div>
		  	<div class="form-outline mb-4">
		  		<label class="col-sm-1 col-form-label">Constraseña:</label>
		    	<input type="password" name="txt_pass" class="form-control">
		  	</div>
		  	<div align="center">
		  		<input type="submit" name="btnIngresar" value="Ingresar" class="btn btn-primary">
		  	</div>
	  	</div>
	</form>
	</div>
</body>
</html>