function enlaceEliminar(id){
	if(confirm("¿Esta seguro de eliminar este Vendedor?"))
	{
		document.bandejaVendedor.txt_cod.value=id;	
		document.bandejaVendedor.action="ServletVendedor?tipo=eliminar";
		document.bandejaVendedor.submit();
	}
}

function enlaceEliminarPyV(id){
	if(confirm("¿Esta seguro de eliminar este Venta?"))
	{
		document.bandejaPublicacionYVenta.txt_nventa.value=id;	
		document.bandejaPublicacionYVenta.action="ServletVenta?tipo=eliminar";
		document.bandejaPublicacionYVenta.submit();
	}
}

function enlaceEliminarCliente(id){
	if(confirm("¿Esta seguro de eliminar este usuario?"))
	{
		document.bandejaCliente.txtCodCli.value=id;	
		document.bandejaCliente.action="ServletCliente?tipo=eliminar";
		document.bandejaCliente.submit();
	}
}