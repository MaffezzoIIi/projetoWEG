package br.com.projeto.projetoWeg.api.model;

import br.com.projeto.projetoWeg.api.model.input.CcPagantesInput;
import br.com.projeto.projetoWeg.api.model.input.DespesasInput;
import br.com.projeto.projetoWeg.domain.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjetoModel {

    private long numero_do_projeto;
    private String titulo;
    private String descricao;
    private String nome_responsavel;
    private String nome_solicitante;
    private List<DespesasInput> despesas;
    private List<CcPagantesInput> ccPagantes;
    private Enum<Status> status;
    private String data_inicio;
    private String data_termino;
    private String data_aprovacao;
    private String data_Do_cadastro;
}