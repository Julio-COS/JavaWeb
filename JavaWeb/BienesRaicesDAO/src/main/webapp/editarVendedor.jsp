<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.VendedorDTO"%>
<%@page import="dao.MySqlVendedor"%> 

<%
	int cod=(int)Integer.parseInt(request.getParameter("txt_cod"));
	MySqlVendedor sqlVen= new MySqlVendedor();	
	VendedorDTO beanVen =sqlVen.buscarVendedor(cod);
%>    
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div class="container">
            <br/>
            <div class="panel panel-default">
                <div class="panel-heading"><h3>Editar Vendedor</h3></div>
                <div class="panel-body">
                
                    <form name="regFrm" method="post" action="ServletVendedor?tipo=actualizar" class="form-horizontal" >
                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label">Codigo:</label>
                            <div class="col-sm-3">
	                            <input type="text" name="txtCodigo" value="<%=beanVen.getCodigo()%>" disabled class="form-control">
	                            <input type="hidden" name="txtCodigo" value="<%=beanVen.getCodigo()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label">Nombre:</label>
                            <div class="col-sm-3">
	                            <input type="text" name="txtNombre" value="<%=beanVen.getNombres()%>" class="form-control">

                            </div>
                        </div>
                        <div class="row mb-3">
                        	<label class="col-sm-1 col-form-label">Celular:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCelular" value="<%=beanVen.getCelular()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-1 col-form-label">Telefono:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtTelefono" value="<%=beanVen.getTelefono()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-1 col-form-label">Correo:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanVen.getCorreo()%>" class="form-control">
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	
                            <div class="col-sm-4">
                                <div class="col-sm-9">
                                    <input type="submit" name="btnActualizar" value="Actualizar" class="btn btn-success" />
                                    <a href="ServletVendedor?tipo=listar"><input type="button" value="Regresar" class="btn btn-danger"></a>
                                </div>
                            </div>
                        </div>                      
                    </form>
                    
                </div>
            </div>
        </div>
</body>
</html>