package co.edu.ucentral.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.DTO.ClienteDTO;
import co.edu.ucentral.service.ServiceCliente;

@RestController
@RequestMapping(path = "/api/Clientes")
public class ClientesRest {

	@Autowired
	private ServiceCliente serviceCliente;
	
	@GetMapping
	public List<ClienteDTO> getClientes(){
		return serviceCliente.getAllCliente(); 
	} 
	@PostMapping("/{correo}")
	public ClienteDTO getCorreoCliente(@PathVariable(value = "correo")String Correo) {
		return serviceCliente.getClienteCorreo(Correo);
	}
	@PostMapping()
	public ClienteDTO setNewCleinte(@RequestBody ClienteDTO cliente) {
		return serviceCliente.crearNuevoCliente(cliente);
	}
	
}
