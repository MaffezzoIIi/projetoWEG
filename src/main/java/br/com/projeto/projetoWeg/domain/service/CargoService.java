package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.CargoAssembler;
import br.com.projeto.projetoWeg.api.model.CargoDTO;
import br.com.projeto.projetoWeg.domain.entities.Cargo;
import br.com.projeto.projetoWeg.domain.repository.CargoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CargoService {

    private CargoRepositories cargoRepositories;

    private CargoAssembler cargoAssembler;

    @Transactional
    public Cargo cadastrar(Cargo cargo){
        return cargoRepositories.save(cargo);
    }


    public List<CargoDTO> listar() {
        return cargoAssembler.toCollectionModel(cargoRepositories.findAll());
    }

}
