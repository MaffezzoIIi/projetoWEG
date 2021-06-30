package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.InfoProjetosDTO;
import br.com.projeto.projetoWeg.api.model.ProjetoDTO;
import br.com.projeto.projetoWeg.api.model.input.InfoProjetosInputDTO;
import br.com.projeto.projetoWeg.api.model.input.ProjetoInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Projeto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProjetoAssembler {

    private ModelMapper modelMapper;

    public InfoProjetosDTO toModel(Projeto projeto){
        return modelMapper.map(projeto, InfoProjetosDTO.class);
    }

    public Projeto toEntity(InfoProjetosInputDTO infoProjetosInputDTO){
        return modelMapper.map(infoProjetosInputDTO, Projeto.class);
    }

    public List<InfoProjetosDTO> toCollectionModel(List<Projeto> projetos){
        return projetos.stream().map(this::toModel).collect(Collectors.toList());

    }

}
