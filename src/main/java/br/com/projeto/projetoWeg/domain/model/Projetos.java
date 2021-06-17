package br.com.projeto.projetoWeg.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long numero_do_projeto;

    private String titulo;

    private String descricao;

    //Second Step

    private long solicitante_id;
    private long responsavel_id;

    //Fourth Step

    private String data_de_inicio;

    private String data_de_termino;

    private String data_de_aprovacao;

    /* *
    * Campos que não serão informados na hora do cadastro
    * e servirão apenas para leitura
    *  */

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int horasApontadas;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime data_do_cadastro;

}
