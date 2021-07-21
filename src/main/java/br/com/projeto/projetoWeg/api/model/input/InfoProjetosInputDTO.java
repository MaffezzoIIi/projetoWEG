package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class InfoProjetosInputDTO {

        @NotNull
        private long numeroDoProjeto;

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

}
