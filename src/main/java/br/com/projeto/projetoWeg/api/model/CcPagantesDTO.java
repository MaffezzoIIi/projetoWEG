package br.com.projeto.projetoWeg.api.model;

import br.com.projeto.projetoWeg.domain.entities.CentroDeCusto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CcPagantesDTO {

    private CentroDeCusto centroDeCusto;
    private double percentual;
    private BigDecimal valor;
}
