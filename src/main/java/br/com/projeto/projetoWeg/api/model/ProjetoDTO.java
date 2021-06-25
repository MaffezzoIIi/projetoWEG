package br.com.projeto.projetoWeg.api.model;

import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoDTO {

    private long id;

    private long numero_do_projeto;
    private String titulo;
    private String descricao;

    private FuncionarioDTO solicitante;
    private FuncionarioDTO responsavel;

    private String data_de_inicio;
    private String data_de_termino;
    private String data_de_aprovacao;

}
