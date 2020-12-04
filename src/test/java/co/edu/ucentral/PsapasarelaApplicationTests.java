package co.edu.ucentral;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.ucentral.model.Cliente;
import co.edu.ucentral.model.Transaccion;
import co.edu.ucentral.repository.IClienteRepo;
import co.edu.ucentral.repository.ITransaccionRepo;

@SpringBootTest
class PsapasarelaApplicationTests {

	@Autowired
	private IClienteRepo clienteRepo;
	@Autowired
	private ITransaccionRepo transaccionRepo;
	@Test
	void contextLoads() {
		
		Cliente cliente = clienteRepo.findByEmail("asdfsa");
		List<Transaccion> t = (List<Transaccion>) transaccionRepo.findByCliente(cliente);
		System.out.println(t.get(0).getId());
		System.out.println(t.get(1).getId());
		System.out.println(cliente.getId());
		
	}

}
