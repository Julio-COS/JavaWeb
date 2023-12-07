<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import="java.util.List"%>
<%@ page import="bean.VentaDTO" %>
<%
	List<VentaDTO> lis_ven=(List<VentaDTO>) request.getAttribute("data");
	VentaDTO beanPyv=new VentaDTO();
%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mantenimiento de Publicación y Venta</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<script type="text/javascript" src="ajax/gestVen.js"></script>
</head>
<body>
	<div style="margin:25px">
		<h2 align="center" style="margin:20px">Mantenimiento de Publicacion y Venta</h2>
		<br>
		<form name="bandejaPublicacionYVenta" id="bandejaPublicacionYVenta" method="post" action="ServletVenta?tipo=eliminar">
		<input type="hidden" value="<%=beanPyv.getNventa()%>" name="txt_nventa"> 
	
			<table class="table">
			<tr class="active">
			   <th>Nventa</th>
			   <th>Departamento</th>
			   <th>Tipo</th>
			   <th>DistProv</th>
			   <th>Plantas</th>
			   <th>MtsTerreno</th>
			   <th>Recamaras</th>
			   <th>MtsConstruccion</th>
			   <th>Baños</th>
			   <th>Precio</th>
			   <th>Cochera</th>
			   <th>Patio</th>
			   <th>Amueblado</th>
			   <th>Bardeado</th>
			   <th>Enrejado</th>
			   <th>Vendedor</th>
			   <th>[View]</th>
			   <th>[Edit]</th>
			   <th>[Del]</th>
			</tr>
			<%
			       for(int i=0;i<lis_ven.size();i++){
			    	   beanPyv=(VentaDTO)lis_ven.get(i);
			%>
			   <tr>
			   	  <td> <%=beanPyv.getNventa() %></td>
			   	  <td> <%=beanPyv.getStringDepartamento() %></td>
			   	  <td> <%=beanPyv.getTipo() %></td>
			   	  <td> <%=beanPyv.getDistProv() %></td>
			      <td><%=beanPyv.getPlantas() %></td>
			      <td><%=beanPyv.getMtsTerreno() %></td>
			      <td><%=beanPyv.getRecamaras() %></td>
			      <td><%=beanPyv.getMtsConstuccion() %></td>
			      <td><%=beanPyv.getBanios() %></td>
			      <td><%=beanPyv.getPrecio() %></td>
			      <td><%=beanPyv.getCochera() %></td>
			      <td><%=beanPyv.getPatio() %></td>
			      <td><%=beanPyv.getAmueblado() %></td>
			      <td><%=beanPyv.getBardeado() %></td>
			      <td><%=beanPyv.getEnrejado() %></td>
			      <td><%=beanPyv.getNombreVendedor() %> </td>
			      <td><a href="viewPyv.jsp?nventa=<%=beanPyv.getNventa() %> "><img src="icon/view.svg"></a></td>
			      <td><a href="editarPyv.jsp?nventa=<%=beanPyv.getNventa() %>">
			          <img src="icon/edit.svg"></a></td>
			      <td><img src="icon/delete.svg" onclick="javascript:enlaceEliminarPyV('<%=beanPyv.getNventa()%>')"></td>
			   </tr>
			   <% } %> 
			</table>
		
		</form>
		<a href="menu.jsp"><input type="button" value="Retornar al Menu" class="btn btn-primary"></a>
	</div>
</body>
</html>