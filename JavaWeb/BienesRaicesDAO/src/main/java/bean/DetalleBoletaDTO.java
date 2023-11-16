package bean;

public class DetalleBoletaDTO {
	private int numBoleta;
	private int codVenta;
	private double precio;
	
	public DetalleBoletaDTO() {
		// TODO Auto-generated constructor stub
	}

	public DetalleBoletaDTO(int numBoleta, int codVenta, double precio) {
		super();
		this.numBoleta = numBoleta;
		this.codVenta = codVenta;
		this.precio = precio;
	}



	public int getNumBoleta() {
		return numBoleta;
	}

	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}

	public int getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
