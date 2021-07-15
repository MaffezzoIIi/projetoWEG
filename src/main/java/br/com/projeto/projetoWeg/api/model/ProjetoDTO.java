package br.com.projeto.projetoWeg.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjetoDTO {

    private InfoProjetosDTO infoprojetoDTO;
    private List<CcPagantesDTO> ccPagantes;
    private List<DespesasDTO> despesas;

}
