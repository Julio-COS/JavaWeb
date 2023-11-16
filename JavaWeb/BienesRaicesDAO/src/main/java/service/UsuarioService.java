package service;

import bean.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class UsuarioService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	UsuarioDAO objDao=fabrica.getUsuario();
	
	public UsuarioDTO buscarUsuario(String email, String pas) {
		return objDao.buscarUsuario(email, pas);
	}
}
