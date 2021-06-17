package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.model.input.ProjetosInput;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import br.com.projeto.projetoWeg.domain.model.Status;
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
    private FuncionariosService funcionariosService;

    @Transactional
    public Projetos cadastrarProjeto(Projetos projetos, String nome_responsavel, String nome_solicitante) {
        projetos.setData_do_cadastro(LocalDateTime.now());
        projetos.setStatus(Status.NAO_INICIADO);
        projetos.setHorasApontadas(0);

        projetos.setResponsavel_id(funcionariosService.buscarPorNome(nome_responsavel).getNumero_cracha());
        projetos.setSolicitante_id(funcionariosService.buscarPorNome(nome_solicitante).getNumero_cracha());

        return projetosRepository.save(projetos);
    }

    public List<Projetos> listarProjetos() {
        return projetosRepository.findAll();
    }

}
