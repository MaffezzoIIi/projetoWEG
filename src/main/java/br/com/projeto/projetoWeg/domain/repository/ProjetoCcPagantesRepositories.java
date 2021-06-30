package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.ProjetoCcPagantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoCcPagantesRepositories extends JpaRepository<ProjetoCcPagantes, Long> {
}
