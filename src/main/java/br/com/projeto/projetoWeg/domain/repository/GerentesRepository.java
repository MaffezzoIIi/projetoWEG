package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.model.Gerentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerentesRepository extends JpaRepository<Gerentes, Long> {

    Gerentes findByName(String name);
    Gerentes findByUsername(String username);
    Gerentes findByPassword(String password);
}
