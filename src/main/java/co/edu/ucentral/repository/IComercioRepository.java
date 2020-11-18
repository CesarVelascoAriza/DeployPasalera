package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Comercio;

public interface IComercioRepository extends JpaRepository<Comercio, Integer> {
	Comercio findByDocumento(long documento);
	boolean  existsByDocumento(long documento);	
}
