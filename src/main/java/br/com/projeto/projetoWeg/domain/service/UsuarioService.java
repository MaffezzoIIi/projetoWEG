package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.CargosUsuarios;
import br.com.projeto.projetoWeg.domain.entities.Usuario;
import br.com.projeto.projetoWeg.domain.exception.ExceptionTratement;
import br.com.projeto.projetoWeg.domain.repository.UsuarioRepositories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepositories usuarioRepositories;
    private CargoUsuarioService cargoUsuarioService;

    @Transactional
    public Usuario cadastrar(Usuario usuario){
        boolean userValidation = usuarioRepositories.findByEmail(usuario.getEmail()).isPresent();

        if (userValidation) {
            throw new ExceptionTratement("Email já cadastrado em outro usuário");
        }

        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

        usuarioRepositories.save(usuario);

        CargosUsuarios cargosUsuarios = new CargosUsuarios();
        cargosUsuarios.setUsuario_id(usuario.getId());
        cargosUsuarios.setCargo_id(4L);

        cargoUsuarioService.cadastrar(cargosUsuarios);

        return usuario;
    }
}
