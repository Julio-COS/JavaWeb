package service;

import java.util.List;

import bean.ClienteDTO;
import dao.DAOFactory;
import interfaces.ClienteDAO;

public class ClienteService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ClienteDAO objDao= fabrica.getCliente();
	
	public ClienteDTO buscarCliente(int cod) {
		return objDao.buscarCliente(cod);
	}
	public List<ClienteDTO> buscarCliente(String nom){
		return objDao.buscarCliente(nom);
	}
	public List<ClienteDTO> ListaCliente(){
		return objDao.ListaCliente();
	}
	public int RegistrarCliente(ClienteDTO obj) {
		return objDao.RegistrarCliente(obj);
	}
	public int ActualizarCliente(ClienteDTO obj) {
		return objDao.ActualizarCliente(obj);
	}
	public int EliminarCliente(int cod) {
		return objDao.EliminarCliente(cod);
	}
	
}
