package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.input.CcPagantesInputDTO;
import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CcPagantesAssembler {

    private ModelMapper modelMapper;

    public CcPagante toEntity(CcPagantesInputDTO ccPagantesInputDTO){
        return modelMapper.map(ccPagantesInputDTO, CcPagante.class);
    }

}
