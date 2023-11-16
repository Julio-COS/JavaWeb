package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClienteDTO;
import interfaces.ClienteDAO;
import utils.SqlDBConn;

public class MySqlCliente implements ClienteDAO{

	@Override
	public ClienteDTO buscarCliente(int cod) {
		ClienteDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_cliente where cod_cli=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new ClienteDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setCorreo(rs.getString(2));
				obj.setNombres(rs.getString(3));
				obj.setApellidos(rs.getString(4));
				obj.setCelular(rs.getString(5));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<ClienteDTO> buscarCliente(String nom) {
		List<ClienteDTO> data=new ArrayList<ClienteDTO>();
		ClienteDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_cliente where nombres like ?";

			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (nom+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new ClienteDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setCorreo(rs.getString(2));
				obj.setNombres(rs.getString(3));
				obj.setApellidos(rs.getString(4));
				obj.setCelular(rs.getString(5));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public List<ClienteDTO> ListaCliente() {
		List<ClienteDTO> data=new ArrayList<ClienteDTO>();
		ClienteDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_cliente";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new ClienteDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setCorreo(rs.getString(2));
				obj.setNombres(rs.getString(3));
				obj.setApellidos(rs.getString(4));
				obj.setCelular(rs.getString(5));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int RegistrarCliente(ClienteDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="insert into tb_cliente values(null,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCorreo());
			pstm.setString(2, obj.getNombres());	
			pstm.setString(3, obj.getApellidos());
			pstm.setString(4, obj.getCelular());

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
	public int ActualizarCliente(ClienteDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="update tb_cliente set "
					+ " correo=?, nombres=?, apellidos=?, celular=? "
					+ " where cod_cli=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCorreo());
			pstm.setString(2, obj.getNombres());	
			pstm.setString(3, obj.getApellidos());
			pstm.setString(4, obj.getCelular());
			pstm.setInt(5, obj.getCodigo());

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
	public int EliminarCliente (int cod) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="delete from tb_cliente where cod_cli like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
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
