package Senai.Ipiranga.com.blogPessoal.Seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Senai.Ipiranga.com.blogPessoal.Model.Usuario;
import Senai.Ipiranga.com.blogPessoal.Repository.UsuarioRepository;

@Service
public class UserDetailsServicelmpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<Usuario> user = userRepository.findByUsuario(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "not found."));
		
		return user.map(UserDetailslmpl::new).get();
	}
}
