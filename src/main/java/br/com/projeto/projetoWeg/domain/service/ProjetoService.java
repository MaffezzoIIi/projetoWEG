package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.CcPagantesAssembler;
import br.com.projeto.projetoWeg.api.assembler.DespesasAssembler;
import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.InfoProjetosDTO;
import br.com.projeto.projetoWeg.api.model.ProjetoDTO;
import br.com.projeto.projetoWeg.domain.entities.Projeto;
import br.com.projeto.projetoWeg.domain.exception.ExceptionTratement;
import br.com.projeto.projetoWeg.domain.repository.ProjetoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ProjetoService {

    private final ProjetoRepositories projetoRepositories;

    private final ProjetoAssembler projetoAssembler;
    private final DespesasAssembler despesasAssembler;
    private final CcPagantesAssembler ccPagantesAssembler;

    private final ProjetoDespesasService projetoDespesasService;
    private final ProjetoCcPagantesService projetoCcPagantesService;

    @Transactional
    public Projeto cadastrar(Projeto projeto) {
        boolean projetoValidation = projetoRepositories.findByNumeroDoProjeto(
                projeto.getNumeroDoProjeto()
        ).isPresent();

        if (projetoValidation) {
            throw new ExceptionTratement("Projeto com este número já cadastrado");
        }

        return projetoRepositories.save(projeto);
    }

    public ResponseEntity<List<ProjetoDTO>> listar() {

        if (projetoRepositories.count() <= 0) {
           return ResponseEntity.noContent().build();
        }

        List<Long> ids  = new ArrayList<>();

        for (int i = 0; i < projetoRepositories.findAll().size(); i++) {
            ids.add(projetoRepositories.findAll().get(i).getId());
        }

        List<ProjetoDTO> projetoDTOList = montarProjetos(ids);

        return ResponseEntity.ok(projetoDTOList);
    }

    public List<ProjetoDTO> montarProjetos(List<Long> ids) {
        List<ProjetoDTO> projetoDTOList = new ArrayList<>();

        for (Long id : ids) {
            ProjetoDTO projetoDTO = new ProjetoDTO();

            projetoDTO.setInfoprojetoDTO(
                    Objects.requireNonNull(this.buscar(id).getBody()).getInfoprojetoDTO()
            );

            projetoDTO.setDespesas(
                    despesasAssembler.toCollectionModel(
                            projetoDespesasService.listarProjetoDespesas(id)
                    )
            );

            projetoDTO.setCcPagantes(
                    ccPagantesAssembler.toCollectionModel(
                            projetoCcPagantesService.listarProjetoCcPagantes(id)
                    )
            );
            projetoDTOList.add(projetoDTO);
        }

        return projetoDTOList;
    }

    public ResponseEntity<ProjetoDTO> buscar(Long id) {
        if (!projetoRepositories.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(montarProjeto(id));
    }

    private ProjetoDTO montarProjeto(long id) {
        ProjetoDTO projetoDTO = new ProjetoDTO();

        projetoDTO.setInfoprojetoDTO(
                projetoAssembler.toModel(projetoRepositories.getById(id))
        );

        projetoDTO.setDespesas(
                despesasAssembler.toCollectionModel(
                        projetoDespesasService.listarProjetoDespesas(id)
                )
        );

        projetoDTO.setCcPagantes(
                ccPagantesAssembler.toCollectionModel(
                        projetoCcPagantesService.listarProjetoCcPagantes(id)
                )
        );

        return projetoDTO;
    }

    public void remover(long id) {
        projetoRepositories.deleteById(id);
    }
}
