package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.VendedorDTO;
import service.VendedorService;
import utils.ExportarEXCEL;

@WebServlet("/ServletVendedor")
public class ServletVendedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VendedorService serviceVen= new VendedorService();
	
    public ServletVendedor() {
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
		}else if(xtipo.equals("exportarEXCEL")) {
			exportarEXCEL(request,response);
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviceVen.ListaVendedor());
		request.getRequestDispatcher("bandejaVendedor.jsp").forward(request, response);
	}
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Vendedor", serviceVen.buscarVendedor(cod));
		request.getRequestDispatcher("buscarVendedor.jsp").forward(request, response);
	}
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre,celular,telefono,correo;
		nombre=request.getParameter("txtNombre");
		celular=request.getParameter("txtCelular");
		telefono=request.getParameter("txtTelefono");
		correo=request.getParameter("txtCorreo");
	
		VendedorDTO beanVen=new VendedorDTO();
		beanVen.setNombres(nombre);
		beanVen.setCelular(celular);
		beanVen.setTelefono(telefono);
		beanVen.setCorreo(correo);
		
		serviceVen.RegistrarVendedor(beanVen);
		listar(request, response);
	}
	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre,celular,telefono,correo;
		int codigo= Integer.parseInt(request.getParameter("txtCodigo"));
		nombre=request.getParameter("txtNombre");
		celular=request.getParameter("txtCelular");
		telefono=request.getParameter("txtTelefono");
		correo=request.getParameter("txtCorreo");
	
		VendedorDTO beanVen=new VendedorDTO();
		
		beanVen.setCodigo(codigo);
		beanVen.setNombres(nombre);
		beanVen.setCelular(celular);
		beanVen.setTelefono(telefono);
		beanVen.setCorreo(correo);
		
		serviceVen.ActualizarVendedor(beanVen);
		listar(request, response);
		
		}
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("cod"));
		serviceVen.EliminarVendedor(cod);
		listar(request, response);
	}
	protected void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void exportarEXCEL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExportarEXCEL excel= new ExportarEXCEL(serviceVen.ListaVendedor());
		excel.crearExcel();
		listar(request, response);
	}



}
