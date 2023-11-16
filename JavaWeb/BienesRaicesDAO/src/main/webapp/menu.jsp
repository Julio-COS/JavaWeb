<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String nombre=(String)session.getAttribute("nombre");
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menu</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >	
</head>
<body>
	<div align="center">
		<br>
		<h1>Menu Principal</h1>
		<h3>Bienvenido <%=nombre%></h3>
	</div>
  	<nav class="collapse d-lg-block sidebar collapse bg-white">
    	<div class="position-sticky">
			<div class="list-group list-group-flush mx-3 mt-4">
	        	<a href="frmPublicacionYVenta.jsp" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Formulario Publicacion Y Venta</span>
	        	</a>
	        	<a href="registrarVendedor.jsp" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Registrar Vendedor</span>
	        	</a>
 		        <a href="registrarCliente.jsp" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Registrar Cliente</span>
	        	</a>
  	 		    <a href="registrarBoleta.jsp" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Generar Boleta</span>
	        	</a>
	        	<a href="ServletVenta?tipo=listar" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Bandeja Publicacion Y Ventas</span>
	        	</a>
	        	<a href="ServletVendedor?tipo=listar" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Bandeja Vendedor</span>
	        	</a>
 		        <a href="ServletCliente?tipo=listar" class="list-group-item list-group-item-action py-2 ripple">
	        		<span>Bandeja Cliente</span>
	        	</a>
	        	<a href="ServletUsuario?tipo=cerrarSesion" class="list-group-item list-group-item-action py-2 ripple active">
	        		<span>Cerrar Sesion</span>
	        	</a>
	  		</div>
	    </div>
	  </nav>
</body>
</html>