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

    private ProjetoDespesaRepositories projetoDespesaRepositories;

    private DespesasAssembler despesasAssembler;
    private DespesasService despesasService;

    @Transactional
    public ProjetoDespesas cadastrar(ProjetoDespesas projetoDespesas) {
        return projetoDespesaRepositories.save(projetoDespesas);
    }

    public List<Long> listarPorId(Long id){
        return projetoDespesaRepositories.findByProjetoId(id);
    }

    public List<Despesa> listarProjetoDespesas(@PathVariable Long id){
        List<Long> ids = projetoDespesaRepositories.findByProjetoId(id);

        List<Despesa> despesas = new ArrayList<>();

        for (int i = 0; i < ids.size() ; i++) {
            despesas.add(despesasService.buscar(ids.get(i)));
        }

        return despesas;
    }
}
