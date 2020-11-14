/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.DTO.ClienteDTO;
import co.edu.ucentral.DTO.ComercioDTO;
import co.edu.ucentral.DTO.EstadoDTO;
import co.edu.ucentral.DTO.TransaccionesDTO;
import co.edu.ucentral.model.Banco;
import co.edu.ucentral.model.Cliente;
import co.edu.ucentral.model.Comercio;
import co.edu.ucentral.model.Estado;
import co.edu.ucentral.model.TipoDocumento;
import co.edu.ucentral.model.Transaccion;
import co.edu.ucentral.repository.IBanacoRepository;
import co.edu.ucentral.repository.IClienteRepo;
import co.edu.ucentral.repository.IComercioRepository;
import co.edu.ucentral.repository.IEstadoRespository;
import co.edu.ucentral.repository.ITipoDocRepo;
import co.edu.ucentral.repository.ITransaccionRepo;

/**
 *
 * @author juand
 */
@Service
public class ServiceTransaccion {

	@Autowired
	private ITransaccionRepo transaccionRepo;
	@Autowired
	private ITipoDocRepo tipoDocumentoRep;
	@Autowired
	private IClienteRepo clienteRepo;
	@Autowired
	private IEstadoRespository estadoRepo;
	@Autowired
	private IComercioRepository comercioRepo;

	public List<TransaccionesDTO> getAllTransacciones() {
		List<TransaccionesDTO> transaccion = new ArrayList<TransaccionesDTO>();
		transaccionRepo.findAll().stream().forEach(tran -> {
			EstadoDTO estado = new EstadoDTO(tran.getEstado().getDescripcion());
			ClienteDTO cliente = new ClienteDTO(tran.getCliente().getTipodocumeto().getDescripcion(),
					tran.getCliente().getDocumento(), tran.getCliente().getNombre(), tran.getCliente().getEmail(), "");
			ComercioDTO comercio = new ComercioDTO(tran.getComercios().getDocumento(), tran.getComercios().getNombre());

			transaccion.add(new TransaccionesDTO(tran.getId(), estado, cliente, tran.getNumeroCuentaDestino(), tran.getNumeroCuentaOrigen(),
					tran.getBanco(), tran.getValorPago(), tran.getDescipcionPago(), comercio, ""));
		});

		return transaccion;
	}

	public TransaccionesDTO crearTransaccion(TransaccionesDTO trans) {
		Estado estado = estadoRepo.findByDescripcion(trans.getEstado().getEstado());
		TipoDocumento tipo = tipoDocumentoRep.findByDescripcion(trans.getCliente().getTipoDocument());
		Cliente cliente = null;
		Comercio comercio = null;
		if(!clienteRepo.existsByDocumento(trans.getCliente().getDocumento())) {
			clienteRepo.save(new Cliente(tipo, trans.getCliente().getDocumento(), trans.getCliente().getNombre(),
					trans.getCliente().getEmail()));
			
		}if(!comercioRepo.existsByDocumento(trans.getComercio().getNit())) {
			comercioRepo.save(new Comercio(0, trans.getComercio().getNit(), trans.getComercio().getNombreComercio(), "", ""));
		}
		cliente = clienteRepo.findByDocumento(trans.getCliente().getDocumento());
		comercio = comercioRepo.findByDocumento(trans.getComercio().getNit());
		Transaccion transacciones = new Transaccion(trans.getNumeroCuentaorigen(), trans.getNumeroCuentaDestino(), trans.getDescripcionPago(),
				trans.getMonto(), trans.getBanco(), cliente, comercio, estado);
		
		 
		transacciones = transaccionRepo.save(transacciones);
		trans.setUrlRetorno("https://vistapasarela/transaccion/"+transacciones.getId());
		trans.setCus(transacciones.getId());
		
		return trans;
	}

	public TransaccionesDTO actualizarTransaccion(TransaccionesDTO transacciones,int id) {

		Estado estado = estadoRepo.findByDescripcion(transacciones.getEstado().getEstado());
		TipoDocumento tipo = tipoDocumentoRep.findByDescripcion(transacciones.getCliente().getTipoDocument());
		Cliente cliente = clienteRepo.findByDocumento(transacciones.getCliente().getDocumento());
		Comercio comercio = comercioRepo.findByDocumento(transacciones.getComercio().getNit());
		Optional<Object> transaccione = Optional.of(new Transaccion("", transacciones.getNumeroCuentaDestino(),
				transacciones.getDescripcionPago(), transacciones.getMonto(), transacciones.getBanco(), cliente,
				comercio, estado));
		if (cliente.getTipodocumeto().getDescripcion().equals(tipo.getDescripcion())) {
			transaccione = transaccionRepo.findById(id).map(t ->{
				t.setEstado(estado);
				transaccionRepo.save(t);
				return t;
			});
		}
		
		return transacciones;

	}

	public TransaccionesDTO getTransaccion(int id) {
		Optional<Transaccion> transaccion = transaccionRepo.findById(id);
		EstadoDTO estado = new EstadoDTO(transaccion.get().getEstado().getDescripcion());
		ClienteDTO cliente = new ClienteDTO(transaccion.get().getCliente().getTipodocumeto().getDescripcion(),
				transaccion.get().getCliente().getDocumento(), transaccion.get().getCliente().getNombre(),
				transaccion.get().getCliente().getEmail(), "");
		ComercioDTO comercio = new ComercioDTO(transaccion.get().getComercios().getDocumento(),
				transaccion.get().getComercios().getNombre());

		return new TransaccionesDTO(transaccion.get().getId(), estado, cliente,
				transaccion.get().getNumeroCuentaDestino(),transaccion.get().getNumeroCuentaOrigen(), transaccion.get().getBanco(),
				transaccion.get().getValorPago(), transaccion.get().getDescipcionPago(), comercio, "");
	}

}
