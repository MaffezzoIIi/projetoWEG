package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.api.model.CentroDeCustoDTO;
import br.com.projeto.projetoWeg.domain.entities.CentroDeCusto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentrosDeCustoRepositories extends JpaRepository<CentroDeCusto, Long> {

    Optional<CentroDeCusto> findByNome(String nome);

}
