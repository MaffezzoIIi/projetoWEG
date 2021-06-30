package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.CcPagantesAssembler;
import br.com.projeto.projetoWeg.api.assembler.DespesasAssembler;
import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.InfoProjetosDTO;
import br.com.projeto.projetoWeg.api.model.input.CcPagantesInputDTO;
import br.com.projeto.projetoWeg.api.model.input.DespesasInputDTO;
import br.com.projeto.projetoWeg.api.model.input.InfoProjetosInputDTO;
import br.com.projeto.projetoWeg.api.model.input.ProjetoInputDTO;
import br.com.projeto.projetoWeg.domain.entities.*;
import br.com.projeto.projetoWeg.domain.exception.EntityNotFoundException;
import br.com.projeto.projetoWeg.domain.repository.CentrosDeCustoRepositories;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import br.com.projeto.projetoWeg.domain.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoAssembler projetoAssembler;
    private final CcPagantesAssembler ccPagantesAssembler;
    private final DespesasAssembler despesasAssembler;

    private final ProjetoService projetoService;
    private final DespesasService despesasService;
    private final CcPagantesService ccPagantesService;
    private final ProjetoCcPagantesService projetoCcPagantesService;
    private final ProjetoDespesasService projetoDespesasService;

    private final FuncionarioRepositories funcionarioRepositories;
    private final CentrosDeCustoRepositories centrosDeCustoRepositories;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InfoProjetosDTO cadastrar(@RequestBody ProjetoInputDTO projetoInputDTO) {
        Projeto novoProjeto = projetoAssembler.toEntity(projetoInputDTO.getInfoProjetosInputDTO());

        setDefaultInfo(novoProjeto, projetoInputDTO.getInfoProjetosInputDTO());

        Projeto projeto = projetoService.cadastrar(novoProjeto);

        cadastrarCcPagantes(projetoInputDTO.getCcPagantesInputDTO(), projeto.getId());

        cadastrarDespesas(projetoInputDTO.getDespesasInputDTOS(), projeto.getId());

        return projetoAssembler.toModel(projeto);
    }

    private void setDefaultInfo(Projeto projeto, InfoProjetosInputDTO infoProjeto) {
        projeto.setData_do_cadastro(LocalDateTime.now());
        projeto.setStatus(Status.NAO_INICIADO);
        projeto.setHorasApontadas(0);
        projeto.setResponsavel(funcionarioRepositories.findByNome(
                infoProjeto.getNome_responsavel()
        ));
        projeto.setSolicitante(funcionarioRepositories.findByNome(
                infoProjeto.getNome_solicitante()
        ));
    }

    private void cadastrarCcPagantes(List<CcPagantesInputDTO> ccPagantesInputDTO, Long projetoId) {
        for (CcPagantesInputDTO ccPagantes : ccPagantesInputDTO) {
            CcPagante novoCcPagante = ccPagantesAssembler.toEntity(ccPagantes);

            novoCcPagante.setCentroDeCusto(buscarCc(ccPagantes.getCentro_de_custo_id()));

            CcPagante ccPagante = ccPagantesService.cadastrar(novoCcPagante);

            ProjetoCcPagantes projetoCcPagantes = new ProjetoCcPagantes();

            projetoCcPagantes.setCcpagantes_id(ccPagante.getId());
            projetoCcPagantes.setProjeto_id(projetoId);

            projetoCcPagantesService.cadastrar(projetoCcPagantes);
        }
    }

    private CentroDeCusto buscarCc(Long cc_id) {
        return centrosDeCustoRepositories.findById(cc_id)
                .orElseThrow(() -> new EntityNotFoundException("Centro de Custo inválido"));
    }

    private void cadastrarDespesas(List<DespesasInputDTO> despesasInputDTOS, Long projetoId) {
        for (DespesasInputDTO despesas : despesasInputDTOS) {
            Despesa novaDespesa = despesasAssembler.toEntity(despesas);

            Despesa despesa = despesasService.cadastrar(novaDespesa);

            ProjetoDespesas projetoDespesas = new ProjetoDespesas();

            projetoDespesas.setDespesas_id(despesa.getId());
            projetoDespesas.setProjeto_id(projetoId);

            projetoDespesasService.cadastrar(projetoDespesas);
        }
    }

}
