package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.VentaDTO;
import interfaces.VentaDAO;
import utils.SqlDBConn;

public class MySqlVenta implements VentaDAO{

	@Override
	public VentaDTO buscarVenta(int cod) {
		VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_venta where nventa=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new VentaDTO();
				obj.setNventa(rs.getInt(1));
				obj.setDepartamento(rs.getString(2));
				obj.setTipo(rs.getString(3));
				obj.setDistProv(rs.getString(4));
				obj.setPlantas(rs.getString(5));
				obj.setMtsTerreno(rs.getString(6));
				obj.setRecamaras(rs.getString(7));
				obj.setMtsConstuccion(rs.getString(8));
				obj.setBanios(rs.getString(9));
				obj.setPrecio(rs.getString(10));
				obj.setCochera(rs.getString(11));
				obj.setPatio(rs.getString(12));
				obj.setAmueblado(rs.getString(13));
				obj.setBardeado(rs.getString(14));
				obj.setEnrejado(rs.getString(15));
				obj.setVendedor(rs.getInt(16));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<VentaDTO> buscarVenta(String nventa) {
		List<VentaDTO> data=new ArrayList<VentaDTO>();
		VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_venta where nventa like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (nventa+"%"));
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new VentaDTO();
				obj.setNventa(rs.getInt(1));
				obj.setDepartamento(rs.getString(2));
				obj.setTipo(rs.getString(3));
				obj.setDistProv(rs.getString(4));
				obj.setPlantas(rs.getString(5));
				obj.setMtsTerreno(rs.getString(6));
				obj.setRecamaras(rs.getString(7));
				obj.setMtsConstuccion(rs.getString(8));
				obj.setBanios(rs.getString(9));
				obj.setPrecio(rs.getString(10));
				obj.setCochera(rs.getString(11));
				obj.setPatio(rs.getString(12));
				obj.setAmueblado(rs.getString(13));
				obj.setBardeado(rs.getString(14));
				obj.setEnrejado(rs.getString(15));
				obj.setVendedor(rs.getInt(16));
				data.add(obj);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<VentaDTO> ListaVenta() {
		List<VentaDTO> data=new ArrayList<VentaDTO>();
		VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="select * from tb_venta";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new VentaDTO();
				obj.setNventa(rs.getInt(1));
				obj.setDepartamento(rs.getString(2));
				obj.setTipo(rs.getString(3));
				obj.setDistProv(rs.getString(4));
				obj.setPlantas(rs.getString(5));
				obj.setMtsTerreno(rs.getString(6));
				obj.setRecamaras(rs.getString(7));
				obj.setMtsConstuccion(rs.getString(8));
				obj.setBanios(rs.getString(9));
				obj.setPrecio(rs.getString(10));
				obj.setCochera(rs.getString(11));
				obj.setPatio(rs.getString(12));
				obj.setAmueblado(rs.getString(13));
				obj.setBardeado(rs.getString(14));
				obj.setEnrejado(rs.getString(15));
				obj.setVendedor(rs.getInt(16));
				data.add(obj);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int RegistrarVenta(VentaDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="insert into tb_venta values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDepartamento());	
			pstm.setString(2, obj.getTipo());	
			pstm.setString(3, obj.getDistProv());	
			pstm.setString(4, obj.getPlantas());	
			pstm.setString(5, obj.getMtsTerreno());	
			pstm.setString(6, obj.getRecamaras());
			pstm.setString(7, obj.getMtsConstuccion());
			pstm.setString(8, obj.getBanios());
			pstm.setString(9, obj.getPrecio());
			pstm.setString(10, obj.getCochera());
			pstm.setString(11, obj.getPatio());
			pstm.setString(12, obj.getAmueblado());
			pstm.setString(13, obj.getBardeado());
			pstm.setString(14, obj.getEnrejado());
			pstm.setInt(15, obj.getVendedor());

			estado=pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Errror"+e);
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				System.out.println("Error2"+e2);
			}
		}
		return estado;
		
	}

	@Override
	public int ActualizarVenta(VentaDTO obj) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="update tb_venta set "
					+ " departamento=?, tipo=?, distProv=?, plantas=?, "
					+ " mtsTerreno=?, recamaras=?, mtsConstruccion=?, banios=?, "
					+ " precio=?, cochera=?, patio=?, amueblado=?, "
					+ " bardeado=?, enrejado=?, vendedor=? "
					+ " where nventa=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDepartamento());	
			pstm.setString(2, obj.getTipo());	
			pstm.setString(3, obj.getDistProv());	
			pstm.setString(4, obj.getPlantas());	
			pstm.setString(5, obj.getMtsTerreno());	
			pstm.setString(6, obj.getRecamaras());
			pstm.setString(7, obj.getMtsConstuccion());
			pstm.setString(8, obj.getBanios());
			pstm.setString(9, obj.getPrecio());
			pstm.setString(10, obj.getCochera());
			pstm.setString(11, obj.getPatio());
			pstm.setString(12, obj.getAmueblado());
			pstm.setString(13, obj.getBardeado());
			pstm.setString(14, obj.getEnrejado());
			pstm.setInt(15, obj.getVendedor());
			pstm.setInt(16, obj.getNventa());

			estado=pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Errror"+e);
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				System.out.println("Errror2"+e2);
			}
		}
		return estado;
		
	}


	@Override
	public int EliminarVenta(int cod) {
		int estado =-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			String sql="delete from tb_venta where nventa like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1,cod);	

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

}
