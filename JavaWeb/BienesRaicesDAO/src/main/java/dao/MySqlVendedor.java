package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.VendedorDTO;
import interfaces.VendedorDAO;
import utils.SqlDBConn;

public class MySqlVendedor implements VendedorDAO{

	@Override
	public VendedorDTO buscarVendedor(int cod) {
		VendedorDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_vendedor where ven_codigo=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new VendedorDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setCelular(rs.getString(3));
				obj.setTelefono(rs.getString(4));
				obj.setCorreo(rs.getString(5));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<VendedorDTO> buscarVendedor(String nom) {
		List<VendedorDTO> data=new ArrayList<VendedorDTO>();
		VendedorDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_vendedor where nombre like ?";

			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (nom+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new VendedorDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setCelular(rs.getString(3));
				obj.setTelefono(rs.getString(4));
				obj.setCorreo(rs.getString(5));
				data.add(obj);
				
				}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<VendedorDTO> ListaVendedor() {
		List<VendedorDTO> data=new ArrayList<VendedorDTO>();
		VendedorDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_vendedor";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new VendedorDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setCelular(rs.getString(3));
				obj.setTelefono(rs.getString(4));
				obj.setCorreo(rs.getString(5));
				data.add(obj);
				
				}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int RegistrarVendedor(VendedorDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="insert into tb_vendedor values(null,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getCelular());
			pstm.setString(3, obj.getTelefono());
			pstm.setString(4, obj.getCorreo());

			estado=pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Errror"+e);
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				System.out.println("Errror"+e2);
			}
		}
		return estado;
	}

	@Override
	public int ActualizarVendedor(VendedorDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="update tb_vendedor set "
					+ " nombre=?, celular=?, telefono=?, correo=? "
					+ " where ven_codigo=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());	
			pstm.setString(2, obj.getCelular());
			pstm.setString(3, obj.getTelefono());
			pstm.setString(4, obj.getCorreo());
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
	public int EliminarVendedor(int cod) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="delete from tb_vendedor where ven_codigo like ?";
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
