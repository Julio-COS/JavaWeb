package interfaces;

import java.util.List;

import bean.VentaDTO;

public interface VentaDAO {
	public VentaDTO buscarVenta(int cod);
	public List<VentaDTO> buscarVenta(String nom);
	public List<VentaDTO> ListaVenta();
	public int RegistrarVenta(VentaDTO obj);
	public int ActualizarVenta(VentaDTO obj);
	public int EliminarVenta(int cod);
	
}
