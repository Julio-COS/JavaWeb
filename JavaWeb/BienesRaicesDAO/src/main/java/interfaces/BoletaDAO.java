package interfaces;

import java.util.List;

import bean.BoletaDTO;
import bean.DetalleBoletaDTO;

public interface BoletaDAO {
	public int RegistrarBoleta(BoletaDTO obj,List<DetalleBoletaDTO> lstDetalle);
}
