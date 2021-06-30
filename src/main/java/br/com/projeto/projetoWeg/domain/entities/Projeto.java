package br.com.projeto.projetoWeg.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long numero_do_projeto;
    private String titulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Funcionario solicitante;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Funcionario responsavel;

    private String data_de_inicio;
    private String data_de_termino;
    private String data_de_aprovacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int horasApontadas;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime data_do_cadastro;

    @JoinTable(name = "projetos_ccpagantes", joinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ccpagantes_id", referencedColumnName = "id"))
    @ManyToMany
    private List<CcPagante> ccPagantes;

    @JoinTable(name = "projetos_despesas", joinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "despesas_id", referencedColumnName = "id"))
    @ManyToMany
    private List<Despesa> despesas;

}
