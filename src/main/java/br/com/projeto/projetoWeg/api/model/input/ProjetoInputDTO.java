package br.com.projeto.projetoWeg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ProjetoInputDTO {

    @NotNull
    private InfoProjetosInputDTO infoProjetosInputDTO;

    @NotNull
    private List<CcPagantesInputDTO> ccPagantesInputDTO;

    @NotNull
    private List<DespesasInputDTO> despesasInputDTOS;

}
