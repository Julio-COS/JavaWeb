<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="bean.ClienteDTO" %>
<%
	List<ClienteDTO> lis_cli=(List<ClienteDTO>) request.getAttribute("data");
	ClienteDTO cli=new ClienteDTO();
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
		<h2 align="center" style="margin:20px">Mantenimiento de Cliente</h2>
		<br>
		<form name="bandejaCliente" id="bandejaCliente" method="post" action="ServletCliente?tipo=eliminar">
		<input type="hidden" value="<%=cli.getCodigo()%>" name="txtCodCli"> 
		<div style="margin:100px">
		<table class="table">
		<tr class="active">
		   <th>Codigo</th>
		   <th>Correo</th>
		   <th>Nombres</th>
		   <th>Apellidos</th>
		   <th>Celular</th>
		   <th>[View]</th>
		   <th>[Edit]</th>
		   <th>[Del]</th>
		</tr>
		<%
		       for(int i=0;i<lis_cli.size();i++){
		    	   cli=(ClienteDTO)lis_cli.get(i);
		%>
		   <tr>
		   	  <td><%=cli.getCodigo() %> </td>
		   	  <td><%=cli.getCorreo() %> </td>
		      <td><%=cli.getNombres() %></td>
		      <td><%=cli.getApellidos() %></td>
		      <td><%=cli.getCelular() %></td>
		      <td><a href="viewCliente.jsp?txtCodCli=<%=cli.getCodigo() %>"><img src="icon/view.svg" width="60" height="60"></a></td>
		      <td><a href="editarCliente.jsp?txtCodCli=<%=cli.getCodigo() %>">
		          <img src="icon/edit.svg" width="60" height="60"></a></td>
		      <td><img src="icon/delete.svg" width="60" height="60" onclick="javascript:enlaceEliminarCliente('<%=cli.getCodigo()%>')"></td>
		   </tr>
		   <% } %> 
		</table>
		<a href="menu.jsp"><input type="button" value="Retornar al Menu" class="btn btn-primary"></a>
		<a href="ServletCliente?tipo=exportarPDF"><input type="button" value="Exportar a PDF" class="btn btn-danger"></a>
		</div>
		</form>
	</div>
</body>
</html>