package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.Usuario;
import br.com.projeto.projetoWeg.domain.repository.UsuarioRepositories;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepositories usuarioRepositories;

    @Transactional
    public Usuario cadastrar(Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuario.getCargos().setNome(usuario.getCargos().getNome().toUpperCase(Locale.ROOT));
        return usuarioRepositories.save(usuario);
    }
}
