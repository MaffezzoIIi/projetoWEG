package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.CargoAssembler;
import br.com.projeto.projetoWeg.api.assembler.FuncionarioAssembler;
import br.com.projeto.projetoWeg.api.assembler.UsuarioAssembler;
import br.com.projeto.projetoWeg.api.model.FuncionarioDTO;
import br.com.projeto.projetoWeg.api.model.input.FuncionarioInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Cargo;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import br.com.projeto.projetoWeg.domain.entities.Usuario;
import br.com.projeto.projetoWeg.domain.repository.CargoRepositories;
import br.com.projeto.projetoWeg.domain.service.FuncionarioService;
import br.com.projeto.projetoWeg.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private UsuarioService usuarioService;

    private CargoRepositories cargoRepositories;


    private FuncionarioAssembler funcionarioAssembler;
    private UsuarioAssembler usuarioAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioDTO cadastrarFuncionario(@Valid @RequestBody FuncionarioInputDTO funcionarioInputDTO){
        Funcionario novoFuncionario = funcionarioAssembler.toEntity(funcionarioInputDTO);

        Usuario novoUsuario = usuarioAssembler.toEntity(funcionarioInputDTO.getUsuario());

        Cargo cargo = cargoRepositories.findByNome("FUNCIONARIO");
        novoUsuario.setCargos(cargo);

        Usuario usuario = usuarioService.cadastrar(novoUsuario);
        novoFuncionario.setUsuario(usuario);

        Funcionario funcionario = funcionarioService.cadastrar(novoFuncionario);
        return funcionarioAssembler.toModel(funcionario);
    }

    @GetMapping
    public List<FuncionarioDTO> listar() {
        return funcionarioService.listar();
    }


}
