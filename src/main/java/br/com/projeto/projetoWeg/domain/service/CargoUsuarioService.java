package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.CargosUsuarios;
import br.com.projeto.projetoWeg.domain.repository.CargoUsuarioRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CargoUsuarioService {

    private final CargoUsuarioRepositories cargoUsuarioRepositories;

    public CargosUsuarios cadastrar(CargosUsuarios cargosUsuarios) {
        return cargoUsuarioRepositories.save(cargosUsuarios);
    }

}
