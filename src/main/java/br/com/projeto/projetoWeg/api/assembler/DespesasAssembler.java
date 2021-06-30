package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.DespesasDTO;
import br.com.projeto.projetoWeg.api.model.input.DespesasInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Despesa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DespesasAssembler {

    private ModelMapper modelMapper;

    public DespesasDTO toModel(Despesa despesa){
        return modelMapper.map(despesa, DespesasDTO.class);
    }

    public Despesa toEntity(DespesasInputDTO despesasInputDTO){
        return modelMapper.map(despesasInputDTO, Despesa.class);
    }

    public List<DespesasDTO> toCollectionModel(List<Despesa> despesas) {
        return despesas.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<Despesa> toCollectionEntity(List<DespesasInputDTO> despesasInputDTOS){
        return despesasInputDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
