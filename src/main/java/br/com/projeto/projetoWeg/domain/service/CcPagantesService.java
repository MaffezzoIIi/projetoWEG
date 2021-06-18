package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.model.CcPagantes;
import br.com.projeto.projetoWeg.domain.repository.CcPagantesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CcPagantesService {

    //Respository
    private CcPagantesRepository ccPagantesRepository;

    //Services
    private FuncionariosService funcionariosService;

    public CcPagantes cadastrarCcPagantes(CcPagantes ccPagantes, long projeto_id, String resposavel_cc) {
        ccPagantes.setProjeto_id(projeto_id);
        ccPagantes.setResponsavel_id(funcionariosService.buscarPorNome(resposavel_cc).getNumero_cracha());
        return ccPagantesRepository.save(ccPagantes);
    }

    public List<CcPagantes> listarPeloIdDoProjeto(){

        return null;
    }

}
