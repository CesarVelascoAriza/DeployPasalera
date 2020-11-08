package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Usuario;

public interface IUsuarioReposirory extends JpaRepository<Usuario, Integer> {
	Usuario findByNombre(String nombre);
}
