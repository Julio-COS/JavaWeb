package interfaces;

import java.util.List;

import bean.ClienteDTO;

public interface ClienteDAO {
	public ClienteDTO buscarCliente(int cod);
	public List<ClienteDTO> buscarCliente(String nom);
	public List<ClienteDTO> ListaCliente();
	public int RegistrarCliente(ClienteDTO obj);
	public int ActualizarCliente(ClienteDTO obj);
	public int EliminarCliente(int cod);
}
