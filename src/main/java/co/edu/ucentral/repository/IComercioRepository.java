package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Comercio;

public interface IComercioRepository extends JpaRepository<Comercio, Integer> {
	Comercio findByDocumento(int documento);
	boolean  existsByDocumento(int documento);	
}
