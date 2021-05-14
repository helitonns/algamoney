package com.algaworks.algamoney.security;

import com.algaworks.algamoney.model.Usuario;
import com.algaworks.algamoney.repository.UsuarioRepository;
import com.algaworks.algamoney.security.util.UsuarioSistema;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository UsuarioRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> userioOptional = UsuarioRepository.findByEmail(email);
        
        Usuario usuario = userioOptional.orElseThrow(()->new UsernameNotFoundException("Usuário ou senha incorretos") );
        return new UsuarioSistema(usuario, getPermissoes(usuario));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorites = new HashSet<>();
        
        usuario.getPermissoes().forEach(p -> authorites.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
        
        return authorites;
    }
    
}
