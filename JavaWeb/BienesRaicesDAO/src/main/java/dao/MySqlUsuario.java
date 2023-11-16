package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.SqlDBConn;

public class MySqlUsuario implements UsuarioDAO{

	@Override
	public UsuarioDTO buscarUsuario(String email, String pas) {
		UsuarioDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		
		try {
			cn= SqlDBConn.getConnection("bienesraices");
			String sql="";
			sql+=" select u.* ";
			sql+=" from tb_usuario u inner join tb_acceso a on u.email=a.login ";
			sql+=" where a.login=? and a.clave=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, pas);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new UsuarioDTO();
				obj.setEmail(rs.getString(1));
				obj.setNombre(rs.getString(2));
				obj.setAppat(rs.getString(3));
				obj.setApmat(rs.getString(4));
				obj.setTelefono(rs.getString(5));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
				
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return obj;
	}
	
}
