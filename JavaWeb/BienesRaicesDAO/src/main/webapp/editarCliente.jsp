<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.ClienteDTO"%>
<%@page import="dao.MySqlCliente"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%
 	int cod=(int)Integer.parseInt(request.getParameter("txtCodCli"));
 	MySqlCliente sqlCli= new MySqlCliente();	
 	ClienteDTO cliObj = sqlCli.buscarCliente(cod);
 %>    

<div class="container">
            <br/>
            <div class="panel panel-default">
                <div class="panel-heading"><h3>Editar Cliente</h3></div>
                <div class="panel-body">
                
                    <form name="regFrm" method="post" action="ServletCliente?tipo=actualizar" class="form-horizontal" >
                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label">Codigo:</label>
                            <div class="col-sm-3">
	                            <input type="text" name="txtCodCli" value="<%=cliObj.getCodigo()%>" disabled class="form-control">
	                            <input type="hidden" name="txtCodCli" value="<%=cliObj.getCodigo()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label">Correo:</label>
                            <div class="col-sm-3">
	                            <input type="text" name="txtCorreo" value="<%=cliObj.getCorreo()%>" class="form-control">

                            </div>
                        </div>
                        <div class="row mb-3">
                        	<label class="col-sm-1 col-form-label">Nombres:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtNombres" value="<%=cliObj.getNombres()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-1 col-form-label">Apellidos:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtApellidos" value="<%=cliObj.getApellidos()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-1 col-form-label">Celular:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCelular" value="<%=cliObj.getCelular()%>" class="form-control">
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	
                            <div class="col-sm-4">
                                <div class="col-sm-9">
                                    <input type="submit" name="btnActualizar" value="Actualizar" class="btn btn-success" />
                                    <a href="ServletCliente?tipo=listar"><input type="button" value="Regresar" class="btn btn-danger"></a>
                                </div>
                            </div>
                        </div>                      
                    </form>
                    
                </div>
            </div>
        </div>
</body>
</html>