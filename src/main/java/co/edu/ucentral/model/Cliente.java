package co.edu.ucentral.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JoinColumn(name = "tipodocumeto", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TipoDocumento tipodocumeto;
	private String documento;
	private String nombre;
	private String email;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, TipoDocumento tipodocumeto, String documento, String nombre, String email) {
		super();
		this.id = id;
		this.tipodocumeto = tipodocumeto;
		this.documento = documento;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoDocumento getTipodocumeto() {
		return tipodocumeto;
	}

	public void setTipodocumeto(TipoDocumento tipodocumeto) {
		this.tipodocumeto = tipodocumeto;
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

}
