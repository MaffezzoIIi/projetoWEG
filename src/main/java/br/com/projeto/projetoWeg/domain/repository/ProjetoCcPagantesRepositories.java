package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.ProjetoCcPagantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoCcPagantesRepositories extends JpaRepository<ProjetoCcPagantes, Long> {

    @Query("SELECT ccpagantes_id FROM ProjetoCcPagantes WHERE projeto_id = ?1")
    List<Long> findByProjetoId(Long id);

}
