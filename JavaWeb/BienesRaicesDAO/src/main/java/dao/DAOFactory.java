package dao;

import interfaces.AccesoDAO;
import interfaces.BoletaDAO;
import interfaces.ClienteDAO;
import interfaces.UsuarioDAO;
import interfaces.VendedorDAO;
import interfaces.VentaDAO;


public abstract class DAOFactory {

	public static final int MYSQL=1;
	public static final int ORACLE=2;
	public static final int DB2=3;
	public static final int SQLSERVER=4;
	public static final int XML=5;
	
	public abstract AccesoDAO getAcceso();
	public abstract BoletaDAO getBoleta();
	public abstract ClienteDAO getCliente();
	public abstract UsuarioDAO getUsuario();
	public abstract VentaDAO getVenta();
	public abstract VendedorDAO getVendedor();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
	switch(whichFactory) {
	case MYSQL:
		return new MySqlDAOFactory();
	case XML:
	//
	case ORACLE:
	//
	default: return null;
	}
	}
	
}
