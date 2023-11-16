package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.AccesoDTO;
import interfaces.AccesoDAO;
import utils.SqlDBConn;

public class MySqlAcceso implements AccesoDAO{

	@Override
	public int InsertarAcceso(AccesoDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="insert into tb_acceso values(?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getLogin());
			pstm.setString(2, obj.getClave());	

			estado=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return estado;
		
	}

	@Override
	public int EliminarAcceso(String login) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="delete from tb_acceso where login like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, login);
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return estado;
	}
	

}
