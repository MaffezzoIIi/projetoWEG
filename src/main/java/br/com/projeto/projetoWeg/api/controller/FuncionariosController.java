package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.domain.model.Funcionarios;
import br.com.projeto.projetoWeg.domain.service.FuncionariosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private FuncionariosService funcionariosService;

    @PostMapping("/cadastrar")
    public Funcionarios cadastrarFuncionario(@RequestBody Funcionarios funcionarios) {
        return funcionariosService.cadastrarFuncionario(funcionarios);
    }

    @GetMapping("/listar")
    public List<Funcionarios> listarFuncionarios() {
        return funcionariosService.listarFuncionarios();
    }

}
