package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class CcPagantesInputDTO {

    @NotNull
    private Long centro_de_custo_id;

    @NotNull
    private double percentual;

    @NotNull
    private BigDecimal valor;

}
