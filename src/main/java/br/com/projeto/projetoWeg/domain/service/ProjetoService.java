package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.InfoProjetosDTO;
import br.com.projeto.projetoWeg.api.model.ProjetoDTO;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import br.com.projeto.projetoWeg.domain.entities.Projeto;
import br.com.projeto.projetoWeg.domain.entities.Status;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import br.com.projeto.projetoWeg.domain.repository.ProjetoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProjetoService {

    private ProjetoRepositories projetoRepositories;

    private ProjetoAssembler projetoAssembler;

    @Transactional
    public Projeto cadastrar(Projeto projeto) {
        return projetoRepositories.save(projeto);
    }

    public List<Projeto> listar() { return projetoRepositories.findAll(); }

    public ResponseEntity<InfoProjetosDTO> buscar(Long id) {
        return projetoRepositories.findById(id)
                .map(projeto -> ResponseEntity.ok(projetoAssembler.toModel(projeto)))
                .orElse(ResponseEntity.notFound().build());
    }
}
