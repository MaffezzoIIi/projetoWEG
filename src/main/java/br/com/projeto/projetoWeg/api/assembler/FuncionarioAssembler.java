package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.FuncionarioDTO;
import br.com.projeto.projetoWeg.api.model.input.FuncionarioInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class FuncionarioAssembler {

    private ModelMapper modelMapper;

    public FuncionarioDTO toModel(Funcionario funcionario){
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public Funcionario toEntity(FuncionarioInputDTO funcionarioInputDTO){
        return modelMapper.map(funcionarioInputDTO, Funcionario.class);
    }

    public List<FuncionarioDTO> toCollectionModel(List<Funcionario> funcionarios){
        return funcionarios.stream().map(this::toModel).collect(Collectors.toList());
    }

}
