package co.edu.ucentral.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.DTO.UsuarioDTO;
import co.edu.ucentral.jwt.JwtUtil;
import co.edu.ucentral.service.UsuarioService;

@RestController

@RequestMapping(path = "/authenticate")
public class RestControllerAuth {

	private static Logger log = LoggerFactory.getLogger(RestControllerAuth.class);
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping
	public UsuarioDTO createAuthenticationToken(@RequestBody UsuarioDTO usuario) throws Exception {
		try {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
			} catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}
			final UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getUsername());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			usuario.setBearerToken(jwt);
		} catch (Exception e) {
			log.error("Errer al loguear {} ", e.getMessage());
		}
		return usuario;

	}
}
