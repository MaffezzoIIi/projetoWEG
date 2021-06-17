package br.com.projeto.projetoWeg.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DespesasModel {

    private String nome;
    private int esforco;
    private BigDecimal valor;
}
