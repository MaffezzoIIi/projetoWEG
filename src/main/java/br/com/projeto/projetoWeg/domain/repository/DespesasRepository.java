package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.model.Despesas;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {
}
