package br.com.projeto.projetoWeg.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "cc_pagantes")
public class CcPagantes {

    @OneToMany
    @JoinColumn(name = "centro_de_custo_id")
    private CentroDeCusto centroDeCusto;
    
    private double percentual;
    private BigDecimal valor;

}
