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
import bean.DetalleBoletaDTO;
import bean.VentaDTO;
import dao.MySqlVenta;
import service.BoletaService;

@WebServlet("/ServletBoleta")
public class ServletBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoletaService serviBoleta=new BoletaService();
	public ServletBoleta() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo=request.getParameter("tipo");
		if(tipo.equals("registrar")) {
			registrar(request,response);
		}
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


}
