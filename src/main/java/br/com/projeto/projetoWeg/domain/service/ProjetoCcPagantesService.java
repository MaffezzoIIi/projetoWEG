package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.ProjetoCcPagantes;
import br.com.projeto.projetoWeg.domain.repository.ProjetoCcPagantesRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ProjetoCcPagantesService {

    private ProjetoCcPagantesRepositories projetoCcPagantesRepositories;

    @Transactional
    public ProjetoCcPagantes cadastrar( ProjetoCcPagantes projetoCcPagantes){
        return projetoCcPagantesRepositories.save(projetoCcPagantes);
    }
}
