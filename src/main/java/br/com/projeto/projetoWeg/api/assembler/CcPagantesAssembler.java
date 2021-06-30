package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.CcPagantesDTO;
import br.com.projeto.projetoWeg.api.model.input.CcPagantesInputDTO;
import br.com.projeto.projetoWeg.domain.entities.CcPagante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CcPagantesAssembler {

    private ModelMapper modelMapper;

    public CcPagante toEntity(CcPagantesInputDTO ccPagantesInputDTO){
        return modelMapper.map(ccPagantesInputDTO, CcPagante.class);
    }

    public CcPagantesDTO toModel(CcPagante ccPagante){
        return modelMapper.map(ccPagante, CcPagantesDTO.class);
    }

    public List<CcPagantesDTO> toCollectionModel(List<CcPagante> ccPagantes){
        return ccPagantes.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<CcPagante> toCollectionEntity(List<CcPagantesInputDTO> ccPagantesInputDTOS){
        return  ccPagantesInputDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }


}
