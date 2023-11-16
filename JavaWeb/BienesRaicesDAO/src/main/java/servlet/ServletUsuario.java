package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.UsuarioDTO;
import service.UsuarioService;


@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService servicio= new UsuarioService();

    public ServletUsuario() {
    	super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo=request.getParameter("tipo");
		if(xtipo.equals("sesion"))
			iniciarSesion(request,response);
		else if(xtipo.equals("cerrarSesion"))
			cerrarSesion(request,response);
	}
	protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xlogin=request.getParameter("txt_login");
		String xpass=request.getParameter("txt_pass");
		
		UsuarioDTO obj=servicio.buscarUsuario(xlogin, xpass);
		
		if(obj!=null) {
			HttpSession sesion=request.getSession();
			sesion.setAttribute("nombre",obj.getNombre()+" "+obj.getAppat()+" "+obj.getApmat());
			sesion.setAttribute("email", obj.getEmail());
			response.sendRedirect("menu.jsp");
		}else {
			request.setAttribute("msg", "Usuario no existe...");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "Iniciar Sesion");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


}
