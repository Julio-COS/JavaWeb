package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClienteDTO;
import service.ClienteService;
import utils.ExportarPDF;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClienteService serviceCli=new ClienteService();
	
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
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
		}else if(xtipo.equals("exportarPDF")) {
			exportarPDF(request,response);
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviceCli.ListaCliente());
		request.getRequestDispatcher("bandejaCliente.jsp").forward(request, response);
	}
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo=request.getParameter("txtCorreo");
		String nombres=request.getParameter("txtNombres");
		String apellidos=request.getParameter("txtApellidos");
		String celular=request.getParameter("txtCelular");
	
		ClienteDTO obj=new ClienteDTO();
		obj.setCorreo(correo);
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setCelular(celular);
		
		serviceCli.RegistrarCliente(obj);
		listar(request, response);
	}
	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("txtCodCli"));
		String correo=request.getParameter("txtCorreo");
		String nombres=request.getParameter("txtNombres");
		String apellidos=request.getParameter("txtApellidos");
		String celular=request.getParameter("txtCelular");
	
		ClienteDTO obj=new ClienteDTO();
		obj.setCodigo(cod);
		obj.setCorreo(correo);
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setCelular(celular);
		
		serviceCli.ActualizarCliente(obj);
		listar(request, response);
	}
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("txtCodCli"));
		serviceCli.EliminarCliente(cod);
		listar(request, response);
	}
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("txtCodCli"));
		request.setAttribute("cliente", serviceCli.buscarCliente(cod));
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}
	protected void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String des=request.getParameter("des");
		request.setAttribute("clientes", serviceCli.buscarCliente(des));
		request.getRequestDispatcher("buscarCliente.jsp").forward(request, response);
	}
	protected void exportarPDF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String nomFile=dateFormat.format(new Date());
		String variable1="Content-Disposition";
		String variable2="attachment; filename=Clientes_"+nomFile+".pdf";
		response.setHeader(variable1, variable2);
		
		ExportarPDF exportarPDF=new ExportarPDF(serviceCli.ListaCliente());
		exportarPDF.export(response);
		
		request.getRequestDispatcher("bandejaCliente.jsp").forward(request, response);
	}

}
