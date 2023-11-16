package service;

import java.util.List;

import bean.BoletaDTO;
import bean.DetalleBoletaDTO;
import dao.DAOFactory;
import interfaces.BoletaDAO;

public class BoletaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	BoletaDAO obj=fabrica.getBoleta();
	
	public int registrarBoleta(BoletaDTO boleta,List<DetalleBoletaDTO> lstDetalle) {
		return obj.RegistrarBoleta(boleta, lstDetalle);
	}
}
