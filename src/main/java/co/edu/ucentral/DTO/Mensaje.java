package co.edu.ucentral.DTO;

import org.springframework.stereotype.Service;

@Service
public class Mensaje {

	private String status;
	private Object entidad;
	private String mensaje;
	
	public Mensaje() {}

	public Mensaje(String status, Object entidad, String mensaje) {
		super();
		this.status = status;
		this.entidad = entidad;
		this.mensaje = mensaje;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getEntidad() {
		return entidad;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
