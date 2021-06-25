package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.Despesa;
import br.com.projeto.projetoWeg.domain.repository.DespesasRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DespesasService {

    private DespesasRepositories despesasRepositories;

    public Despesa cadastrar(Despesa despesas) {
        return despesasRepositories.save(despesas);
    }

}
