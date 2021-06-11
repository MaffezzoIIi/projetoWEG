package br.com.projeto.projetoWeg.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Envolvidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long id_responsavel;

    private long id_solicitante;

    private long id_aprovador;
}
