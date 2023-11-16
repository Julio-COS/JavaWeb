package bean;

import java.util.Date;

public class BoletaDTO {
	private int numBoleta;
	private int cod_cli;
	private Date fechaventa;
	private double monto;
	
	public BoletaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public int getCod_cli() {
		return cod_cli;
	}
	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}
	public Date getFechaventa() {
		return fechaventa;
	}
	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
}
