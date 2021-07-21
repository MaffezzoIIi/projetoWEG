package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.ProjetoDespesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoDespesaRepositories extends JpaRepository<ProjetoDespesas, Long> {

    @Query("SELECT despesas_id FROM ProjetoDespesas WHERE projeto_id = ?1")
    List<Long> findByProjetoId(Long id);

}
