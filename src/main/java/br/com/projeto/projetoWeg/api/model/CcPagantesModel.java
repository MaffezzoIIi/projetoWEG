package br.com.projeto.projetoWeg.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CcPagantesModel {

    private long cc_id;
    private String responsavel_cc;
    private double percentual;
    private BigDecimal valor;
}
