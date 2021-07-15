package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import br.com.projeto.projetoWeg.domain.entities.Despesa;
import br.com.projeto.projetoWeg.domain.entities.ProjetoCcPagantes;
import br.com.projeto.projetoWeg.domain.repository.ProjetoCcPagantesRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProjetoCcPagantesService {

    private ProjetoCcPagantesRepositories projetoCcPagantesRepositories;

    private CcPagantesService ccPagantesService;

    @Transactional
    public ProjetoCcPagantes cadastrar( ProjetoCcPagantes projetoCcPagantes){
        return projetoCcPagantesRepositories.save(projetoCcPagantes);
    }

    public List<CcPagante> listarProjetoCcPagantes(@PathVariable Long id){
        List<Long> ids = projetoCcPagantesRepositories.findByProjetoId(id);

        List<CcPagante> ccPagantes = new ArrayList<>();

        for (int i = 0; i < ids.size() ; i++) {
            ccPagantes.add(ccPagantesService.buscar(ids.get(i)));
        }

        return ccPagantes;
    }
}
