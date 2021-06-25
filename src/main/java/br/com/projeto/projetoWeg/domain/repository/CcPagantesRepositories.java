package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcPagantesRepositories extends JpaRepository<CcPagante, Long> {
}
