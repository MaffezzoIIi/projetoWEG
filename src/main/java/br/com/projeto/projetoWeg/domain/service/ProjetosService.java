package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.model.Projetos;
import br.com.projeto.projetoWeg.domain.repository.EnvolvidosRepository;
import br.com.projeto.projetoWeg.domain.repository.ProjetosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProjetosService {

    private ProjetosRepository projetosRepository;

    @Transactional
    public Projetos cadastrarProjeto(Projetos projetos, long id) {
        projetos.setData_Do_cadastro(LocalDateTime.now());
        projetos.setId_envolvidos(id);
        return projetosRepository.save(projetos);
    }

    public List<Projetos> listarProjetos() {
        return projetosRepository.findAll();
    }

}
