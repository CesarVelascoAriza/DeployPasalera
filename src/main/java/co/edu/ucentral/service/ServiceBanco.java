package co.edu.ucentral.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.DTO.BancoDTO;
import co.edu.ucentral.model.Banco;
import co.edu.ucentral.repository.IBanacoRepository;

@Service
public class ServiceBanco {

	@Autowired
	private IBanacoRepository bancoRepo;

	public List<BancoDTO> listadoBancosServico() {
		List<BancoDTO> banco = new ArrayList<BancoDTO>();
		bancoRepo.findAll().stream().forEach(action -> {
			banco.add(new BancoDTO(action.getId(), action.getNombre()));
		});
		return banco;
	}

	public BancoDTO getBancoId(int id) {
		BancoDTO bancoDTO = new BancoDTO();
		Optional<Banco> temp= bancoRepo.findById(id);
		bancoDTO.setId(temp.get().getId());
		bancoDTO.setNombeBanco(temp.get().getNombre());
		
		return bancoDTO;
	}
	
	public BancoDTO getBancoNombre(String nombre) {
		BancoDTO bancoDTO = new BancoDTO();
		Banco temp= bancoRepo.findByNombre(nombre);
		bancoDTO.setId(temp.getId());
		bancoDTO.setNombeBanco(temp.getNombre());
		
		return bancoDTO;
	}
}
