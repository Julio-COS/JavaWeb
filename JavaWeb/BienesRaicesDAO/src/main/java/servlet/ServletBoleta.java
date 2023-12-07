package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BoletaDTO;
import bean.ClienteDTO;
import bean.DetalleBoletaDTO;
import bean.VentaDTO;
import dao.MySqlVenta;
import service.BoletaService;
import service.ClienteService;
import service.VentaService;

@WebServlet("/ServletBoleta")
public class ServletBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoletaService serviBoleta=new BoletaService();
	ClienteService serviceCli= new ClienteService();
	VentaService serviceVen= new VentaService();
	public ServletBoleta() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo=request.getParameter("tipo");
		if(tipo.equals("registrarVenta")) {
			registrarVenta(request,response);
		}else if(tipo.equals("registrar")) {
			registrar(request,response);
		}else if(tipo.equals("buscarCliente")) {
			buscarCliente(request,response);
		}else if(tipo.equals("buscarVenta")) {
			buscarVenta(request,response);
		}
	}
	protected void registrarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nventa= Integer.parseInt(request.getParameter("txtventa"));
		int codCli= Integer.parseInt(request.getParameter("txtcod"));
		
		BoletaDTO b=new BoletaDTO();
		b.setCod_cli(codCli);
		
		MySqlVenta venta= new MySqlVenta();
		VentaDTO obj=venta.buscarVenta(nventa);
		
		ArrayList<DetalleBoletaDTO> detalles=new ArrayList<DetalleBoletaDTO>();

		DetalleBoletaDTO det=new DetalleBoletaDTO(0,obj.getNventa(),Double.parseDouble(obj.getPrecio()));
		detalles.add(det);

		serviBoleta.registrarBoleta(b, detalles);
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}
	
	protected void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("codCliente"));
		ClienteDTO cliente=serviceCli.buscarCliente(cod);
		
		HttpSession session=request.getSession();
		session.setAttribute("cliente", cliente);
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}
	
	protected void buscarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt(request.getParameter("codVenta"));
		VentaDTO venta=serviceVen.buscarVenta(cod);
		
		HttpSession session=request.getSession();
		session.setAttribute("venta", venta);
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}



}
