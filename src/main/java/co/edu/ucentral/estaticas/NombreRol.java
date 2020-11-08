package co.edu.ucentral.estaticas;

public enum NombreRol {

	ROLE_ADMIN(1), ROL_USER(2);

	private final int value;

	private NombreRol(int value) {
		this.value = value;
	}
}
