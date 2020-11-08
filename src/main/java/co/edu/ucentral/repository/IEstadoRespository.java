package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Estado;

public interface IEstadoRespository extends JpaRepository<Estado, Integer> {
	Estado  findByDescripcion(String descripcion) ;
}
