package br.com.projeto.projetoWeg.domain.repository;

import br.com.projeto.projetoWeg.domain.entities.CargosUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoUsuarioRepositories extends JpaRepository<CargosUsuarios, Long> {}
