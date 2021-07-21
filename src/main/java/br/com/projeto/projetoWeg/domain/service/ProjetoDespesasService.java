package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.DespesasAssembler;
import br.com.projeto.projetoWeg.api.model.DespesasDTO;
import br.com.projeto.projetoWeg.domain.entities.Despesa;
import br.com.projeto.projetoWeg.domain.entities.ProjetoDespesas;
import br.com.projeto.projetoWeg.domain.repository.ProjetoDespesaRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProjetoDespesasService {

    private final ProjetoDespesaRepositories projetoDespesaRepositories;

    private final DespesasService despesasService;

    @Transactional
    public ProjetoDespesas cadastrar(ProjetoDespesas projetoDespesas) {
        return projetoDespesaRepositories.save(projetoDespesas);
    }

    public List<Despesa> listarProjetoDespesas(Long projetoId){
        List<Long> ids = projetoDespesaRepositories.findByProjetoId(projetoId);

        List<Despesa> despesas = new ArrayList<>();

        for (Long id : ids) {
            despesas.add(despesasService.buscar(id).getBody());
        }

        return despesas;
    }

    public void remover(long id) {
        List<Long> ids = projetoDespesaRepositories.findByProjetoId(id);

        for (Long aLong : ids) {
            projetoDespesaRepositories.deleteById(aLong);
        }
    }

}
