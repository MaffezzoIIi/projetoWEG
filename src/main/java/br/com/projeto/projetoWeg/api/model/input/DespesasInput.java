package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DespesasInput {

    private String nome;
    private int esforco;
    private BigDecimal valor;
}
