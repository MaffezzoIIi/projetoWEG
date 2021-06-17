package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.ProjetoModel;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInput;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import br.com.projeto.projetoWeg.domain.service.EnvolvidosService;
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
    private EnvolvidosService envolvidosService;
    private ProjetoAssembler projetoAssembler;

    //Repositorys


    @PostMapping("/cadastrar")
    public @ResponseBody ProjetoModel cadastrarProjeto(@RequestBody ProjetosInput projetosInput) {
        Projetos novoProjeto = projetoAssembler.toEntity(projetosInput);
        Projetos projeto = projetosService.cadastrarProjeto(novoProjeto);
        return projetoAssembler.toModel(projeto);
    }

    @GetMapping("/listar")
    public List<Projetos> listarProjetos() {
        return projetosService.listarProjetos();
    }

}
