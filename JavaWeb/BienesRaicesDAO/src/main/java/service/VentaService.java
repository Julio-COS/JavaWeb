package service;

import java.util.List;

import bean.VentaDTO;
import dao.DAOFactory;
import interfaces.VentaDAO;

public class VentaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	VentaDAO objDao= fabrica.getVenta();
	
	public VentaDTO buscarVenta(int cod) {
		return objDao.buscarVenta(cod);
	}
	public List<VentaDTO> buscarVenta(String nom){
		return objDao.buscarVenta(nom);
	}
	public List<VentaDTO> ListaVenta(){
		return objDao.ListaVenta();
	}
	public int RegistrarVenta(VentaDTO obj) {
		return objDao.RegistrarVenta(obj);
	}
	public int ActualizarVenta(VentaDTO obj) {
		return objDao.ActualizarVenta(obj);
	}
	public int EliminarVenta(int cod) {
		return objDao.EliminarVenta(cod);
	}
}
