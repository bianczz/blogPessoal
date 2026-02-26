package Senai.Ipiranga.com.blogPessoal.Seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Senai.Ipiranga.com.blogPessoal.Model.Usuario;

public class UserDetailslmpl implements UserDetails{ //userdails interface de seguranca do springboot
		private static final long serialVersionUID = 1L; //versionamento
		
		private String userName;
		private String password;
		private List<GrantedAuthority> authorities;
		
		public UserDetailslmpl(Usuario user) { //metodo contrstutor recebendo parametro Usuario recebendo usuario e senha 
			this.userName = user.getUsuario();
			this.password = user.getSenha();
		}

		public UserDetailslmpl() {}//polimorfirmo de sobrecarga
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities(){
			return authorities; //categorizaçao tipo user e admin
		}
		
		@Override
		public String getPassword() {
			return password;
		}
		
		@Override
		public String getUsername() {
			return userName;
		}
		
		@Override
		public boolean isAccountNonExpired() {
			return true; //vericacao se a conta expirou
		}
		
		@Override
		public boolean isAccountNonLocked() {
			return true; //conta bloaqueada
		}
		
		@Override
		public boolean isCredentialsNonExpired() {
			return true; //senha expirou ou não
		}
		
		@Override
		public boolean isEnabled() {
			return true;
		}
		
}
