package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.FuncionarioAssembler;
import br.com.projeto.projetoWeg.api.model.FuncionarioDTO;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class FuncionarioService {

    private FuncionarioRepositories funcionarioRepositories;

    private FuncionarioAssembler funcionarioAssembler;

    @Transactional
    public Funcionario cadastrar(Funcionario funcionario){
        return funcionarioRepositories.save(funcionario);
    }

    public List<FuncionarioDTO> listar() {
        return funcionarioAssembler.toCollectionModel(funcionarioRepositories.findAll());
    }

}
