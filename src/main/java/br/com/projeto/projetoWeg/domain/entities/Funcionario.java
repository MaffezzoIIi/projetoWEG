package br.com.projeto.projetoWeg.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity(name = "funcionarios")
public class Funcionario {

    @Id
    private long numero_cracha;

    private String nome;
    private String cpf;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
