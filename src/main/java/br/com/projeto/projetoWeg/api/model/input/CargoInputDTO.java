package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CargoInputDTO {

    @NotBlank
    private String nome;

}
