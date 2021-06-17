package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.repository.EnvolvidosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EnvolvidosService {

    private EnvolvidosRepository envolvidosRepository;
    private FuncionariosService funcionariosService;

    public List<Envolvidos> listarTodos(){
        return envolvidosRepository.findAll();
    }

    //public Envolvidos cadastrarEnvolvidos(Envolvidos envolvidos) {
    //    return envolvidosRepository.save(envolvidos);
    //}

    public Envolvidos cadastrarEnvolvidos(ProjetoEnvolvidos projetoEnvolvidos){
        Long[] ids = funcionariosService.buscarIdPeloNome(projetoEnvolvidos.getEnvolvidos());

        Envolvidos envolvidos = new Envolvidos();

        envolvidos.setId_solicitante(ids[0]);
        envolvidos.setId_responsavel(ids[1]);
        envolvidos.setId_aprovador(ids[2]);

        return envolvidosRepository.save(envolvidos);
    }
}
