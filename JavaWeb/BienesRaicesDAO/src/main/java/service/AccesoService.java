package service;

import bean.AccesoDTO;
import dao.DAOFactory;
import interfaces.AccesoDAO;

public class AccesoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	AccesoDAO objDao=fabrica.getAcceso();
	
	public int InsertarAcceso(AccesoDTO obj) {
		return objDao.InsertarAcceso(obj);
	}
	public int EliminarAcceso(String login) {
		return objDao.EliminarAcceso(login);
	}
}
