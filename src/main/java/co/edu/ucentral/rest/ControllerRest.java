package co.edu.ucentral.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.DTO.BancoDTO;
import co.edu.ucentral.model.Banco;
import co.edu.ucentral.repository.IBanacoRepository;
import co.edu.ucentral.service.ServiceBanco;

@RestController
@RequestMapping(path = "/api/bancos")
@CrossOrigin (origins = "http://localhost:4200")
public class ControllerRest {

	@Autowired
	private ServiceBanco serviceBanco;
	@Autowired
	private IBanacoRepository bancoRepo;

	@GetMapping()
	public List<BancoDTO> listadoBanco() {
		return serviceBanco.listadoBancosServico();
	}
	@GetMapping("/{id}")
	public BancoDTO getBanco(@PathVariable(value  = "id") int id) {
		return serviceBanco.getBancoId(id);
	}
	@GetMapping("/{nombre}")
	public BancoDTO getBanco(@PathVariable(value  = "nombre") String nombre) {
		return serviceBanco.getBancoNombre(nombre);
	}
	@PostMapping()
	public void agregarBanco(@RequestBody() Banco banco) {
		bancoRepo.save(banco);
	}

	@PutMapping("/{id}")
	public Optional<Object>  actualizarBanco(@RequestBody() Banco banco, @PathVariable(value  = "id") int id ) {
		return bancoRepo.findById(id).map( b->{
			b.setCodigoBanco(banco.getCodigoBanco());
			b.setNombre(banco.getNombre());
			bancoRepo.save(b);
			return b;
		});
	
	}
	/*@PutMapping("/{id}")
	public <U> void actualizarBanco(@RequestBody() Banco banco, @PathVariable(value  = "id") int id ) {
		bancoRepo.findById(id).map((Function<? super Banco, ? extends U>) b->{
			b.setCodigoPasarela(banco.getCodigoPasarela());
			b.setCodigoBanco(banco.getCodigoBanco());
			b.setNombre(banco.getNombre());
			bancoRepo.save(b);
			return null;
		});
			
	}*/
	@DeleteMapping("/{id}")
	public void borrarBanco(@PathVariable int id) {
		bancoRepo.deleteById(id);
	}
}