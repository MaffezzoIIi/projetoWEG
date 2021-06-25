package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class DespesasInputDTO {

    @NotBlank
    private String nome;

    @NotNull
    private int esforco;

    @NotNull
    private BigDecimal valor;
}
