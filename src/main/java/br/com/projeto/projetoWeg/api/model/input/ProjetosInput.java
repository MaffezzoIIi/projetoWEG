package br.com.projeto.projetoWeg.api.model.input;

import br.com.projeto.projetoWeg.domain.model.CcPagantes;
import br.com.projeto.projetoWeg.domain.model.Despesas;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ProjetosInput {

    private long numero_do_projeto;
    private String titulo;
    private String descricao;
    private String nome_responsavel;
    private String nome_solicitante;
    private List<DespesasInput> despesas;
    private List<CcPagantesInput> ccPagantes;
    private String data_de_inicio;
    private String data_de_termino;
    private String data_de_aprovacao;


}
