package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.controller.FuncionariosController;
import br.com.projeto.projetoWeg.domain.model.Envolvidos;
import br.com.projeto.projetoWeg.domain.model.Funcionarios;
import br.com.projeto.projetoWeg.domain.model.NomeEnvolvidos;
import br.com.projeto.projetoWeg.domain.model.ProjetoEnvolvidos;
import br.com.projeto.projetoWeg.domain.repository.FuncionariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    public Long[] buscarIdPeloNome(NomeEnvolvidos nomeEnvolvidos){
        Long idEnvolvidos[] = new Long[3];

        //Solicitante
        idEnvolvidos[0] = funcionariosRepository.findByNome(nomeEnvolvidos.getNome_solicitante()).getNumero_cracha();
        //Responsavel
        idEnvolvidos[1] = funcionariosRepository.findByNome(nomeEnvolvidos.getNome_responsavel()).getNumero_cracha();
        //Aprovador
        idEnvolvidos[2] = funcionariosRepository.findByNome(nomeEnvolvidos.getNome_aprovador()).getNumero_cracha();

        return idEnvolvidos;
    }


}
