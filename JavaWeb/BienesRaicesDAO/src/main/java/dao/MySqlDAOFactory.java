package dao;

import interfaces.AccesoDAO;
import interfaces.BoletaDAO;
import interfaces.ClienteDAO;
import interfaces.UsuarioDAO;
import interfaces.VendedorDAO;
import interfaces.VentaDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public AccesoDAO getAcceso() {
		return new MySqlAcceso();
	}

	@Override
	public BoletaDAO getBoleta() {
		return new MySqlBoleta();
	}

	@Override
	public ClienteDAO getCliente() {
		return new MySqlCliente();
	}

	@Override
	public UsuarioDAO getUsuario() {
		return new MySqlUsuario();
	}

	@Override
	public VentaDAO getVenta() {
		return new MySqlVenta();
	}

	@Override
	public VendedorDAO getVendedor() {
		return new MySqlVendedor();
	}

}
