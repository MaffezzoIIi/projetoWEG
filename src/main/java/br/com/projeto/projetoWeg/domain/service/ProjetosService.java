package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.api.assembler.CcPagantesAssembler;
import br.com.projeto.projetoWeg.api.assembler.DespesasAssembler;
import br.com.projeto.projetoWeg.api.assembler.ProjetoAssembler;
import br.com.projeto.projetoWeg.api.model.ProjetoModel;
import br.com.projeto.projetoWeg.api.model.input.ProjetosInput;
import br.com.projeto.projetoWeg.domain.model.Projetos;
import br.com.projeto.projetoWeg.domain.model.Status;
import br.com.projeto.projetoWeg.domain.repository.FuncionariosRepository;
import br.com.projeto.projetoWeg.domain.repository.ProjetosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProjetosService {

    //Assembler
    private CcPagantesAssembler ccPagantesAssembler;
    private DespesasAssembler despesasAssembler;
    private ProjetoAssembler projetoAssembler;

    //Repositorys
    private ProjetosRepository projetosRepository;
    private FuncionariosRepository funcionariosRepository;


    private FuncionariosService funcionariosService;
    private ProjetosService projetosService;


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


    public ProjetoModel colocarDadosAdicionais(ProjetosInput projetosInput){
        Projetos novoProjeto = projetoAssembler.toEntity(projetosInput);
        Projetos projeto = projetosService.cadastrarProjeto(novoProjeto,
                projetosInput.getNome_responsavel(), projetosInput.getNome_solicitante());

        ProjetoModel projetoModel = projetoAssembler.toModel(projeto);

        projetoModel.setCcPagantes(ccPagantesAssembler.toCollectionModelB(projetosInput.getCcPagantes()));
        projetoModel.setDespesas(despesasAssembler.toCollectionModelB(projetosInput.getDespesas()));
        projetoModel.setNome_responsavel(funcionariosRepository.findById(projeto.getResponsavel_id()).get().getNome());
        projetoModel.setNome_solicitante(funcionariosRepository.findById(projeto.getSolicitante_id()).get().getNome());
        return projetoModel;
    }
}
