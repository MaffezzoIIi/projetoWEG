package br.com.projeto.projetoWeg.api.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncionarioInputDTO {

    @NotNull
    private Long numero_cracha;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotNull
    private UsuarioInputDTO usuario;


}
