package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.domain.model.Envolvidos;
import br.com.projeto.projetoWeg.domain.service.EnvolvidosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/envolvidos")
public class EnvolvidosController {

    private EnvolvidosService envolvidosService;

    @GetMapping("/listar")
    public List<Envolvidos> listar(){
        return envolvidosService.listarTodos();
    }

//    @PostMapping("/cadastrar")
//    public Envolvidos cadastrarEnvolvidos(@RequestBody Envolvidos envolvidos) {
//        return envolvidosService.cadastrarEnvolvidos(envolvidos);
//    }

//    @GetMapping("/{name}")
//    public Envolvidos listarPeloNome(@PathVariable String name){
//        return envolvidosService.selelcionarPeloNome(name);
//    }

}
