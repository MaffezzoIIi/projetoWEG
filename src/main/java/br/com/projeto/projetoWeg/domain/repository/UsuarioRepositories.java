package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
