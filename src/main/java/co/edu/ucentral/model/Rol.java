package co.edu.ucentral.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.edu.ucentral.estaticas.NombreRol;

@Entity
@Table(name = "Roles")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private NombreRol nmbreRol;

	public Rol() {
	}

	public Rol(int id, NombreRol nmbreRol) {
		super();
		this.id = id;
		this.nmbreRol = nmbreRol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NombreRol getNmbreRol() {
		return nmbreRol;
	}

	public void setNmbreRol(NombreRol nmbreRol) {
		this.nmbreRol = nmbreRol;
	}

}
