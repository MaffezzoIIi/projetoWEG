package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjetoRepositories extends JpaRepository<Projeto, Long> {

    Optional<Projeto> findByNumeroDoProjeto(long numero_do_projeto);

}
