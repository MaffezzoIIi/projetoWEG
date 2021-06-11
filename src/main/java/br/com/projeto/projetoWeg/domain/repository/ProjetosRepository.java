package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.model.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<Projetos, Long> {
}
