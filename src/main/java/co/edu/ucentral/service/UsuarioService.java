package co.edu.ucentral.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import co.edu.ucentral.model.Usuario;
import co.edu.ucentral.repository.IUsuarioReposirory;

@Service
public class UsuarioService implements UserDetailsService {

	private static Logger log= LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private IUsuarioReposirory usuarioRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Se consulta el usuario, {}", username);
		Usuario usuario = usuarioRepo.findByNombre(username);
		List<GrantedAuthority>  roles= new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDet  = new User(usuario.getNombre(), usuario.getContrasenia(), roles); 
		return userDet;
	}

}
