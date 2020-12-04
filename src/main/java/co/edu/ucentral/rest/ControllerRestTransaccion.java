/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.DTO.Mensaje;
import co.edu.ucentral.DTO.TransaccionesDTO;
import co.edu.ucentral.service.ServiceTransaccion;

/**
 *
 * @author juand
 */
@RestController
@RequestMapping(path = "/api/transaccion")
public class ControllerRestTransaccion {

    @Autowired
    private ServiceTransaccion serviceTransaccion;
    @Autowired
    private Mensaje mensaje; 
    
    @GetMapping
    public List<TransaccionesDTO> getServiTransaccion() {
        return serviceTransaccion.getAllTransacciones();
    }

    @GetMapping("/{id}")
    public TransaccionesDTO getTransaccion(@PathVariable(value = "id") int id) {
        return serviceTransaccion.getTransaccion(id);
    }
    @GetMapping("/email/{email}")
    public TransaccionesDTO getTransaccionByEmail(@PathVariable(value = "email") String email) {
        return serviceTransaccion.getTransaccionByEmail(email);
    }

    @PostMapping()
    public TransaccionesDTO agregarTransaccion(@RequestBody() TransaccionesDTO trans) {
    	
    	//mensaje.setStatus("200");
    	//mensaje.setEntidad(serviceTransaccion.crearTransaccion(trans));
    	//mensaje.setMensaje("se actualizo");
    	return  serviceTransaccion.crearTransaccion(trans);
    			
    }
    @PutMapping("/{id}")
    public TransaccionesDTO actualizarTransaccion(@RequestBody() TransaccionesDTO t, @PathVariable(value = "id") int id) {
        return serviceTransaccion.actualizarTransaccion(t, id);
    }
    @PutMapping("/idbanco/{id}")
    public TransaccionesDTO actualizarIbanco(@RequestBody() TransaccionesDTO t, @PathVariable(value = "id") long id) {
        return serviceTransaccion.actualizarIdBanco(t, id);
    }
    
  
        
}
	
      


