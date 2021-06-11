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
import java.math.BigDecimal;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id_envolvidos;

    //Third Step

    private long id_cc;

    private BigDecimal verba_aprovada;

    private int limite_de_horas;

    //Fourth Step

    private String data_de_inicio;

    private String data_de_termino;

    private String data_de_aprovacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime data_Do_cadastro;

}
