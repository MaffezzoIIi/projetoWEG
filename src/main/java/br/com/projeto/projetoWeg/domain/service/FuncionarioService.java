package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.FuncionarioAssembler;
import br.com.projeto.projetoWeg.api.model.FuncionarioDTO;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import br.com.projeto.projetoWeg.domain.exception.ExceptionTratement;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        boolean crachaValidation = funcionarioRepositories.findById(funcionario.getNumero_cracha()).isPresent();

        if (crachaValidation) {
            throw new ExceptionTratement("Funcionário com esse crachá já cadastrado");
        }

        boolean cpfValidation = funcionarioRepositories.findByCpf(funcionario.getCpf()).isPresent();

        if (cpfValidation) {
            throw new ExceptionTratement("Funcionário com esse CPF já cadastrado");
        }

        return funcionarioRepositories.save(funcionario);
    }

    public ResponseEntity<List<FuncionarioDTO>> listar() {
        if (funcionarioRepositories.count() <= 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(funcionarioAssembler.toCollectionModel(
                funcionarioRepositories.findAll())
        );
    }

    public ResponseEntity<FuncionarioDTO> buscar(long id) {
        return funcionarioRepositories.findById(id)
                .map(funcionario -> ResponseEntity.ok(funcionarioAssembler.toModel(funcionario)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<FuncionarioDTO> remover(long id) {
        if (!funcionarioRepositories.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        funcionarioRepositories.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
