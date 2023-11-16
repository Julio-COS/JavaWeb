<%@ page contentType="text/xml" %><?xml version="1.0" encoding="ISO-8859-1"?>
<%@ page import="java.util.*"%>
<%@ page import="bean.VendedorDTO"%>
<%@ page import="dao.MySqlVendedor"%>
<%
	String nom=(String)request.getParameter("nom");
	ArrayList<VendedorDTO> resultados=new ArrayList<VendedorDTO>();
	MySqlVendedor obj=new MySqlVendedor();
	resultados=(ArrayList<VendedorDTO>)obj.buscarVendedor(nom);

	String xml="<nucleo>";
	for(int i=0; i<resultados.size(); i++)
	{
		VendedorDTO nuevo=(VendedorDTO)resultados.get(i);
		xml+="<vendedor ";		
		xml+="nom='"+nuevo.getCodigo()+"' ";
		xml+="cod='"+nuevo.getNombres()+"'/> ";	
	}
	xml+="</nucleo>";
	out.print(xml);
%>