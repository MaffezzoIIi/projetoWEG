package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ProjetosInputDTO {

    @NotNull
    private long numero_do_projeto;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String nome_responsavel;

    @NotBlank
    private String nome_solicitante;

    @NotNull
    private String data_de_inicio;

    @NotNull
    private String data_de_termino;

    @NotNull
    private String data_de_aprovacao;

    @NotNull
    private List<CcPagantesInputDTO> cc_pagantes;

    @NotNull
    private List<DespesasInputDTO> despesas;

}
