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
public class NomeEnvolvidos {

    private String nome_solicitante;
    private String nome_responsavel;
    private String nome_aprovador;

}
