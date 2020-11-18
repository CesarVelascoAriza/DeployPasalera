package co.edu.ucentral.DTO;

public class ComercioDTO {
	
	
	private long nit;
	private String nombreComercio;
	
	public ComercioDTO() {
	
	}

	public ComercioDTO(long nit, String nombreComercio) {
		super();
		this.nit = nit;
		this.nombreComercio = nombreComercio;
	}

	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	

}
