package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.domain.model.Envolvidos;
import br.com.projeto.projetoWeg.domain.model.ProjetoEnvolvidos;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import br.com.projeto.projetoWeg.domain.repository.EnvolvidosRepository;
import br.com.projeto.projetoWeg.domain.repository.FuncionariosRepository;
import br.com.projeto.projetoWeg.domain.repository.ProjetosRepository;
import br.com.projeto.projetoWeg.domain.service.EnvolvidosService;
import br.com.projeto.projetoWeg.domain.service.FuncionariosService;
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

    //Repositorys


    @PostMapping("/cadastrar")
    public @ResponseBody Projetos cadastrarProjeto(@RequestBody ProjetoEnvolvidos projetoEnvolvidos) {
        envolvidosService.cadastrarEnvolvidos(projetoEnvolvidos);

        return null;
    }

    @GetMapping("/listar")
    public List<Projetos> listarProjetos() {
        return projetosService.listarProjetos();
    }

}
