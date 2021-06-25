package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.CcPagantesAssembler;
import br.com.projeto.projetoWeg.api.assembler.DespesasAssembler;
import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.ProjetoDTO;
import br.com.projeto.projetoWeg.api.model.input.CcPagantesInputDTO;
import br.com.projeto.projetoWeg.api.model.input.DespesasInputDTO;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInputDTO;
import br.com.projeto.projetoWeg.domain.entities.*;
import br.com.projeto.projetoWeg.domain.repository.CentrosDeCustoRepositories;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import br.com.projeto.projetoWeg.domain.service.CcPagantesService;
import br.com.projeto.projetoWeg.domain.service.DespesasService;
import br.com.projeto.projetoWeg.domain.service.ProjetoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private ProjetoService projetoService;
    private CcPagantesService ccPagantesService;
    private DespesasService despesasService;

    private ProjetoAssembler projetoAssembler;
    private CcPagantesAssembler ccPagantesAssembler;
    private DespesasAssembler despesasAssembler;

    private FuncionarioRepositories funcionarioRepositories;
    private CentrosDeCustoRepositories centrosDeCustoRepositories;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetoDTO cadastrar(@RequestBody ProjetosInputDTO projetosInputDTO) {
        Projeto novoProjeto = projetoAssembler.toEntity(projetosInputDTO);
        novoProjeto = setAtributosPadrao(novoProjeto, projetosInputDTO);

        for (int i = 0; i < projetosInputDTO.getCc_pagantes().size(); i ++) {
            cadastrarCcPagante(projetosInputDTO.getCc_pagantes().get(i));
        }

        for (int i = 0; i < projetosInputDTO.getDespesas().size(); i ++) {
            cadastrarDespesa(projetosInputDTO.getDespesas().get(i));
        }

        Projeto projeto = projetoService.cadastrar(novoProjeto);

        return projetoAssembler.toModel(projeto);
    }

    public void cadastrarCcPagante(CcPagantesInputDTO ccPagantesInputDTO) {
        CcPagante cc_provisorio = new CcPagante();
        cc_provisorio.setCentroDeCusto(centrosDeCustoRepositories.findById(ccPagantesInputDTO.getCentro_de_custo_id()));
        cc_provisorio.setPercentual(ccPagantesInputDTO.getPercentual());
        cc_provisorio.setValor(ccPagantesInputDTO.getValor());

        ccPagantesService.cadastrar(cc_provisorio);
    }

    public void cadastrarDespesa(DespesasInputDTO despesasInputDTO) {
        Despesa despesa = despesasAssembler.toEntity(despesasInputDTO);

        despesasService.cadastrar(despesa);
    }

    public Projeto setAtributosPadrao(Projeto projeto, ProjetosInputDTO projetosInputDTO) {
        projeto.setData_do_cadastro(LocalDateTime.now());
        projeto.setStatus(Status.NAO_INICIADO);
        projeto.setHorasApontadas(0);
        projeto.setResponsavel(funcionarioRepositories.findByNome(
                projetosInputDTO.getNome_responsavel()
        ));
        projeto.setSolicitante(funcionarioRepositories.findByNome(
                projetosInputDTO.getNome_solicitante()
        ));

        return projeto;
    }

}
