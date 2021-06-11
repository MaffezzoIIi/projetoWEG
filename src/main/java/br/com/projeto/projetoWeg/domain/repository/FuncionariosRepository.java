package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

    Funcionarios findByNome(String name);

}
