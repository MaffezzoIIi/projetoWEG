package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.model.Gerentes;
import br.com.projeto.projetoWeg.domain.repository.GerentesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class GerentesService {

    private GerentesRepository gerentesRepository;

    @Transactional
    public Gerentes cadastrarGerentes(Gerentes gerentes){
        return gerentesRepository.save(gerentes);
    }

    public String loginGerentes(String username, String password){
//        if (gerentesRepository.findByUsername(username).getUsername() != username &&
//               gerentesRepository.findByPassword(password).getPassword() != password){
//            return "Passou";
//        }

        return  "Falhouw";
    }

}
