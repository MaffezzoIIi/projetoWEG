package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.CentroDeCustoAssembler;
import br.com.projeto.projetoWeg.api.model.CentroDeCustoDTO;
import br.com.projeto.projetoWeg.domain.entities.CentroDeCusto;
import br.com.projeto.projetoWeg.domain.exception.EntityNotFoundException;
import br.com.projeto.projetoWeg.domain.exception.ExceptionTratement;
import br.com.projeto.projetoWeg.domain.repository.CentrosDeCustoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CentroDeCustoService {

    private CentrosDeCustoRepositories centrosDeCustoRepositories;
    private CentroDeCustoAssembler centroDeCustoAssembler;

    @Transactional
    public CentroDeCusto cadastrar(CentroDeCusto centroDeCusto) {
        boolean ccValidation = centrosDeCustoRepositories.findByNome(centroDeCusto.getNome()).isPresent();

        if (ccValidation) {
            throw new ExceptionTratement("Centro de Custo já cadastrado");
        }

        return centrosDeCustoRepositories.save(centroDeCusto);
    }

    public ResponseEntity<List<CentroDeCustoDTO>> listar() {
        if (centrosDeCustoRepositories.count() <= 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(centroDeCustoAssembler.toCollectionModel(
                centrosDeCustoRepositories.findAll())
        );
    }

    public ResponseEntity<CentroDeCustoDTO> buscar(long id) {
        return centrosDeCustoRepositories.findById(id)
                .map(centroDeCusto -> ResponseEntity.ok(centroDeCustoAssembler.toModel(centroDeCusto)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CentroDeCustoDTO> removerPorId(long id) {
        if (!centrosDeCustoRepositories.existsById(id)){
            return  ResponseEntity.notFound().build();
        }

        centrosDeCustoRepositories.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
