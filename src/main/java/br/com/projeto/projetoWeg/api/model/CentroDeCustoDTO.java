package br.com.projeto.projetoWeg.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CentroDeCustoDTO {

    private String nome;
    private FuncionarioDTO responsavel;

}
