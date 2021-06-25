package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.CargoDTO;
import br.com.projeto.projetoWeg.api.model.CentroDeCustoDTO;
import br.com.projeto.projetoWeg.api.model.input.CargoInputDTO;
import br.com.projeto.projetoWeg.api.model.input.CentroDeCustoInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Cargo;
import br.com.projeto.projetoWeg.domain.entities.CentroDeCusto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CentroDeCustoAssembler {

    private ModelMapper modelMapper;

    public CentroDeCustoDTO toModel(CentroDeCusto centroDeCusto){
        return modelMapper.map(centroDeCusto, CentroDeCustoDTO.class);
    }

    public CentroDeCusto toEntity(CentroDeCustoInputDTO centroDeCustoInputDTO){
        return modelMapper.map(centroDeCustoInputDTO, CentroDeCusto.class);
    }

    public List<CentroDeCustoDTO> toCollectionModel(List<CentroDeCusto> centroDeCustos){
        return centroDeCustos.stream().map(this::toModel).collect(Collectors.toList());

    }

}
