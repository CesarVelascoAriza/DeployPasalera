package co.edu.ucentral.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.model.Cliente;
import co.edu.ucentral.model.Transaccion;

public interface ITransaccionRepo extends JpaRepository<Transaccion, Integer> {
	Optional<Transaccion> findByIdTxBanco(long id);
	List<Transaccion> findByCliente(Cliente cliente);
}
