package br.com.projeto.projetoWeg.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Apontamento {

    private long id;
    private long funcionarios_id ;
    private int horas_apontadas;

}
