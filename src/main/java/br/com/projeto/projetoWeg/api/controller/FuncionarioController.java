package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.FuncionarioAssembler;
import br.com.projeto.projetoWeg.api.assembler.UsuarioAssembler;
import br.com.projeto.projetoWeg.api.model.FuncionarioDTO;
import br.com.projeto.projetoWeg.api.model.input.FuncionarioInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Funcionario;
import br.com.projeto.projetoWeg.domain.entities.Usuario;
import br.com.projeto.projetoWeg.domain.service.FuncionarioService;
import br.com.projeto.projetoWeg.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final UsuarioService usuarioService;

    private final FuncionarioAssembler funcionarioAssembler;
    private final UsuarioAssembler usuarioAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioDTO cadastrarFuncionario(@Valid @RequestBody FuncionarioInputDTO funcionarioInputDTO){
        Funcionario novoFuncionario = funcionarioAssembler.toEntity(funcionarioInputDTO);

        Usuario novoUsuario = usuarioAssembler.toEntity(funcionarioInputDTO.getUsuario());

        Usuario usuario = usuarioService.cadastrar(novoUsuario);
        novoFuncionario.setUsuario(usuario);

        Funcionario funcionario = funcionarioService.cadastrar(novoFuncionario);
        return funcionarioAssembler.toModel(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listar() {
        return funcionarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscar(@PathVariable long id) {
        return funcionarioService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> remover(@PathVariable long id) {
        return funcionarioService.remover(id);
    }

}
