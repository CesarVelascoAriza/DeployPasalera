package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Banco;

public interface IBanacoRepository extends JpaRepository<Banco, Integer> {
	Banco findByNombre(String name);
}

