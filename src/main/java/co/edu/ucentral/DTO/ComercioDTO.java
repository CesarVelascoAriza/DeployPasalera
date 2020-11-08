package co.edu.ucentral.DTO;

public class ComercioDTO {
	
	
	private int nit;
	private String nombreComercio;
	
	public ComercioDTO() {
	
	}

	public ComercioDTO(int nit, String nombreComercio) {
		super();
		this.nit = nit;
		this.nombreComercio = nombreComercio;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	

}
