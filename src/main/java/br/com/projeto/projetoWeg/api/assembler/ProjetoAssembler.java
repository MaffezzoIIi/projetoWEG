package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.FuncionarioDTO;
import br.com.projeto.projetoWeg.api.model.ProjetoDTO;
import br.com.projeto.projetoWeg.api.model.input.FuncionarioInputDTO;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
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

    public ProjetoDTO toModel(Projeto projeto){
        return modelMapper.map(projeto, ProjetoDTO.class);
    }

    public Projeto toEntity(ProjetosInputDTO projetosInputDTO){
        return modelMapper.map(projetosInputDTO, Projeto.class);
    }

    public List<ProjetoDTO> toCollectionModel(List<Projeto> projetos){
        return projetos.stream().map(this::toModel).collect(Collectors.toList());

    }

}
