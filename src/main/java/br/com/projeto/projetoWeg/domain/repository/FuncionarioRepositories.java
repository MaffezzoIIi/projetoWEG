package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepositories extends JpaRepository<Funcionario, Long> {

    Funcionario findByNome(String nome);

    Optional<Funcionario> findByCpf(String cpf);

}
