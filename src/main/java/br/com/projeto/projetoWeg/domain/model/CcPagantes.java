package br.com.projeto.projetoWeg.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CcPagantes {

    private long cc_id;
    private long projeto_id;
    private long responsavel_id;
    private double percentual;
    private BigDecimal valor;

}
