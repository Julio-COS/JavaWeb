package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.VentaDTO;
import service.VentaService;

@WebServlet("/ServletVenta")
public class ServletVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VentaService serviceVenta=new VentaService();
	
    public ServletVenta() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo=request.getParameter("tipo");
		if(xtipo.equals("listar")) {
			listar(request,response);
		}else if(xtipo.equals("buscar")) {
			buscar(request,response);
		}else if(xtipo.equals("registrar")) {
			registrar(request,response);
		}else if(xtipo.equals("actualizar")) {
			actualizar(request,response);
		}else if(xtipo.equals("eliminar")) {
			eliminar(request,response);
		}else if(xtipo.equals("buscarCliente")) {
			buscarCliente(request,response);
		}
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviceVenta.ListaVenta());
		request.getRequestDispatcher("bandejaPublicacionYVenta.jsp").forward(request, response);
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departamento,tipo,distProv,plantas,mtsTerreno,recamaras,mtsConstruccion,banios,precio,cochera,patio,amueblado,bardeado,enrejado;	
		int vendedor=Integer.parseInt(request.getParameter("txtVendedor"));
		departamento=request.getParameter("cmbDepa");
		tipo=request.getParameter("chkradio");
		distProv=request.getParameter("txtDistPro");
		plantas=request.getParameter("cmbPlantas");
		mtsTerreno=request.getParameter("txtMtsTerreno");
		recamaras=request.getParameter("txtRecamara");
		mtsConstruccion=request.getParameter("txtMtsConstruccion");
		banios=request.getParameter("txtBanios");
		precio=request.getParameter("txtPrecio");
		cochera=request.getParameter("txtCochera");
		patio=request.getParameter("chkradio1");
		amueblado=request.getParameter("chkradio2");
		bardeado=request.getParameter("chkradio3");
		enrejado=request.getParameter("chkradio4");
		
	
		VentaDTO beanPyv=new VentaDTO();
		beanPyv.setDepartamento(departamento);
		beanPyv.setTipo(tipo);
		beanPyv.setDistProv(distProv);
		beanPyv.setPlantas(plantas);
		beanPyv.setMtsTerreno(mtsTerreno);
		beanPyv.setRecamaras(recamaras);
		beanPyv.setMtsConstuccion(mtsConstruccion);
		beanPyv.setBanios(banios);
		beanPyv.setPrecio(precio);
		beanPyv.setCochera(cochera);
		beanPyv.setPatio(patio);
		beanPyv.setAmueblado(amueblado);
		beanPyv.setBardeado(bardeado);
		beanPyv.setEnrejado(enrejado);
		beanPyv.setVendedor(vendedor);
		
		serviceVenta.RegistrarVenta(beanPyv);
		listar(request, response);
	}
	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departamento,tipo,distProv,plantas,mtsTerreno,recamaras,mtsConstruccion,banios,precio,cochera,patio,amueblado,bardeado,enrejado;	
		int nventa=Integer.parseInt(request.getParameter("txtNumVenta"));
		int vendedor=Integer.parseInt(request.getParameter("txtVendedor"));
		departamento=request.getParameter("cmbDepa");
		tipo=request.getParameter("chkradio");
		distProv=request.getParameter("txtDistPro");
		plantas=request.getParameter("cmbPlantas");
		mtsTerreno=request.getParameter("txtMtsTerreno");
		recamaras=request.getParameter("txtRecamara");
		mtsConstruccion=request.getParameter("txtMtsConstruccion");
		banios=request.getParameter("txtBanios");
		precio=request.getParameter("txtPrecio");
		cochera=request.getParameter("txtCochera");
		patio=request.getParameter("chkradio1");
		amueblado=request.getParameter("chkradio2");
		bardeado=request.getParameter("chkradio3");
		enrejado=request.getParameter("chkradio4");
		
	
		VentaDTO beanPyv=new VentaDTO();
		beanPyv.setNventa(nventa);
		beanPyv.setDepartamento(departamento);
		beanPyv.setTipo(tipo);
		beanPyv.setDistProv(distProv);
		beanPyv.setPlantas(plantas);
		beanPyv.setMtsTerreno(mtsTerreno);
		beanPyv.setRecamaras(recamaras);
		beanPyv.setMtsConstuccion(mtsConstruccion);
		beanPyv.setBanios(banios);
		beanPyv.setPrecio(precio);
		beanPyv.setCochera(cochera);
		beanPyv.setPatio(patio);
		beanPyv.setAmueblado(amueblado);
		beanPyv.setBardeado(bardeado);
		beanPyv.setEnrejado(enrejado);
		beanPyv.setVendedor(vendedor);
		
		serviceVenta.RegistrarVenta(beanPyv);
		listar(request, response);
	}
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("txt_nventa"));
		serviceVenta.EliminarVenta(cod);
		listar(request, response);
	}
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("txt_nventa"));
		request.setAttribute("venta", serviceVenta.buscarVenta(cod));
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}
	protected void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	


}
