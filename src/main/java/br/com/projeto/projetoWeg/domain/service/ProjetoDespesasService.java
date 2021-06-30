package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.ProjetoDespesas;
import br.com.projeto.projetoWeg.domain.repository.ProjetoDespesaRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProjetoDespesasService {

    private ProjetoDespesaRepositories projetoDespesaRepositories;

    public ProjetoDespesas cadastrar(ProjetoDespesas projetoDespesas) {
        return projetoDespesaRepositories.save(projetoDespesas);
    }

}
