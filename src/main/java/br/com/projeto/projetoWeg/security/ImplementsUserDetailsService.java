package br.com.projeto.projetoWeg.security;

import br.com.projeto.projetoWeg.domain.entities.Usuario;
import br.com.projeto.projetoWeg.domain.exception.ExceptionTratement;
import br.com.projeto.projetoWeg.domain.repository.UsuarioRepositories;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private final UsuarioRepositories usuarioRepositories;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositories.findByEmail(email).get();

        if (usuario == null){
            throw new ExceptionTratement("User or Password invalid");
        }

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                true,
                true,
                true,
                true,
                usuario.getAuthorities()
        );
    }
}
