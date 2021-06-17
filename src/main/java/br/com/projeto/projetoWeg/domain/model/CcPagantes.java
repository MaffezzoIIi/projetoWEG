package br.com.projeto.projetoWeg.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CcPagantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cc_id;

    @JoinColumn
    private long projeto_id;

    @JoinColumn
    private long responsavel_id;
    private double percentual;
    private BigDecimal valor;

}
