<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="bean.VendedorDTO" %>
<%
	List<VendedorDTO> lis_ven=(List<VendedorDTO>) request.getAttribute("data");
	VendedorDTO ven=new VendedorDTO();
%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<script type="text/javascript" src="ajax/gestVen.js"></script>
</head>
<body>
	<div style="margin:50px">
		<h2 align="center" style="margin:20px">Mantenimiento de Vendedor</h2>
		<br>
		<form name="bandejaVendedor" id="bandejaVendedor" method="post" action="ServletVendedor?tipo=eliminar">
		<input type="hidden" value="<%=ven.getCodigo()%>" name="txt_cod"> 
		<div style="margin:100px">
		<table class="table">
		<tr class="active">
		   <th>Codigo</th>
		   <th>Nombre</th>
		   <th>Celular</th>
		   <th>Telefono</th>
		   <th>Correo</th>
		   <th>[View]</th>
		   <th>[Edit]</th>
		   <th>[Del]</th>
		</tr>
		<%
		       for(int i=0;i<lis_ven.size();i++){
		    	   ven=(VendedorDTO)lis_ven.get(i);
		%>
		   <tr>
		   	  <td><%=ven.getCodigo() %> </td>
		   	  <td><%=ven.getNombres() %> </td>
		      <td><%=ven.getCelular() %></td>
		      <td><%=ven.getTelefono() %></td>
		      <td><%=ven.getCorreo() %></td>
		      <td><a href="viewVendedor.jsp?txt_cod=<%=ven.getCodigo() %>"><img src="icon/view.svg" width="60" height="60"></a></td>
		      <td><a href="editarVendedor.jsp?txt_cod=<%=ven.getCodigo() %>">
		          <img src="icon/edit.svg" width="60" height="60"></a></td>
		      <td><img src="icon/delete.svg" width="60" height="60" onclick="javascript:enlaceEliminar('<%=ven.getCodigo()%>')"></td>
		   </tr>
		   <% } %> 
		</table>
		<a href="menu.jsp"><input type="button" value="Retornar al Menu" class="btn btn-primary"></a>
		<a href="ServletVendedor?tipo=exportarEXCEL"><input type="button" value="Exportar EXCEL" class="btn btn-success"></a>
		</div>
		</form>
	</div>
</body>
</html>