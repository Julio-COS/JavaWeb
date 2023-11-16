<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="bean.VentaDTO"%>
<%@page import="dao.MySqlVenta"%>

<%
	int nventa=Integer.parseInt(request.getParameter("nventa"));
	MySqlVenta sqlPyv= new MySqlVenta();
	VentaDTO beanPyv=sqlPyv.buscarVenta(nventa);
%>    
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div class="container">
            <br/>
            <div class="panel panel-default">
                <div class="panel-heading"><h3>Visualizar Publicación Y Venta</h3></div>
                <div class="panel-body">
                
                    <form name="regFrm" method="post" action="#" class="form-horizontal" >
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Numero de Venta:</label>
                            <div class="col-sm-3">
	                            <input type="text" name="txtNombre" value="<%=beanPyv.getNventa() %>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        	<label class="col-sm-2 col-form-label">Departamento:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCelular" value="<%=beanPyv.getDepartamento()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Tipo:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtTelefono" value="<%=beanPyv.getTipo()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Distrito/Provincia:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getDistProv()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Plantas:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getPlantas()%>" disabled class="form-control">
                            </div>
                        </div>
						<div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Mts Terreno:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getMtsTerreno()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Recamaras:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getRecamaras()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Mts Construccion:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getMtsConstuccion()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Baños:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getBanios()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Precio:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getPrecio()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Cochera(s):</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getCochera()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Patio(s):</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getPatio()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Amueblado:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getAmueblado()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Bardeado:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getBardeado()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Enrejado:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getEnrejado()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Vendedor:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCorreo" value="<%=beanPyv.getVendedor()%>" disabled class="form-control">
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	
                            <div class="col-sm-4">
                                <div class="col-sm-9">
                                    <a href="ServletVenta?tipo=listar"><input type="button" value="Regresar" class="btn btn-danger"></a>
                                </div>
                            </div>
                        </div>                      
                    </form>
                    
                </div>
            </div>
        </div>
</body>
</html>