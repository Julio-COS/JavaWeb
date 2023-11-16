package bean;

public class UsuarioDTO {
   private String email;
   private String nombre;
   private String appat;
   private String apmat;
   private String telefono;
   
   public UsuarioDTO() {
	
   }

   public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAppat() {
		return appat;
	}
	public void setAppat(String appat) {
		this.appat = appat;
	}
	public String getApmat() {
		return apmat;
	}
	public void setApmat(String apmat) {
		this.apmat = apmat;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
