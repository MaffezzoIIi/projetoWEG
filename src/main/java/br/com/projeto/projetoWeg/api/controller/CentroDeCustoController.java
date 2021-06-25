package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.CentroDeCustoAssembler;
import br.com.projeto.projetoWeg.api.model.CentroDeCustoDTO;
import br.com.projeto.projetoWeg.api.model.input.CentroDeCustoInputDTO;
import br.com.projeto.projetoWeg.domain.entities.CentroDeCusto;
import br.com.projeto.projetoWeg.domain.repository.FuncionarioRepositories;
import br.com.projeto.projetoWeg.domain.service.CentroDeCustoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/centros_de_custos")
public class CentroDeCustoController {

    private CentroDeCustoService centroDeCustoService;

    private CentroDeCustoAssembler centroDeCustoAssembler;

    private FuncionarioRepositories funcionarioRepositories;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CentroDeCustoDTO cadastrar(@RequestBody CentroDeCustoInputDTO centroDeCustoInputDTO) {
        CentroDeCusto novoCentroDeCusto = centroDeCustoAssembler.toEntity(centroDeCustoInputDTO);
        novoCentroDeCusto.setResponsavel(funcionarioRepositories.findByNome(centroDeCustoInputDTO.getResponsavel()));

        CentroDeCusto centroDeCusto = centroDeCustoService.cadastrar(novoCentroDeCusto);

        return centroDeCustoAssembler.toModel(centroDeCusto);
    }


}
