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
public class Despesas {
    /*
     * Classe de gastos referentes as skills necessárias para o projeto
     */

    private long id;
    private long projeto_id;
    private String nome;
    private int esforco;
    private BigDecimal valor;

}
