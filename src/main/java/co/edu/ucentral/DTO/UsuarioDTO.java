package co.edu.ucentral.DTO;

public class UsuarioDTO {

	private String username;
	private String password;
	private String BearerToken;
	
	public UsuarioDTO() {
	
	}


	public UsuarioDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBearerToken() {
		return BearerToken;
	}


	public void setBearerToken(String bearerToken) {
		BearerToken = bearerToken;
	}
	
}
