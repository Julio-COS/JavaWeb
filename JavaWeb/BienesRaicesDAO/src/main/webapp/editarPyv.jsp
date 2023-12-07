<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="bean.VentaDTO" %>    
<%@ page import="dao.MySqlVenta" %>    

<%
	int nventa=Integer.parseInt(request.getParameter("nventa"));
	MySqlVenta sqlPyv= new MySqlVenta();
	VentaDTO beanPyv=sqlPyv.buscarVenta(nventa);
%>    
<html>
<head>
	<meta charset="UTF-8">
	<title>Actualizar Publicacion Y Venta</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div class="container">
            <br/>
            <div class="panel panel-default">
                <div class="panel-heading"><h3>Actualizar Publicacion Y Venta</h3></div>
                <div class="panel-body">
                
                    <form name="editarPyv" method="post" action="ServletActualizarPyv" class="form-horizontal" >
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Numero de Venta:</label>
                            <div class="col-sm-3">
	                            <input type="text" name="txtNumVenta" value="<%=beanPyv.getNventa() %>" disabled class="form-control">
	                            <input type="hidden" name="txtNumVenta" value="<%=beanPyv.getNventa()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        	<label class="col-sm-2 col-form-label">Departamento:</label>
                            <div class="col-sm-3">
                            <input type="text" name="cmbDepa" value="<%=beanPyv.getDepartamento()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Tipo:</label>
                            <div class="col-sm-3">
                            <input type="text" name="chkradio" value="<%=beanPyv.getTipo()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Distrito/Provincia:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtDistPro" value="<%=beanPyv.getDistProv()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Plantas:</label>
                            <div class="col-sm-3">
                            <input type="text" name="cmbPlantas" value="<%=beanPyv.getPlantas()%>" class="form-control">
                            </div>
                        </div>
						<div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Mts Terreno:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtMtsTerreno" value="<%=beanPyv.getMtsTerreno()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Recamaras:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtRecamara" value="<%=beanPyv.getRecamaras()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Mts Construccion:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtMtsConstruccion" value="<%=beanPyv.getMtsConstuccion()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Baños:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtBanios" value="<%=beanPyv.getBanios()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Precio:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtPrecio" value="<%=beanPyv.getPrecio()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Cochera(s):</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtCochera" value="<%=beanPyv.getCochera()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Patio(s):</label>
                            <div class="col-sm-3">
                            <input type="text" name="chkradio1" value="<%=beanPyv.getPatio()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Amueblado:</label>
                            <div class="col-sm-3">
                            <input type="text" name="chkradio2" value="<%=beanPyv.getAmueblado()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Bardeado:</label>
                            <div class="col-sm-3">
                            <input type="text" name="chkradio3" value="<%=beanPyv.getBardeado()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Enrejado:</label>
                            <div class="col-sm-3">
                            <input type="text" name="chkradio4" value="<%=beanPyv.getEnrejado()%>" class="form-control">
                            </div>
                        </div>
                        <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Vendedor:</label>
                            <div class="col-sm-3">
                            <input type="text" name="txtVendedor" value="<%=beanPyv.getVendedor()%>" class="form-control">
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	
                            <div class="col-sm-4">
                                <div class="col-sm-9">
                                	<input type="submit" name="btnActualizar" value="Actualizar" class="btn btn-success" />
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