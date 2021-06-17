package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.model.Despesas;
import br.com.projeto.projetoWeg.domain.repository.DespesasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DespesasService {

    private DespesasRepository despesasRepository;

    public Despesas cadastrarDespesas(Despesas despesas, long projeto_id) {
        despesas.setProjeto_id(projeto_id);
        return despesasRepository.save(despesas);
    }

}
