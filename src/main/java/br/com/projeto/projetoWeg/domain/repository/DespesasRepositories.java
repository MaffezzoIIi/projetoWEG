package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesasRepositories extends JpaRepository<Despesa, Long> {
}
