package service;

import java.util.List;

import bean.VendedorDTO;
import dao.DAOFactory;
import interfaces.VendedorDAO;

public class VendedorService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	VendedorDAO objDao= fabrica.getVendedor();
	
	public VendedorDTO buscarVendedor(int cod) {
		return objDao.buscarVendedor(cod);
	}
	public List<VendedorDTO> buscarVendedor(String nom){
		return objDao.buscarVendedor(nom);
	}
	public List<VendedorDTO> ListaVendedor(){
		return objDao.ListaVendedor();
	}
	public int RegistrarVendedor(VendedorDTO obj) {
		return objDao.RegistrarVendedor(obj);
	}
	public int ActualizarVendedor(VendedorDTO obj) {
		return objDao.ActualizarVendedor(obj);
	}
	public int EliminarVendedor(int cod) {
		return objDao.EliminarVendedor(cod);
	}
}
