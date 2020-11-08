package co.edu.ucentral.DTO;

public class BancoDTO {

	private long id;
	private String nombeBanco;
	
	public BancoDTO() {
	}

	public BancoDTO(long id, String nombeBanco) {
		super();
		this.id = id;
		this.nombeBanco = nombeBanco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombeBanco() {
		return nombeBanco;
	}

	public void setNombeBanco(String nombeBanco) {
		this.nombeBanco = nombeBanco;
	}
	
}
