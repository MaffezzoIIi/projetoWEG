package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.CcPagantesModel;
import br.com.projeto.projetoWeg.api.model.ProjetoModel;
import br.com.projeto.projetoWeg.api.model.input.CcPagantesInput;
import br.com.projeto.projetoWeg.domain.model.CcPagantes;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CcPagantesAssembler {

    private ModelMapper modelMapper;

    public CcPagantesModel toModel(CcPagantes ccPagantes){
        return modelMapper.map(ccPagantes, CcPagantesModel.class);
    }

    public List<CcPagantesModel> toCollectionModel(List<CcPagantes> ccPagantes){
        return ccPagantes.stream().map(this::toModel).collect(Collectors.toList());
    }

    public CcPagantes toEntity(CcPagantesInput ccPagantesInput){
        return modelMapper.map(ccPagantesInput, CcPagantes.class);
    }

}
