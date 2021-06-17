package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CcPagantesInput {

    private long cc_id;
    private String responsavel_cc;
    private double percentual;
    private BigDecimal valor;

}
