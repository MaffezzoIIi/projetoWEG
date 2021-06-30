package br.com.projeto.projetoWeg.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DespesasDTO {

    private String nome;
    private int esforco;
    private BigDecimal valor;

}
