package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import br.com.projeto.projetoWeg.domain.entities.Projeto;
import br.com.projeto.projetoWeg.domain.entities.Status;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import br.com.projeto.projetoWeg.domain.repository.ProjetoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProjetoService {

    private ProjetoRepositories projetoRepositories;

    @Transactional
    public Projeto cadastrar(Projeto projeto) {
        return projetoRepositories.save(projeto);
    }

}
