package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.model.CcPagantes;
import br.com.projeto.projetoWeg.domain.repository.CcPagantesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CcPagantesService {

    private CcPagantesRepository ccPagantesRepository;
    private FuncionariosService funcionariosService;

    public CcPagantes cadastrarCcPagantes(CcPagantes ccPagantes, long projeto_id, String resposavel_cc) {
        ccPagantes.setProjeto_id(projeto_id);
        ccPagantes.setResponsavel_id(funcionariosService.buscarPorNome(resposavel_cc).getNumero_cracha());
        return ccPagantesRepository.save(ccPagantes);
    }

}
