package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.ProjetoModel;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInput;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProjetoAssembler {

    private ModelMapper modelMapper;

    public ProjetoModel toModel(Projetos projetos){
        return modelMapper.map(projetos, ProjetoModel.class);
    }

    public List<ProjetoModel> toCollectionModel(List<Projetos> projetos){
        return projetos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Projetos toEntity(ProjetosInput projetosInput){
        return modelMapper.map(projetosInput, Projetos.class);
    }

}
