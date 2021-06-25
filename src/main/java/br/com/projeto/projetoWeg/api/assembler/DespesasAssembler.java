package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.input.DespesasInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Despesa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DespesasAssembler {

    private ModelMapper modelMapper;

    public Despesa toEntity(DespesasInputDTO despesasInputDTO){
        return modelMapper.map(despesasInputDTO, Despesa.class);
    }
}
