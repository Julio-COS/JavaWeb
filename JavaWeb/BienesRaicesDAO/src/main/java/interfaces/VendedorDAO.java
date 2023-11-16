package interfaces;

import java.util.List;

import bean.VendedorDTO;

public interface VendedorDAO {
	public VendedorDTO buscarVendedor(int cod);
	public List<VendedorDTO> buscarVendedor(String nom);
	public List<VendedorDTO> ListaVendedor();
	public int RegistrarVendedor(VendedorDTO obj);
	public int ActualizarVendedor(VendedorDTO obj);
	public int EliminarVendedor(int cod);
}
