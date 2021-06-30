package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CcPagantesRepositories extends JpaRepository<CcPagante, Long> {

    List<CcPagante> findByCentroDeCustoId(Long centro_de_custo_id);

}
