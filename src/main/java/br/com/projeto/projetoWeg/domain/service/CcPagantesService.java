package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import br.com.projeto.projetoWeg.domain.repository.CcPagantesRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CcPagantesService {

    private CcPagantesRepositories ccPagantesRepositories;

    public CcPagante cadastrar(CcPagante ccPagantes) {
        return ccPagantesRepositories.save(ccPagantes);
    }

}
