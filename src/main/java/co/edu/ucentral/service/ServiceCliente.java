package co.edu.ucentral.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.DTO.ClienteDTO;
import co.edu.ucentral.model.Cliente;
import co.edu.ucentral.model.TipoDocumento;
import co.edu.ucentral.repository.IClienteRepo;
import co.edu.ucentral.repository.ITipoDocRepo;

@Service
public class ServiceCliente {
	
	@Autowired
	private IClienteRepo clienteRepo;
	@Autowired
	private ITipoDocRepo tipoDocRepo;
	
	public List<ClienteDTO> getAllCliente(){
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		clienteRepo.findAll().stream().forEach(cliente->{
			lista.add(
					new ClienteDTO(cliente.getTipodocumeto().getDescripcion(),
					cliente.getDocumento(), cliente.getNombre(), cliente.getEmail(), ""));
		});
		return lista;
	} 
	
	public ClienteDTO getClienteCorreo(String email) {
		Cliente cliente = clienteRepo.findByEmail(email);
		
		return new ClienteDTO(cliente.getTipodocumeto().getDescripcion(),
				cliente.getDocumento(), cliente.getNombre(), cliente.getEmail(), "");
	}

	public ClienteDTO crearNuevoCliente(ClienteDTO cliente) {
		try {
			TipoDocumento tipo =tipoDocRepo.findByDescripcion(cliente.getTipoDocument());
			clienteRepo.save(
					new Cliente(0, tipo, cliente.getDocumento(), cliente.getNombre(),cliente.getEmail()));
			cliente.setRespuesta("Se guardo el cliente");
		} catch (Exception e) {
			cliente.setRespuesta("Se genero un error al guardar el cliete"); 
		}
		return cliente ;
	}
}
