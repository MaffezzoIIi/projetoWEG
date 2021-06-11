package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.model.Envolvidos;
import br.com.projeto.projetoWeg.domain.model.Gerentes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnvolvidosRepository extends JpaRepository<Envolvidos, Long> {
//    Envolvidos findByNameContaining(String name)
}
