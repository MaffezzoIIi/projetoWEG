package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.CargoDTO;
import br.com.projeto.projetoWeg.api.model.input.CargoInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Cargo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CargoAssembler {

    private ModelMapper modelMapper;

    public CargoDTO toModel(Cargo cargo){
        return modelMapper.map(cargo, CargoDTO.class);
    }

    public Cargo toEntity(CargoInputDTO cargoInputDTO){
        return modelMapper.map(cargoInputDTO, Cargo.class);
    }

    public List<CargoDTO> toCollectionModel(List<Cargo> cargos){
        return cargos.stream().map(this::toModel).collect(Collectors.toList());

    }

}
