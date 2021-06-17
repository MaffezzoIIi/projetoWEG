package br.com.projeto.projetoWeg.api.assembler;

import br.com.projeto.projetoWeg.api.model.DespesasModel;
import br.com.projeto.projetoWeg.api.model.ProjetoModel;
import br.com.projeto.projetoWeg.api.model.input.DespesasInput;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInput;
import br.com.projeto.projetoWeg.domain.model.Despesas;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DespesasAssembler {

    private ModelMapper modelMapper;

    public DespesasModel toModel(Despesas despesas){
        return modelMapper.map(despesas, DespesasModel.class);
    }

    public List<DespesasModel> toCollectionModel(List<Despesas> despesas){
        return despesas.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Despesas toEntity(DespesasInput despesasInput){
        return modelMapper.map(despesasInput, Despesas.class);
    }

    public List<Despesas> toCollectionEntity(List<DespesasInput> despesasInput) {
        return despesasInput.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
