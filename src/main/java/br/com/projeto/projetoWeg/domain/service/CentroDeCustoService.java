package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.model.CentroDeCustoDTO;
import br.com.projeto.projetoWeg.domain.entities.CentroDeCusto;
import br.com.projeto.projetoWeg.domain.repository.CentrosDeCustoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CentroDeCustoService {

    private CentrosDeCustoRepositories centrosDeCustoRepositories;

    @Transactional
    public CentroDeCusto cadastrar(CentroDeCusto centroDeCusto) {
        return centrosDeCustoRepositories.save(centroDeCusto);
    }

}
