package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.TipoDocumento;

public interface ITipoDocRepo extends JpaRepository<TipoDocumento, Integer> {
	TipoDocumento findByDescripcion(String descripcion);
}
