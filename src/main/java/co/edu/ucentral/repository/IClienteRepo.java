package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {
	Cliente findByEmail(String email);
	Cliente findByDocumento(String documento);
	boolean existsByDocumento(String documento);
	
}
