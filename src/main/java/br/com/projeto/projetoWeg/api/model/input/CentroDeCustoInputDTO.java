package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CentroDeCustoInputDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String responsavel;

}