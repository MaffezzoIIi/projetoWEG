package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.domain.model.Gerentes;
import br.com.projeto.projetoWeg.domain.repository.GerentesRepository;
import br.com.projeto.projetoWeg.domain.service.GerentesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/gerentes")
public class GerentesController {

    private GerentesService gerentesService;
    private GerentesRepository gerentesRepository;

    @PostMapping
    public Gerentes cadastrar(@RequestBody Gerentes gerentes) {
        return gerentesService.cadastrarGerentes(gerentes);
    }

    @GetMapping("/{username}&{password}")
    public String listarGerentes(@PathVariable String username, @PathVariable String password){

        if (gerentesRepository.findByUsername(username).getUsername() != null && gerentesRepository.findByPassword(password).getPassword() != null){
            return "Passou";
        }

        return "Reprovou";
    }
}
