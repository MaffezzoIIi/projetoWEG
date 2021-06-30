package br.com.projeto.projetoWeg.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InfoProjetosDTO {

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
