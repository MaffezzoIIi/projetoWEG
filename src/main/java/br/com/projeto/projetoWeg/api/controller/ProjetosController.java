package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.CcPagantesAssembler;
import br.com.projeto.projetoWeg.api.assembler.DespesasAssembler;
import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.ProjetoModel;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInput;
import br.com.projeto.projetoWeg.domain.model.CcPagantes;
import br.com.projeto.projetoWeg.domain.model.Despesas;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import br.com.projeto.projetoWeg.domain.service.CcPagantesService;
import br.com.projeto.projetoWeg.domain.service.DespesasService;
import br.com.projeto.projetoWeg.domain.service.ProjetosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/projetos")
public class ProjetosController {

    //Services
    private ProjetosService projetosService;
    private DespesasService despesasService;
    private CcPagantesService ccPagantesService;

    //Assemblers
    private ProjetoAssembler projetoAssembler;
    private DespesasAssembler despesasAssembler;
    private CcPagantesAssembler ccPagantesAssembler;

    //Repositorys


    @PostMapping("/cadastrar")
    public @ResponseBody ProjetoModel cadastrarProjeto(@RequestBody ProjetosInput projetosInput) {
        Projetos novoProjeto = projetoAssembler.toEntity(projetosInput);
        Projetos projeto = projetosService.cadastrarProjeto(novoProjeto,
                projetosInput.getNome_responsavel(), projetosInput.getNome_solicitante());

        for(int i = 0; i < projetosInput.getDespesas().size(); i ++) {
            Despesas novasDespesas = despesasAssembler.toEntity(projetosInput.getDespesas().get(i));
            despesasService.cadastrarDespesas(novasDespesas, projeto.getId());
        }

        for (int i = 0; i < projetosInput.getCcPagantes().size(); i ++) {
            CcPagantes novosCcPagantes = ccPagantesAssembler.toEntity(projetosInput.getCcPagantes().get(i));
            ccPagantesService.cadastrarCcPagantes(novosCcPagantes, projeto.getId(),
                    projetosInput.getCcPagantes().get(i).getResponsavel_cc());
        }

        return projetoAssembler.toModel(projeto);
    }

    @GetMapping("/listar")
    public List<Projetos> listarProjetos() {
        return projetosService.listarProjetos();
    }

}
