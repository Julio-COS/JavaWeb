package interfaces;

import bean.AccesoDTO;

public interface AccesoDAO {
	public int InsertarAcceso(AccesoDTO obj);
	public int EliminarAcceso(String login);
}
