package bean;

public class VentaDTO {
	
	public VentaDTO() {
		
	}
	
	private int nventa;
	private String departamento;
	private String tipo;
	private String distProv;
	private String plantas;
	private String mtsTerreno;
	private String recamaras;
	private String mtsConstuccion;
	private String banios;
	private String precio;
	private String cochera;
	private String patio;
	private String amueblado;
	private String bardeado;
	private String enrejado;
	private int vendedor;
	private String nombreVendedor;

	
	public int getNventa() {
		return nventa;
	}
	public void setNventa(int nventa) {
		this.nventa = nventa;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public String getStringDepartamento() {
		switch(departamento) {
		case "1": return"Ancash";
		case "2": return"Arequipa";
		case "3": return"Ayacucho";
		case "4": return"Cajamarca";
		default : return "error";
		}
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDistProv() {
		return distProv;
	}
	public void setDistProv(String distProv) {
		this.distProv = distProv;
	}
	public String getPlantas() {
		return plantas;
	}
	public void setPlantas(String plantas) {
		this.plantas = plantas;
	}
	public String getMtsTerreno() {
		return mtsTerreno;
	}
	public void setMtsTerreno(String mtsTerreno) {
		this.mtsTerreno = mtsTerreno;
	}
	public String getRecamaras() {
		return recamaras;
	}
	public void setRecamaras(String recamaras) {
		this.recamaras = recamaras;
	}
	public String getMtsConstuccion() {
		return mtsConstuccion;
	}
	public void setMtsConstuccion(String mtsConstuccion) {
		this.mtsConstuccion = mtsConstuccion;
	}
	public String getBanios() {
		return banios;
	}
	public void setBanios(String banios) {
		this.banios = banios;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getCochera() {
		return cochera;
	}
	public void setCochera(String cochera) {
		this.cochera = cochera;
	}
	public String getPatio() {
		return patio;
	}
	public void setPatio(String patio) {
		this.patio = patio;
	}
	public String getAmueblado() {
		return amueblado;
	}
	public void setAmueblado(String amueblado) {
		this.amueblado = amueblado;
	}
	public String getBardeado() {
		return bardeado;
	}
	public void setBardeado(String bardeado) {
		this.bardeado = bardeado;
	}
	public String getEnrejado() {
		return enrejado;
	}
	public void setEnrejado(String enrejado) {
		this.enrejado = enrejado;
	}
	public int getVendedor() {
		return vendedor;
	}
	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}
	public String getNombreVendedor() {
		return nombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
	
	
}
