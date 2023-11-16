package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.BoletaDTO;
import bean.DetalleBoletaDTO;
import interfaces.BoletaDAO;
import utils.SqlDBConn;

public class MySqlBoleta implements BoletaDAO {

	@Override
	public int RegistrarBoleta(BoletaDTO boleta, List<DetalleBoletaDTO> lstDetalle) {
		int contador=-1;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm1=null,pstm2=null,pstm3=null;
		//System.out.print(boleta.getCod_cli());
		try {
			cn=SqlDBConn.getConnection("bienesraices");
			
			cn.setAutoCommit(false);
			
			String sql1="select max(numBoleta) from tb_boleta";
			pstm1=cn.prepareStatement(sql1);
			rs=pstm1.executeQuery();
			rs.next();
			int numBoleta=rs.getInt(1)+1;
			
			double monto=0;
			for(DetalleBoletaDTO aux: lstDetalle) {
				monto+=aux.getPrecio();
			}
			String sql2="insert into tb_boleta values(?,?,curdate(),?)";
			pstm2=cn.prepareStatement(sql2);
			pstm2.setInt(1, numBoleta);
			pstm2.setInt(2, boleta.getCod_cli());
			pstm2.setDouble(3, monto);
			pstm2.executeUpdate();
			
			String sql3="insert into tb_detalleboleta values(?,?,?)";
			pstm3=cn.prepareStatement(sql3);
			for(DetalleBoletaDTO aux:lstDetalle) {
				pstm3.setInt(1, numBoleta);
				pstm3.setInt(2, aux.getCodVenta());
				pstm3.setDouble(3, aux.getPrecio());
				pstm3.executeUpdate();
			}
			cn.commit();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			pstm1.close();
			pstm2.close();
			pstm3.close();
			cn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contador;
	}

}
