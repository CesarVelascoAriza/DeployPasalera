package co.edu.ucentral.DTO;

public class ClienteDTO {

	private String tipoDocument;
	private String documento;
	private String nombre;
	private String email;
	private String respuesta;
	
	
	public ClienteDTO() {
	// TODO Auto-generated constructor stub
	}


	public ClienteDTO(String tipoDocument, String documento, String nombre, String email, String respuesta) {
		super();
		this.tipoDocument = tipoDocument;
		this.documento = documento;
		this.nombre = nombre;
		this.email = email;
		this.respuesta = respuesta;
	}


	public String getTipoDocument() {
		return tipoDocument;
	}


	public void setTipoDocument(String tipoDocument) {
		this.tipoDocument = tipoDocument;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
	
	
	
}
