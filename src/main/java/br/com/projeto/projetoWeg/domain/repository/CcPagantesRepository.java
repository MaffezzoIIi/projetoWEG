package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.model.CcPagantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcPagantesRepository extends JpaRepository<CcPagantes, Long> {
}
