package interfaces;

import bean.UsuarioDTO;

public interface UsuarioDAO {
	public UsuarioDTO buscarUsuario(String email, String pas);
}
