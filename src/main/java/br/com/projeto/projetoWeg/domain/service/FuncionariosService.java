package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.model.Funcionarios;
import br.com.projeto.projetoWeg.domain.repository.FuncionariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;

    @Transactional
    public Funcionarios cadastrarFuncionario(Funcionarios funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }


    public List<Funcionarios> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    public Funcionarios buscarPorNome(String nome) {
        return funcionariosRepository.findByNome(nome);
    }

}
