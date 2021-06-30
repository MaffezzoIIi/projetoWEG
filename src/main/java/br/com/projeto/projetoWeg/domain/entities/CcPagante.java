package br.com.projeto.projetoWeg.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity(name = "cc_pagantes")
public class CcPagante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "centro_de_custo_id")
    private CentroDeCusto centroDeCusto;

    private double percentual;
    private BigDecimal valor;

    @ManyToMany
    private List<Projeto> projetos;

}
