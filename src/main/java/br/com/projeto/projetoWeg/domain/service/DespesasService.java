package br.com.projeto.projetoWeg.domain.service;

import br.com.projeto.projetoWeg.domain.entities.Despesa;
import br.com.projeto.projetoWeg.domain.repository.DespesasRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;

@AllArgsConstructor
@Service
public class DespesasService {

    private DespesasRepositories despesasRepositories;

    public Despesa cadastrar(Despesa despesas) {
        return despesasRepositories.save(despesas);
    }

    public List<Despesa> listar() { return  despesasRepositories.findAll(); }

    public Despesa buscar(Long id) { return  despesasRepositories.findById(id).get(); }
}
