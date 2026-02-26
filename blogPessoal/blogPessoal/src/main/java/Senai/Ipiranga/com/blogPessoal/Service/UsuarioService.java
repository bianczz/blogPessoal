package Senai.Ipiranga.com.blogPessoal.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import Senai.Ipiranga.com.blogPessoal.Model.Usuario;
import Senai.Ipiranga.com.blogPessoal.Model.UsuarioLogin;
import Senai.Ipiranga.com.blogPessoal.Repository.UsuarioRepository;

@Service 
public class UsuarioService {

	@Autowired 
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario  usuario) { //criacao do objeto e do metodo contrutor da classe cadastrarusuario vai pegar a senha q o usario digitar e vai criptografar
		BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();//criptografando a senha
		String senhaEncoder = encoder.encode(usuario.getSenha());//senha tipo string
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);//salvar a senha no banco da dados
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin>user){ //para a checagem de usuario conseguir logar na conta
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //tem q criptografar dnv pq a senha só foi guardada naquele metodo
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {//comparação do banco de dados com o front pelo metches 
				String auth = user.get().getUsuario()+":"+user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader= "Basic" + new String(encodedAuth);
				//pegando informações do usuario e contruindo um token e salvando em base64 
				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getId());
				user.get().setNome(usuario.get().getNome());
				user.get().setFoto(usuario.get().getFoto());
				user.get().setTipo(usuario.get().getTipo());
				return user;
			}
		}
		return null;
	}
}
