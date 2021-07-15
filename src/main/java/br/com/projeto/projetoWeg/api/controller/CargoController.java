package br.com.projeto.projetoWeg.api.controller;

import br.com.projeto.projetoWeg.api.assembler.CargoAssembler;
import br.com.projeto.projetoWeg.api.model.CargoDTO;
import br.com.projeto.projetoWeg.api.model.input.CargoInputDTO;
import br.com.projeto.projetoWeg.domain.entities.Cargo;
import br.com.projeto.projetoWeg.domain.service.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
@RequestMapping("/cargos")
public class CargoController {

    private CargoAssembler cargoAssembler;
    private CargoService cargoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CargoDTO cadastrar(@RequestBody CargoInputDTO cargoInputDTO){
        Cargo novoCargo = cargoAssembler.toEntity(cargoInputDTO);
        novoCargo.setNome("ROLE_" + novoCargo.getNome().toUpperCase(Locale.ROOT));
        Cargo cargo = cargoService.cadastrar(novoCargo);

        return cargoAssembler.toModel(cargo);
    }

    @GetMapping
    public List<CargoDTO> listar() {
        return cargoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> buscar(@PathVariable long id) {
        return cargoService.buscar(id);
    }

    @DeleteMapping("/{cargoId}")
    public ResponseEntity<CargoDTO> removerPorId(@PathVariable long cargoId) {
        return cargoService.removerPorId(cargoId);
    }

}
