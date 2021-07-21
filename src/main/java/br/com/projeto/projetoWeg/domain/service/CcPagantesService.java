package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import br.com.projeto.projetoWeg.domain.exception.EntityNotFoundException;
import br.com.projeto.projetoWeg.domain.repository.CcPagantesRepositories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CcPagantesService {

    private final CcPagantesRepositories ccPagantesRepositories;

    public CcPagante cadastrar(CcPagante ccPagantes) {
        return ccPagantesRepositories.save(ccPagantes);
    }

    public List<CcPagante> listar() { return ccPagantesRepositories.findAll(); }

    public ResponseEntity<CcPagante> buscar(long id) {
        return ccPagantesRepositories.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
